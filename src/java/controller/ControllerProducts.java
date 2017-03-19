/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fpt.dao.CartDAO;
import fpt.dao.CustomerDAO;
import fpt.entity.Customers;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Product;
import model.Products;

/**
 *
 * @author HP
 */
@WebServlet(name = "ControllerProducts", urlPatterns = {"/ControllerProducts"})
public class ControllerProducts extends HttpServlet {
    public List<Product> listP = new ArrayList<>();
    int flag= 1;
    float sum = 0;
    float sum1 =0, sum2 = 0;
    String ma_sp, userP="";
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
        
        /* TODO output your page here. You may use following sample code. */
        try {
            String action = request.getParameter("action");
           
            if (action.equals("Search")) {
                String tensp = request.getParameter("txtTenSP");
                Products sp = new Products();
                List<Product> list = new ArrayList<Product>();
                list = sp.showProduct(tensp);
                request.setAttribute("listSP", list);
                RequestDispatcher rd = request.getRequestDispatcher("products.jsp");
                rd.forward(request, response);
            } else if (action.equals("Delete")) {
                String code = request.getParameter("txtCode");
                Products sp = new Products();
                sp.delete(code);
                String url = "ControllerProducts?action=Search&txtTenSP=";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            } else if (action.equals("Edit")) {
                String code = request.getParameter("txtCode");
                String name = request.getParameter("txtName");
                String pri = request.getParameter("txtPrice");
                float fpri = Float.parseFloat(pri);
                Product sp = new Product(code, name, fpri);
                ma_sp = code; // lấy Id của SP truoc khi duoc chuyen sang EditProduct
                request.setAttribute("SP", sp);
                
                String url = "editproduct.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);

            } else if (action.equals("Update")) {
                String name = request.getParameter("txtName");
                String pri = request.getParameter("txtPrice");
                float fpri = Float.parseFloat(pri);
                Products sp = new Products();
                sp.update(ma_sp, name, fpri);
                String url = "ControllerProducts?action=Search&txtTenSP=";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);

            } else if (action.equals("New")) {
                String url = "newProduct.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            } else if (action.equals("Insert")) {
                String code = request.getParameter("txtCode");
                String name = request.getParameter("txtName");
                String pri = request.getParameter("txtPrice");
                float fpri = Float.parseFloat(pri);
                Products sp = new Products(); 
                sp.insert(code, name, fpri);
                String url = "ControllerProducts?action=Search&txtTenSP=";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);

            } 
             else if (action.equals("Add")) {
                String code = request.getParameter("txtProductCode");
                String name = request.getParameter("txtProductName");
                String pri = request.getParameter("txtProductPrice");
                String quantity = request.getParameter("txtQX");
                float fpri = Float.parseFloat(pri);
                
                for (int i = 0; i < listP.size(); i++) {
                    if (listP.get(i).getCode().equals(code)) {
                        flag = listP.get(i).getQuantity();
                        flag++;
                        listP.remove(i);
                    }else{
                        flag=1;
                    }
                }
                Product sp = new Product(code,name,fpri, flag, fpri*flag);
                listP.add(sp);
            //    listP.clear();
                sum = TongA();
                
                request.setAttribute("list", listP);
                
                
                
                String url = "home_user.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);

            }
             else if (action.equals("DeleteX")) {
                String code = request.getParameter("txtCodeX");
                int codeX = Integer.parseInt(code);
            //    listP.clear();
                //System.out.println(code);
                
                listP.remove((codeX - 1));
                request.setAttribute("list", listP);
                sum1 = TongA();
                HttpSession session = request.getSession(true);
                session.setAttribute("KeyTatol", sum1);
                
                String url = "cart.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);

            }
             else if (action.equals("Cart")) {
                String code = request.getParameter("txtProductCode");
                for (int i = 0; i < listP.size(); i++) {
                    if (listP.get(i).getCode().equals(code)) {
                        flag = listP.get(i).getQuantity();
                        //System.out.println(flag);
                        flag++;
                        listP.remove(i);
                        
                    }else{
                    flag=1;
                    }
                    
                }
                HttpSession session = request.getSession(true);
                session.setAttribute("KeyTatol", sum);
                
                request.setAttribute("list", listP);
                String url = "cart.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);

            }
             
            else if (action.equals("Logout")) {
                listP.clear();
                String url = "login.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);

            }
            else if (action.equals("CustomerManger")) {
                List<Customers> list = CustomerDAO.layDanhSachKH("");
                request.setAttribute("listKH", list); 
                String url = "admin.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);

            }
            else if (action.equals("HistoryManger")) {
                List<Cart> cart = CartDAO.layDanhSachKH("%%");
                for (int i = 0; i < cart.size(); i++) {
                    Cart get = cart.get(i);
                    
                }
                request.setAttribute("listCart", cart); 
                String url = "history_admin.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);

            }
            else if (action.equals("SearchCartID")) {
                try {
                    
               
                String cart_id = request.getParameter("txtCartID");
                
                if (cart_id.isEmpty()) {
                        List<Cart> cart = CartDAO.layDanhSachKH("%%");
                        for (int i = 0; i < cart.size(); i++) {
                            Cart get = cart.get(i);

                        }
                        request.setAttribute("listCart", cart); 
                        String url = "history_admin.jsp";
                        RequestDispatcher rd = request.getRequestDispatcher(url);
                        rd.forward(request, response);
                }
                
                int id = Integer.parseInt(cart_id);
                List<Cart> cart = CartDAO.layDanhSachKH_ID(id);
                
                request.setAttribute("listCart", cart); 
                String url = "history_admin.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
                } catch (Exception e) {
                    String url = "history_admin.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
                }
            }
            else if (action.equals("SearchCartID_User")) {
                try {
                    String cart_id = request.getParameter("txtCartID");
                    String name = ControllerCustomers.username;
                    int id = Integer.parseInt(cart_id);
                    if (cart_id.isEmpty()) {
                        List<Cart> cart = CartDAO.layDanhSachKH(""+name);
                        request.setAttribute("listCart", cart); 
                        String url = "history_user.jsp";
                        RequestDispatcher rd = request.getRequestDispatcher(url);
                        rd.forward(request, response);
                     }
                    List<Cart> cart = CartDAO.layDanhSachKH_ID_User(id, name);
                    request.setAttribute("listCart", cart);
                    String url = "history_user.jsp";
                    RequestDispatcher rd = request.getRequestDispatcher(url);
                    rd.forward(request, response);
                } catch (Exception e) {
                    String url = "history_user.jsp";
                    RequestDispatcher rd = request.getRequestDispatcher(url);
                    rd.forward(request, response);
                }


            }
            else if (action.equals("ProductManger")) {
                Products sp = new Products();
                List<Product> list = new ArrayList<Product>();
                list = sp.showProduct("");
                request.setAttribute("listSP", list);   
                String url = "products.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);

            }
             else if (action.equals("InsertProduct")) {

                String url = "newProducts.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);

            }
            
            
            
           
            if (action.equals("+")) {
               
               String code = request.getParameter("txtCodePro");
               
                for (int i = 0; i < listP.size(); i++) {
                    Product pro = listP.get(i);
                    if (pro.getCode().equals(code)) {
                        pro.setQuantity(pro.getQuantity()+1);
                        pro.setTatol(pro.getPrice()*(pro.getQuantity()));
                    }
                   
                }
               
                sum = TongA();
                HttpSession session = request.getSession(true);
                session.setAttribute("KeyTatol", sum);
                
                
               request.setAttribute("list", listP);
                String url = "cart.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);

            }
            if (action.equals("-")) {
               
               String code = request.getParameter("txtCodePro");
               
                for (int i = 0; i < listP.size(); i++) {
                    Product pro = listP.get(i);
                    if (pro.getCode().equals(code)) {
                        pro.setQuantity(pro.getQuantity()-1);
                        pro.setTatol(pro.getPrice()*(pro.getQuantity()));
                    }
                    if (pro.getQuantity()<=0) {
                        pro.setQuantity(0);
                        listP.remove(i);
                    }
                    
                }
                sum = TongA();
                HttpSession session = request.getSession(true);
                session.setAttribute("KeyTatol", sum);

                
               request.setAttribute("list", listP);
                String url = "cart.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);

            }
             else if (action.equals("ClearAll")) {
                listP.clear();
                
                sum = 0;
                HttpSession session = request.getSession(true);
                session.setAttribute("KeyTatol", sum);
                String url = "cart.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);

            }
            else if (action.equals("History")) {
             
                //Cart cart = new Cart(flag, flag, sum, ma_sp, action, action);
               // String name = request.getParameter("txtUserCart");
                //CartDAO.delete(1);
                String name = ControllerCustomers.username;
               
                
                List<Cart> cart = CartDAO.layDanhSachKH(""+name);
                for (int i = 0; i < cart.size(); i++) {
                    Cart get = cart.get(i);
                    
                }
                request.setAttribute("listCart", cart);
                String url = "history_user.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);

            }
            
             else if (action.equals("Send")) {
                try {
                     if (listP.size()==0) {
                         String url = "home_user.jsp";
                         RequestDispatcher rd = request.getRequestDispatcher(url);
                        rd.forward(request, response);
                        return ;
                     }
                      System.out.println(""+listP.size());
               String name = request.getParameter("txtUserCart");
                
                System.out.println(""+userP);
                 /* String code = request.getParameter("txtCodeCart");
                 String total = request.getParameter("txtTotalPro");
                 String quantity = request.getParameter("txtQuantityCart");
                 */
                 String date =now("dd-MM-yyyy HH:mm:ss");
                 //int q = Integer.parseInt(quantity);
                // float t = Float.parseFloat(total);
                
                 
                 
                   /* for (int i = 0; i < listP.size(); i++) {
                       
                         //System.out.println(listP.get(i).getQuantity()+", "+name+", "+listP.get(i).getTatol()+", "+listP.get(i).getName()+", "+now("dd-MM-yyyy HH:mm:ss"));
                    }*/
                
                    for (int i = 0; i < listP.size(); i++) {
                        Product p = listP.get(i);
                        CartDAO.insert(p.getQuantity(), date, p.getCode(), name, p.getTatol());
                    }
                
                
                listP.clear();
                
                
                sum = 0;
                HttpSession session = request.getSession(true);
                session.setAttribute("KeyTatol", sum);
                List<Cart> cart = CartDAO.layDanhSachKH(""+name);
                for (int i = 0; i < cart.size(); i++) {
                    Cart get = cart.get(i);
                    
                }
                request.setAttribute("listCart", cart);
                String url = "history_user.jsp";
                
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
                 
                 
                 
                } catch (Exception e) {
                }
                 
                 

            }
            //...
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private float TongA(){
        float sumOkie = 0;
        for (int i = 0; i < listP.size(); i++) {
            Product get = listP.get(i);
            sumOkie += get.Tong();
        }
        return sumOkie;
    }
    public String now(String dateFormat){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(cal.getTime());    

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
