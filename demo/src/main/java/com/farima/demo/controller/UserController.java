package com.farima.demo.controller;

import com.farima.demo.Utils.FileUtil;
import com.farima.demo.dto.UserDto;
import com.farima.demo.entity.Project;
import com.farima.demo.entity.User;
import com.farima.demo.repository.UserRepository;
import com.farima.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    public Iterable<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") final Long id) {
        Optional<User> user = userService.getUser(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") final Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/modif")
    public User updateUser(@RequestBody UserDto u){
        return userService.updateUser(u);
    }

    @PostMapping()
    public User createUser(@RequestBody User u){
        return userService.saveUser(u);
    }

/*    @PostMapping("/user")
    public User createUser(@RequestPart("image") MultipartFile file,@RequestPart("user") UserDto userDto){
        User user = upload(file,userDto);
        return user;
    }*/

/* bamba code
    @PostMapping("/utilisateur")
    public Utilisateur CreatUtilisateur(@RequestPart("img") MultipartFile file,@RequestPart("utilisateur") UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = upload(file,utilisateurDto);
        return utilisateur;
    }
*/

   /* private User upload (MultipartFile file, UserDto userDto){
        String fileName = "";
        String lastFile = "";
        if(file != null){
            String[] nameExtension = Objects.requireNonNull(file.getContentType()).split("/");//pour dire le type de l'img(jpg, png, jpeg=
            fileName = "photo" + "." + nameExtension;//le nom donner à mon file par defaut
            lastFile = userDto.getId() != null ?userDto.getImage():"";
            userDto.setImage(lastFile);
        }
        User user = userRepository.save(modelMapper.map(userDto, User.class));
        if (file != null){
            try {
                if (user.getId() != null){
                    FileUtil.saveFileAndReplace(lastFile, file, fileName, user.getId());
                }else{
                    FileUtil.saveFile(user.getId(), fileName, file);
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return user;
    }*/

}
