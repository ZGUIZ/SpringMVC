package com.zguiz.bean;

import java.util.Date;
import java.util.List;

public class Cart {
    private int cartId;
    private int userId;
    private Date createDate;

    private List<CartItem> cartItems;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public String toString(){
        return "账号编码："+userId+"\t日期："+createDate;
    }
}
