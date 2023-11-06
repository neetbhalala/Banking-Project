package com.example.Banking.Project.Service;

import com.example.Banking.Project.Model.User;
import com.example.Banking.Project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User adddata(User u) {
        return userRepository.save(u);
    }

    public List<User> getdata() {
        return userRepository.findAll();
    }
}
