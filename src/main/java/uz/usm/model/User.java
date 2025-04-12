package uz.usm.model;
import lombok.*;
import uz.usm.model.enums.UserRole;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@ToString
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
}
