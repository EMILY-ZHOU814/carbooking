package com.zuche.service.impl;

import com.zuche.dao.CarMapper;
import com.zuche.pojo.Car;
import com.zuche.service.CarService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * created by emily on 2020/02/29
 */
@Service
public class CarServiceImpl implements CarService {

    @Resource
    CarMapper carMapper;

    @Override
    public Map<Integer, Car> getAllCarReserveInfo() {
        List<Car> carList = carMapper.getAllCarReserveInfo();
        if (CollectionUtils.isEmpty(carList)) {
            return null;
        }
        Map<Integer, Car> result = carList.stream().collect(Collectors.toMap(Car::getId, car -> car));
        return result;
    }

    @Override
    public List<Car> getAllCarReserveInfoList() {
        return carMapper.getAllCarReserveInfo();
    }

    @Override
    public int updateCarReserveInfo(int id, String bookDate) {
        return carMapper.update(id, bookDate);
    }

}
