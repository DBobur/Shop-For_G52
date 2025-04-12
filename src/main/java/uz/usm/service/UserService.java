package uz.usm.service;

import uz.usm.model.User;
import uz.usm.repository.UserRepository;

import java.util.List;

public class UserService {
    private static UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean addUser(User user) {
        if(checkUsername(user.getUsername())){
            return false;
        }
        return userRepository.save(user);
    }

    private boolean checkUsername(String username) {
        List<User> users = userRepository.readUsers();
        for (User user : users) {
            if(user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public User login(String username, String password) {
        List<User> users = userRepository.readUsers();
        for (User user : users) {
            if(
                    user.getUsername().equals(username) &&
                    user.getPassword().equals(password)
            ){
                return user;
            }
        }
        return null;
    }
}
