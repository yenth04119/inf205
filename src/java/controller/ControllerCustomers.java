/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fpt.dao.CustomerDAO;
import fpt.entity.Customers;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import model.Customers;

/**
 *
 * @author HP
 */
@WebServlet(name = "ControllerCustomers", urlPatterns = {"/ControllerCustomers"})
public class ControllerCustomers extends HttpServlet {

    private List<Customers> list;
    public static String username;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String action = request.getParameter("action");
            
            // xử lý login ở trang login.jsp
            if (action.equals("Login")) {
                String user = request.getParameter("txtUser");
                String pass = request.getParameter("txtPass");
                Customers cus = new Customers();
                // neu 1 trong 2 trống thì chuyển sang trang nhập lại
                if (user.isEmpty() || pass.isEmpty()) {                    
                    String url = "error.jsp";
                        RequestDispatcher rd = request.getRequestDispatcher(url);
                        rd.forward(request, response);
                    return;
                }
                // check tai khoan
                int check = CustomerDAO.checkLogin(user, pass);
                
                // nếu check role =1 thi chuyen sang trang admin
                if (check==1) {
                        
                        HttpSession session = request.getSession(true);
                        list= CustomerDAO.layDanhSachKH("");
                        session.setAttribute("listKH", list);
                        String url = "admin.jsp";
                        RequestDispatcher rd = request.getRequestDispatcher(url);
                        rd.forward(request, response);
                        
                }
                // nêu check role = 2 thì chuyển sang trang user
                if (check==2) {
                        String url = "account.jsp";
                        HttpSession session = request.getSession(true);
                        session.setAttribute("Username", user);
                        username = user;
                        Customers kh2 = CustomerDAO.layThongTinKH(user);                      
                        session.setAttribute("kh2", kh2);
                        
                        RequestDispatcher rd = request.getRequestDispatcher(url);
                        rd.forward(request, response);
                        
                }
                // nếu role nằm ngoài thì chuyển sang trang error.jsp
                 if (check==0 || check ==4) {
                        String url = "error.jsp";
                        RequestDispatcher rd = request.getRequestDispatcher(url);
                        rd.forward(request, response);
                        
                }
               
            }
            
            // Xử lý nút search trang Account Manager (admin.jsp)
            if (action.equals("Search")) {
                
                String tenkh = request.getParameter("txtTenKH");
                List<Customers> list = CustomerDAO.layDanhSachKH(tenkh);
                request.setAttribute("listKH", list);
                String url = "admin.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
                
                
            } 
            // Xử lý SignUp ở login.jsp
            else if (action.equals("Signup")) {
                String username = request.getParameter("txtUsername");
                String name = request.getParameter("txtName");
                String matkhau = request.getParameter("txtPassword");
                String email = request.getParameter("txtEmail");
                String gender = request.getParameter("txtGender");
                int check = CustomerDAO.checkRegester(username, matkhau, name, email, gender);
                int checkUser = CustomerDAO.checkUser(username);
                // check user nếu bằng 1 thì tài khoản tồn tại
                if (checkUser==1) {
                        out.print("<p style='font-size: 250%; color: red;'><b> That user is taken</b></p>");
                        return; 
                    }
                // check bỏ trống trường...
                if (check==1) {
                        out.print("<p style='font-size: 250%; color: red;'><b>Regester Failed</b></p>");
                        
                }
                // nguoc lại thì đăng ký thành công
                else{
                     
                    Customers kh = new Customers(username, matkhau, name, gender, email, "user");
                    CustomerDAO.themKhachHang(kh);
                    String url = "login.jsp";
                    RequestDispatcher rd = request.getRequestDispatcher(url);
                    rd.forward(request, response);
                }
                
                    
                    
                
            }else if (action.equals("Delete")) {
                String makh = request.getParameter("txtMaKH");
                 boolean daxoa = CustomerDAO.xoaKhachHang(makh);
               if (daxoa) {
                   String url = "ControllerCustomers?txtTenKH=&action=Search";
                   RequestDispatcher rd = request.getRequestDispatcher(url);
                   rd.forward(request, response);
               }

            }
            else if (action.equals("Edit")) {
                String txtusernameE = request.getParameter("txtusernameE");
                String txtpasswordE = request.getParameter("txtpasswordE");
                String txtnameE = request.getParameter("txtnameE");
                String txtgenderE = request.getParameter("txtgenderE");
                String txtemailE = request.getParameter("txtemailE");
                String txtroleE = request.getParameter("txtroleE");
                
                Customers kh = new Customers(txtusernameE, txtpasswordE, txtnameE, txtgenderE, txtemailE, txtroleE);
                request.setAttribute("kh", kh);
                
                String url = "editCustomer.jsp"; 
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);

            } 
            else if (action.equals("Update")) {

                String username2 = request.getParameter("txtUsername");
                String txtpasswordE = request.getParameter("txtPassword");
                String txtnameE = request.getParameter("txtName");
                String txtgenderE = request.getParameter("txtGender");
                String txtemailE = request.getParameter("txtEmail");
                String txtroleE = request.getParameter("txtRole");

                Customers kh = new Customers(username2, txtpasswordE, txtnameE, txtgenderE, txtemailE, txtroleE);

                boolean daCapNhat = CustomerDAO.CapNhatKhachHang(kh);
                if (daCapNhat) {
                    if (txtroleE.equalsIgnoreCase("admin")) {
                        List<Customers> list = CustomerDAO.layDanhSachKH("");
                        request.setAttribute("listKH", list);
                        String url = "admin.jsp";
                         RequestDispatcher rd = request.getRequestDispatcher(url);
                         rd.forward(request, response);
                    }
                        String url = "login.jsp";
                         RequestDispatcher rd = request.getRequestDispatcher(url);
                         rd.forward(request, response);
                }


            }
            else if (action.equals("UpdateUser")) {

                String username = request.getParameter("txtUsername");
                String txtpasswordE = request.getParameter("txtPassword");
                String txtnameE = request.getParameter("txtName");
                String txtgenderE = request.getParameter("txtGender");
                String txtemailE = request.getParameter("txtEmail");
               

                Customers kh = new Customers(username, txtpasswordE, txtnameE, txtgenderE, txtemailE, "user");

                boolean daCapNhat = CustomerDAO.CapNhatKhachHang(kh);
                if (daCapNhat) {
                    Customers kh2 = CustomerDAO.layThongTinKH(username);                      
                    request.setAttribute("kh2", kh2);
                    String url = "account.jsp";
                    RequestDispatcher rd = request.getRequestDispatcher(url);
                    rd.forward(request, response);
                }


            }
        } catch (Exception e) {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
