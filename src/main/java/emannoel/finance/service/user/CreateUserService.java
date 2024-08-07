package emannoel.finance.service.user;

import emannoel.finance.DTOs.requests.UserRequestDTO;
import emannoel.finance.model.user.User;
import emannoel.finance.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {

    private final UserRepository userRepository;
    public CreateUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public User handler(UserRequestDTO userRequestDTO){

        User user = new User();

        user.setEmail(userRequestDTO.email());
        user.setName(userRequestDTO.name());
        user.setPassword(userRequestDTO.password());
        this.userRepository.save(user);
        return user;



    }
}
