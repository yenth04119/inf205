<%-- 
    Document   : account
    Created on : Oct 14, 2016, 11:43:46 PM
    Author     : HP
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="fpt.dao.CustomerDAO"%>
<%@page import="fpt.entity.Customers"%>
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
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>
    <jsp:include page="_menu_admin.jsp"></jsp:include>
    <jsp:include page="_header.jsp"></jsp:include>
        <div class="container">

            <h2 class="title text-center">Customers</h2>

            <section id="form"><!--form-->
                <div class="container">
                    <form action="ControllerCustomers">
                        Customer Name: <input type="text" name="txtTenKH" value=""/>
                        <input type="submit" name="action" value="Search"/> 
                    </form>
                    <br/>
                    <section id="cart_items">
                        <div class="table-responsive cart_info">
                            <table border="0" class="table table-condensed">
                                <thead>
                                    <tr class="cart_menu">

                                        <td>Username</td>
                                        <td>Password</td>
                                        <td>Name</td>
                                        <td>Gender</td>
                                        <td>Email</td>
                                        <td>Role</td>
                                        <td>Delete</td>
                                        <td>Update</td>
                                </thead>
                                </tr>
                            <c:forEach var="rows" items="${listKH}">
                                <form action="ControllerCustomers">

                                    <tr>
                                        <td>${rows.username}</td>
                                        <td>${rows.password}</td>
                                        <td>${rows.name}</td>
                                        <td>${rows.gender}</td>
                                        <td>${rows.email}</td>
                                        <td>${rows.role}</td>
                                        <td>
                                            <input type="hidden" name="txtMaKH" value="${rows.username}"/>
                                            <input type="submit" name="action" value="Delete"/>
                                        </td>
                                        <td>
                                            <input type="hidden" name="txtusernameE" value="${rows.username}"/>
                                            <input type="hidden" name="txtpasswordE" value="${rows.password}"/>
                                            <input type="hidden" name="txtnameE" value="${rows.name}"/>
                                            <input type="hidden" name="txtgenderE" value="${rows.gender}"/>
                                            <input type="hidden" name="txtemailE" value="${rows.email}"/>
                                            <input type="hidden" name="txtroleE" value="${rows.role}"/>
                                            <input type="submit" name="action" value="Edit"/>
                                        </td>
                                    </tr>
                                </form>
                            </c:forEach>
                        </table>
                    </div>     </section> 
                    <jsp:include page="_footer.jsp"></jsp:include>

                <script src="js/jquery.js"></script>
                <script src="js/bootstrap.min.js"></script>
                <script src="js/jquery.scrollUp.min.js"></script>
                <script src="js/price-range.js"></script>
                <script src="js/jquery.prettyPhoto.js"></script>
                <script src="js/main.js"></script>
                </body>
                </html>