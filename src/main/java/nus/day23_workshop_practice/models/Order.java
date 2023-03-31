package nus.day23_workshop_practice.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private int id;
    private LocalDateTime orderDate;
    private int customerId;
    private Float totalPrice;
    private Float costPrice;
    private Float discount;
    
}
