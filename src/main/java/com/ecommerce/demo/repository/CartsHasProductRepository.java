package com.ecommerce.demo.repository;

import com.ecommerce.demo.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartsHasProductRepository extends JpaRepository<CartItem, Integer> {
}
