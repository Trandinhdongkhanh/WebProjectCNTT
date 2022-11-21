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
<link rel="stylesheet" href="emptyCart_template/css/style.css">

</head>
<body>

	<div class="site-wrap">
		<jsp:include page="header.jsp"></jsp:include>

		<div class="bg-light py-3">
			<div class="container">
				<div class="row">
					<div class="col-md-12 mb-0">
						<a href="homePage">Home</a> <span class="mx-2 mb-0">/</span> <strong
							class="text-black">Cart</strong>
					</div>
				</div>
			</div>
		</div>
		<c:if test="${!cartList.isEmpty()}">
			<div id="content" class="site-section">
				<div class="container">
					<div class="row mb-5">
						<form class="col-md-12" method="post">
							<div class="site-blocks-table">
								<table class="table table-bordered">
									<thead>
										<tr>
											<th class="product-thumbnail">Image</th>
											<th class="product-name">Product</th>
											<th class="product-price">Price</th>
											<th class="product-quantity">Quantity</th>
											<th class="product-total">Total</th>
											<th class="product-remove">Remove</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${productList}" var="p">
											<c:forEach items="${cartList}" var="o">
												<c:if test="${p.productID == o.productID}">
													<tr>
														<td class="product-thumbnail"><img src="${p.image}"
															alt="Image" class="img-fluid"></td>
														<td class="product-name">
															<h2 class="h5 text-black">${p.productName}</h2>
														</td>
														<td>$${p.price}</td>
														<td>
															<div class="input-group mb-3" style="max-width: 120px;">
																<div class="input-group-prepend">
																	<button
																		onclick="subAmmount(${p.productID })"
																		class="btn btn-outline-primary js-btn-minus"
																		type="button">&minus;</button>
																</div>
																<input id="ammountValue" type="text" class="form-control text-center"
																	value="${o.ammount}" placeholder=""
																	aria-label="Example text with button addon"
																	aria-describedby="button-addon1">
																<div class="input-group-append">
																	<button
																		onclick="addAmmount(${p.productID })"
																		class="btn btn-outline-primary js-btn-plus"
																		type="button">&plus;</button>
																</div>
															</div>
														</td>
														<td>$${p.price * o.ammount }</td>
														<td><button onclick="deleteProCart(${p.productID})"
															class="btn btn-primary btn-sm" type="button">X</button></td>
													</tr>
												</c:if>
											</c:forEach>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</form>
					</div>

					<div class="row">
						<div class="col-md-6">
							<div class="row mb-5">
								<div class="col-md-6">
									<button class="btn btn-primary btn-sm btn-block"
										onclick="window.location='shopPage'"
										class="btn btn-outline-primary btn-sm btn-block">Continue
										Shopping</button>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<label class="text-black h4" for="coupon">Coupon</label>
									<p>Enter your coupon code if you have one.</p>
								</div>
								<div class="col-md-8 mb-3 mb-md-0">
									<input type="text" class="form-control py-3" id="coupon"
										placeholder="Coupon Code">
								</div>
								<div class="col-md-4">
									<button class="btn btn-primary btn-sm">Apply Coupon</button>
								</div>
							</div>
						</div>
						<div class="col-md-6 pl-5">
							<div class="row justify-content-end">
								<div class="col-md-7">
									<div class="row">
										<div class="col-md-12 text-right border-bottom mb-5">
											<h3 class="text-black h4 text-uppercase">Cart Totals</h3>
										</div>
									</div>
									<div class="row mb-3">
										<div class="col-md-6">
											<span class="text-black">Subtotal</span>
										</div>
										<div class="col-md-6 text-right">
											<strong class="text-black">$${totalMoney}</strong>
										</div>
									</div>
									<div class="row mb-5">
										<div class="col-md-6">
											<span class="text-black">Total</span>
										</div>
										<div class="col-md-6 text-right">
											<strong class="text-black">$${totalMoney}</strong>
										</div>
									</div>

									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-primary btn-lg py-3 btn-block"
												onclick="window.location='checkOut'">Proceed To
												Checkout</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${cartList.isEmpty()}">
			<div class="container-fluid  mt-100">
				<div class="row">

					<div class="col-md-12">

						<div class="card">
							<div class="card-body cart">
								<div class="col-sm-12 empty-cart-cls text-center">
									<img
										src="https://media.istockphoto.com/vectors/empty-shopping-bag-icon-online-business-vector-icon-template-vector-id861576608?k=20&m=861576608&s=612x612&w=0&h=UgHaPYlYrsPTO6BKKTzizGQqFgqEnn7eYK9EOA16uDs="
										width="250" height="250" class="img-fluid mb-4 mr-3">
									<h3>
										<strong>Your Cart is Empty</strong>
									</h3>
									<h4>Add something to make us happy :)</h4>
									<a href="shopPage" class="btn btn-primary cart-btn-transform m-3"
										data-abc="true">Continue shopping</a>


								</div>
							</div>
						</div>


					</div>

				</div>

			</div>
		</c:if>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
	<script>
	function addAmmount(pid) {
		var id = pid;
        $.ajax({
            url: "/FinalProject/addAmmoutAjax",
            type: 'POST',
            data: {
        		productID: id,
            },
            success: function (data) {
            	loadCartAjax();
            },
            error: function (e) {
                console.log(e.message);
                throw e;
            }
        });
	}
	function subAmmount(pid) {
		var id = pid;
        $.ajax({
            url: "/FinalProject/subAmmountAjax",
            type: 'POST',
            data: {
        		productID: id,
            },
            success: function (data) {
               loadCartAjax();
            },
            error: function (e) {
                console.log(e.message);
                throw e;
            }
        });
	}
	function deleteProCart(pid) {
		var id = pid;
        $.ajax({
            url: "/FinalProject/delete_cart_ajax",
            type: 'POST',
            data: {
            	productID: id,
            },
            success: function (data) {
            	loadCartAjax();
            },
            error: function (e) {
                console.log(e.message);
                throw e;
            }
        });
	}
	function loadCartAjax() {
        $.ajax({
            url: "/FinalProject/loadcartAjax",
            type: 'POST',
            data: {
            },
            success: function (data) {
               var row = document.getElementById("content");
               row.innerHTML = data;
            },
            error: function (e) {
                console.log(e.message);
                throw e;
            }
        });
	}
	</script>

</body>
</html>