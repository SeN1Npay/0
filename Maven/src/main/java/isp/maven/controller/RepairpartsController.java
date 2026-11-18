package isp.maven.controller;

import isp.maven.entity.Repairparts;
import isp.maven.entity.Repairs;
import isp.maven.entity.Spareparts;
import isp.maven.repository.RepairpartsRepository;
import isp.maven.repository.RepairsRepository;
import isp.maven.repository.SparepartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Maven/Repairparts")
public class RepairpartsController {

    @Autowired private RepairpartsRepository RepairpartsRepository;
    @Autowired private RepairsRepository RepairsRepository;
    @Autowired private SparepartsRepository SparepartsRepository;

    @GetMapping("/allRepairparts")
    public @ResponseBody Iterable<Repairparts> allRepairparts() {
        return RepairpartsRepository.findAll();
    }

    @PostMapping("/addRepairparts")
    public @ResponseBody boolean addRepairparts(@RequestParam(name = "idrepair") String idrepair,
                                                @RequestParam(name = "idsparepart") String idsparepart,
                                                @RequestParam(name = "quantity") String quantity) {
        try {
            Repairparts rp = new Repairparts();
            Repairs repair = RepairsRepository.findById(Integer.parseInt(idrepair)).orElseThrow();
            Spareparts spare = SparepartsRepository.findById(Integer.parseInt(idsparepart)).orElseThrow();
            rp.setIdrepair(repair);
            rp.setIdsparepart(spare);
            rp.setQuantity(Integer.parseInt(quantity));
            RepairpartsRepository.save(rp);
            return true;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    @PostMapping("/updateRepairparts")
    public @ResponseBody boolean updateRepairparts(@RequestParam(name = "idrepairpart") String idrepairpart,
                                                   @RequestParam(name = "idrepair") String idrepair,
                                                   @RequestParam(name = "idsparepart") String idsparepart,
                                                   @RequestParam(name = "quantity") String quantity) {
        try {
            Repairparts rp = RepairpartsRepository.findById(Integer.parseInt(idrepairpart)).orElseThrow();
            Repairs repair = RepairsRepository.findById(Integer.parseInt(idrepair)).orElseThrow();
            Spareparts spare = SparepartsRepository.findById(Integer.parseInt(idsparepart)).orElseThrow();
            rp.setIdrepair(repair);
            rp.setIdsparepart(spare);
            rp.setQuantity(Integer.parseInt(quantity));
            RepairpartsRepository.save(rp);
            return true;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    @PostMapping("/deleteRepairparts")
    public @ResponseBody boolean deleteRepairparts(@RequestParam(name = "idrepairpart") String idrepairpart) {
        try { RepairpartsRepository.deleteById(Integer.parseInt(idrepairpart)); return true; }
        catch (Exception e) { e.printStackTrace(); return false; }
    }
}