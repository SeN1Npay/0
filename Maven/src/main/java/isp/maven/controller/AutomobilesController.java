package isp.maven.controller;

import isp.maven.entity.Automobiles;
import isp.maven.entity.Customers;
import isp.maven.entity.Models;
import isp.maven.repository.AutomobilesRepository;
import isp.maven.repository.CustomersRepository;
import isp.maven.repository.ModelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Maven/Automobiles")
public class AutomobilesController {

    @Autowired
    private AutomobilesRepository AutomobilesRepository;

    @Autowired
    private CustomersRepository CustomersRepository;

    @Autowired
    private ModelsRepository ModelsRepository;

    @GetMapping("/allAutomobiles")
    public @ResponseBody Iterable<Automobiles> allAutomobiles() {
        return AutomobilesRepository.findAll();
    }

    @PostMapping("/addAutomobiles")
    public @ResponseBody boolean addAutomobiles(@RequestParam(name = "idcustomer") String idcustomer,
                                                @RequestParam(name = "idmodel") String idmodel,
                                                @RequestParam(name = "vin") String vin,
                                                @RequestParam(name = "registrationnumber") String registrationnumber,
                                                @RequestParam(name = "productionyear") String productionyear,
                                                @RequestParam(name = "photolink") String photolink) {
        try {
            Automobiles Automobiles = new Automobiles();
            Customers Customers = CustomersRepository.findById(Integer.parseInt(idcustomer)).orElseThrow();
            Models Models = ModelsRepository.findById(Integer.parseInt(idmodel)).orElseThrow();

            Automobiles.setIdcustomer(Customers);
            Automobiles.setIdmodel(Models);
            Automobiles.setVin(vin);
            Automobiles.setRegistrationnumber(registrationnumber);
            Automobiles.setProductionyear(Integer.valueOf(productionyear));
            Automobiles.setPhotolink(photolink);

            AutomobilesRepository.save(Automobiles);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/updateAutomobiles")
    public @ResponseBody boolean updateAutomobiles(@RequestParam(name = "idautomobile") String idautomobile,
                                                   @RequestParam(name = "idcustomer") String idcustomer,
                                                   @RequestParam(name = "idmodel") String idmodel,
                                                   @RequestParam(name = "vin") String vin,
                                                   @RequestParam(name = "registrationnumber") String registrationnumber,
                                                   @RequestParam(name = "productionyear") String productionyear,
                                                   @RequestParam(name = "photolink") String photolink) {
        try {
            Automobiles Automobiles = AutomobilesRepository.findById(Integer.parseInt(idautomobile)).orElseThrow();
            Customers Customers = CustomersRepository.findById(Integer.parseInt(idcustomer)).orElseThrow();
            Models Models = ModelsRepository.findById(Integer.parseInt(idmodel)).orElseThrow();

            Automobiles.setIdcustomer(Customers);
            Automobiles.setIdmodel(Models);
            Automobiles.setVin(vin);
            Automobiles.setRegistrationnumber(registrationnumber);
            Automobiles.setProductionyear(Integer.valueOf(productionyear));
            Automobiles.setPhotolink(photolink);

            AutomobilesRepository.save(Automobiles);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/deleteAutomobiles")
    public @ResponseBody boolean deleteAutomobiles(@RequestParam(name = "idautomobile") String idautomobile) {
        try {
            AutomobilesRepository.deleteById(Integer.parseInt(idautomobile));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}