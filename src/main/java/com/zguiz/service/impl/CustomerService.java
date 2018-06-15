package com.zguiz.service.impl;

import com.zguiz.bean.Book;
import com.zguiz.bean.Cart;
import com.zguiz.bean.CartItem;
import com.zguiz.bean.Customer;
import com.zguiz.mapper.BookMapper;
import com.zguiz.mapper.CartMapper;
import com.zguiz.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerMapper mapper;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private BookMapper bookMapper;

    public Customer login(Customer customer) throws Exception {
        if(customer.getAccount()==null || customer.getPassword()==null){
            throw new Exception("账号名或密码不能为空");
        }

        List<Customer> customers=mapper.findCustomer(customer);
        if(customers.size()!=0){
            return customers.get(0);
        }
        System.out.println("登录失败!");
        return null;
    }

    public Customer register(String account, String password) throws Exception {
        if(account==null||account.trim().equals("")||
                password==null||password.trim().equals("")){
            throw new Exception("账号名或密码不能为空!");
        }
        Customer customer= new Customer();
        customer.setAccount(account.trim());
        customer.setPassword(password.trim());
        int res=mapper.register(customer);
        Customer cus=null;
        if(res>0){
            List<Customer> customers=mapper.findCustomer(customer);
            cus=customers.get(0);
        }
        return cus;
    }

    public List<Cart> findBuyHistory(Customer customer){
        Cart cart= new Cart();
        cart.setUserId(customer.getUserId());
        List<Cart> carts=cartMapper.findCart(cart);
        for(Cart c:carts){
            List<CartItem> items=c.getCartItems();
            for(CartItem item:items){
                Book book=new Book();
                book.setIsbn(item.getBookId());
                List<Book> bookList=bookMapper.findBook(book);
                item.setBook(bookList.get(0));
            }
        }
        return carts;
    }

}
