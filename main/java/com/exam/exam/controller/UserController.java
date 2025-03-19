package com.exam.exam.controller;

import com.exam.exam.Model.Role;
import com.exam.exam.Model.User;
import com.exam.exam.Model.userRole;
import com.exam.exam.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostMapping()
    public User create(@RequestBody User user){

        Set<userRole> role1=new HashSet<>() ;
       Role role=new Role();
       role.setRoleName("Normal");
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       userRole usrole=new userRole();
       usrole.setUser(user);
       usrole.setRole(role);

       role1.add(usrole);

       return userService.createUser(user,role1);
    }

    @GetMapping("/{Username}")
     User getUser(@PathVariable("Username") String Username){

        return this.userService.getUser(Username);
    }
    
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
    	
    	this.userService.deleteUser(userId);
    }
}
