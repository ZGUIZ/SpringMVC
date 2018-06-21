package com.zguiz.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.hibernate.validator.constraints.NotBlank;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

public class Book {
    @NotBlank(message = "{isbn_blank}")
    private String isbn;
    @NotBlank(message = "{bookName_blank}")
    private String bookName;
    private double price;
    private Date publishDate;
    private String publisher;
    private int categoryId;
    private String bookImage;

    private Category category;

    public Book() {
    }

    public Book(String isbn, String bookName, double price, Date publishDate, String publisher, int categoryId) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.price = price;
        this.publishDate = publishDate;
        this.publisher = publisher;
        this.categoryId = categoryId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if(isbn==null||isbn.trim().equals("")){
            this.isbn=null;
        }else {
            this.isbn = isbn;
        }
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        if(bookName==null||bookName.trim().equals("")){
            this.bookName=null;
        }else {
            this.bookName = bookName;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        if(bookName==null||bookName.trim().equals("")){
            this.bookName=null;
        } else {
            this.publisher = publisher;
        }
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String toString(){
        return isbn+"\t"+bookName+"\t"+price+"\t"+publisher+"\t"+publishDate;
    }

    public static String toJson(List<Book> books) {
        JSONArray array=new JSONArray();
        for(Book book:books){
            JSONObject object=new JSONObject();
            object.put("isbn",book.getIsbn());
            object.put("bookName",book.getBookName());
            object.put("price",book.getPrice());
            object.put("publisher",book.getPublisher());
            object.put("publishDate",book.getPublishDate());
            object.put("categoryName",book.getCategory().getName());
            array.add(object);
        }
        return array.toString();
    }
}
