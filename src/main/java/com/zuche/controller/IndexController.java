package com.zuche.controller;

import com.zuche.pojo.Car;
import com.zuche.pojo.Order;
import com.zuche.pojo.UserOrder;
import com.zuche.service.CarService;
import com.zuche.service.OrderService;
import net.minidev.json.JSONArray;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Car booking controller, provide services of query car booking information and book car for a period of time
 * created by emily on 2020/02/29
 */
@Controller
public class IndexController {

    @Autowired
    CarService carService;

    @Autowired
    OrderService orderService;

    @GetMapping("/car/query")
    public String query(HttpServletRequest request) {
        List<Car> carList = carService.getAllCarReserveInfoList();
        request.setAttribute("carList", carList);
        return "carQueryResult";
    }

    @GetMapping("/user/reservation/query")
    public String queryUserReservation(HttpServletRequest request) {
        List<UserOrder> userOrderList = orderService.getAllUserOrderByUserName(request.getParameter("userName"));
        request.setAttribute("userOrderList", userOrderList);
        return "personalReservationQueryResult";
    }

    @GetMapping("/car/book")
    public String book(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        Integer idInt = null;
        try {
            idInt = Integer.parseInt(idStr);
        } catch (Exception e) {
            // do nothing
        }
        if (idInt == null) {
            request.setAttribute("message", "id must be number format");
            return "messageForBook";
        }
        String date = request.getParameter("date");
        String userName = request.getParameter("userName");
        Map<Integer, Car> result = carService.getAllCarReserveInfo();
        Car car = result.get(idInt);
        if (car == null) {
            request.setAttribute("message", "Not exist id");
            return "messageForBook";
        }
        String scheduledDate = car.getBookDate();
        String[] bookDateList = date.split(",");
        for (String d : bookDateList) {
            if (scheduledDate.contains(d)) {
                request.setAttribute("message", String.format("This date: %s has been booked by others, please choose another date", d));
                request.setAttribute("id", idStr);
                return "messageForBook";
            }
        }
        // update car booking status
        carService.updateCarReserveInfo(idInt, car.getBookDate() == null || car.getBookDate().equals("") ? date :
                String.format("%s,%s", car.getBookDate(), date));
        // query user reservation info by selceted id (primary key of car_info table) and userName
        Order userOriginOrder = orderService.getUserOrderByUserNameAndCarId(userName, idInt);
        if (userOriginOrder == null) {
            // no history order, insert
            orderService.insert(userName, idInt, date);
        } else {
            // have history order, update
            orderService.updateUserOrderInfo(userName, idInt, userOriginOrder.getBookDate() == null || userOriginOrder.getBookDate().equals("") ? date : String.format("%s,%s", userOriginOrder.getBookDate(), date));
        }
        request.setAttribute("message", "SUCCESS");
        return "messageForBook";
    }

    //jump to homepage
    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

    //jump to car booking page
    @GetMapping(value = "/book")
    public String bookJsp(HttpServletRequest request) {
        request.setAttribute("id", request.getParameter("id"));
        return "book";
    }

    //jump to error page
    @GetMapping(value = "/error")
    public String error() {
        return "error";
    }

    //jump to personal center page
    @GetMapping(value = "/personalReservationQuery")
    public String userJsp() {
        return "personalReservationQuery";
    }
}
