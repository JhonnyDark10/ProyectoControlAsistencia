package Practica.Jhonny.caseuse;

import Practica.Jhonny.entity.User;
import Practica.Jhonny.service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser{
   private UserService userService;


    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
