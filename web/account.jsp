<%-- 
    Document   : account
    Created on : Oct 14, 2016, 11:43:46 PM
    Author     : HP
--%>

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
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>



    <jsp:include page="_menu_user.jsp"></jsp:include>
    <jsp:include page="_header.jsp"></jsp:include>
    <div class="container">

            <div class="container">
            <h2 class="title text-center">User Infomation !</h2>
            <center>     <section id="cart_items">
                    <div class="table-responsive cart_info">
                        <table border="0" >
                
                <div name="Image">Image</div>
                <input type="file" name="pic" accept="image/*"><br/>
        <form action="ControllerCustomers">
            <tr>
                <td>Username: </td> 
                <td>
                    <input type="hidden" name="txtUsername" value="${kh2.username}"/>
                <input type="text" disabled value="${kh2.username}"/>
                </td>
            </tr>
            <tr>
                <td>Password: </td> <td><input type="password" name="txtPassword" value="${kh2.password}"/> </td>
            </tr>
            <tr>
                <td>Name: </td> <td><input type="text" name="txtName" value="${kh2.name}"/> </td>
            </tr>
            <tr>   
                <td> Email: </td> <td><input type="text" name="txtEmail" value="${kh2.email}"/> </td>
            </tr>
            <tr>   
                <td>Gender: </td> <td><input type="text" name="txtGender" value="${kh2.gender}"/> </td>
            </tr>
            <tr>   
                <td> Role: </td> <td><input type="text" disabled value="${kh2.role}"/> </td>
            </tr>
            <tr> 
                <td> </td> <td><button type="submit" name="action" value="UpdateUser"> Update</button></td>
            </tr>   
                      </form>
                    </table>
                </div>
            </section>

        </center>
        <jsp:include page="_footer.jsp"></jsp:include>

        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
</body>
</html>