package br.com.ecommerce.service;

import br.com.ecommerce.entity.CartItem;
import br.com.ecommerce.entity.User;
import br.com.ecommerce.repository.CartItemRepository;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    CartService cartService;

    public void addItemUserCart(Integer productId, User user) {
        CartItem newCartItem = new CartItem();
        newCartItem.setProduct_id(productId);
        newCartItem.setCart_id(cartService.getCartByUser(user).getCart_id());
        cartItemRepository.save(newCartItem);
    }

    public void removeItemUserCart(Integer cartItemId) throws Exception {
        Optional<CartItem> cartItemOptional = cartItemRepository.findById(cartItemId);

        if(cartItemOptional.isPresent()){
            cartItemRepository.deleteById(cartItemId);
        }else{
            throw new Exception("Item does not exist");
        }
    }

    public void updateItemQuantityUserCart(Integer cartItemId, Integer productQuantity) throws Exception {
        Optional<CartItem> cartItemOptional = cartItemRepository.findById(cartItemId);

        if(cartItemOptional.isPresent()){
            CartItem cartItem = cartItemOptional.get();
            cartItem.setProduct_quantity(productQuantity);
            cartItemRepository.save(cartItem);
        }else {
            throw new Exception("Item does not exist");
        }
    }

    public List<CartItem> getItemsUserCart(User user) {
        return cartItemRepository.getCartItemsByCartId(cartService.getCartByUser(user).getCart_id());
    }

    public void removeAllItemsUserCart(User user) {
        cartItemRepository.removeAllItemsUserCart(cartService.getCartByUser(user).getCart_id());
    }

    public void removeCartItemByProductAndCartId(Integer cartId, Integer productId){
        cartItemRepository.DeleteCartItemByProductAndCartId(cartId, productId);
    }
}
