package br.com.ecommerce.repository;

import br.com.ecommerce.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    // Stored Procedures

    //void = @Procedure
    //anyReturnTypeButVoid = @Query

    @Query(value = "CALL SelectUserByEmail(:email)", nativeQuery = true)
    List<User> findUserByEmail(@Param("email") String email);
}
