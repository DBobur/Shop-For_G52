package uz.usm.model;

import lombok.*;
import uz.usm.model.enums.OrderStatus;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private UUID id;
    private UUID userId;
    private OrderStatus status;
    private Map<UUID,Integer> products;
}
