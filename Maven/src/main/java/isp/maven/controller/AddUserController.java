package isp.maven.controller;

import isp.maven.entity.Users;
import isp.maven.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class AddUserController {

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/Maven/addUsers")
    public @ResponseBody boolean addUsers(@RequestParam(name = "lastname") String lastname,
                                          @RequestParam(name = "firstname") String firstname,
                                          @RequestParam(name = "middlename") String middlename,
                                          @RequestParam(name = "birthdate") String birthdate,
                                          @RequestParam(name = "employmentdate") String employmentdate,
                                          @RequestParam(name = "passport") String passport,
                                          @RequestParam(name = "snils") String snils,
                                          @RequestParam(name = "email") String email,
                                          @RequestParam(name = "photolink") String photolink,
                                          @RequestParam(name = "login") String login,
                                          @RequestParam(name = "passwordhash") String passwordhash,
                                          @RequestParam(name = "status") String status,
                                          @RequestParam(name = "registrationcode") String registrationcode) {

        Users user = new Users();

        user.setLastname(lastname);
        user.setFirstname(firstname);
        user.setMiddlename(middlename);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate birth = LocalDate.parse(birthdate, formatter);
        user.setBirthdate(Date.valueOf(birth));

        LocalDate employment = LocalDate.parse(employmentdate, formatter);
        user.setEmploymentdate(Date.valueOf(employment));

        user.setPassport(passport);
        user.setSnils(snils);
        user.setEmail(email);
        user.setPhotolink(photolink);
        user.setLogin(login);
        user.setPasswordhash(passwordhash);
        user.setStatus(status);
        user.setRegistrationcode(registrationcode);

        usersRepository.save(user);
        return true;
    }

    // ИЗМЕНЕНИЕ
    @PostMapping("/Maven/updateUser")
    public @ResponseBody boolean updateUser(@RequestParam(name = "lastname") String lastname,
                                            @RequestParam(name = "firstname") String firstname,
                                            @RequestParam(name = "middlename") String middlename,
                                            @RequestParam(name = "birthdate") String birthdate,
                                            @RequestParam(name = "login") String login,
                                            @RequestParam(name = "passwordhash") String passwordhash,
                                            @RequestParam(name = "iduser") String iduser) {
        try {
            Integer id = Integer.parseInt(iduser);

            Users user = usersRepository.findById(id).orElseThrow();

            user.setLastname(lastname);
            user.setFirstname(firstname);
            user.setMiddlename(middlename);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try {
                LocalDate date = LocalDate.parse(birthdate, formatter);
                user.setBirthdate(Date.valueOf(date));
            } catch (Exception e) {
                System.out.println(e);
            }

            user.setLogin(login);
            user.setPasswordhash(passwordhash);

            usersRepository.save(user);
            return true;

        } catch (NumberFormatException e) {
            System.out.println("Ошибка формата ID: " + e);
            return false;
        } catch (Exception e) {
            // Если пользователь с таким ID не найден
            System.out.println("Пользователь не найден: " + e);
            return false;
        }
    }

    // УДАЛЕНИЕ
    @PostMapping("/Maven/deleteUser")
    public @ResponseBody boolean deleteUser(@RequestParam(name = "iduser") String iduser) {
        try {
            usersRepository.deleteById(Integer.parseInt(iduser));
            return true;
        } catch (Exception e) {
            System.out.println("Ошибка удаления: " + e.getMessage());
            return false;
        }
    }
}