package Practica.Jhonny.caseuse;


import Practica.Jhonny.entity.User;
import Practica.Jhonny.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User newUser) {
        return userService.save(newUser);
    }
}
