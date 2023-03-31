package nus.day23_workshop_practice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nus.day23_workshop_practice.Repositories.OrderRepository;
import nus.day23_workshop_practice.models.Order;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order findByOrderId(int id) {
        return orderRepository.findByOrderId(id);
    }
    
}
