package emannoel.finance.controller.user;


import emannoel.finance.DTOs.requests.UserRequestDTO;
import emannoel.finance.model.user.User;
import emannoel.finance.service.user.CreateUserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
