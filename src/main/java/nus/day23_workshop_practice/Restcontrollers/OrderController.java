package nus.day23_workshop_practice.Restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import nus.day23_workshop_practice.Services.OrderService;
import nus.day23_workshop_practice.models.Order;

@Controller
@RequestMapping("/order/total")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @GetMapping("/search")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/")
    public String getTotalPrice(@RequestParam("order_id") int id, Model model) {
    //     private int id;
    // private LocalDateTime orderDate;
    // private int customerId;
    // private Float totalPrice;
    // private Float costPrice;
    // private Float discount;
        Order incomingOrder = orderService.findByOrderId(id);
        incomingOrder.setId(id);

        model.addAttribute("order", incomingOrder);

        return "totalPrice";
    }
    
}
