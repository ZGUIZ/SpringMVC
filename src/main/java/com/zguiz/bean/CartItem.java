package com.zguiz.bean;

import java.util.Date;

public class CartItem {
    private int cartItem;
    private int cartId;
    private String bookId;
    private Date addTime;
    private int count;

    private Book book;

    public CartItem() {
    }

    public CartItem(int cartItem, int cartId, String bookId, Date addTime) {
        this.cartItem = cartItem;
        this.cartId = cartId;
        this.bookId = bookId;
        this.addTime = addTime;
    }

    public int getCartItem() {
        return cartItem;
    }

    public void setCartItem(int cartItem) {
        this.cartItem = cartItem;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String toString(){
        return book.getBookName()+"\t"+book.getIsbn()+"\t"+book.getPublisher()+"\t"+count+"\t"+addTime;
    }
}
