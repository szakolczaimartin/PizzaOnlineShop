<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pizza a Food Category Flat bootstrap Responsive website Template | Home :: w3layouts</title>
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Pizza Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
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
            x = 1;
            $('#myList li:lt(' + x + ')').show();
            $('#loadMore').click(function () {
                x = (x + 1 <= size_li) ? x + 1 : size_li;
                $('#myList li:lt(' + x + ')').show();
            });
            $('#showLess').click(function () {
                x = (x - 1 < 0) ? 1 : x - 1;
                $('#myList li').not(':lt(' + x + ')').hide();
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
                    <div class="ribbon-fold"><h1><a href="${pageContext.request.contextPath}/welcome">Pizza</a></h1>
                    </div>
                </div>
                <h2>Better Ingredients better Pizza</h2>
            </div>
            <!--navigation-->
            <div class="top-nav">
                <nav class="navbar navbar-default">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                data-target="#bs-example-navbar-collapse-1">
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
                        <div class="clearfix"></div>
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

<div>
    <div class="col-xs-2">
        <ul>
            <li><h4><a href="#small">Pizza 32cm</a></h4></li>
            <br>
            <li><h4><a href="#big">Pizza 50cm</a></h4></li>
            <br>
            <li><h4><a href="#other">Other food</a></h4></li>
            <br>
            <li><h4><a href="#drink">Drink</a></h4></li>
            <br>
        </ul>

    </div>
    <div class="col-xs-8 col-centered">
            <div class="bs-docs-separator">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th width="80"><h2 id="small" class="typoh2">Pizza 32cm</h2></th>
                        <th width="80">Food name</th>
                        <th width="60">Picture</th>
                        <th width="120">Ingredients</th>
                        <th width="60">Size</th>
                        <th width="120">Price</th>
                        <th width="60">Quantity</th>
                        <th width="60">Add to the cart</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${smallPizza}" var="food">
                    <tr>
                    <tr>
                        <form action="/adToChart">
                        <div style=" visibility: hidden">
                            <input name="id" type="text" value="${food.id}" style="visibility: hidden;"/>
                        </div>
                        <td></td>
                        <td>${food.name}</td>
                        <td><img src="${food.url}" style="width:150px;height:120px;"></td>
                        <td>${food.ingredients}</td>
                        <td>${food.size} cm</td>
                        <td>${food.price} Ft</td>
                        <td>
                            <input name="quantity" type="number" min="0" value="0" required/>
                        <td>
                            <button type="submit">Add to the cart</button>
                        </td>
                        </form>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="bs-docs-separator">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th width="80"><h2 id="big" class="typoh2">Pizza 50cm</h2></th>
                        <th width="80">Food name</th>
                        <th width="60">Picture</th>
                        <th width="120">Ingredients</th>
                        <th width="60">Size</th>
                        <th width="120">Price</th>
                        <th width="60">Quantity</th>
                        <th width="60">Add to the cart</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${bigPizza}" var="food">
                    <tr>
                    <tr>
                        <form action="/adToChart">
                            <div style=" visibility: hidden">
                                <input name="id" type="text" value="${food.id}" style="visibility: hidden;"/>
                            </div>
                            <td></td>
                            <td>${food.name}</td>
                            <td><img src="${food.url}" style="width:150px;height:120px;"></td>
                            <td>${food.ingredients}</td>
                            <td>${food.size} cm</td>
                            <td>${food.price} Ft</td>

                            <td>
                                <input name="quantity" type="number" min="0" value="0" required/>
                            <td>
                                <button type="submit">Add to the cart</button>
                            </td>
                        </form>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

                <div class="bs-docs-separator">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th width="80"><h2 id="other" class="typoh2">Other food</h2></th>
                            <th width="80">Food name</th>
                            <th width="60">Picture</th>
                            <th width="120">Ingredients</th>
                            <th width="60">Size</th>
                            <th width="120">Price</th>
                            <th width="60">Quantity</th>
                            <th width="60">Add to the cart</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${otherFood}" var="food">
                        <tr>
                        <tr>
                            <form action="/adToChart">
                            <div style=" visibility: hidden">
                                <input name="id" type="text" value="${food.id}" style="visibility: hidden;"/>
                            </div>
                            <td></td>
                            <td>${food.name}</td>
                            <td><img src="${food.url}" style="width:150px;height:120px;"></td>
                            <td>${food.ingredients}</td>
                            <td>${food.size} </td>
                            <td>${food.price} Ft</td>

                            <td>
                                <input name="quantity" type="number" min="0" value="0" required/>
                            <td>
                                <button type="submit">Add to the cart</button>
                            </td>
                            </form>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

                <div class="bs-docs-separator">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th width="80"><h2 id="drink" class="typoh2">Drink</h2>
                            </th>
                            <th width="80">Food name</th>
                            <th width="60">Picture</th>
                            <th width="120">Ingredients</th>
                            <th width="60">Size</th>
                            <th width="120">Price</th>
                            <th width="60">Quantity</th>
                            <th width="60">Add to the cart</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${drink}" var="food">
                        <tr>
                        <tr>
                            <form action="/adToChart">
                            <div style=" visibility: hidden">
                                <input name="id" type="text" value="${food.id}" style="visibility: hidden;"/>
                            </div>
                            <td></td>
                            <td>${food.name}</td>
                            <td><img src="${food.url}" style="width:150px;height:120px;"></td>
                            <td>${food.ingredients}</td>
                            <td>${food.size} L</td>
                            <td>${food.price} Ft</td>

                            <td>
                                <input name="quantity" type="number" min="0" value="0" required/>
                            <td>
                                <button type="submit">Add to the cart</button>
                            </td>
                            </form>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
        </div>
    </div>

        <br>
        <br>

        <!--//footer-->
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="/resources/js/bootstrap.js"></script>
</body>
</html>