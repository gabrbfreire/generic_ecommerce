package br.com.ecommerce.repository;

import br.com.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Stored Procedures

    //void = @Procedure
    //anyReturnTypeButVoid = @Query

    @Query(value = "CALL SelectProductsByName(:name)", nativeQuery = true)
    List<Product> findProductsByName(@Param("name") String name);
}
