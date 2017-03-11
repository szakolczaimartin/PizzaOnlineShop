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
    <div class="col-xs-1"></div>

    <div class="col-xs-4">
        <form action="/modifyItemSub" method="post">
            <h3>Modify item</h3>

            <br>
            <br>
                <input  type="number" class="form-control input-lg" name='id'  value="${myItem.id}"  hidden="true">

            <div class="input-group">
                <span class="input-group-addon">Name</span>
                <input  type="text" class="form-control input-lg" name='name'  value="${myItem.food.name}" disabled>
            </div>


            <div class="input-group">
                <span class="input-group-addon">Quantity</span>
                <input  type="number" class="form-control input-lg" name='quantity'  value="${myItem.quantity}">
            </div>

            <div>
                <div>
                    <button name="submit" type="submit" value="submit" class="btn btn-primary btn-lg btn-block">Modify item</button>
                    <br>
                    <br>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
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