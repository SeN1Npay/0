package isp.maven.controller;

import isp.maven.entity.Serviceadvisors;
import isp.maven.entity.Users;
import isp.maven.repository.ServiceadvisorsRepository;
import isp.maven.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Maven/Serviceadvisors")
public class ServiceadvisorsController {

    @Autowired
    private ServiceadvisorsRepository ServiceadvisorsRepository;

    @GetMapping("/allServiceadvisors")
    public @ResponseBody Iterable<Serviceadvisors> allServiceadvisors() {
        return ServiceadvisorsRepository.findAll();
    }

    @Autowired
    private UsersRepository UsersRepository;

    @PostMapping("/addServiceadvisors")
    public @ResponseBody boolean addServiceadvisors(@RequestParam(name = "iduser") String iduser) {
        try {
            Serviceadvisors Serviceadvisors = new Serviceadvisors();
            Users Users = UsersRepository.findById(Integer.parseInt(iduser)).orElseThrow();
            Serviceadvisors.setIduser(Users);
            ServiceadvisorsRepository.save(Serviceadvisors);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/updateServiceadvisors")
    public @ResponseBody boolean updateServiceadvisors(@RequestParam(name = "idadvisor") String idadvisor,
                                                       @RequestParam(name = "iduser") String iduser) {
        try {
            Serviceadvisors Serviceadvisors = ServiceadvisorsRepository.findById(Integer.parseInt(idadvisor)).orElseThrow();
            Users Users = UsersRepository.findById(Integer.parseInt(iduser)).orElseThrow();
            Serviceadvisors.setIduser(Users);
            ServiceadvisorsRepository.save(Serviceadvisors);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/deleteServiceadvisors")
    public @ResponseBody boolean deleteServiceadvisors(@RequestParam(name = "idadvisor") String idadvisor) {
        try {
            ServiceadvisorsRepository.deleteById(Integer.parseInt(idadvisor));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}