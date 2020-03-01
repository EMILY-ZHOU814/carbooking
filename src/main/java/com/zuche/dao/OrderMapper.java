package com.zuche.dao;

import com.zuche.pojo.Order;
import com.zuche.pojo.UserOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * created by emily on 2020/02/29
 */
@Mapper
public interface OrderMapper {

    @Select("SELECT car_info.carModel, car_info.carNumber,user_order_info.bookDate from car_info, user_order_info where car_info.id=user_order_info.carId and user_order_info.userName=#{userName}")
    List<UserOrder> getAllUserOrderByUserName(String userName);

    @Select("SELECT id,userName,carId,bookDate FROM user_order_info where userName=#{userName} and carId=#{carId}")
    Order getUserOrderByUserNameAndCarId(String userName, int carId);

    @Update("update user_order_info set bookDate =#{bookDate} where userName=#{userName} and carId=#{carId}")
    int update(@Param("userName") String userName, @Param("carId") int carId, @Param("bookDate") String bookDate);

    @Insert("insert into user_order_info(userName, carId, bookDate) values (#{userName},#{carId},#{bookDate})")
    int insert(@Param("userName") String userName, @Param("carId") int carId, @Param("bookDate") String bookDate);

    @Insert({
            "insert into user_order_info (" +
                    "userName, " +
                    "carId, " +
                    "bookDate)",
            "values (#{userName}, " +
                    "#{carId}, " +
                    "#{bookDate})"
    })
    @Options(useGeneratedKeys=true, keyProperty="id",keyColumn = "id")
    int insertOrder(Order order);
}
