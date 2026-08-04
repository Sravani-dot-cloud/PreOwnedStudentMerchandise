package dao;

import java.sql.*;
import model.User;
import util.DBConnection;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
public class UserDAO {


    // Register User
    public boolean registerUser(User user){

        boolean result = false;

        try{

            Connection con = DBConnection.getConnection();

            String sql =
            "INSERT INTO users(name,email,password,phone,role) VALUES(?,?,?,?,?)";


            PreparedStatement ps =
            con.prepareStatement(sql);


            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            String encryptedPassword =
            		BCrypt.hashpw(
            		user.getPassword(),
            		BCrypt.gensalt()
            		);


            		ps.setString(3, encryptedPassword);
            ps.setString(4, user.getPhone());
            ps.setString(5, "USER");


            int rows = ps.executeUpdate();


            if(rows > 0){
                result = true;
            }


        }catch(Exception e){

            e.printStackTrace();

        }

        return result;
    }



    // Login User
    public User login(String email, String password){

        User user = null;


        try{

            Connection con =
            DBConnection.getConnection();


            String sql =
            "SELECT * FROM users WHERE email=?";


            PreparedStatement ps =
            con.prepareStatement(sql);


            ps.setString(1,email);
           


            ResultSet rs =
            ps.executeQuery();

            if(rs.next()){


            	String storedPassword =
            	rs.getString("password");


            	if(BCrypt.checkpw(password, storedPassword)){


            	    user = new User();


            	    user.setId(
            	    rs.getInt("id"));


            	    user.setName(
            	    rs.getString("name"));


            	    user.setEmail(
            	    rs.getString("email"));


            	    user.setPhone(
            	    rs.getString("phone"));


            	    user.setRole(
            	    rs.getString("role"));

            	}

            	}



        }catch(Exception e){

            e.printStackTrace();

        }


        return user;

    }
    public List<User> getAllUsers(){

        List<User> list = new ArrayList<>();


        try{

            Connection con =
            DBConnection.getConnection();


            String sql =
            "SELECT * FROM users";


            PreparedStatement ps =
            con.prepareStatement(sql);


            ResultSet rs =
            ps.executeQuery();


            while(rs.next()){


                User user = new User();


                user.setId(
                rs.getInt("id"));


                user.setName(
                rs.getString("name"));


                user.setEmail(
                rs.getString("email"));


                user.setPhone(
                rs.getString("phone"));


                user.setRole(
                rs.getString("role"));


                list.add(user);

            }


        }catch(Exception e){

            e.printStackTrace();

        }


        return list;

    }
    public boolean emailExists(String email) {

        boolean exists = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users WHERE email=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                exists = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return exists;
    }

}