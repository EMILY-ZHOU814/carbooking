package com.zuche.service;

import com.zuche.pojo.Car;

import java.util.List;
import java.util.Map;

/**
 * created by emily on 2020/02/29
 */
public interface CarService {
    /**
     * Get all car reservation information, return HashMap
     * @return
     */
    Map<Integer, Car> getAllCarReserveInfo();

    /**
     * Get all car reservation information, return List
     * @return
     */
    List<Car> getAllCarReserveInfoList();

    /**
     * update car reservation info
     * @param id
     * @param bookDate
     * @return
     */
    int updateCarReserveInfo(int id, String bookDate);
}
