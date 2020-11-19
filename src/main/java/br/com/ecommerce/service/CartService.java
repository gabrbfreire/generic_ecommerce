package br.com.ecommerce.service;

import br.com.ecommerce.entity.Cart;
import br.com.ecommerce.entity.User;
import br.com.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public void addNewCartWithLogin(User user){
        Cart newCart = new Cart();
        newCart.setUser_id(user.getUser_id());
        cartRepository.save(newCart);
    }

    public void addNewCartNoLogin() {
        Cart newCart = new Cart();
        cartRepository.save(newCart);
    }

    public Cart getCartByUserId(User user){
        return cartRepository.getCartByUserId(user.getUser_id());
    }

//    public Cart getCardByUserId(User user){
//        cartRepository.getCartByUserId(user.getUser_id());
//    }
}
