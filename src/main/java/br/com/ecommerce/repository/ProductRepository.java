package br.com.ecommerce.repository;

import br.com.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    // Stored Procedures

    //void = @Procedure
    //anyReturnTypeButVoid = @Query

    @Query(value = "CALL SelectProductsByName(:name)", nativeQuery = true)
    List<Product> findProductsByName(@Param("name") String name);

    @Query(value = "CALL SelectProductsByCategoryId(:categoryId)", nativeQuery = true)
    List<Product> getProductsByCategoryId(@Param("categoryId") Integer categoryId);

    @Query(value = "CALL SelectProductsByCartId(:cartId)", nativeQuery = true)
    List<Product> getProductsByCartId(@Param("cartId") Integer cartId);
}
