package tw.practice.mywebdbapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public String getOrdersAll2(){
        return "hello";
    }
    public String getOrdersAll(){
        String sql = "SELECT customers.customerName from customers where customerNumber = 129";
        //queryForObject 要確定 sql 只會回傳一個欄位 哪一種類型(第二個參數要記得 型別.class)
        String name = jdbcTemplate.queryForObject(sql, String.class);
        return name;
    }
    public Long countByCountry(String cname){
        String sql = "SELECT count(*) FROM customers WHERE country = '" + cname + "'";
        //queryForObject 要確定 sql 只會回傳一個欄位 哪一種類型(第二個參數要記得 型別.class)
        Long cnt = jdbcTemplate.queryForObject(sql, Long.class);
        return cnt;
    }

}
