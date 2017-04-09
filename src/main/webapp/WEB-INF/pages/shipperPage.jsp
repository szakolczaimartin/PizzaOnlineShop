<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<div class="col-md-12">
    <ul class="nav navbar-nav navbar-right">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
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
<h2 class="typoh2">Shipper Page</h2>

<div class="container">
    <ul class="nav nav-tabs">
        <li class="active"><a data-toggle="tab" href="#menu1">Prepared orders</a></li>
        <li><a data-toggle="tab" href="#menu2">Shipping orders</a></li>
    </ul>

    <div class="tab-content">
        <div id="menu1" class="tab-pane fade in active">
            <h2 class="typoh2">Prepared orders</h2>

            <div class="bs-docs-separator">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th width="60">Order id</th>
                        <th width="60">Customer</th>
                        <th width="60">Address</th>
                        <th width="60">Phone</th>
                        <th width="60">Order time</th>
                        <th width="60">To pay</th>
                        <th width="60">Items</th>
                        <th width="60">Status</th>
                        <th width="60">Activity</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${orderPreparedList}" var="order">
                    <tr>
                    <tr>
                        <form action="/nextStatus">
                            <td>${order.id}</td>
                            <td>${order.user.userDet.name}</td>
                            <td>${order.user.userDet.address}</td>
                            <td>${order.user.userDet.phoneNumber}</td>
                            <td>${order.date}</td>
                            <td>${order.price}</td>

                            <td><a href="<c:url value='/showItems/${order.id}' />" data-toggle="modal"
                                   data-target="#orderModal"> Show items</a></td>
                            <td>${order.orderStatus}
                                <input name="id" type="text" value="${order.id}" size="1" style="visibility: hidden;"/>
                            </td>
                            <td>
                                <button type="submit">Check to the next status</button>
                            </td>

                        </form>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div id="menu2" class="tab-pane fade">
            <h2 class="typoh2">Shipping orders</h2>

            <div class="bs-docs-separator">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th width="60">Order id</th>
                        <th width="60">Customer</th>
                        <th width="60">Address</th>
                        <th width="60">Phone</th>
                        <th width="60">Order time</th>
                        <th width="60">Shipper</th>
                        <th width="60">To pay</th>
                        <th width="60">Items</th>
                        <th width="60">Status</th>
                        <th width="60">Activity</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${orderShippingList}" var="order">
                    <tr>
                    <tr>
                        <form action="/nextStatus">
                            <td>${order.id}</td>
                            <td>${order.user.userDet.name}</td>
                            <td>${order.user.userDet.address}</td>
                            <td>${order.user.userDet.phoneNumber}</td>
                            <td>${order.date}</td>
                            <td>${order.shipper.userDet.name}</td>
                            <td>${order.price}</td>

                            <td><a href="<c:url value='/showItems/${order.id}' />" data-toggle="modal"
                                   data-target="#orderModal"> Show items</a></td>
                            <td>${order.orderStatus}
                                <input name="id" type="text" value="${order.id}" size="1" style="visibility: hidden;"/>
                            </td>
                            <td>
                                <button type="submit">Check to the next status</button>
                            </td>

                        </form>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<br>
<br>















<!-- Modal -->
<div class="modal fade" id="orderModal" role="dialog">
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

<!-- //testimonial -->
<!--footer-->

<!--//footer-->
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/resources/js/bootstrap.js"></script>
</body>
</html>