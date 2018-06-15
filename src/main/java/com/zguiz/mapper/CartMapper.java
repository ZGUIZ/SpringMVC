package com.zguiz.mapper;

import com.zguiz.bean.Cart;

import java.util.List;

public interface CartMapper {
    int addCart(Cart cart);
    List<Cart> findCart(Cart cart);
}
