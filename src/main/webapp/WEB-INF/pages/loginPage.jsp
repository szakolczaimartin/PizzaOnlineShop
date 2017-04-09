<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Pizza a Food Category Flat bootstrap Responsive website Template | Home :: w3layouts</title>
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Pizza Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- //Custom Theme files -->
    <link href="/resources/css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
    <link href="/resources/css/style.css" type="text/css" rel="stylesheet" media="all">
    <!--js-->
    <script src="/resources/js/jquery-1.11.1.min.js"></script>
    <script src="/resources/js/modernizr.custom.js"></script>
    <!-- //js -->


    <script>
        $(document).ready(function () {
            size_li = $("#myList li").size();
            x=1;
            $('#myList li:lt('+x+')').show();
            $('#loadMore').click(function () {
                x= (x+1 <= size_li) ? x+1 : size_li;
                $('#myList li:lt('+x+')').show();
            });
            $('#showLess').click(function () {
                x=(x-1<0) ? 1 : x-1;
                $('#myList li').not(':lt('+x+')').hide();
            });
        });
    </script>
</head>
<body>
<!--banner-->
<!--banner-->
<div class="banner about-bnr">
    <div class="banner-info about-bnr-info">
        <div class="container">
            <div class="logo">
                <div class="ribbon">
                    <div class="ribbon-fold"><h1> <a href="${pageContext.request.contextPath}/welcome">Pizza</a></h1></div>
                </div>
                <h2>Better Ingredients better Pizza</h2>
            </div>
            <!--navigation-->
            <div class="top-nav">
                <nav class="navbar navbar-default">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-center cl-effect-14">
                            <li class="active"><a href="${pageContext.request.contextPath}/welcome">Home</a></li>
                            <li><a href="${pageContext.request.contextPath}/selectOrder">Orders</a></li>
                            <li><a href="${pageContext.request.contextPath}/cart">Cart</a></li>

                            <security:authorize access="hasRole('ROLE_ADMIN')">
                                <li><a href="${pageContext.request.contextPath}/admin">Admin</a></li>
                            </security:authorize>
                            <security:authorize access="hasAnyRole('ROLE_COOK', 'ROLE_ADMIN')">
                                <li><a href="${pageContext.request.contextPath}/cook">Cook</a></li>
                            </security:authorize>
                            <security:authorize access="hasAnyRole('ROLE_SHIPPER', 'ROLE_ADMIN')">
                                <li><a href="${pageContext.request.contextPath}/shipper">Shipper</a></li>
                            </security:authorize>
                            <li><a href="${pageContext.request.contextPath}/about">About</a></li>


                        </ul>
                        <div class="clearfix"> </div>
                    </div>
                </nav>
            </div>
            <!--navigation-->
        </div>
    </div>
</div>
<!--//banner-->
<!--banner-bottom-->



<br>
<br>
<br>
<br>
<br>

<div class="container">
    <form  name='f' action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>
        <div class="col-xs-4"></div>
        <div class="col-xs-4 col-centered">
            <h3 class="title">Login</h3>
            <c:if test="${param.error == 'true'}">
                <div style="color:red;margin:10px 0px;">

                    Login Failed!!!<br />
                    Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

                </div>
            </c:if>
            <br>

            <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input  type="text" class="form-control input-lg" name='username' placeholder="Username">
        </div>
        <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
            <input  type="password" class="form-control input-lg" name='password' placeholder="Password">
            <br>
        </div>
            <div>
                <button name="submit" type="submit" value="submit" class="btn btn-primary btn-lg btn-block">Login</button>
            </div>
            <div>
                <a href="${pageContext.request.contextPath}/signUp" ><button type="button" class="btn btn-default btn-block"><span class="glyphicon glyphicon-user"></span> Sign Up</button></a>
            </div>
        </div>

        </div>
    </form>
<br>
<br>
<br>
<br>

</div>


<!-- //testimonial -->
<!--footer-->
<div class="footer">
    <div class="container">
        <div class="col-md-3 footer-left">
            <h4>Address</h4>
            <ul>
                <li>Martin Restaurant</li>
                <li> Barsony Janos Street</li>
                <li>3531 Miskolc</li>
                <li>+3630/856-2123</li>
            </ul>

        </div>
        <div class="col-md-5 footer-left">
            <h4>Location</h4>
            <div class="map">
                <iframe style="height: 35%;" src="https://www.google.com/maps/embed/v1/place?q=miskolc%20b%C3%A1rsony%20j%C3%A1nos%2043%20&key=AIzaSyC3PM8eQYk6ie6KQBgZCrMXehaCMkFgL7I" ></iframe>
            </div>
        </div>
        <div class="col-md-3 footer-right">
            <div class="icons">
                <ul>
                    <li><a href="#" class="twitter"> </a></li>
                    <li><a href="#" class="twitter facebook"> </a></li>
                    <li><a href="#" class="twitter chrome"> </a></li>
                    <li><a href="#" class="twitter pinterest"> </a></li>
                    <li><a href="#" class="twitter linkedin"> </a></li>
                </ul>
            </div>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<!--//footer-->
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/resources/js/bootstrap.js"></script>
</body>
</html>