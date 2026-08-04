package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Order;
import util.DBConnection;

public class OrderDAO {


    // Save Order
    public boolean saveOrder(Order order){

        boolean result = false;


        try{

            Connection con =
            DBConnection.getConnection();


            String sql =
            "INSERT INTO orders(buyer_email,product_id) VALUES(?,?)";


            PreparedStatement ps =
            con.prepareStatement(sql);


            ps.setString(1, order.getBuyerEmail());

            ps.setInt(2, order.getProductId());


            int rows =
            ps.executeUpdate();


            if(rows > 0){

                result = true;

            }


        }catch(Exception e){

            e.printStackTrace();

        }


        return result;

    }




    // Get Order History
    public List<Order> getOrdersByBuyer(String email){


        List<Order> list =
        new ArrayList<>();


        try{


            Connection con =
            DBConnection.getConnection();



            String sql =
            "SELECT * FROM orders WHERE buyer_email=? ORDER BY order_date DESC";



            PreparedStatement ps =
            con.prepareStatement(sql);



            ps.setString(1,email);



            ResultSet rs =
            ps.executeQuery();




            while(rs.next()){


                Order order =
                new Order();



                order.setId(
                rs.getInt("id"));


                order.setBuyerEmail(
                rs.getString("buyer_email"));



                order.setProductId(
                rs.getInt("product_id"));



                order.setOrderDate(
                rs.getTimestamp("order_date"));



                list.add(order);

            }



        }catch(Exception e){

            e.printStackTrace();

        }



        return list;

    }

}