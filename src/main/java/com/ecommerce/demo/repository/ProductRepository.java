package com.ecommerce.demo.repository;

import com.ecommerce.demo.entity.Product;
import com.ecommerce.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Stored Procedures
    @Query(value = "CALL FindProductsByName(:name)", nativeQuery = true)
    List<Product> findProductsByName(@Param("name") String name);
}
