<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page session="true"%>
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
                            <li><a href="${pageContext.request.contextPath}/userInfo">User Info</a></li>
                            <li><a href="${pageContext.request.contextPath}/admin">Admin</a></li>
                            <li><a href="about.html">About</a></li>
                            <li><a href="codes.html">Codes</a></li>
                            <li><a href="gallery.html">Gallery</a></li>
                            <li><a href="contact.html">Contact</a></li>
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
    <h3>Persons List</h3>
    <c:if test="${!empty usersList}">
        <table class="tg">
            <tr>
                <th width="80">Person Username</th>
                <th width="120">Person password</th>
                <th width="60">Edit</th>
                <th width="60">Delete</th>
            </tr>
            <c:forEach items="${usersList}" var="person">
                <tr>
                    <td>${person.username}</td>
                    <td>${person.password}</td>
                    <td><a href="<c:url value='/edit/${person.username}' />" >Edit</a></td>
                    <td><a href="<c:url value='/remove/${person.username}' />" >Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
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
                <li>New York Restaurant</li>
                <li>3926 Anmoore Road</li>
                <li>New York, NY 10014</li>
                <li>718-749-1714</li>
            </ul>
        </div>
        <div class="col-md-3 footer-left">
            <h4>Popular</h4>
            <ul>
                <li><a href="#">Proin placerat</a></li>
                <li><a href="#">Ipsum et rutrum</a></li>
                <li><a href="#">Proin semper utr</a></li>
                <li><a href="#">ligula sit amet</a></li>
            </ul>
        </div>
        <div class="col-md-3 footer-left">
            <h4>Details</h4>
            <ul>
                <li><a href="about.html">About</a></li>
                <li><a href="#">Careers</a></li>
                <li><a href="#">Privacy Policy</a></li>
                <li><a href="contact.html">Contact</a></li>
            </ul>
        </div>
        <div class="col-md-3 footer-right">
            <p> © 2016 Pizza . All rights reserved | Design by <a href="http://w3layouts.com/">W3layouts</a></p>
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