package com.zguiz.service.impl;

import com.zguiz.bean.Book;
import com.zguiz.bean.Cart;
import com.zguiz.bean.CartItem;
import com.zguiz.mapper.CartItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service

public class CartItemService{

    @Autowired
    private CartItemMapper mapper;

    public boolean addItem(Book book, int number, Cart cart){
        CartItem cartItem= new CartItem();
        cartItem.setAddTime(new Date());
        cartItem.setBookId(book.getIsbn());
        cartItem.setCartId(cart.getCartId());
        cartItem.setCount(number);
        int res=mapper.addCartItem(cartItem);
        if(res>0){
            return true;
        }
        return false;
    }

}
