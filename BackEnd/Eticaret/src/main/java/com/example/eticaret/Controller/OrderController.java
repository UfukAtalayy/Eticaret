package com.example.eticaret.Controller;

import com.example.eticaret.DTO.OrderDTO;
import com.example.eticaret.Entity.Order;
import com.example.eticaret.Mapper.OrderMapper;
import com.example.eticaret.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(OrderService orderService,OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper=orderMapper;
    }

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        Optional<OrderDTO> order = orderService.getOrderById(id);
        return order.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO newOrder = orderService.createOrder(orderDTO);
        return ResponseEntity.ok(newOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        Optional<Order> updatedOrder = orderService.updateOrder(id, orderDetails);
        if (updatedOrder.isPresent()) {
            return ResponseEntity.ok(orderMapper.toDto(updatedOrder.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
