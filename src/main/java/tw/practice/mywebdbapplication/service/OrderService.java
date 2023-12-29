package tw.practice.mywebdbapplication.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import tw.practice.mywebdbapplication.mapper.OrderMapper;
import tw.practice.mywebdbapplication.model.Order;

import java.util.List;

@Service //表示這是一個Spring服務類別，通常用於標記業務邏輯的組件
public class OrderService {
    @Autowired
    JdbcTemplate template;  //使用Spring的JdbcTemplate來執行SQL查詢
    //1.取得所有訂單
    //2.取得request 訂單編號 -> 根據訂單編號取得該訂單編號的所有訂單
    //3.取得request 客戶編號 -> 根據客戶編號取得該客戶編號的所有訂單
    public List<Order> getAll(){
        return template.query("select * from orders", new OrderMapper());
    }
    public List<Order> getOrderById(int ono){
        return template.query("select * from orders where orderNumber=" + ono, new OrderMapper());
    }
    public List<Order> getOrderByCustomerNumber(int cno){
        return template.query("select * from orders where customerNumber=" + cno, new OrderMapper());
    }
}
