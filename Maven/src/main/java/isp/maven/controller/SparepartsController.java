package isp.maven.controller;

import isp.maven.entity.Spareparts;
import isp.maven.repository.SparepartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Maven/Spareparts")
public class SparepartsController {

    @Autowired
    private SparepartsRepository SparepartsRepository;

    @GetMapping("/allSpareparts")
    public @ResponseBody Iterable<Spareparts> allSpareparts() {
        return SparepartsRepository.findAll();
    }

    @PostMapping("/addSpareparts")
    public @ResponseBody boolean addSpareparts(@RequestParam(name = "name") String name,
                                               @RequestParam(name = "article") String article,
                                               @RequestParam(name = "price") String price,
                                               @RequestParam(name = "stock") String stock) {
        try {
            Spareparts sparepart = new Spareparts();
            sparepart.setName(name);
            sparepart.setArticle(article);
            sparepart.setPrice(Integer.valueOf(price));
            sparepart.setStock(Integer.valueOf(stock));
            SparepartsRepository.save(sparepart);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/updateSpareparts")
    public @ResponseBody boolean updateSpareparts(@RequestParam(name = "idsparepart") String idsparepart,
                                                  @RequestParam(name = "name") String name,
                                                  @RequestParam(name = "article") String article,
                                                  @RequestParam(name = "price") String price,
                                                  @RequestParam(name = "stock") String stock) {
        try {
            Spareparts sparepart = SparepartsRepository.findById(Integer.parseInt(idsparepart)).orElseThrow();
            sparepart.setName(name);
            sparepart.setArticle(article);
            sparepart.setPrice(Integer.valueOf(price));
            sparepart.setStock(Integer.valueOf(stock));
            SparepartsRepository.save(sparepart);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/deleteSpareparts")
    public @ResponseBody boolean deleteSpareparts(@RequestParam(name = "idsparepart") String idsparepart) {
        try {
            SparepartsRepository.deleteById(Integer.parseInt(idsparepart));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}