package isp.maven.controller;

import isp.maven.entity.Repairservices;
import isp.maven.entity.Repairs;
import isp.maven.entity.Services;
import isp.maven.repository.RepairservicesRepository;
import isp.maven.repository.RepairsRepository;
import isp.maven.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Maven/Repairservices")
public class RepairservicesController {

    @Autowired private RepairservicesRepository RepairservicesRepository;
    @Autowired private RepairsRepository RepairsRepository;
    @Autowired private ServicesRepository ServicesRepository;

    @GetMapping("/allRepairservices")
    public @ResponseBody Iterable<Repairservices> allRepairservices() {
        return RepairservicesRepository.findAll();
    }

    @PostMapping("/addRepairservices")
    public @ResponseBody boolean addRepairservices(@RequestParam(name = "idrepair") String idrepair,
                                                   @RequestParam(name = "idservice") String idservice,
                                                   @RequestParam(name = "quantity") String quantity) {
        try {
            Repairservices rs = new Repairservices();
            Repairs repair = RepairsRepository.findById(Integer.parseInt(idrepair)).orElseThrow();
            Services service = ServicesRepository.findById(Integer.parseInt(idservice)).orElseThrow();
            rs.setIdrepair(repair);
            rs.setIdservice(service);
            rs.setQuantity(Integer.parseInt(quantity));
            RepairservicesRepository.save(rs);
            return true;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    @PostMapping("/updateRepairservices")
    public @ResponseBody boolean updateRepairservices(@RequestParam(name = "idrepairservice") String idrepairservice,
                                                      @RequestParam(name = "idrepair") String idrepair,
                                                      @RequestParam(name = "idservice") String idservice,
                                                      @RequestParam(name = "quantity") String quantity) {
        try {
            Repairservices rs = RepairservicesRepository.findById(Integer.parseInt(idrepairservice)).orElseThrow();
            Repairs repair = RepairsRepository.findById(Integer.parseInt(idrepair)).orElseThrow();
            Services service = ServicesRepository.findById(Integer.parseInt(idservice)).orElseThrow();
            rs.setIdrepair(repair);
            rs.setIdservice(service);
            rs.setQuantity(Integer.parseInt(quantity));
            RepairservicesRepository.save(rs);
            return true;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    @PostMapping("/deleteRepairservices")
    public @ResponseBody boolean deleteRepairservices(@RequestParam(name = "idrepairservice") String idrepairservice) {
        try { RepairservicesRepository.deleteById(Integer.parseInt(idrepairservice)); return true; }
        catch (Exception e) { e.printStackTrace(); return false; }
    }
}