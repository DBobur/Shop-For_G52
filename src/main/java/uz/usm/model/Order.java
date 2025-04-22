package uz.usm.model;

import lombok.*;
import uz.usm.model.enums.OrderStatus;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
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

    @Override
    public String toString() {
        String border = "┌──────────────────────────────┐\n";
        String divider = "├──────────────────────────────┤\n";
        String bottom = "└──────────────────────────────┘";
        StringBuilder sb = new StringBuilder();
        sb.append(border);
        sb.append("│ Order Details                │\n");
        sb.append(divider);
        sb.append(String.format("│ ID:       %-20s │\n", id.toString().substring(0, 8)));
        sb.append(String.format("│ User ID:  %-20s │\n", userId != null ? userId.toString().substring(0, 8) : "N/A"));
        sb.append(String.format("│ Status:   %-20s │\n", status != null ? status : "N/A"));
        sb.append(String.format("│ Products: %-20s │\n", products != null ? products.size() + " item(s)" : "0 item(s)"));
        sb.append(bottom);
        return sb.toString();
    }
}
