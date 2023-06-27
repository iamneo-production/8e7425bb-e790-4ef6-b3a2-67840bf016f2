package main.java.com.application.springapp.service;

import main.java.com.application.springapp.model.UserModel;
import main.java.com.application.springapp.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }
	public List<UserModel> getAllUsers() {
		return userRepository.findAll();
	}

    
}
