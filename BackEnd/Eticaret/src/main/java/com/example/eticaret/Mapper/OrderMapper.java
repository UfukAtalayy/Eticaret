package com.example.eticaret.Mapper;

import com.example.eticaret.DTO.OrderDTO;
import com.example.eticaret.Entity.Order;
import com.example.eticaret.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderDTO toDto(Order order) {
        return new OrderDTO(
                order.getId(),
                order.getUser().getId(),
                order.getTotalAmount(),
                order.getStatus()
        );
    }

    public Order toEntity(OrderDTO orderDTO, User user) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setUser(user);
        order.setTotalAmount(orderDTO.getTotalAmount());
        order.setStatus(orderDTO.getStatus());
        // orderDate burada otomatik olarak set ediliyor.
        return order;
    }
}
