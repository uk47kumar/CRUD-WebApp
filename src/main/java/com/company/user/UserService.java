package com.company.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return (List<User>) userRepository.findAll();
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public User updateUser(Integer id) throws UserNotFoundException {
        Optional<User> result = userRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("could not find any users with ID " + id);
    }

    public void deleteUser(Integer id) throws UserNotFoundException {
        Long count = userRepository.countById(id);
        if (count == null || count == 0){
            throw new UserNotFoundException("could not find any users with ID " + id);
        }
        userRepository.deleteById(id);
    }

}
