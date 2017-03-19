/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cart;


/**
 *
 * @author HP
 */
public class CartDAO {
       public CartDAO(){
       }
     public static List<Cart> layDanhSachKH(String name) {
        List<Cart> list = new ArrayList<>();
 try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://AssignmentSOF301.mssql.somee.com:1433;databaseName=AssignmentSOF301";
            Connection con = DriverManager.getConnection(url, "yenthinf205", "foplyjava");
            String sql = "select * from History where Username like '"+name+"'";
            
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while (rs.next()) {
                int id = rs.getInt("ID");
                String date = rs.getString("DateX");
                int quantity = rs.getInt("Quantity");
                float total = rs.getFloat("Total");
                String code = rs.getString("Code");
                String user = rs.getString("Username");
                Cart cart = new Cart(id, quantity, total, date, code, user);
                //Product sp = new Product(code, name, price);
                list.add(cart);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
     
     public static void insert(int Quantity, String date, String Code, String Username , float Total) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://AssignmentSOF301.mssql.somee.com:1433;databaseName=AssignmentSOF301";
           Connection con = DriverManager.getConnection(url, "yenthinf205", "foplyjava");
            String sql = "insert into History values (?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, date);
            stm.setInt(2, Quantity);
            stm.setFloat(3, Total);
            stm.setString(4, Code);
            stm.setString(5, Username);
            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public static void delete(int id) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://AssignmentSOF301.mssql.somee.com:1433;databaseName=AssignmentSOF301";
           Connection con = DriverManager.getConnection(url, "yenthinf205", "foplyjava");
            String sql = "delete from History where ID=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
        public static List<Cart> layDanhSachKH_ID(int id_cart) {
        List<Cart> list = new ArrayList<>();
 try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://AssignmentSOF301.mssql.somee.com:1433;databaseName=AssignmentSOF301";
           Connection con = DriverManager.getConnection(url, "yenthinf205", "foplyjava");
            String sql = "select * from History where ID="+id_cart;
            
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while (rs.next()) {
                int id = rs.getInt("ID");
                String date = rs.getString("DateX");
                int quantity = rs.getInt("Quantity");
                float total = rs.getFloat("Total");
                String code = rs.getString("Code");
                String user = rs.getString("Username");
                Cart cart = new Cart(id, quantity, total, date, code, user);
                //Product sp = new Product(code, name, price);
                list.add(cart);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
        
public static List<Cart> layDanhSachKH_ID_User(int id_cart, String user_cart) {
        List<Cart> list = new ArrayList<>();
 try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://AssignmentSOF301.mssql.somee.com:1433;databaseName=AssignmentSOF301";
           Connection con = DriverManager.getConnection(url, "yenthinf205", "foplyjava");
            String sql = "select * from History where ID="+id_cart+" AND Username='"+user_cart+"'";
            
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while (rs.next()) {
                int id = rs.getInt("ID");
                String date = rs.getString("DateX");
                int quantity = rs.getInt("Quantity");
                float total = rs.getFloat("Total");
                String code = rs.getString("Code");
                String user = rs.getString("Username");
                Cart cart = new Cart(id, quantity, total, date, code, user);
                //Product sp = new Product(code, name, price);
                list.add(cart);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
