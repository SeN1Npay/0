package isp.maven.controller;

import isp.maven.entity.Salaries;
import isp.maven.entity.Users;
import isp.maven.repository.SalariesRepository;
import isp.maven.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/Maven/Salaries")
public class SalariesController {

    @Autowired
    private SalariesRepository SalariesRepository;

    @GetMapping("/allSalaries")
    public @ResponseBody Iterable<Salaries> allSalaries() {
        return SalariesRepository.findAll();
    }

    @Autowired
    private UsersRepository UsersRepository;

    @PostMapping("/addSalaries")
    public @ResponseBody boolean addSalaries(@RequestParam(name = "iduser") String iduser,
                                             @RequestParam(name = "periodstart") String periodstart,
                                             @RequestParam(name = "periodend") String periodend,
                                             @RequestParam(name = "amount") String amount,
                                             @RequestParam(name = "paymentdate") String paymentdate) {
        try {
            Salaries Salaries = new Salaries();
            Users Users = UsersRepository.findById(Integer.parseInt(iduser)).orElseThrow();
            Salaries.setIduser(Users);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Salaries.setPeriodstart(Date.valueOf(LocalDate.parse(periodstart, formatter)));
            Salaries.setPeriodend(Date.valueOf(LocalDate.parse(periodend, formatter)));
            Salaries.setAmount(Integer.valueOf(amount));
            Salaries.setPaymentdate(Date.valueOf(LocalDate.parse(paymentdate, formatter)));

            SalariesRepository.save(Salaries);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/updateSalaries")
    public @ResponseBody boolean updateSalaries(@RequestParam(name = "idsalary") String idsalary,
                                                @RequestParam(name = "iduser") String iduser,
                                                @RequestParam(name = "periodstart") String periodstart,
                                                @RequestParam(name = "periodend") String periodend,
                                                @RequestParam(name = "amount") String amount,
                                                @RequestParam(name = "paymentdate") String paymentdate) {
        try {
            Salaries Salaries = SalariesRepository.findById(Integer.parseInt(idsalary)).orElseThrow();
            Users Users = UsersRepository.findById(Integer.parseInt(iduser)).orElseThrow();
            Salaries.setIduser(Users);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Salaries.setPeriodstart(Date.valueOf(LocalDate.parse(periodstart, formatter)));
            Salaries.setPeriodend(Date.valueOf(LocalDate.parse(periodend, formatter)));
            Salaries.setAmount(Integer.valueOf(amount));
            Salaries.setPaymentdate(Date.valueOf(LocalDate.parse(paymentdate, formatter)));

            SalariesRepository.save(Salaries);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/deleteSalaries")
    public @ResponseBody boolean deleteSalaries(@RequestParam(name = "idsalary") String idsalary) {
        try {
            SalariesRepository.deleteById(Integer.parseInt(idsalary));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}