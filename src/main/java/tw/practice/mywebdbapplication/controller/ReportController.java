package tw.practice.mywebdbapplication.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tw.practice.mywebdbapplication.data.DBProvider;
import tw.practice.mywebdbapplication.model.Orders_demo;
import tw.practice.mywebdbapplication.service.DBService;

import java.sql.ResultSet;
import java.util.List;

@Controller
public class ReportController {
    DBProvider dbProvider = new DBProvider();

    //託管版本 -> Spring Boot會自動處理宣告物件 即可使用(不用new的方式建立物件)
    @Autowired
    DBService dbService;

    @GetMapping("/testService")
    public String sayHello(Model model){
        //注意重點: dbService並無 new DBService的過程 注意-> 必須使用@Autowired裝飾
        String name = dbService.getOrdersAll();
        Long cusa = dbService.countByCountry("USA");
        Long cfr = dbService.countByCountry("France");
        model.addAttribute("name", name);
        model.addAttribute("USA", cusa);
        model.addAttribute("France", cfr);
        return "hello";
    }

    @GetMapping("/orders")
    public String getOrderList(Model model){
        ResultSet rs = null;
        List<Orders_demo> orders;
        //提供一個訂單總覽
        String sql = """
                SELECT
                    orders.orderNumber,
                    orders.orderDate,
                    orders.requiredDate,
                    orders.comments,
                    customers.customerName
                FROM
                    orders
                JOIN
                    customers
                ON
                    customers.customerNumber = orders.customerNumber
                """;
        orders = dbProvider.getOrderData(sql);
        //接收資料 放入model
        model.addAttribute("orders", orders);
        return "orders_list";
    }

    public String getOrderDetails(){
        //提供一個訂單總覽 點選其中一筆 在顯示訂單明細
        return "orderDetail";
    }

}
