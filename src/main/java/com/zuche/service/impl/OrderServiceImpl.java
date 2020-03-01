package com.zuche.service.impl;

import com.zuche.dao.OrderMapper;
import com.zuche.pojo.Order;
import com.zuche.pojo.UserOrder;
import com.zuche.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by emily on 2020/02/29
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderMapper orderMapper;

    @Override
    public List<UserOrder> getAllUserOrderByUserName(String userName) {
        return orderMapper.getAllUserOrderByUserName(userName);
    }

    @Override
    public int updateUserOrderInfo(String userName, int carId, String bookDate) {
        return orderMapper.update(userName, carId, bookDate);
    }

    @Override
    public Order getUserOrderByUserNameAndCarId(String userName, int carId) {
        return orderMapper.getUserOrderByUserNameAndCarId(userName, carId);
    }

    @Override
    public int insert(String userName, int carId, String bookDate) {
//        return orderMapper.insert(userName, carId, bookDate);
        Order order = new Order();
        order.setUserName(userName);
        order.setCarId(carId);
        order.setBookDate(bookDate);
        return orderMapper.insertOrder(order);
    }

}
