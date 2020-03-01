package com.zuche.dao;

import com.zuche.pojo.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * created by emily on 2020/02/29
 */
@Mapper
public interface CarMapper {
    @Select("SELECT id,carModel,carNumber,bookDate FROM car_info")
    List<Car> getAllCarReserveInfo();

    @Update("update car_info set bookDate =#{bookDate} where id=#{id}")
    int update(@Param("id") int id, @Param("bookDate") String bookDate);
}
