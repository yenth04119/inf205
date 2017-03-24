<%-- 
    Document   : _main
    Created on : Oct 11, 2016, 3:57:40 PM
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
      <section>
        <div class="container">
            
            <div class="row">
                <div class="col-sm-12 padding-right">
                    <div class="features_items"><!--features_items-->
                        <h2 class="title text-center">Features Items</h2>
                        
                
                        
                            
                               
                                   
                                        
                                     <%
                      Products listSP = new Products();
                List<Product> list = listSP.showProduct("");
                
                for(int i = 0; i<list.size(); i++){
                           out.print("<form action='ControllerProducts'>");
                           out.print(
                                   "<div class='col-sm-4'>"
                                    +"<div class='product-image-wrapper'>"
                                    +"<div class='single-products'>"
                                    +"       <div class='productinfo text-center'>"
                                    +"            <img src='images/home/product"+(i+1)+".jpg' />"
                                    +"          <h2>$"+list.get(i).getPrice()+"</h2>"
                                    +"          <p>"+list.get(i).getName()+"</p>"
                                    +"          <p>"+list.get(i).getCode()+"</p>"
                                    +"          <a href='#' class='btn btn-default add-to-cart'><i class='fa fa-shopping-cart'></i>Add to cart</a>"
                                    +"       </div>"
                                    +"      <div class='product-overlay'>"
                                    +"          <div class='overlay-content'>"
                                    +"               <h2>$"+list.get(i).getPrice()+"</h2>"
                                    +"               <p>"+list.get(i).getName()+"</p>"
                                    +"               <p>"+list.get(i).getCode()+"</p>"
                                                    +"<input type='hidden' name='txtProductCode' value='"+list.get(i).getCode()+"'/>"
                                           +"<input type='hidden' name='txtProductName' value='"+list.get(i).getName()+"'/>"
                                           +"<input type='hidden' name='txtProductPrice' value='"+list.get(i).getPrice()+"'/>"
                                    +"               <button type='submit' class='btn btn-default add-to-cart' name='action' value='Add'><i class='fa fa-shopping-cart'></i>Add to cart</a>"
                                    +"          </div>"
                                    +"      </div>"
                                    +"</div>"
                                    +"  <div class='choose'>"
                                    +"      <ul class='nav nav-pills nav-justified'>"
                                    +"          <li><a href='#'><i class='fa fa-plus-square'></i>Add to wishlist</a></li>"
                                    +"          <li><a href='#'><i class='fa fa-plus-square'></i>Add to compare</a></li>"
                                    +"      </ul>"
                                    +"  </div>"
                                    +"</div>"
                                    +"</div>"
                                    
                                   
                                    );
                    out.print("</form>");
                   }
                                         
                                     %>
                                        
                    </div><!--features_items--><!--/category-tab--><!--/recommended_items-->

                </div>
            </div>
        </div>
    </section>
    </body>
</html>
