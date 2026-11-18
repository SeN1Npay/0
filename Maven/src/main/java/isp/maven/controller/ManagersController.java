package isp.maven.controller;

import isp.maven.entity.Managers;
import isp.maven.entity.Users;
import isp.maven.repository.ManagersRepository;
import isp.maven.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Maven/Managers")
public class ManagersController {

    @Autowired
    private ManagersRepository ManagersRepository;

    @Autowired
    private UsersRepository UsersRepository;

    // 1. Выборка всех
    @GetMapping("/allManagers")
    public @ResponseBody Iterable<Managers> allManagers() {
        return ManagersRepository.findAll();
    }

    // 2. ВЫБОРКА ИЗ ДВУХ ТАБЛИЦ (Строго по презентации)
    @GetMapping("/allList")
    public @ResponseBody List allList() {
        List listManagers = new ArrayList();
        for (Managers manager : ManagersRepository.findAll()) {
            listManagers.add(manager.getIduser());
        }
        return listManagers;
    }

    // 3. Добавление
    @PostMapping("/addManagers")
    public @ResponseBody boolean addManagers(@RequestParam(name = "iduser") String iduser) {
        try {
            Managers Managers = new Managers();
            Users Users = UsersRepository.findById(Integer.parseInt(iduser)).orElseThrow();
            Managers.setIduser(Users);
            ManagersRepository.save(Managers);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 4. Изменение
    @PostMapping("/updateManagers")
    public @ResponseBody boolean updateManagers(@RequestParam(name = "idmanager") String idmanager,
                                                @RequestParam(name = "iduser") String iduser) {
        try {
            Managers Managers = ManagersRepository.findById(Integer.parseInt(idmanager)).orElseThrow();
            Users Users = UsersRepository.findById(Integer.parseInt(iduser)).orElseThrow();
            Managers.setIduser(Users);
            ManagersRepository.save(Managers);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 5. Удаление
    @PostMapping("/deleteManagers")
    public @ResponseBody boolean deleteManagers(@RequestParam(name = "idmanager") String idmanager) {
        try {
            ManagersRepository.deleteById(Integer.parseInt(idmanager));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}