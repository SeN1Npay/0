package isp.maven.controller;

import isp.maven.entity.Models;
import isp.maven.entity.Brands;
import isp.maven.repository.ModelsRepository;
import isp.maven.repository.BrandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Maven/Models")
public class ModelsController {

    @Autowired
    private ModelsRepository ModelsRepository;

    @GetMapping("/allModels")
    public @ResponseBody Iterable<Models> allModels() {
        return ModelsRepository.findAll();
    }

    @Autowired
    private BrandsRepository BrandsRepository;

    @PostMapping("/addModels")
    public @ResponseBody boolean addModels(@RequestParam(name = "idbrand") String idbrand,
                                           @RequestParam(name = "name") String name) {
        try {
            Models Models = new Models();
            Brands Brands = BrandsRepository.findById(Integer.parseInt(idbrand)).orElseThrow();
            Models.setIdbrand(Brands);
            Models.setName(name);
            ModelsRepository.save(Models);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/updateModels")
    public @ResponseBody boolean updateModels(@RequestParam(name = "idmodel") String idmodel,
                                              @RequestParam(name = "idbrand") String idbrand,
                                              @RequestParam(name = "name") String name) {
        try {
            Models Models = ModelsRepository.findById(Integer.parseInt(idmodel)).orElseThrow();
            Brands Brands = BrandsRepository.findById(Integer.parseInt(idbrand)).orElseThrow();
            Models.setIdbrand(Brands);
            Models.setName(name);
            ModelsRepository.save(Models);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/deleteModels")
    public @ResponseBody boolean deleteModels(@RequestParam(name = "idmodel") String idmodel) {
        try {
            ModelsRepository.deleteById(Integer.parseInt(idmodel));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}