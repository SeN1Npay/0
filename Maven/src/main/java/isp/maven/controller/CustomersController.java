package isp.maven.controller;

import isp.maven.entity.Customers;
import isp.maven.entity.Users;
import isp.maven.repository.CustomersRepository;
import isp.maven.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Maven/Customers")
public class CustomersController {

    @Autowired
    private CustomersRepository CustomersRepository;

    @Autowired
    private UsersRepository UsersRepository;

    // 1. Выборка всех клиентов
    @GetMapping("/allCustomers")
    public @ResponseBody Iterable<Customers> allCustomers() {
        return CustomersRepository.findAll();
    }

    // 2. ВЫБОРКА ИЗ ДВУХ ТАБЛИЦ (Строго по презентации)
    @GetMapping("/allList")
    public @ResponseBody List allList() {
        List listCustomers = new ArrayList();
        for (Customers customer : CustomersRepository.findAll()) {
            listCustomers.add(customer.getIduser());
        }
        return listCustomers;
    }

    // 3. Добавление
    @PostMapping("/addCustomers")
    public @ResponseBody boolean addCustomers(@RequestParam(name = "iduser") String iduser,
                                              @RequestParam(name = "phone") String phone) {
        try {
            Customers Customers = new Customers();
            Users Users = UsersRepository.findById(Integer.parseInt(iduser)).orElseThrow();
            Customers.setIduser(Users);
            Customers.setPhone(phone);
            CustomersRepository.save(Customers);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 4. Изменение
    @PostMapping("/updateCustomers")
    public @ResponseBody boolean updateCustomers(@RequestParam(name = "idcustomer") String idcustomer,
                                                 @RequestParam(name = "iduser") String iduser,
                                                 @RequestParam(name = "phone") String phone) {
        try {
            Customers Customers = CustomersRepository.findById(Integer.parseInt(idcustomer)).orElseThrow();
            Users Users = UsersRepository.findById(Integer.parseInt(iduser)).orElseThrow();
            Customers.setIduser(Users);
            Customers.setPhone(phone);
            CustomersRepository.save(Customers);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 5. Удаление
    @PostMapping("/deleteCustomers")
    public @ResponseBody boolean deleteCustomers(@RequestParam(name = "idcustomer") String idcustomer) {
        try {
            CustomersRepository.deleteById(Integer.parseInt(idcustomer));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}