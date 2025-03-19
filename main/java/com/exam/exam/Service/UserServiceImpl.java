package com.exam.exam.Service;

import com.exam.exam.Model.User;
import com.exam.exam.Model.userRole;
import com.exam.exam.repository.RoleRepository;
import com.exam.exam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public User createUser(User user, Set<userRole> role) {

      User local=  this.userRepository.findByUsername(user.getUsername());

      try {
          if (local != null) {
              System.out.println("User Exist");
              throw new Exception("invalid user");
          } else {
              for (userRole roles : role) {
                  this.roleRepository.save(roles.getRole());
              }
              user.getRole().addAll(role);
              local = this.userRepository.save(user);
          }

          return local;
      } catch (Exception e) {
          throw new RuntimeException("already exist");
      }
    }

    @Override
    public User getUser(String Username) {
        return this.userRepository.findByUsername(Username);
    }

	//@Override
    @Transactional
	public void deleteUser(Long userId) {
		 roleRepository.deleteById(userId);
		 this.userRepository.deleteById(userId);
		
	}
}
