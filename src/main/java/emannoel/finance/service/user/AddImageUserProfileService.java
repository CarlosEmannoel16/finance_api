package emannoel.finance.service.user;


import emannoel.finance.DTOs.requests.UploadImageUserProfileDTO;
import emannoel.finance.exceptions.NotFoundException;
import emannoel.finance.model.user.User;
import emannoel.finance.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddImageUserProfileService {

    private final UserRepository userRepository;

    public AddImageUserProfileService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User handler(UploadImageUserProfileDTO uploadUserProfileDTO) throws NotFoundException {

        Optional<User> responseDb = this.userRepository.findById(uploadUserProfileDTO.userId());

        if(responseDb.isPresent()){
            User user = responseDb.get();
            user.setProfileImage(uploadUserProfileDTO.urlPath());
            this.userRepository.save(user);
            return user;
        }

        throw new NotFoundException("user not exists");
    }
}
