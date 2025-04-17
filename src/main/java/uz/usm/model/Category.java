package uz.usm.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private UUID id;
    private String name;
    private String description;
    private Category parent;

    {
        this.id = UUID.randomUUID();
    }
}
