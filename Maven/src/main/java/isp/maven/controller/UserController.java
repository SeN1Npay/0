package isp.maven.controller;

import isp.maven.entity.Users;
import isp.maven.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Maven/Users")
public class UserController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/allUsers")
public @ResponseBody Iterable<Users> allUsers(){
        return usersRepository.findAll();
}
}
