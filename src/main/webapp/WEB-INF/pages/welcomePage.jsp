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
<div class="banner">
    <div class="banner-info">
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
                            <li><a href="${pageContext.request.contextPath}/userInfo">Orders</a></li>
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
        </div>

            <!--navigation-->
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

<!--//banner-->
        <!--welcome-->
        <div class="welcome">
            <h3 class="title">Welcome</h3>
            <p>Nam libero tempore cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod </p>
            <div class="welcome-info">
                <div class="col-md-6 welcome-grids">
                    <div class="welcome-img">
                        <img src="/resources/images/img1.jpg" class="img-responsive zoom-img" alt=""/>
                    </div>
                </div>
                <div class="col-md-6 welcome-grids">
                    <div class="welcome-img">
                        <img src="/resources/images/img2.jpg" class="img-responsive zoom-img" alt=""/>
                    </div>
                </div>
                <div class="clearfix"> </div>
            </div>
            <p>Nam libero tempore cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus omnis optio cumque nihil impedit quo minus id quod maxime placeat facere possimus.Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae </p>
        </div>
        <!--//welcome-->
    </div>
</div>
<!--//banner-bottom-->
<!--services-->
<div class="services">
    <div class="container">
        <h3 class="title">Services</h3>
        <div class="servc-grids">
            <div class="col-md-3 servc-grid">
                <div class="servc-icon hi-icon-effect-8">
                    <a href="#" class="hi-icon hi-icon-archive"><span class="glyphicon glyphicon glyphicon-user" aria-hidden="true"></span></a>
                </div>
                <h4>Lorem ipsum dolor </h4>
                <p>Nam libero tempore cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod </p>
            </div>
            <div class="col-md-3 servc-grid">
                <div class="servc-icon hi-icon-effect-8">
                    <a href="#" class="hi-icon hi-icon-archive"><span class="glyphicon glyphicon glyphicon-home" aria-hidden="true"></span></a>
                </div>
                <h4>Lorem ipsum dolor </h4>
                <p>Nam libero tempore cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod </p>
            </div>
            <div class="col-md-3 servc-grid">
                <div class="servc-icon hi-icon-effect-8">
                    <a href="#" class="hi-icon hi-icon-archive"><span class="glyphicon glyphicon glyphicon-fire" aria-hidden="true"></span></a>
                </div>
                <h4>Lorem ipsum dolor </h4>
                <p>Nam libero tempore cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod </p>
            </div>
            <div class="col-md-3 servc-grid">
                <div class="servc-icon hi-icon-effect-8">
                    <a href="#" class="hi-icon hi-icon-archive"><span class="glyphicon glyphicon glyphicon-heart-empty" aria-hidden="true"></span></a>
                </div>
                <h4>Lorem ipsum dolor </h4>
                <p>Nam libero tempore cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod </p>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!--//services-->
