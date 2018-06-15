package com.zguiz.service.impl;

import com.zguiz.bean.Cart;
import com.zguiz.bean.Customer;
import com.zguiz.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CartService {

    @Autowired
    private CartMapper cartMapper;

    public Cart addCart(Customer customer){
        Date date=new Date();
        Cart cart= new Cart();
        cart.setCreateDate(date);
        cart.setUserId(customer.getUserId());
        int res=cartMapper.addCart(cart);
        if(res>0){
            List<Cart> carts=cartMapper.findCart(cart);
            Cart c=carts.get(0);
            return c;
        }
        return null;
    }

}
