package emannoel.finance.controller.user;


import emannoel.finance.DTOs.requests.UploadImageUserProfileDTO;
import emannoel.finance.DTOs.requests.UserRequestDTO;
import emannoel.finance.config.FileStorageProperties;
import emannoel.finance.exceptions.NotFoundException;
import emannoel.finance.model.user.User;
import emannoel.finance.service.user.AddImageUserProfileService;
import emannoel.finance.service.user.CreateUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@RestController
public class UserController {

    private final CreateUserService createUserService;
    private final Path fileAbsoluteStorageLocation;
    private final AddImageUserProfileService addImageUserProfileService;

    public UserController(CreateUserService createUserService, FileStorageProperties fileStorageProperties, AddImageUserProfileService addImageUserProfileService){
        this.createUserService = createUserService;
        this.fileAbsoluteStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
        this.addImageUserProfileService = addImageUserProfileService;
    }
    @PostMapping("/user/register")
    @Validated
    public ResponseEntity<User> create(@Valid @RequestBody  UserRequestDTO userRequestDTO){
        try{
            User user = this.createUserService.handler(userRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }catch (Exception e){
            User user = new User();
            user.setErrorMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.valueOf(400)).body(user);
        }

    }

    @PostMapping("/user/upload/profile/{id}")
    public ResponseEntity<String> uploadImageProfile(@RequestParam("file") MultipartFile file, @PathVariable Long userId) throws NotFoundException {

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        try {
            Path targetLocation = fileAbsoluteStorageLocation.resolve(fileName);
            file.transferTo(targetLocation);

            UploadImageUserProfileDTO changeProfile = new UploadImageUserProfileDTO(targetLocation.toString(), userId );
            this.addImageUserProfileService.handler(changeProfile);
            return ResponseEntity.ok("Uplaod success");
        }catch (IOException ex){
            return ResponseEntity.badRequest().build();
        }
    }


//    @GetMapping("/user/profile/{fileName:.+}")
//    public ResponseEntity<Resource> getImageProfile(@PathVariable String fileName, RequestMapping request){
//        Path filePath = fileAbsuluteStorageLoacation.resolve(fileName).normalize();
//
//        try{
//            Resource resource = new UrlResource(filePath.toUri());
//            String contentType = request.get
//        }catch (){}
//    }
}
