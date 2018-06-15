package com.zguiz.mapper;

import com.zguiz.bean.Customer;

import java.util.List;

public interface CustomerMapper {
    /**
     * 查找账号
     * @return
     */
    List<Customer> findCustomer(Customer customer);

    /**
     * 注册
     * @param customer
     * @return
     */
    int register(Customer customer);
}
