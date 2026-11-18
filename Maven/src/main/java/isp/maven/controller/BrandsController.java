package isp.maven.controller;

import isp.maven.entity.Brands;
import isp.maven.repository.BrandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Maven/Brands")
public class BrandsController {

    @Autowired
    private BrandsRepository BrandsRepository;

    @GetMapping("/allBrands")
    public @ResponseBody Iterable<Brands> allBrands() {
        return BrandsRepository.findAll();
    }

    @PostMapping("/addBrands")
    public @ResponseBody boolean addBrands(@RequestParam(name = "name") String name) {
        try {
            Brands Brands = new Brands();
            Brands.setName(name);
            BrandsRepository.save(Brands);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/updateBrands")
    public @ResponseBody boolean updateBrands(@RequestParam(name = "idbrand") String idbrand,
                                              @RequestParam(name = "name") String name) {
        try {
            Brands Brands = BrandsRepository.findById(Integer.parseInt(idbrand)).orElseThrow();
            Brands.setName(name);
            BrandsRepository.save(Brands);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/deleteBrands")
    public @ResponseBody boolean deleteBrands(@RequestParam(name = "idbrand") String idbrand) {
        try {
            BrandsRepository.deleteById(Integer.parseInt(idbrand));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}