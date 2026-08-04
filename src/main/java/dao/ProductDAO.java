package dao;

import java.sql.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import util.DBConnection;

public class ProductDAO {


    // Add Product
    public boolean addProduct(Product product){

        boolean result = false;

        try{

            Connection con = DBConnection.getConnection();

            String sql =
            "INSERT INTO products(product_name,category_id,description,price,image,seller_email,status) VALUES(?,?,?,?,?,?,?)";


            PreparedStatement ps =
            con.prepareStatement(sql);


            ps.setString(1, product.getProductName());
            ps.setInt(2, product.getCategoryId());
            ps.setString(3, product.getDescription());
            ps.setDouble(4, product.getPrice());
            ps.setString(5, product.getImage());
            ps.setString(6, product.getSellerEmail());
            ps.setString(7, "AVAILABLE");


            int rows = ps.executeUpdate();


            if(rows > 0){
                result = true;
            }


        }catch(Exception e){
            e.printStackTrace();
        }


        return result;
    }




    // View All Products
    public List<Product> getAllProducts(){

        List<Product> list = new ArrayList<>();

        try{

            Connection con =
            DBConnection.getConnection();


            String sql =
            "SELECT * FROM products WHERE status='AVAILABLE'";


            PreparedStatement ps =
            con.prepareStatement(sql);


            ResultSet rs =
            ps.executeQuery();



            while(rs.next()){


                Product p = new Product();


                p.setId(
                rs.getInt("id"));


                p.setProductName(
                rs.getString("product_name"));


                p.setCategoryId(
                rs.getInt("category_id"));


                p.setDescription(
                rs.getString("description"));


                p.setPrice(
                rs.getDouble("price"));


                p.setImage(
                rs.getString("image"));


                p.setSellerEmail(
                rs.getString("seller_email"));


                p.setStatus(
                rs.getString("status"));


                list.add(p);

            }


        }catch(Exception e){

            e.printStackTrace();

        }


        return list;
    }





    // Search Products
    public List<Product> searchProducts(String keyword){

        List<Product> list =
        new ArrayList<>();


        try{

            Connection con =
            DBConnection.getConnection();


            String sql =
            "SELECT * FROM products WHERE product_name LIKE ?";


            PreparedStatement ps =
            con.prepareStatement(sql);


            ps.setString(1,"%"+keyword+"%");


            ResultSet rs =
            ps.executeQuery();



            while(rs.next()){


                Product p = new Product();


                p.setId(
                rs.getInt("id"));


                p.setProductName(
                rs.getString("product_name"));


                p.setDescription(
                rs.getString("description"));


                p.setPrice(
                rs.getDouble("price"));


                list.add(p);

            }


        }catch(Exception e){

            e.printStackTrace();

        }


        return list;

    }
 // Update Product
    public boolean updateProduct(Product product){

        boolean result = false;

        try{

            Connection con = DBConnection.getConnection();

            String sql =
            "UPDATE products SET product_name=?, description=?, price=? WHERE id=?";


            PreparedStatement ps =
            con.prepareStatement(sql);


            ps.setString(1, product.getProductName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getId());


            int rows = ps.executeUpdate();


            if(rows > 0){
                result = true;
            }


        }catch(Exception e){

            e.printStackTrace();

        }

        return result;
    }
 // Delete Product
    public boolean deleteProduct(int id){

        boolean result = false;


        try{

            Connection con =
            DBConnection.getConnection();


            String sql =
            "DELETE FROM products WHERE id=?";


            PreparedStatement ps =
            con.prepareStatement(sql);


            ps.setInt(1,id);


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
 // My Products
    public List<Product> getProductsBySeller(String email){

        List<Product> list =
        new ArrayList<>();


        try{

            Connection con =
            DBConnection.getConnection();


            String sql =
            "SELECT * FROM products WHERE seller_email=?";


            PreparedStatement ps =
            con.prepareStatement(sql);


            ps.setString(1,email);


            ResultSet rs =
            ps.executeQuery();



            while(rs.next()){


                Product p =
                new Product();


                p.setId(rs.getInt("id"));

                p.setProductName(
                rs.getString("product_name"));

                p.setDescription(
                rs.getString("description"));

                p.setPrice(
                rs.getDouble("price"));

                p.setStatus(
                rs.getString("status"));


                list.add(p);

            }


        }catch(Exception e){

            e.printStackTrace();

        }


        return list;

    }
 // Buy Product
    public boolean buyProduct(int productId, String buyerEmail){

        boolean result = false;


        try{

            Connection con =
            DBConnection.getConnection();


            String check =
            "SELECT seller_email,status FROM products WHERE id=?";


            PreparedStatement checkPs =
            con.prepareStatement(check);


            checkPs.setInt(1,productId);


            ResultSet rs =
            checkPs.executeQuery();



            if(rs.next()){


                String seller =
                rs.getString("seller_email");


                String status =
                rs.getString("status");



                if(seller.equals(buyerEmail)
                        || status.equals("SOLD")){

                    return false;

                }

            }



            String orderSql =
            "INSERT INTO orders(buyer_email,product_id) VALUES(?,?)";


            PreparedStatement ps1 =
            con.prepareStatement(orderSql);


            ps1.setString(1,buyerEmail);

            ps1.setInt(2,productId);


            ps1.executeUpdate();




            String update =
            "UPDATE products SET status='SOLD' WHERE id=?";


            PreparedStatement ps2 =
            con.prepareStatement(update);


            ps2.setInt(1,productId);


            int rows =
            ps2.executeUpdate();



            if(rows > 0){

                result = true;

            }


        }catch(Exception e){

            e.printStackTrace();

        }


        return result;

    }
    public List<Product> filterProducts(int categoryId, double minPrice, double maxPrice){

        List<Product> list = new ArrayList<>();

        try{

            Connection con =
            DBConnection.getConnection();


            String sql =
            "SELECT * FROM products WHERE category_id=? AND price BETWEEN ? AND ? AND status='AVAILABLE'";


            PreparedStatement ps =
            con.prepareStatement(sql);


            ps.setInt(1, categoryId);

            ps.setDouble(2, minPrice);

            ps.setDouble(3, maxPrice);


            ResultSet rs =
            ps.executeQuery();



            while(rs.next()){


                Product p = new Product();


                p.setId(
                rs.getInt("id"));


                p.setProductName(
                rs.getString("product_name"));


                p.setDescription(
                rs.getString("description"));


                p.setPrice(
                rs.getDouble("price"));


                p.setImage(
                rs.getString("image"));


                p.setSellerEmail(
                rs.getString("seller_email"));


                list.add(p);

            }


        }catch(Exception e){

            e.printStackTrace();

        }


        return list;

    }
    public Product getProductById(int id){

        Product product = null;


        try{


            Connection con =
            DBConnection.getConnection();


            String sql =
            "SELECT * FROM products WHERE id=?";


            PreparedStatement ps =
            con.prepareStatement(sql);


            ps.setInt(1,id);



            ResultSet rs =
            ps.executeQuery();



            if(rs.next()){


                product = new Product();


                product.setId(
                rs.getInt("id"));


                product.setProductName(
                rs.getString("product_name"));


                product.setDescription(
                rs.getString("description"));


                product.setPrice(
                rs.getDouble("price"));


            }


        }catch(Exception e){

            e.printStackTrace();

        }


        return product;

    }

}