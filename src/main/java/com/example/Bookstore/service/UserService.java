package com.example.Bookstore.service;

import com.example.Bookstore.model.User;
import com.example.Bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> getUser(Integer id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User newUser, Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            User userToBeUpdated = user.get();
            userToBeUpdated.setFirstName(newUser.getFirstName());
            userToBeUpdated.setLastName(newUser.getLastName());
            userToBeUpdated.setPassword(newUser.getPassword());
            userToBeUpdated.setEmail(newUser.getEmail());

            return userRepository.save(userToBeUpdated);
        }

        return null;
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
