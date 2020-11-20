package br.com.ecommerce.service;

import br.com.ecommerce.entity.CartItem;
import br.com.ecommerce.entity.User;
import br.com.ecommerce.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {

    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    CartService cartService;

    public void addItemToUserCart(Integer productId, Integer productQuantity, User user) {
        CartItem newCartItem = new CartItem();
        newCartItem.setProduct_id(productId);
        newCartItem.setProduct_quantity(productQuantity);
        newCartItem.setCart_id(cartService.getCartByUserId(user).getCart_id());
        cartItemRepository.save(newCartItem);
    }
}
