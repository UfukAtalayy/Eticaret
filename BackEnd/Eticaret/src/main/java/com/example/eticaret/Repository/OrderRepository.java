package com.example.eticaret.Repository;

import com.example.eticaret.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Long> {
    // Belirli bir kullanıcının siparişlerini listeleme
    List<Order> findByUserId(Long userId);

    // Sipariş durumuna göre siparişleri bulma
    List<Order> findByStatus(String status);

    // Belirli bir kullanıcının ve durumun siparişlerini bulma
    List<Order> findByUserIdAndStatus(Long userId, String status);
}
