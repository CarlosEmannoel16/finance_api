package emannoel.finance.controller.bank;


import emannoel.finance.DTOs.UserRequestDTO;
import emannoel.finance.model.user.User;
import emannoel.finance.service.bank.user.CreateUserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    private CreateUserService createUserService;

    public UserController(CreateUserService createUserService){
        this.createUserService = createUserService;
    }


    public User create(@RequestBody  UserRequestDTO userRequestDTO){
        User user = this.createUserService.handler(userRequestDTO);
        return user;
    }
}