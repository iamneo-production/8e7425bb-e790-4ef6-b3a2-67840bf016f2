package main.java.com.application.springapp.controllers;

import main.java.com.application.springapp.model.UserModel;
import main.java.com.application.springapp.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
	public List<UserModel> getAllUsers(){
		return userService.getAllUsers();
	}


    
    
}
