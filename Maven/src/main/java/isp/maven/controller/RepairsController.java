package isp.maven.controller;

import isp.maven.entity.Repairs;
import isp.maven.entity.Automobiles;
import isp.maven.entity.Mechanics;
import isp.maven.entity.Serviceadvisors;
import isp.maven.entity.Repairbays;
import isp.maven.repository.RepairsRepository;
import isp.maven.repository.AutomobilesRepository;
import isp.maven.repository.MechanicsRepository;
import isp.maven.repository.ServiceadvisorsRepository;
import isp.maven.repository.RepairbaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/Maven/Repairs")
public class RepairsController {

    @Autowired private RepairsRepository RepairsRepository;
    @Autowired private AutomobilesRepository AutomobilesRepository;
    @Autowired private MechanicsRepository MechanicsRepository;
    @Autowired private ServiceadvisorsRepository ServiceadvisorsRepository;
    @Autowired private RepairbaysRepository RepairbaysRepository;

    @GetMapping("/allRepairs")
    public @ResponseBody Iterable<Repairs> allRepairs() {
        return RepairsRepository.findAll();
    }

    @PostMapping("/addRepairs")
    public @ResponseBody boolean addRepairs(@RequestParam(name = "idautomobile") String idautomobile,
                                            @RequestParam(name = "idmechanic") String idmechanic,
                                            @RequestParam(name = "idadvisor") String idadvisor,
                                            @RequestParam(name = "idbay") String idbay,
                                            @RequestParam(name = "acceptancedate") String acceptancedate,
                                            @RequestParam(name = "completiondate") String completiondate,
                                            @RequestParam(name = "status") String status) {
        try {
            Repairs repair = new Repairs();
            Automobiles auto = AutomobilesRepository.findById(Integer.parseInt(idautomobile)).orElseThrow();
            Mechanics mech = MechanicsRepository.findById(Integer.parseInt(idmechanic)).orElseThrow();
            Serviceadvisors advisor = ServiceadvisorsRepository.findById(Integer.parseInt(idadvisor)).orElseThrow();
            Repairbays bay = RepairbaysRepository.findById(Integer.parseInt(idbay)).orElseThrow();

            repair.setIdautomobile(auto);
            repair.setIdmechanic(mech);
            repair.setIdadvisor(advisor);
            repair.setIdbay(bay);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            repair.setAcceptancedate(Date.valueOf(LocalDate.parse(acceptancedate, formatter)));
            repair.setCompletiondate(Date.valueOf(LocalDate.parse(completiondate, formatter)));

            repair.setStatus(status);

            RepairsRepository.save(repair);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/updateRepairs")
    public @ResponseBody boolean updateRepairs(@RequestParam(name = "idrepair") String idrepair,
                                               @RequestParam(name = "idautomobile") String idautomobile,
                                               @RequestParam(name = "idmechanic") String idmechanic,
                                               @RequestParam(name = "idadvisor") String idadvisor,
                                               @RequestParam(name = "idbay") String idbay,
                                               @RequestParam(name = "acceptancedate") String acceptancedate,
                                               @RequestParam(name = "completiondate") String completiondate,
                                               @RequestParam(name = "status") String status) {
        try {
            Repairs repair = RepairsRepository.findById(Integer.parseInt(idrepair)).orElseThrow();
            Automobiles auto = AutomobilesRepository.findById(Integer.parseInt(idautomobile)).orElseThrow();
            Mechanics mech = MechanicsRepository.findById(Integer.parseInt(idmechanic)).orElseThrow();
            Serviceadvisors advisor = ServiceadvisorsRepository.findById(Integer.parseInt(idadvisor)).orElseThrow();
            Repairbays bay = RepairbaysRepository.findById(Integer.parseInt(idbay)).orElseThrow();

            repair.setIdautomobile(auto);
            repair.setIdmechanic(mech);
            repair.setIdadvisor(advisor);
            repair.setIdbay(bay);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            repair.setAcceptancedate(Date.valueOf(LocalDate.parse(acceptancedate, formatter)));
            repair.setCompletiondate(Date.valueOf(LocalDate.parse(completiondate, formatter)));

            repair.setStatus(status);

            RepairsRepository.save(repair);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/deleteRepairs")
    public @ResponseBody boolean deleteRepairs(@RequestParam(name = "idrepair") String idrepair) {
        try {
            RepairsRepository.deleteById(Integer.parseInt(idrepair));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}