package com.ecommerce.demo.service;

import com.ecommerce.demo.entity.Cart;
import com.ecommerce.demo.entity.User;
import com.ecommerce.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public void addNewCart(User user){
        Cart newCart = new Cart();
        newCart.setUser_id(user.getUser_id());
        cartRepository.save(newCart);
    }
}
