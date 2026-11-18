package isp.maven.controller;

import isp.maven.entity.Services;
import isp.maven.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Maven/Services")
public class ServicesController {

    @Autowired
    private ServicesRepository ServicesRepository;

    @GetMapping("/allServices")
    public @ResponseBody Iterable<Services> allServices() {
        return ServicesRepository.findAll();
    }

    @PostMapping("/addServices")
    public @ResponseBody boolean addServices(@RequestParam(name = "name") String name,
                                             @RequestParam(name = "cost") String cost) {
        try {
            Services service = new Services();
            service.setName(name);
            service.setCost(Integer.valueOf(cost));
            ServicesRepository.save(service);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/updateServices")
    public @ResponseBody boolean updateServices(@RequestParam(name = "idservice") String idservice,
                                                @RequestParam(name = "name") String name,
                                                @RequestParam(name = "cost") String cost) {
        try {
            Services service = ServicesRepository.findById(Integer.parseInt(idservice)).orElseThrow();
            service.setName(name);
            service.setCost(Integer.valueOf(cost));
            ServicesRepository.save(service);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/deleteServices")
    public @ResponseBody boolean deleteServices(@RequestParam(name = "idservice") String idservice) {
        try {
            ServicesRepository.deleteById(Integer.parseInt(idservice));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}