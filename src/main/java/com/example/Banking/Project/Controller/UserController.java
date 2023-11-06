package com.example.Banking.Project.Controller;

import com.example.Banking.Project.Model.User;
import com.example.Banking.Project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    private User adddata(@RequestBody User u){
        return userService.adddata(u);
    }

    @GetMapping("/getuser")
    private List<User> getdata(){
        return userService.getdata();
    }

}
