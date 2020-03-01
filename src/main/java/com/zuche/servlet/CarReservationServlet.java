//package com.zuche.servlet;
//
//import com.zuche.pojo.UserOrder;
//import com.zuche.service.CarService;
//import com.zuche.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
///**
// * Servlet implementation class CarReservationServlet, handle web request
// * created by emily on 2020/02/29
// */
//@WebServlet("/CarReservationServlet")
//public class CarReservationServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    public CarReservationServlet() {
//        super();
//    }
//
//    // CarService provide interface to query car and car booked date info
//    @Autowired
//    CarService carService;
//
//    // OrderService provide interface to query user car reservation info
//    @Autowired
//    OrderService orderService;
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        service(request, response);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        service(request, response);
//    }
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
//        String method = req.getParameter("method");
//        if ("queryUserOrderByName".equals(method)) {
//            queryUserOrderByName(req, resp);
//        }
//    }
//
//    private void queryUserOrderByName(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        req.setCharacterEncoding("utf-8");
//        String userName = req.getParameter("userName");
//        List<UserOrder> userOrders = orderService.getAllUserOrderByUserName(userName);
//        req.setAttribute("userOrders", userOrders);
//        req.getRequestDispatcher("userOrderList.jsp").forward(req, resp);
//
//    }
//}
