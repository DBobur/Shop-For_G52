package uz.usm.model;

import lombok.*;
import uz.usm.model.enums.OrderStatus;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    private UUID id;
    private UUID userId;
    private OrderStatus status;
    private Map<UUID,Integer> products;

    {
        id = UUID.randomUUID();
        status = OrderStatus.NEW;
    }
}