<!--menu-->
<div class="menu">
    <div class="container">
        <div class="menu-tag">
            <h3 class="title">The Menu</h3>
        </div>
        <div class="load_more">
            <ul id="myList">
                <li>
                    <div class="l_g">
                        <div class="l_g_r">
                            <div class="col-md-6 menu-grids">
                                <div class="menu-text">
                                    <div class="menu-text-left">
                                        <h4>Voluptate cillum fugiat.</h4>
                                        <h6>Cheese, tomato, mushrooms, onions.</h6>
                                    </div>
                                    <div class="menu-text-midle">
                                        <span class="line"> </span>
                                    </div>
                                    <div class="menu-text-right">
                                        <h4>$ 50</h4>
                                    </div>
                                    <div class="clearfix"> </div>
                                </div>
                                <div class="menu-text">
                                    <div class="menu-text-left">
                                        <h4>Metus varius laoreet.</h4>
                                        <h6>Chicken, mozzarella cheese, onions.</h6>
                                    </div>
                                    <div class="menu-text-midle">
                                        <span class="line"> </span>
                                    </div>
                                    <div class="menu-text-right">
                                        <h4>$62</h4>
                                    </div>
                                    <div class="clearfix"> </div>
                                </div>
                                <div class="menu-text">
                                    <div class="menu-text-left">
                                        <h4>Donec sodales magna.</h4>
                                        <h6>Tuna, Sweetcorn, Cheese.</h6>
                                    </div>
                                    <div class="menu-text-midle">
                                        <span class="line"> </span>
                                    </div>
                                    <div class="menu-text-right">
                                        <h4>$25</h4>
                                    </div>
                                    <div class="clearfix"> </div>
                                </div>
                                <div class="menu-text">
                                    <div class="menu-text-left">
                                        <h4>Saugue velit cursus.</h4>
                                        <h6>Pineapple, Minced Beef, Cheese.</h6>
                                    </div>
                                    <div class="menu-text-midle">
                                        <span class="line"> </span>
                                    </div>
                                    <div class="menu-text-right">
                                        <h4>$30</h4>
                                    </div>
                                    <div class="clearfix"> </div>
                                </div>
                            </div>
                            <div class="col-md-6 menu-grids">
                                <div class="menu-text">
                                    <div class="menu-text-left">
                                        <h4>Arcu pede enim justo.</h4>
                                        <h6>Tuna, Sweetcorn, Cheese.</h6>
                                    </div>
                                    <div class="menu-text-midle">
                                        <span class="line"> </span>
                                    </div>
                                    <div class="menu-text-right">
                                        <h4>$50</h4>
                                    </div>
                                    <div class="clearfix"> </div>
                                </div>
                                <div class="menu-text">
                                    <div class="menu-text-left">
                                        <h4>Cras dapibussemper nisi.</h4>
                                        <h6>Pineapple, Minced Beef, Cheese.</h6>
                                    </div>
                                    <div class="menu-text-midle">
                                        <span class="line"> </span>
                                    </div>
                                    <div class="menu-text-right">
                                        <h4>$62</h4>
                                    </div>
                                    <div class="clearfix"> </div>
                                </div>
                                <div class="menu-text">
                                    <div class="menu-text-left">
                                        <h4>Quam semper libero.</h4>
                                        <h6>Cheese, tomato, mushrooms, onions.</h6>
                                    </div>
                                    <div class="menu-text-midle">
                                        <span class="line"> </span>
                                    </div>
                                    <div class="menu-text-right">
                                        <h4>$25</h4>
                                    </div>
                                    <div class="clearfix"> </div>
                                </div>
                                <div class="menu-text">
                                    <div class="menu-text-left">
                                        <h4>Nam eget dui Etiam.</h4>
                                        <h6>Chicken, mozzarella cheese, onions.</h6>
                                    </div>
                                    <div class="menu-text-midle">
                                        <span class="line"> </span>
                                    </div>
                                    <div class="menu-text-right">
                                        <h4>$30</h4>
                                    </div>
                                    <div class="clearfix"> </div>
                                </div>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                </li>
                <li><div class="l_g">
                    <div class="l_g_r g_r">
                        <div class="col-md-6 menu-grids">
                            <div class="menu-text">
                                <div class="menu-text-left">
                                    <h4>Voluptate cillum fugiat.</h4>
                                    <h6>Cheese, tomato, mushrooms, onions.</h6>
                                </div>
                                <div class="menu-text-midle">
                                    <span class="line"> </span>
                                </div>
                                <div class="menu-text-right">
                                    <h4>$50</h4>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="menu-text">
                                <div class="menu-text-left">
                                    <h4>Metus varius laoreet.</h4>
                                    <h6>Chicken, mozzarella cheese, onions.</h6>
                                </div>
                                <div class="menu-text-midle">
                                    <span class="line"> </span>
                                </div>
                                <div class="menu-text-right">
                                    <h4>$62</h4>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="menu-text">
                                <div class="menu-text-left">
                                    <h4>Donec sodales magna.</h4>
                                    <h6>Tuna, Sweetcorn, Cheese.</h6>
                                </div>
                                <div class="menu-text-midle">
                                    <span class="line"> </span>
                                </div>
                                <div class="menu-text-right">
                                    <h4>$25</h4>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="menu-text">
                                <div class="menu-text-left">
                                    <h4>Saugue velit cursus.</h4>
                                    <h6>Pineapple, Minced Beef, Cheese.</h6>
                                </div>
                                <div class="menu-text-midle">
                                    <span class="line"> </span>
                                </div>
                                <div class="menu-text-right">
                                    <h4>$30</h4>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                        </div>
                        <div class="col-md-6 menu-grids">
                            <div class="menu-text">
                                <div class="menu-text-left">
                                    <h4>Arcu pede enim justo.</h4>
                                    <h6>Tuna, Sweetcorn, Cheese.</h6>
                                </div>
                                <div class="menu-text-midle">
                                    <span class="line"></span>
                                </div>
                                <div class="menu-text-right">
                                    <h4>$50</h4>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="menu-text">
                                <div class="menu-text-left">
                                    <h4>Cras dapibussemper nisi.</h4>
                                    <h6>Pineapple, Minced Beef, Cheese.</h6>
                                </div>
                                <div class="menu-text-midle">
                                    <span class="line"> </span>
                                </div>
                                <div class="menu-text-right">
                                    <h4>$62</h4>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="menu-text">
                                <div class="menu-text-left">
                                    <h4>Quam semper libero.</h4>
                                    <h6>Cheese, tomato, mushrooms, onions.</h6>
                                </div>
                                <div class="menu-text-midle">
                                    <span class="line"> </span>
                                </div>
                                <div class="menu-text-right">
                                    <h4>$25</h4>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="menu-text">
                                <div class="menu-text-left">
                                    <h4>Nam eget dui Etiam.</h4>
                                    <h6>Chicken, mozzarella cheese, onions.</h6>
                                </div>
                                <div class="menu-text-midle">
                                    <span class="line"> </span>
                                </div>
                                <div class="menu-text-right">
                                    <h4>$30</h4>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </div>
                </li>
                <li><div class="l_g">
                    <div class="l_g_r g_r">
                        <div class="col-md-6 menu-grids">
                            <div class="menu-text">
                                <div class="menu-text-left">
                                    <h4>Voluptate cillum fugiat.</h4>
                                    <h6>Cheese, tomato, mushrooms, onions.</h6>
                                </div>
                                <div class="menu-text-midle">
                                    <span class="line"> </span>
                                </div>
                                <div class="menu-text-right">
                                    <h4>$50</h4>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="menu-text">
                                <div class="menu-text-left">
                                    <h4>Metus varius laoreet.</h4>
                                    <h6>Chicken, mozzarella cheese, onions.</h6>
                                </div>
                                <div class="menu-text-midle">
                                    <span class="line"> </span>
                                </div>
                                <div class="menu-text-right">
                                    <h4>$62</h4>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="menu-text">
                                <div class="menu-text-left">
                                    <h4>Donec sodales magna.</h4>
                                    <h6>Tuna, Sweetcorn, Cheese.</h6>
                                </div>
                                <div class="menu-text-midle">
                                    <span class="line"> </span>
                                </div>
                                <div class="menu-text-right">
                                    <h4>$25</h4>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="menu-text">
                                <div class="menu-text-left">
                                    <h4>Saugue velit cursus.</h4>
                                    <h6>Pineapple, Minced Beef, Cheese.</h6>
                                </div>
                                <div class="menu-text-midle">
                                    <span class="line"> </span>
                                </div>
                                <div class="menu-text-right">
                                    <h4>$30</h4>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                        </div>
                        <div class="col-md-6 menu-grids">
                            <div class="menu-text">
                                <div class="menu-text-left">
                                    <h4>Arcu pede enim justo.</h4>
                                    <h6>Tuna, Sweetcorn, Cheese.</h6>
                                </div>
                                <div class="menu-text-midle">
                                    <span class="line"> </span>
                                </div>
                                <div class="menu-text-right">
                                    <h4>$50</h4>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="menu-text">
                                <div class="menu-text-left">
                                    <h4>Cras dapibussemper nisi.</h4>
                                    <h6>Pineapple, Minced Beef, Cheese.</h6>
                                </div>
                                <div class="menu-text-midle">
                                    <span class="line"> </span>
                                </div>
                                <div class="menu-text-right">
                                    <h4>$62</h4>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="menu-text">
                                <div class="menu-text-left">
                                    <h4>Quam semper libero.</h4>
                                    <h6>Cheese, tomato, mushrooms, onions.</h6>
                                </div>
                                <div class="menu-text-midle">
                                    <span class="line"> </span>
                                </div>
                                <div class="menu-text-right">
                                    <h4>$25</h4>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="menu-text">
                                <div class="menu-text-left">
                                    <h4>Nam eget dui Etiam.</h4>
                                    <h6>Chicken, mozzarella cheese, onions.</h6>
                                </div>
                                <div class="menu-text-midle">
                                    <span class="line"> </span>
                                </div>
                                <div class="menu-text-right">
                                    <h4>$30</h4>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </div>
                </li>
            </ul>
            <div id="loadMore">Load more</div>
            <div id="showLess">Show less</div>
        </div>
    </div>
