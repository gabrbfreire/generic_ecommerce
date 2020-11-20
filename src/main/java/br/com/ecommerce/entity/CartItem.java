package br.com.ecommerce.entity;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import javax.persistence.*;

@Entity(name = "cart_item")
@NamedStoredProcedureQuery(
        name = "DeleteCartItemsByCartId",
        procedureName = "DeleteCartItemsByCartId",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "cartId", type = Integer.class)
        }
)
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cart_item_id;
    private Integer cart_id;
    private Integer product_id;
    private Integer product_quantity;

    public Integer getCart_item_id() {
        return cart_item_id;
    }

    public Integer getCart_id() {
        return cart_id;
    }

    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(Integer product_quantity) {
        this.product_quantity = product_quantity;
    }
}
