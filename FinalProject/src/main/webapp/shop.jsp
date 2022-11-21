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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
<body>

	<div class="site-wrap">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="bg-light py-3">
			<div class="container">
				<div class="row">
					<div class="col-md-12 mb-0">
						<a href="homePage">Home</a> <span class="mx-2 mb-0">/</span> <strong
							class="text-black">Shop</strong>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section">
			<div class="container">

				<div class="row mb-5">
					<div class="col-md-9 order-2">

						<div class="row">
							<div class="col-md-12 mb-5">
								<div class="float-md-left mb-4">
									<h2 class="text-black h5">${cateName}</h2>
								</div>
								
							</div>
						</div>

						<div id="content" class="row mb-5">
							<c:forEach items="${productList}" var="o">
								<div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up">
									<div class="block-4 text-center border">
										<figure class="block-4-image">
											<a href="detailPage?productID=${o.productID}"><img
												src="${o.image}" alt="Image placeholder" class="img-fluid"></a>
										</figure>
										<div class="block-4-text p-4">
											<h3>
												<a href="detailPage?productID=${o.productID}">${o.productName}</a>
											</h3>
											<p class="mb-0">Finding perfect shoes</p>
											<p class="text-primary font-weight-bold">$${o.price}</p>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>

						<div id="pagingContent" class="row" data-aos="fade-up">
							<div class="col-md-12 text-center">
								<div class="site-block-27">
									<ul>
										<c:if test="${cateID != null }">
											<c:if test="${(tag - 1) > 0}">
												<li><a href="category?cateID=${cateID}&p=${tag - 1}">&lt;</a></li>
											</c:if>
											<c:forEach begin="1" end="${endP}" var="i">
												<li class="${tag == i ? 'active':''}"><a
													href="category?cateID=${cateID}&p=${i}">${i}</a></li>
											</c:forEach>
											<c:if test="${(tag + 1) <= endP}">
												<li><a href="category?cateID=${cateID}&p=${tag + 1}">&gt;</a></li>
											</c:if>
										</c:if>

										<c:if test="${cateID == null }">
											<c:if test="${(tag - 1) > 0 && cateID == null}">
												<li><a href="shopPage?p=${tag - 1}">&lt;</a></li>
											</c:if>
											<c:forEach begin="1" end="${endP}" var="i">
												<li class="${tag == i ? 'active':''}"><a
													href="shopPage?p=${i}">${i}</a></li>
											</c:forEach>
											<c:if test="${(tag + 1) <= endP && cateID == null}">
												<li><a href="shopPage?p=${tag + 1}">&gt;</a></li>
											</c:if>
										</c:if>
									</ul>
								</div>
							</div>
						</div>
					</div>

					<div class="col-md-3 order-1 mb-5 mb-md-0">
						<div class="border p-4 rounded mb-4">
							<h3 class="mb-3 h6 text-uppercase text-black d-block">Categories</h3>
							<ul class="list-unstyled mb-0">
								<c:forEach items="${categoryList}" var="o">
									<li class="mb-1"><a href="category?cateID=${o.cateID }"><span>${o.cateName}</span></a>
										<span class="text-black ml-auto"></span></li>
								</c:forEach>
							</ul>
						</div>

						<div class="border p-4 rounded mb-4">
							<div class="mb-4">
								<h3 class="mb-3 h6 text-uppercase text-black d-block">Filter
									by Price</h3>
							</div>
							<div class="form-check mb-3">
								<input onchange="searchByPriceUnder200()" type="radio"
									class="form-check-input" id="under100"
									name="materialExampleRadios"> <label
									class="form-check-label text-uppercase card-link-secondary d-block"
									for="under100">Under $200</label>
							</div>
							<div class="form-check mb-3">
								<input onchange="searchByPrice200To300()" type="radio"
									class="form-check-input" id="100200"
									name="materialExampleRadios"> <label
									class="form-check-label text-uppercase card-link-secondary d-block"
									for="100200">$200 to $300</label>
							</div>
							<div class="form-check mb-3">
								<input onchange="searchByPriceAbove300()" type="radio"
									class="form-check-input" id="200above"
									name="materialExampleRadios"> <label
									class="form-check-label text-uppercase card-link-secondary d-block"
									for="200above">$300 & Above</label>
							</div>
							<form>
								<div class="d-flex align-items-center mt-4 pb-1">
									<div class="md-form md-outline my-0">
										<input oninput="searchByPriceMinToMax()" id="priceMin"
											type="text" class="form-control mb-0"> <label
											for="priceMin">$ Min</label>
									</div>
									<p class="px-2 text-muted">-</p>
									<div class="md-form md-outline my-0">
										<input oninput="searchByPriceMinToMax()" id="priceMax"
											type="text" class="form-control mb-0"> <label
											for="priceMax">$ Max</label>
									</div>
								</div>
							</form>
							<div class="mb-4">
								<form action="searchAjax" method="post"
									class="site-block-top-search">
									<span class="icon icon-search2"></span> <input
										oninput="searchByName(this)" name="txt" type="text"
										class="form-control border-0" placeholder="Search">
								</form>
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

	<script>
		function searchByName(param) {
			var txtSearch = param.value;
			$.ajax({
				url : "/FinalProject/searchAjax",
				type : 'POST',
				data : {
					txt : txtSearch
				},
				success : function(data) {
					var row = document.getElementById("content");
					row.innerHTML = data;
				},
				error : function(e) {
					console.log(e.message);
				}
			});
		}
		function loadLastestAjax() {
			$.ajax({
				url : "/FinalProject/load_lastest_ajax",
				type : 'POST',
				data : {},
				success : function(data) {
					var row = document.getElementById("content");
					row.innerHTML = data;
				},
				error : function(e) {
					console.log(e.message);
				}
			});
		}
		function searchByPriceUnder200() {
			$.ajax({
				url : "/FinalProject/searchAjaxPriceUnder200Shop",
				type : 'POST',
				data : {},
				success : function(data) {
					var row = document.getElementById("content");
					row.innerHTML = data;
				},
				error : function(e) {
					console.log(e.message);
				}
			});
		}
		function searchByPrice200To300() {
			$.ajax({
				url : "/FinalProject/searchByPrice200To300Shop",
				type : 'POST',
				data : {},
				success : function(data) {
					var row = document.getElementById("content");
					row.innerHTML = data;
				},
				error : function(e) {
					console.log(e.message);
				}
			});
		}
		function searchByPriceAbove300() {
			$.ajax({
				url : "/FinalProject/searchAjaxPriceAbove300Shop",
				type : 'POST',
				data : {},
				success : function(data) {
					var row = document.getElementById("content");
					row.innerHTML = data;
				},
				error : function(e) {
					console.log(e.message);
				}
			});
		}
	    function searchByPriceMinToMax(){
	        var numMin = document.getElementById("priceMin").value;
	        var numMax = document.getElementById("priceMax").value;
	        $.ajax({
	            url: "/FinalProject/searchAjaxPriceMinToMax",
	            type: "get", //send it through get method
	            data: {
	                priceMin: numMin,
	                priceMax: numMax
	            },
	            success: function (data) {
	                var row = document.getElementById("content");
	                row.innerHTML = data;
	            },
	            error: function (xhr) {
	                //Do Something to handle error
	            }
	        });
	    }
	</script>

</body>
</html>