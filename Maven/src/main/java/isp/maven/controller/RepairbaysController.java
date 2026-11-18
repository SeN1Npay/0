package isp.maven.controller;

import isp.maven.entity.Repairbays;
import isp.maven.repository.RepairbaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Maven/Repairbays")
public class RepairbaysController {

    @Autowired
    private RepairbaysRepository RepairbaysRepository;

    @GetMapping("/allRepairbays")
    public @ResponseBody Iterable<Repairbays> allRepairbays() {
        return RepairbaysRepository.findAll();
    }

    @PostMapping("/addRepairbays")
    public @ResponseBody boolean addRepairbays(@RequestParam(name = "number") String number,
                                               @RequestParam(name = "purpose") String purpose) {
        try {
            Repairbays Repairbays = new Repairbays();
            Repairbays.setNumber(Integer.valueOf(number));
            Repairbays.setPurpose(purpose);
            RepairbaysRepository.save(Repairbays);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/updateRepairbays")
    public @ResponseBody boolean updateRepairbays(@RequestParam(name = "idbay") String idbay,
                                                  @RequestParam(name = "number") String number,
                                                  @RequestParam(name = "purpose") String purpose) {
        try {
            Repairbays Repairbays = RepairbaysRepository.findById(Integer.parseInt(idbay)).orElseThrow();
            Repairbays.setNumber(Integer.valueOf(number));
            Repairbays.setPurpose(purpose);
            RepairbaysRepository.save(Repairbays);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/deleteRepairbays")
    public @ResponseBody boolean deleteRepairbays(@RequestParam(name = "idbay") String idbay) {
        try {
            RepairbaysRepository.deleteById(Integer.parseInt(idbay));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}