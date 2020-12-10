package br.com.ecommerce.repository;

import br.com.ecommerce.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {

    // Stored Procedures

    //void = @Procedure
    //anyReturnTypeButVoid = @Query

    @Query(value = "CALL SelectCartByUserId(:userId);", nativeQuery = true)
    Cart getCartByUserId(@Param("userId") Integer userId);
}
