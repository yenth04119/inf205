<%-- 
    Document   : history_user
    Created on : Oct 18, 2016, 12:56:27 AM
    Author     : HP
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@page import="model.Products"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home | CJ-Apple Store</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       

    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->





<jsp:include page="_menu_user.jsp"></jsp:include>




            <section id="cart_items">
                <div class="container">
                    <div class="breadcrumbs">
                        <ol class="breadcrumb">
                            <li><a href="#">Home</a></li>
                            <li class="active">Histoty</li>
                        </ol>
                    </div>
                    <form action="ControllerProducts">
                        Cart ID: <input type="text" name="txtCartID" value=""/>
                        <button type="submit" name="action" value="SearchCartID_User"> Search</button>
                    </form>
                    <br/>
                    <div class="table-responsive cart_info">
                        
                        <table class="table table-condensed">
                            <thead>
                                <tr class="cart_menu">
                                    <td class="image">Cart ID</td>
                                    <td class="image">Date</td>
                                    <td class="price">Quantity</td>
                                    <td class="quantity">Total</td>
                                    <td class="total">Product Code</td>
                                    <td class="total">Username</td>
                                </tr>
                            </thead>
                            <tbody>
                            
                              
                                <c:forEach var="rows" items="${listCart}">
                                    <form >
                               <tr>
                                    <td class="cart_product">
                                        <a href="">${rows.getId()}</a>
                                    </td>
                                    <td class="cart_price">
                                        <a href="">${rows.getDateX()}</a>
                                    </td>
                                    <td class="cart_description">
                                        <a href="">${rows.getQuantity()}</a>
                                    </td>
                                    <td class="cart_price">
                                       <a href="">${rows.getTotal()}</a>
                                    </td>
                                    <td class="cart_quantity">
                                        <a href="">${rows.getCode()}</a>
                                    </td>
                                    <td class="cart_total">
                                       <a href="">${rows.getUsername()}</a>
                                       
                                    </td>
                                </tr>
                                    </form>
                            </c:forEach>
                                
                            </tbody>
                        </table>
                    </div>
                </div>
            </section> <!--/#cart_items-->







<jsp:include page="_footer.jsp"></jsp:include>



<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/price-range.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
</body>
</html>