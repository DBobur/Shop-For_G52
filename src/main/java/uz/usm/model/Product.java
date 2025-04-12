package uz.usm.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private UUID id;
    private UUID ownerId;
    private String name;
    private String description;
    private int quantity;
    private Double price;
    private Category category;
}
