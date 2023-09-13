package com.iternova.becalled.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public void register(User user) {
        user.setStatus("online");
        userRepository.save(user);
    }

    public User login(User user) throws UserNotFoundException{
      User loginUser = userRepository.findByEmail(user.getEmail());
      if(!loginUser.getPassword().equals(user.getPassword())){
          throw new UserNotFoundException("Contraseña incorrecta");

       }
      loginUser.setStatus("online");
      userRepository.save(loginUser);
      return loginUser;

    }

    public void logout(String email) {
        User user = userRepository.findByEmail(email);
        user.setStatus("offline");
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAllConnected();
    }
}