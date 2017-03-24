<%-- 
    Document   : cart
    Created on : Oct 13, 2016, 8:56:41 PM
    Author     : HP
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home | CJ-Apple Moblie</title>
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
        <link rel="shortcut icon" href="images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    </head><!--/head-->

    <body>
        <jsp:include page="_menu_user.jsp"></jsp:include>



            <section id="cart_items">
                <div class="container">
                    <div class="breadcrumbs">
                        <ol class="breadcrumb">
                            <li><a href="#">Home</a></li>
                            <li class="active">Shopping Cart</li>
                        </ol>
                    </div>
                    <div class="table-responsive cart_info">
                        <table class="table table-condensed">
                            <thead>
                                <tr class="cart_menu">
                                    <td class="image">Item</td>
                                    <td class="description"></td>
                                    <td class="price">Price</td>
                                    <td class="quantity">Quantity</td>
                                    <td class="total">Total</td>
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody>
                            
                              
                                <c:forEach var="rows" items="${list}" varStatus="loopCounter">
                                    <form action="ControllerProducts">
                               <tr>
                                    <td class="cart_product">
                                        <a href=""><img src='images/cart/one.jpg' alt=""></a>
                                    </td>
                                    <td class="cart_description">
                                        <h4><a href="">${rows.name}</a></h4>
                                        <p>Web ID: ${rows.code}</p>
                                    </td>
                                    <td class="cart_price">
                                        <p>$${rows.price}</p>
                                    </td>
                                    <td class="cart_quantity">
                                        <div class="cart_quantity_button">
                                            
                                            <button name="action" value="+">+</button>
                                            <input type="hidden" name="txtCodePro" value="${rows.code}"/>
                                            <input type="hidden" name="txtQX" value="${rows.quantity}"/>
                                            <input type="text" name="quantity" value="${rows.quantity}" autocomplete="off" size="2" disabled>
                                            
                                            <button name="action" value="-">-</button>
                                            
                                        </div>
                                    </td>
                                    <td class="cart_total">
                                        <p class="cart_total_price" id="tongtien">$${rows.tatol}</p>
                                        
                                    </td>
                                    <td class="cart_delete">
                                         <input type="hidden" name="txtCodeX" value="${loopCounter.count}"/>
                                        <button name="action" value="DeleteX" class="cart_quantity_delete">X</button>
                                    </td>
                                </tr>
                                    </form>
                            </c:forEach>
                                
                            </tbody>
                        </table>
                    </div>
                </div>
            </section> <!--/#cart_items-->


            <section id="do_action">
                <div class="container">
                    <div class="col-sm-6">
                        <div class="total_area">
                            <ul>
                                
                                <li>Total <span><i class="fa fa-usd" aria-hidden="true"></i>${sessionScope.KeyTatol}</span></li>
                            </ul>
                            
                            <form action="ControllerProducts">
                                  <input type="hidden" name="txtUserCart" value="${sessionScope.Username}"/>
                                  <button name="action" value="Send" class="btn btn-default update"><i class="fa fa-credit-card"></i>  Send</button>
                                  <button name="action" value="ClearAll" class="btn btn-default check_out"><i class="fa fa-ban fa-fw"></i> Clear All</button>
                            </form>
                          
                        </div>
                    </div>

                </div>
            </section> 


        <jsp:include page="_footer.jsp"></jsp:include>

        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>