<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Shoppers &mdash; Colorlib e-Commerce Template</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Mukta:300,400,700">
<link rel="stylesheet" href="fonts/icomoon/style.css">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">


<link rel="stylesheet" href="css/aos.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>
	<div class="site-wrap">

		<!-- Begin of Header -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- End of Header -->

		<div class="site-blocks-cover"
			style="background-image: url(images/hero_1.jpg);" data-aos="fade">
			<div class="container">
				<div
					class="row align-items-start align-items-md-center justify-content-end">
					<div class="col-md-5 text-center text-md-left pt-5 pt-md-0">
						<h1 class="mb-2">Finding Your Perfect Shoes</h1>
						<div class="intro-text text-center text-md-left">
							<p class="mb-4">Your hapiness is our hapiness</p>
							<p>
								<a href="shopPage" class="btn btn-sm btn-primary">Shop Now</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section site-section-sm site-blocks-1">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4"
						data-aos="fade-up" data-aos-delay="">
						<div class="icon mr-4 align-self-start">
							<span class="icon-truck"></span>
						</div>
						<div class="text">
							<h2 class="text-uppercase">Free Shipping</h2>
							<p>Expensive shipping cost is no longer your concern, here we
								offer free shipping service in only 24 hours</p>
						</div>
					</div>
					<div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4"
						data-aos="fade-up" data-aos-delay="100">
						<div class="icon mr-4 align-self-start">
							<span class="icon-refresh2"></span>
						</div>
						<div class="text">
							<h2 class="text-uppercase">Free Returns</h2>
							<p>If you don't like our products you can return them for
								free. For us, customer satisfaction comes first</p>
						</div>
					</div>
					<div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4"
						data-aos="fade-up" data-aos-delay="200">
						<div class="icon mr-4 align-self-start">
							<span class="icon-help"></span>
						</div>
						<div class="text">
							<h2 class="text-uppercase">Customer Support</h2>
							<p>We are always ready to listen and support customers to
								bring the best user experience</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="site-section site-blocks-2">
					<div class="container">
						<div class="row">
							<div class="col-sm-6 col-md-6 col-lg-4 mb-4 mb-lg-0"
								data-aos="fade" data-aos-delay="">
								<a class="block-2-item" href="category?cateID=1">
									<figure class="image">
										<img
											src="https://advertisingvietnam.com/wp-content/uploads/2018/09/nike-image.jpg"
											alt="" class="img-fluid">
									</figure>
									<div class="text">
										<span class="text-uppercase">Collections</span>
										<h3>Nike</h3>
									</div>
								</a>
							</div>
							<div class="col-sm-6 col-md-6 col-lg-4 mb-5 mb-lg-0"
								data-aos="fade" data-aos-delay="100">
								<a class="block-2-item" href="category?cateID=2">
									<figure class="image">
										<img
											src="http://runningshoes.vn/wp-content/uploads/2021/12/giay-chay-bo-adidas-tot-nhat-2021.jpg"
											alt="" class="img-fluid">
									</figure>
									<div class="text">
										<span class="text-uppercase">Collections</span>
										<h3>Adidas</h3>
									</div>
								</a>
							</div>
							<div class="col-sm-6 col-md-6 col-lg-4 mb-5 mb-lg-0"
								data-aos="fade" data-aos-delay="200">
								<a class="block-2-item" href="category?cateID=3">
									<figure class="image">
										<img
											src="https://www.highsnobiety.com/static-assets/thumbor/M9qHqZbWqh6IDj0WuMLrgwNutBE=/1600x1165/www.highsnobiety.com/static-assets/wp-content/uploads/2022/05/01182010/pglang-converse-collab-release-date-price.jpg"
											alt="" class="img-fluid">
									</figure>
									<div class="text">
										<span class="text-uppercase">Collections</span>
										<h3>Converse</h3>
									</div>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section block-3 site-blocks-2 bg-light">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-7 site-section-heading text-center pt-4">
						<h2>Lastest Products</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="nonloop-block-3 owl-carousel">
							<c:forEach items="${lastestProducts}" var="o">
								<div class="item">
									<div class="block-4 text-center">
										<figure class="block-4-image">
											<img src="${o.image}" alt="Image placeholder"
												class="img-fluid">
										</figure>
										<div class="block-4-text p-4">
											<h3>
												<a href="detailPage?productID=${o.productID }">${o.productName}</a>
											</h3>
											<p class="mb-0">Finding perfect shoes</p>
											<p class="text-primary font-weight-bold">$${o.price}</p>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section block-8">
			<div class="container">
				<div class="row justify-content-center  mb-5">
					<div class="col-md-7 site-section-heading text-center pt-4">
						<h2>Big Sale!</h2>
					</div>
				</div>
				<div class="row align-items-center">
					<div class="col-md-12 col-lg-7 mb-5">
						<a href="#"><img
							src="https://c8.alamy.com/comp/2AXX6W4/new-fitness-sneakers-set-fashion-shoes-for-training-running-shoe-sport-shoes-set-2AXX6W4.jpg"
							alt="Image placeholder" class="img-fluid rounded"></a>
					</div>
					<div class="col-md-12 col-lg-5 text-center pl-md-5">
						<h2>
							<a href="homePage">50% less in all items</a>
						</h2>
						<p>Hurry up to enjoy up to 50% discount in our store</p>
						<p>
							<a href="shopPage" class="btn btn-primary btn-sm">Shop Now</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		<!-- Footer -->
		<jsp:include page="footer.jsp"></jsp:include>
	</div>

	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/jquery-ui.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/aos.js"></script>

	<script src="js/main.js"></script>

</body>
</html>