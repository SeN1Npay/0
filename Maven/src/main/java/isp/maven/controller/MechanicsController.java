package isp.maven.controller;

import isp.maven.entity.Mechanics;
import isp.maven.entity.Users;
import isp.maven.repository.MechanicsRepository;
import isp.maven.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Maven/Mechanics")
public class MechanicsController {

    @Autowired
    private MechanicsRepository MechanicsRepository;

    @GetMapping("/allMechanics")
    public @ResponseBody Iterable<Mechanics> allMechanics() {
        return MechanicsRepository.findAll();
    }

    @Autowired
    private UsersRepository UsersRepository;

    @PostMapping("/addMechanics")
    public @ResponseBody boolean addMechanics(@RequestParam(name = "iduser") String iduser) {
        try {
            Mechanics Mechanics = new Mechanics();
            Users Users = UsersRepository.findById(Integer.parseInt(iduser)).orElseThrow();
            Mechanics.setIduser(Users);
            MechanicsRepository.save(Mechanics);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/updateMechanics")
    public @ResponseBody boolean updateMechanics(@RequestParam(name = "idmechanic") String idmechanic,
                                                 @RequestParam(name = "iduser") String iduser) {
        try {
            Mechanics Mechanics = MechanicsRepository.findById(Integer.parseInt(idmechanic)).orElseThrow();
            Users Users = UsersRepository.findById(Integer.parseInt(iduser)).orElseThrow();
            Mechanics.setIduser(Users);
            MechanicsRepository.save(Mechanics);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/deleteMechanics")
    public @ResponseBody boolean deleteMechanics(@RequestParam(name = "idmechanic") String idmechanic) {
        try {
            MechanicsRepository.deleteById(Integer.parseInt(idmechanic));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}