package com.example.eticaret.Service;

import com.example.eticaret.DTO.OrderDTO;
import com.example.eticaret.Entity.Order;
import com.example.eticaret.Entity.Product;
import com.example.eticaret.Entity.User;
import com.example.eticaret.Mapper.OrderMapper;
import com.example.eticaret.Repository.OrderRepository;
import com.example.eticaret.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserRepository userRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderMapper = orderMapper;
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<OrderDTO> getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(orderMapper::toDto);
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        User user = userRepository.findById(orderDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Order order = orderMapper.toEntity(orderDTO, user);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDto(savedOrder);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Optional<Order> updateOrder(Long id, Order orderDetails) {
        Optional<Order> existingOrder = orderRepository.findById(id);

        if (existingOrder.isPresent()) {
            Order orderToUpdate = existingOrder.get();

            // Diğer alanları güncelle
            orderToUpdate.setStatus(orderDetails.getStatus());
            orderToUpdate.setTotalAmount(orderDetails.getTotalAmount());

            // Eğer yeni bir kullanıcı ID'si ile güncellemek isteniyorsa:
            if (orderDetails.getUser() != null && orderDetails.getUser().getId() != null) {
                Optional<User> newUser = userRepository.findById(orderDetails.getUser().getId());
                if (newUser.isPresent()) {
                    orderToUpdate.setUser(newUser.get());  // Güncellenen kullanıcı ile ilişkilendir
                } else {
                    throw new IllegalArgumentException("Geçersiz kullanıcı ID");
                }
            }

            return Optional.of(orderRepository.save(orderToUpdate));
        } else {
            return Optional.empty();  // Eğer sipariş bulunamazsa boş döner
        }
    }

}
