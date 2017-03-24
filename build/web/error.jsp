<%-- 
    Document   : error
    Created on : Sep 28, 2016, 3:57:23 PM
    Author     : HP
--%>

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
        <style type="text/css">
            body,td,th {
                font-family: Roboto, sans-serif;
                color: #F8090D;
            }
        </style>
    </head><!--/head-->

    <body>
        <jsp:include page="_menu.jsp"></jsp:include>
        <jsp:include page="_header.jsp"></jsp:include>




            <section id="form"><!--form-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4 col-sm-offset-1">
                            <div class="login-form"><!--login form-->
                                <h1> User Name or Password invalid!</h1>
                                <form action="#">
                                </form>
                            </div><!--/login form-->
                        </div>
                        <div class="col-sm-1">
                            <h2 class="or">OR</h2>
                        </div>
                        <div class="row">
                            <div class="col-sm-4 col-sm-offset-1">
                                <div class="login-form"><!--login form-->
                                    <h2>Login to your account</h2>
                                    <form action="ControllerCustomers">
                                        <input type="text"  name="txtUser" value=""placeholder="Name" />
                                        <input type="password" name="txtPass" value=""placeholder="Password" />
                                        <span>
                                            <input type="checkbox" class="checkbox"> 
                                            Keep me signed in
                                        </span>
                                        <button type="submit" name="action" value="Login" class="btn btn-default">Login</button>
                                        <button type="reset" name="action" value="Reset" class="btn btn-default">Reset</button>
                                    </form>
                                </div><!--/login form-->
                            </div><!--/sign up form-->
                        </div>
                    </div>
                </div>
            </section>

        <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>