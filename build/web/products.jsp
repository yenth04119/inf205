<%-- 
    Document   : products
    Created on : Sep 29, 2016, 10:14:32 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <jsp:include page="_menu_admin.jsp"></jsp:include>
        <jsp:include page="_header.jsp"></jsp:include>


            <h2 class="title text-center">Products</h2>


            <section id="form"><!--form-->
                <div class="container">
                    <form action="ControllerProducts">
                        <center> Product Name: <input type="text" name="txtTenSP" value=""/>
                        <input type="submit" name="action" value="Search"/>
                        <button name="action" value="InsertProduct">Insert</button>
                    </form> </center>
                    <br/>
                    <section id="cart_items">
                        <div class="table-responsive cart_info">
                            <table border="0" class="table table-condensed" >
                                <thead>
                                    <tr class="cart_menu">

                                        <td>Code</td>
                                        <td>Name</td>
                                        <td>Price</td>
                                        <td>Edit</td>
                                        <td>Delete</td>
                                </thead>
                                </tr>
                            <c:forEach var="rows" items="${listSP}">
                                <form action="ControllerProducts">
                                    <tr>
                                        <td>${rows.code}</td>
                                        <td>${rows.name}</td>
                                        <td>${rows.price}</td>
                                        <c:url var="del" value="ControllerProducts">
                                            <c:param name="action" value="Edit"/>
                                            <c:param name="txtCode" value="${rows.code}"/>
                                            <c:param name="txtName" value="${rows.name}"/>
                                            <c:param name="txtPrice" value="${rows.price}"/>
                                        </c:url>
                                        <td><a href="${del}">Edit<a/></td>
                                        <td>
                                            <input type="hidden" name="txtCode" value="${rows.code}"/>
                                            <input type="submit" name="action" value="Delete"/>
                                        </td>
                                    </tr>
                                </form>
                            </c:forEach>
                        </table>  
                    </div>
                </section>
                <br/>
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