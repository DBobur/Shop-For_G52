package uz.usm.repository;

import lombok.NoArgsConstructor;
import uz.usm.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class UserRepository {
    private static final String USER_FILE = "src/main/resources/users.txt";

    public boolean save(User user){
        List<User> users = readUsers();
        users.add(user);
        return writeUsers(users);
    }

    public boolean writeUsers(List<User> users) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(USER_FILE))) {
            out.writeObject(users);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<User> readUsers() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(USER_FILE))) {
            return (List<User>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