</div>
<!--//menu-->
<!-- testimonial -->
<div class="testimonial">
    <!-- container -->
    <div class="container">
        <h3 class="title">Feedback About us</h3>
        <!-- banner-text Slider starts Here -->
        <script src="/resources/js/responsiveslides.min.js"></script>
        <script>
            // You can also use "$(window).load(function() {"
            $(function () {
                // Slideshow 4
                $("#slider3").responsiveSlides({
                    auto: true,
                    pager:true,
                    nav:false,
                    speed: 500,
                    namespace: "callbacks",
                    before: function () {
                        $('.events').append("<li>before event fired.</li>");
                    },
                    after: function () {
                        $('.events').append("<li>after event fired.</li>");
                    }
                });
            });
        </script>
        <!--//End-slider-script -->
        <div  id="top" class="callbacks_container">
            <ul class="rslides" id="slider3">
                <li>
                    <div class="testimonial-grids">
                        <div class="testimonial-left">
                            <img src="/resources/images/t1.jpg" alt="" />
                        </div>
                        <div class="testimonial-right">
                            <h5>Mary Wilson</h5>
                            <p><span>"</span> Lorem ipsum dolor sit amet consec tetuer adi piscing elit Praesent vestibulum
                                molestie lacus consec tetuer adi piscing elit Praesent vestibulum molestie lacus <span>"</span>
                            </p>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </li>
                <li>
                    <div class="testimonial-grids">
                        <div class="testimonial-left">
                            <img src="/resources/images/t3.jpg" alt="" />
                        </div>
                        <div class="testimonial-right">
                            <h5>Lora  Alance</h5>
                            <p><span>"</span> Lorem ipsum dolor sit amet consec tetuer adi piscing elit Praesent vestibulum
                                molestie lacus consec tetuer adi piscing elit Praesent vestibulum molestie lacus <span>"</span>
                            </p>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </li>
                <li>
                    <div class="testimonial-grids">
                        <div class="testimonial-left">
                            <img src="/resources/images/t2.jpg" alt="" />
                        </div>
                        <div class="testimonial-right">
                            <h5>David Smith</h5>
                            <p><span>"</span> Lorem ipsum dolor sit amet consec tetuer adi piscing elit Praesent vestibulum
                                molestie lacus consec tetuer adi piscing elit Praesent vestibulum molestie lacus <span>"</span>
                            </p>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <!-- //container -->
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