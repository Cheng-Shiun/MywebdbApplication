package tw.practice.mywebdbapplication.mapper;


import org.springframework.jdbc.core.RowMapper;
import tw.practice.mywebdbapplication.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException{
        // 因為 只有你知道你要那些欄位  或是 需要轉換資料的內容
        // ORM過程
        // 將資料庫的欄位轉換成class 物件
        Customer c = new Customer();
        c.setCustomerNumber(rs.getInt("customerNumber"));
        c.setCustomerName(rs.getString("customerName"));
        c.setPhone(rs.getString("phone"));
        c.setCity(rs.getString("city"));
        c.setCountry(rs.getString("country"));
        c.setCreditLimit(rs.getDouble("creditLimit"));
        return c;
    }
}
