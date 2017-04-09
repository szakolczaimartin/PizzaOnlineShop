<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
            <li><a href="${pageContext.request.contextPath}/cart"><span class="glyphicon glyphicon-shopping-cart"></span> <span class="badge badge-primary">${countItemNumber}</span></a></li>
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

<div class="container">
    <ul class="nav nav-tabs">
        <li class="active"><a data-toggle="tab" href="#addFood">Add food</a></li>
        <li><a data-toggle="tab" href="#menu2">Food modify</a></li>
        <li><a data-toggle="tab" href="#menu1">User modify</a></li>
        <li><a data-toggle="tab" href="#menu3">Orders</a></li>
    </ul>

    <div class="tab-content">
        <div id="addFood" class="tab-pane fade in active">
            <h3>Add food</h3>
            <form  action="/addFood" method='POST'>
                <div class="col-xs-4"></div>
                <div class="col-xs-4 col-centered">
                <div class="input-group">
                    <span class="input-group-addon">Name</span>
                    <input  type="text" class="form-control input-lg" name='name' placeholder="Food name">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">Price</span>
                    <input  type="number" class="form-control input-lg" name='price' placeholder="Price">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">Url</span>
                    <input  type="text" class="form-control input-lg" name='url' placeholder="Url">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">Type</span>
                    <select  class="selectpicker form-control" name="type">
                        <option value="pizza">Pizza</option>
                        <option value="drink">Drink</option>
                        <option value="other">Other food</option>
                    </select>
                 </div>
                <div class="input-group">
                    <span class="input-group-addon">Size</span>
                    <input  type="text" class="form-control input-lg" name='size' placeholder="Size">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">Ingredients</span>
                    <input  type="text" class="form-control input-lg" name='ingredients' placeholder="Ingredients">
                </div>
                <div>
                    <div>
                        <button name="submit" type="submit" value="submit" class="btn btn-primary btn-lg btn-block">Add new food</button>
                    </div>
                </div>
                    </div>
                </form>
        </div>
        <div id="menu1" class="tab-pane fade">
            <form>
                <h2 class="typoh2">Users</h2>
                        <div class="bs-docs-separator">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th width="80">Person name</th>
                                    <th width="120">Person username</th>
                                    <th width="60">Permissions</th>
                                    <th width="70">Add Permission</th>
                                    <th width="130">Deprive Permission</th>
                                    <th width="60">Delete</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${userList}" var="person">
                                    <tr>
                                        <td>${person.userDet.name}</td>
                                        <td>${person.username}</td>

                                        <td>
                                            <ul>
                                                <c:forEach items="${userRoleList}" var="roleList">
                                                    <c:if test="${(person.username == roleList.user.username)}">
                                                        <li>${roleList.userRole} </li>
                                                    </c:if>
                                                </c:forEach>

                                            </ul>
                                        </td>

                                        <td>
                                        <div>
                                            <form action="/addPermission">
                                                <select name="permission">
                                                    <option value="USER">USER</option>
                                                    <option value="ADMIN">ADMIN</option>
                                                    <option value="SHIPPER">SHIPPER</option>
                                                    <option value="COOK">COOK</option>
                                                </select>
                                                <button type="submit" class="btn btn-primary">ADD</button>
                                                <input name="username" type="text" value="${person.username}" size="1" style="visibility: hidden;"/>
                                            </form>
                                            </div>
                                        </td>

                                        <td>
                                            <form action="/deprivePermission">
                                                <select name="permission">
                                                    <option value="USER">USER</option>
                                                    <option value="ADMIN">ADMIN</option>
                                                    <option value="SHIPPER">SHIPPER</option>
                                                    <option value="COOK">COOK</option>
                                                </select>
                                                <button type="submit" class="btn btn-danger">DEPRIVE</button>
                                                <input name="username" type="text" value="${person.username}" size="1" style="visibility: hidden;"/>
                                            </form>
                                        </td>

                                        <td><a href="<c:url value='/remove/${person.username}' />" >Delete</a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
        </form>
        </div>
        <div id="menu2" class="tab-pane fade">

            <form>
                <h2 class="typoh2">Food modify</h2>
                        <div class="bs-docs-separator">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th width="80">Food name</th>
                                    <th width="80">Price</th>
                                    <th width="120">Ingredients</th>
                                    <th width="120">Url</th>
                                    <th width="60">Type</th>
                                    <th width="30">Size</th>
                                    <th width="60">Edit</th>
                                    <th width="60">Delete</th>

                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${foods}" var="food">
                                <tr>
                                    <td>${food.name}</td>
                                    <td>${food.price}</td>
                                    <td>${food.ingredients}</td>
                                    <td><img src="${food.url}" style="width:100px;height:80px;"></td>
                                    <td>${food.type}</td>
                                    <td>${food.size}</td>
                                    <td><a href="<c:url value='/modifyFoodModal/${food.id}' />" data-toggle="modal"
                                           data-target="#myModal"> Edit</a></td>
                                    <td><a href="<c:url value='/removeFood/${food.id}' />" >Delete</a></td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

        </div>
        </form>
        </div>
        <div id="menu3" class="tab-pane fade">
            <form>
                <div>
                <div class="container">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#ordered">Ordered</a></li>
                        <li><a data-toggle="tab" href="#prepared">Prepared</a></li>
                        <li><a data-toggle="tab" href="#shipping">Shipping</a></li>
                        <li><a data-toggle="tab" href="#delivered">Delivered</a></li>
                    </ul>

                    <div class="tab-content">
                        <div id="ordered" class="tab-pane fade in active">

                            <form>
                                <h2 class="typoh2">Ordered</h2>
                                <div class="bs-docs-separator">
                                    <table class="table table-striped">
                                        <thead>
                                        <tr>
                                            <th width="80">Order id</th>
                                            <th width="80">Customer name</th>
                                            <th width="120">Phone number</th>
                                            <th width="120">Address</th>
                                            <th width="60">Order time</th>
                                            <th width="30">Price</th>
                                            <th width="60">Show items</th>
                                            <th width="60">Status</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${orderedList}" var="order">
                                            <tr>
                                                <td>${order.id}</td>
                                                <td>${order.user.userDet.name}</td>
                                                <td>${order.user.userDet.phoneNumber}</td>
                                                <td>${order.user.userDet.address}</td>
                                                <td>${order.date}</td>
                                                <td>${order.price}</td>
                                                <td><a href="<c:url value='/showItems/${order.id}' />" data-toggle="modal"
                                                       data-target="#orderModal"> Show items</a></td>
                                                <th width="60">${order.orderStatus}</th>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>

                                </div>
                            </form>

                        </div>




                        <div id="prepared" class="tab-pane fade">
                            <form>
                                <h2 class="typoh2">Prepared orders</h2>
                                <div class="bs-docs-separator">
                                    <table class="table table-striped">
                                        <thead>
                                        <tr>
                                            <th width="80">Order id</th>
                                            <th width="80">Customer name</th>
                                            <th width="120">Phone number</th>
                                            <th width="120">Address</th>
                                            <th width="60">Order time</th>
                                            <th width="30">Price</th>
                                            <th width="60">Show items</th>
                                            <th width="60">Status</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${preparedList}" var="order">
                                            <tr>
                                                <td>${order.id}</td>
                                                <td>${order.user.userDet.name}</td>
                                                <td>${order.user.userDet.phoneNumber}</td>
                                                <td>${order.user.userDet.address}</td>
                                                <td>${order.date}</td>
                                                <td>${order.price}</td>
                                                <td><a href="<c:url value='/showItems/${order.id}' />" data-toggle="modal"
                                                       data-target="#orderModal"> Show items</a></td>
                                                <th width="60">${order.orderStatus}</th>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>

                                </div>
                            </form>
                        </div>




                        <div id="shipping" class="tab-pane fade">

                            <form>
                                <h2 class="typoh2">Shipping orders</h2>
                                <div class="bs-docs-separator">
                                    <table class="table table-striped">
                                        <thead>
                                        <tr>
                                            <th width="80">Order id</th>
                                            <th width="80">Customer name</th>
                                            <th width="120">Phone number</th>
                                            <th width="120">Address</th>
                                            <th width="60">Order time</th>
                                            <th width="30">Price</th>
                                            <th width="60">Show items</th>
                                            <th width="60">Shipper</th>
                                            <th width="60">Status</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${shippingList}" var="order">
                                            <tr>
                                                <td>${order.id}</td>
                                                <td>${order.user.userDet.name}</td>
                                                <td>${order.user.userDet.phoneNumber}</td>
                                                <td>${order.user.userDet.address}</td>
                                                <td>${order.date}</td>
                                                <td>${order.price}</td>
                                                <td><a href="<c:url value='/showItems/${order.id}' />" data-toggle="modal"
                                                       data-target="#orderModal"> Show items</a></td>
                                                <th width="60">${order.shipper.userDet.name}</th>
                                                <th width="60">${order.orderStatus}</th>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>

                                </div>
                            </form>
                        </div>
                        <div id="delivered" class="tab-pane fade">
                            <form>
                                <h2 class="typoh2">Delivered orders</h2>
                                <div class="bs-docs-separator">
                                    <table class="table table-striped">
                                        <thead>
                                        <tr>
                                            <th width="80">Order id</th>
                                            <th width="80">Customer name</th>
                                            <th width="120">Phone number</th>
                                            <th width="120">Address</th>
                                            <th width="60">Order time</th>
                                            <th width="30">Price</th>
                                            <th width="60">Show items</th>
                                            <th width="60">Shipper</th>
                                            <th width="60">Status</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${deliveredList}" var="order">
                                            <tr>
                                                <td>${order.id}</td>
                                                <td>${order.user.userDet.name}</td>
                                                <td>${order.user.userDet.phoneNumber}</td>
                                                <td>${order.user.userDet.address}</td>
                                                <td>${order.date}</td>
                                                <td>${order.price}</td>
                                                <td><a href="<c:url value='/showItems/${order.id}' />" data-toggle="modal"
                                                       data-target="#orderModal"> Show items</a></td>
                                                <th width="60">${order.shipper.userDet.name}</th>
                                                <th width="60">${order.orderStatus}</th>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>

                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                </div>
        </form>
        </div>
    </div>
</div>
<br>
<br>


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