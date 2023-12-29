package tw.practice.mywebdbapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import tw.practice.mywebdbapplication.mapper.CustomerMapper;
import tw.practice.mywebdbapplication.model.Customer;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Customer> getCustomerAll(){
        CustomerMapper cmapper = new CustomerMapper();
        //jdbcTemplete 負責 迴圈(rs.next) 跟蒐集(List)
        List<Customer> allcustomer = jdbcTemplate.query("select * from customers", cmapper);
        return allcustomer;
    }
}
