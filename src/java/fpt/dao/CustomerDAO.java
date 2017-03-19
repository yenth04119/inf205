/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.dao;


import fpt.entity.Customers;
import fpt.util.HibernateUtil; 
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session; 

/**
 *
 * @author HP
 */
public class CustomerDAO {
    public  CustomerDAO() {
    }
    
     public static List<Customers> layDanhSachKH(String name) {
        List<Customers> list = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "from Customers where Name like '%"+name+"%'";
        Query query = session.createQuery(sql);
        list = query.list();
        return list;
    }
     
      public static Customers layThongTinKH(String username) {
         Session session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
        Customers cus = (Customers) session.get(Customers.class, username);
         return cus;
    };
      
     public static boolean xoaKhachHang(String maKhachHang) {
      Customers kh =  CustomerDAO.layThongTinKH(maKhachHang);
        
        if (kh == null) {
            return false;
        }
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.delete(kh);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.print(e);
            return false;
        }
    }
    public static boolean CapNhatKhachHang(Customers kh) {
        
        if (CustomerDAO.layThongTinKH(kh.getUsername()) == null) {
            return false;
        }
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.update(kh);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.print(e);
            return false;
        }
    }
    
    public static boolean themKhachHang(Customers kh) {
        
        if (CustomerDAO.layThongTinKH(kh.getUsername()) != null) {
            return false;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.save(kh);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.print(e);
            return false;
        } finally{
            session.close();
        }
    }
    public static int checkLogin(String user, String pass){
       Customers kh =  CustomerDAO.layThongTinKH(user);
        
        if (kh == null) {
            return 0; // 0 là khong co tai khoan
        }
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            
            if (kh.getUsername().equals(user) && kh.getPassword().equals(pass) && kh.getRole().equalsIgnoreCase("admin")) {
                return 1; // 1 la quyen admin
            }else if (kh.getUsername().equals(user) && kh.getPassword().equals(pass) && kh.getRole().equalsIgnoreCase("user")) {
                return 2; // 2 là quyen customer
            }
            if (!(kh.getUsername().equals(user) && kh.getPassword().equals(pass))) {
                return 4;
            }
             return 3;     
        } catch (Exception e) {
            
            System.out.print(e);
            return 0;
        }
    
    }
    public static int checkUser(String user){
       Customers kh =  CustomerDAO.layThongTinKH(user);
        
        if (kh != null) {
            return 0;
        }
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
 
            if (kh.getUsername().equals(user)) {
                return 1; // 2 la trung user
            }
            return 2;
        } catch (Exception e) {
            
            System.out.print(e);
            return 0;
        }
    
    }
    public static int checkRegester(String user, String pass, String name, String email, String gender){
       Customers kh =  CustomerDAO.layThongTinKH(user);
        if (kh != null) {
            return 0;
        }   
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            if (user.isEmpty() || pass.isEmpty() || name.isEmpty() || email.isEmpty() || gender.isEmpty()) {
                return 1; // 1 la khong duoc bo trong
            }
            if (kh.getUsername().equals(user)) {
                return 2; // 2 la trung user
            }
            /*if (user.length() <6) {
                return 3; // 3 la user khong duoc it hon 6 ki tu
            }
            if (pass.length() <6 || pass.length() >15  ) {
                return 4; // 4 la pass khong dc it hon 6 hoac lon hon 15 ki tu
            }
            if (name.length() <6) {
                return 5; // 5 la ten khong dc it hon 6 ki tu
            }
            if (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") == false) {
                return 6; // 6 la email
            }*/
            return 7; // 7 la check okie
        } catch (Exception e) {
            
            System.out.print(e);
            return 0;
        }
    
    }
}
