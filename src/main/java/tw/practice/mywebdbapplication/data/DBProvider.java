package tw.practice.mywebdbapplication.data;



import tw.practice.mywebdbapplication.model.Orders_demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBProvider {

    public DBProvider(){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            System.err.println("驅動程式載入失敗，請確認 MariaDB-Java-Connection 是否有載入");
        }
    }
    public List<Orders_demo> getOrderData(String sql) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Orders_demo> orders = new ArrayList<>();
        try {
            con = DriverManager.getConnection("jdbc:mariadb://localhost/classicmodels", "root", "12345");
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            //將mariaDB的records存入變數o
            while (rs.next()) {
                Orders_demo o = new Orders_demo();
                o.setOrderNumber(rs.getInt("orderNumber"));
                o.setOrderDate(rs.getDate("orderDate"));
                o.setRequiredDate(rs.getDate("requiredDate"));
                o.setComments(rs.getString("comments"));
                o.setCompanyName(rs.getString("customerName"));
                orders.add(o);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("連線異常" + e.getMessage());
            return null;
        }
        return orders;
    }
}
