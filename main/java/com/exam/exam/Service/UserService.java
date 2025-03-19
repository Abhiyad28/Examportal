package com.exam.exam.Service;

import com.exam.exam.Model.User;
import com.exam.exam.Model.userRole;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {

    User createUser(User user , Set<userRole> userrole);

    User getUser(String Username);
    
    void deleteUser(Long userId);
}
