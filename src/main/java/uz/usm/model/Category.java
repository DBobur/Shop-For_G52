package uz.usm.model;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {
    private UUID id;
    private String name;
    private String description;
    private UUID parentId;

    {
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return  ", name='" + name + '\'' +
                ", description='" + description;
    }
}
