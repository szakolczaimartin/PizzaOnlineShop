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
    <form  action="/modifyFood" method='POST'>
            <h3>Modify food</h3>

            <br>
            <br>
         <div class="input-group">
                <span class="input-group-addon">Name</span>
                <input  type="text" class="form-control input-lg" name='name'  value="${modifyFood.name}" readonly>
            </div>
            <div class="input-group">
                <span class="input-group-addon">Price</span>
                <input  type="number" class="form-control input-lg" name='price'  value="${modifyFood.price}">
            </div>
            <div class="input-group">
                <span class="input-group-addon">Url</span>
                <input  type="text" class="form-control input-lg" name='url' value="${modifyFood.url}">
            </div>
            <div class="input-group">
                <span class="input-group-addon">Type</span>
                <select  class="selectpicker form-control" name="type" value="${modifyFood.type}">
                    <option value="pizza">Pizza</option>
                    <option value="drink">Drink</option>
                    <option value="other">Other food</option>
                </select>
            </div>
            <div class="input-group">
                <span class="input-group-addon">Size</span>
                <input  type="text" class="form-control input-lg" name='size' value="${modifyFood.size}">
            </div>
            <div class="input-group">
                <span class="input-group-addon">Ingredients</span>
                <input  type="text" class="form-control input-lg" name='ingredients' value="${modifyFood.ingredients}">
            </div>
            <div>
                <div>
                    <button name="submit" type="submit" value="submit" class="btn btn-primary btn-lg btn-block">Modify food</button>
                <br>
                    <br>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <br>

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