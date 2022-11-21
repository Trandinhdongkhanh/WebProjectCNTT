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

<link rel="stylesheet" href="css/style.css">

</head>
<body>

	<div class="site-wrap">
		<jsp:include page="header.jsp"></jsp:include>

		<div class="bg-light py-3">
			<div class="container">
				<div class="row">
					<div class="col-md-12 mb-0">
						<a href="homePage">Home</a> <span class="mx-2 mb-0">/</span> <strong
							class="text-black">${detail.productName}</strong>
					</div>
				</div>
			</div>
		</div>
		<c:if test="${mess != null }">
			<div class="alert alert-success">${mess}</div>
		</c:if>
		<form action="addCart?productID=${detail.productID}" method="post">
			<div class="site-section">
				<div class="container">
					<div class="row">
						<div class="col-md-6">
							<img src="${detail.image}" alt="Image" class="img-fluid">
						</div>
						<div class="col-md-6">
							<h2 class="text-black">${detail.productName}</h2>
							<p>${detail.description}</p>
							<p>
								<strong class="text-primary h4">$${detail.price}</strong>
							</p>
							<div class="mb-5">
								<div class="input-group mb-3" style="max-width: 120px;">
									<div class="input-group-prepend">
										<button class="btn btn-outline-primary js-btn-minus"
											type="button">&minus;</button>
									</div>
									<input name="ammount" type="text"
										class="form-control text-center" value="1" placeholder=""
										aria-label="Example text with button addon"
										aria-describedby="button-addon1">
									<div class="input-group-append">
										<button class="btn btn-outline-primary js-btn-plus"
											type="button">&plus;</button>
									</div>
								</div>

							</div>
							<p>
								<button type="submit" class="buy-now btn btn-sm btn-primary">
									Add To Cart</button>
								<!--  <a href="addCart?productID=${detail.productID}"
								class="buy-now btn btn-sm btn-primary">Add To Cart</a>-->
							</p>

						</div>
					</div>
				</div>
			</div>
		</form>

		<!--
		<div class="site-section border-bottom" data-aos="fade">
			<div class="container">
				<div class="row justify-content-center mb-5">
					<div class="col-md-7 site-section-heading text-center pt-4">
						<h2>Review</h2>
					</div>
				</div>
			</div>
		</div>
		<!-->


		<div class="site-section block-3 site-blocks-2 bg-light">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-7 site-section-heading text-center pt-4">
						<h2>Related Products</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="nonloop-block-3 owl-carousel">
							<c:forEach items="${relatedProducts}" var="r">
								<div class="item">
									<div class="block-4 text-center">
										<figure class="block-4-image">
											<img src="${r.image }" alt="Image placeholder"
												class="img-fluid">
										</figure>
										<div class="block-4-text p-4">
											<h3>
												<a href="detailPage?productID=${r.productID}">${r.productName }</a>
											</h3>
											<p class="mb-0">Finding perfect shoes</p>
											<p class="text-primary font-weight-bold">${r.price }</p>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>

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