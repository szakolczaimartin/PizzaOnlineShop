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

<br>
<br>

<div class="container">

    <div class="col-xs-6">
        <form >
            <h2 class="typoh2">List items</h2>
            <div class="bs-docs-separator">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th width="20">id</th>
                        <th width="50">Food name</th>
                        <th width="50">Type</th>
                        <th width="120">Ingredients</th>
                        <th width="30">Size</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${itemList}" var="item">
                        <tr>
                            <td>${item.food.id}</td>
                            <td>${item.food.name}</td>
                            <td>${item.food.type}</td>
                            <td>${item.food.ingredients}</td>
                            <td>${item.food.size}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </form>

    </div>
</div>


<!--//footer-->
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/resources/js/bootstrap.js"></script>
</body>
</html>