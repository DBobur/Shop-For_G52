package uz.usm.model;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    private UUID id;
    private UUID ownerId;
    private String name;
    private String description;
    private int quantity;
    private Double price;
    private UUID categoryId;

    {
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return  ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price;
    }
}
