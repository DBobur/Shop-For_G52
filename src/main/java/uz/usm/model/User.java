package uz.usm.model;
import lombok.*;
import uz.usm.model.enums.UserRole;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private UUID id;
    private String name;
    private String username;
    private String password;
    private Double balance;
    private UserRole role;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    {
        this.id = UUID.randomUUID();
        this.balance = 100.0;
        this.role = UserRole.USER_ROLE;
    }

    @Override
    public User clone(){
        User user = new User();
        user.id = id;
        user.name = name;
        user.username = username;
        user.password = password;
        user.balance = balance;
        user.role = role;
        return user;
    }

    @Override
    public String toString() {
        return  ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                ", role=" + role;
    }
}
