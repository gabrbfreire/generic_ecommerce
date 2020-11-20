package br.com.ecommerce.repository;

import br.com.ecommerce.entity.Cart;
import br.com.ecommerce.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    // Stored Procedures

    //void = @Procedure
    //anyReturnTypeButVoid = @Query

    @Procedure(name = "DeleteCartItemsByCartId")
    void removeAllItemsUserCart(@Param("cartId") Integer cartId);

    @Query(value = "CALL SelectCartItemsByCartId(:cartId);", nativeQuery = true)
    List<CartItem> getCartItemsByCartId(@Param("cartId") Integer cartId);

}
