<%-- 
    Document   : editproduct
    Created on : Sep 29, 2016, 10:22:15 PM
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
            <section id="slider">
                <h2 class="title text-center">Edit Products</h2>
                <div class="container">
                    <center>  <form action="ControllerProducts">
                            Code: ${SP.code}<br/>
                        <p>  <input type="hidden" name="txtCode" value="${SP.code}"/> </p>
                        <p>Name: <input type="text" name="txtName" value="${SP.name}"/> <p/>
                        <p> Price: <input type="text" name="txtPrice" value="${SP.price}"/> <p/>
                        <input type="submit" name="action" value="Update"/>

                    </form> </center></section> </div>
                    <jsp:include page="_footer.jsp"></jsp:include>



</body>
</html>