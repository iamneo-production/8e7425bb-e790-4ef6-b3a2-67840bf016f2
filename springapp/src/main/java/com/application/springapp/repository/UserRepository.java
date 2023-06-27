package main.java.com.application.springapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import main.java.com.application.springapp.model.UserModel;
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    
}
