package br.com.ecommerce.repository;

import br.com.ecommerce.entity.CartItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Integer> {

    // Stored Procedures

    //void = @Procedure
    //anyReturnTypeButVoid = @Query

    @Procedure(name = "DeleteCartItemsByCartId")
    void removeAllItemsUserCart(@Param("cartId") Integer cartId);

    @Query(value = "CALL SelectCartItemsByCartId(:cartId);", nativeQuery = true)
    List<CartItem> getCartItemsByCartId(@Param("cartId") Integer cartId);

    @Procedure(name = "DeleteCartItemByProductAndCartId")
    void DeleteCartItemByProductAndCartId(@Param("cartId") Integer cartId, @Param("productId") Integer productId);

}
