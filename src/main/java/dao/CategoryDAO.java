package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import util.DBConnection;


public class CategoryDAO {


    public List<Category> getAllCategories(){

        List<Category> list =
        new ArrayList<>();


        try{


            Connection con =
            DBConnection.getConnection();


            String sql =
            "SELECT * FROM categories";


            PreparedStatement ps =
            con.prepareStatement(sql);


            ResultSet rs =
            ps.executeQuery();



            while(rs.next()){


                Category c =
                new Category();


                c.setId(
                rs.getInt("id"));


                c.setCategoryName(
                rs.getString("category_name"));


                list.add(c);

            }


        }catch(Exception e){

            e.printStackTrace();

        }


        return list;

    }

}