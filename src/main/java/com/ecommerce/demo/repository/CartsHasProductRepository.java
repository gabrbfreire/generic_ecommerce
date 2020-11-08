package com.ecommerce.demo.repository;

import com.ecommerce.demo.entity.CartsHasProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartsHasProductRepository extends JpaRepository<CartsHasProduct, Integer> {
}
