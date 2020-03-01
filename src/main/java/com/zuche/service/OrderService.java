package com.zuche.service;

import com.zuche.pojo.Order;
import com.zuche.pojo.UserOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by emily on 2020/02/29
 */
public interface OrderService {

    /**
     * Get all user's car booking order info
     *
     * @param userName
     * @return
     */
    List<UserOrder> getAllUserOrderByUserName(String userName);

    /**
     * update user's order info
     *
     * @param userName
     * @param carId
     * @param bookDate
     */
    int updateUserOrderInfo(String userName, int carId, String bookDate);

    /**
     * Query car booking order info by userName and carId
     *
     * @param userName
     * @param carId
     * @return
     */
    Order getUserOrderByUserNameAndCarId(String userName, int carId);

    /**
     * insert user reservation info
     * @param userName
     * @param carId
     * @param bookDate
     * @return
     */
    int insert(String userName, int carId, String bookDate);

}
