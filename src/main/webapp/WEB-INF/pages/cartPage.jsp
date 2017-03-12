<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <script src ="/resources/js/validator.js"></script>

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
                            <li><a href="${pageContext.request.contextPath}/admin">Admin</a></li>
                            <li><a href="${pageContext.request.contextPath}/cart">Cart</a></li>
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
<div class="col-md-12">
    <ul class="nav navbar-nav navbar-right">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <li><a href="${pageContext.request.contextPath}/signUp"><span class="glyphicon glyphicon-shopping-cart"></span> <span class="badge badge-primary">${countItemNumber}</span></a></li>
            <li><a href="/modifyDetails" >Signed in as: ${pageContext.request.userPrincipal.name}</a></li>
            <li><a href="${pageContext.request.contextPath}/logout" ><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
        </c:if>

        <c:if test="${!(pageContext.request.userPrincipal.name != null)}">
            <li><a href="${pageContext.request.contextPath}/signUp"><span class="glyphicon glyphicon-user"></span> Sign Up</font></a></li>
            <li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Login</font</a></li>
        </c:if>
    </ul>
</div>


<br>
<br>
<br>
<br>
<br>
<div class="container">
<div class="col-xs-2 col-centered"></div>
<div class="col-xs-8 col-centered">
    <div class="bs-docs-separator">
        <table class="table table-striped">
            <h3 class="title">Your cart</h3>
            <div style="color:red;margin:10px 0px;">

                ${message}

            </div>
            <br>

            <thead>
            <tr>
                <th width="150"><h5>Food name</h5></th>
                <th width="30"><h5>Quantity<h5></th>
                <th width="400"><h5>Price<h5></th>
                <th width="30"><h5>Edit<h5></th>
                <th width="30"><h5>Delete<h5></th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orders}" var="food">
            <tr>
                <form action="/">
                    <td><h5> ${food.food.name} </h5>
                           Type: ${food.food.type}
                    </td>
                    <td><h5>${food.quantity}</h5></td>
                    <td><h5>${food.price} Ft</h5></td>
                    <td><a href="<c:url value='/modifyItemModal/${food.id}' />" data-toggle="modal" data-target="#myModal">
                        Edit</a></td>
                    <td>
                        <a href="<c:url value='/removeItem/${food.id}' />" >Delete</a>
                    </td>
                </form>

            </tr>
                </c:forEach>
            </tbody>
            <tr class="danger">
                <td></td>
                <td><h3>  </h3></td>
                <td><h3> In all: ${inAll} Ft</h3>  </td>
            <td></td>
            <td></td>
            <tr>
            <tr class="danger">
                <td></td>
            <td></td>

            <td>
            <div>
                <form action="/orderIt" method="post">
                <button name="submit" type="submit" value="submit" class="btn btn-primary btn-lg btn-block"> Order it!</button>
                </form>
            </div>
            </td>
            <td></td>
            <td></td>
            <tr>
        </table>
</div>
    </div>
    </div>


<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Modal Header</h4>
            </div>
            <div class="modal-body">


            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

<br>
<br>
<br>
<br>

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