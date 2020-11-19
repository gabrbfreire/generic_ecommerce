package br.com.ecommerce.repository;

import br.com.ecommerce.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    // Stored Procedures
    @Query(value = "CALL SelectCartByUserId(:userId)", nativeQuery = true)
    Cart getCartByUserId(@Param("userId") Integer userId);
}
