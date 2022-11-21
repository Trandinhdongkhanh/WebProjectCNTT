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
						<a href="homePage">Home</a> <span class="mx-2 mb-0">/</span> <a
							href="cartPage">Cart</a> <span class="mx-2 mb-0">/</span> <strong
							class="text-black">Checkout</strong>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section">
			<div class="container">
				<div class="row mb-5">
					<div class="col-md-12">
						<div class="border p-4 rounded" role="alert">
							Returning customer? <a href="#">Click here</a> to login
						</div>
					</div>
				</div>
				<form action="confirmOrder" method="post">
					<div class="row">
						<div class="col-md-6 mb-5 mb-md-0">
							<h2 class="h3 mb-3 text-black">Billing Details</h2>
							<div class="p-3 p-lg-5 border">
								<div class="form-group">
									<label for="c_country" class="text-black">City <span
										class="text-danger">*</span></label> <select name="country"
										id="c_country" class="form-control">
										<option value="1">Select a country</option>
										<option value="Ha Noi">Ha Noi</option>
										<option value="Ho Chi Minh">Ho Chi Minh</option>
										<option value="Vung Tau">Vung Tau</option>
										<option value="Hai Phong">Hai Phong</option>
										<option value="Da Lat">Da Lat</option>
										<option value="Thanh Hoa">Thanh Hoa</option>
										<option value="Hai Duong">Hai Duong</option>
										<option value="Ha Long">Ha Long</option>
									</select>
								</div>
								<div class="form-group row">
									<div class="col-md-6">
										<label for="c_fname" class="text-black">First Name <span
											class="text-danger">*</span></label> <input type="text"
											class="form-control" id="c_fname" name="c_fname">
									</div>
									<div class="col-md-6">
										<label for="c_lname" class="text-black">Last Name <span
											class="text-danger">*</span></label> <input type="text"
											class="form-control" id="c_lname" name="c_lname">
									</div>
								</div>



								<div class="form-group row">
									<div class="col-md-12">
										<label for="c_address" class="text-black">Address <span
											class="text-danger">*</span></label> <input type="text"
											class="form-control" id="c_address" name="c_address"
											placeholder="Street address">
									</div>
								</div>

								<div class="form-group">
									<input type="text" class="form-control"
										placeholder="Apartment, suite, unit etc. (optional)">
								</div>

								<div class="form-group row">
									<div class="col-md-6">
										<label for="c_state_country" class="text-black">State
											<span class="text-danger">*</span>
										</label> <input type="text" class="form-control" id="c_state_country"
											name="c_state_country">
									</div>
									<div class="col-md-6">
										<label for="c_postal_zip" class="text-black">Posta /
											Zip <span class="text-danger">*</span>
										</label> <input type="text" class="form-control" id="c_postal_zip"
											name="c_postal_zip">
									</div>
								</div>

								<div class="form-group row mb-5">
									<div class="col-md-6">
										<label for="c_email_address" class="text-black">Email
											Address <span class="text-danger">*</span>
										</label> <input type="text" class="form-control" id="c_email_address"
											name="c_email_address">
									</div>
									<div class="col-md-6">
										<label for="c_phone" class="text-black">Phone <span
											class="text-danger">*</span></label> <input type="text"
											class="form-control" id="c_phone" name="c_phone"
											placeholder="Phone Number">
									</div>
								</div>

								<div class="form-group">
									<label for="c_order_notes" class="text-black">Order
										Notes</label>
									<textarea name="c_order_notes" id="c_order_notes" cols="30"
										rows="5" class="form-control"
										placeholder="Write your notes here..."></textarea>
								</div>

							</div>
						</div>
						<div class="col-md-6">

							<div class="row mb-5">
								<div class="col-md-12">
									<h2 class="h3 mb-3 text-black">Coupon Code</h2>
									<div class="p-3 p-lg-5 border">

										<label for="c_code" class="text-black mb-3">Enter your
											coupon code if you have one</label>
										<div class="input-group w-75">
											<input type="text" class="form-control" id="c_code"
												placeholder="Coupon Code" aria-label="Coupon Code"
												aria-describedby="button-addon2">
											<div class="input-group-append">
												<button class="btn btn-primary btn-sm" type="button"
													id="button-addon2">Apply</button>
											</div>
										</div>

									</div>
								</div>
							</div>

							<div class="row mb-5">
								<div class="col-md-12">
									<h2 class="h3 mb-3 text-black">Your Order</h2>
									<div class="p-3 p-lg-5 border">
										<table class="table site-block-order-table mb-5">
											<thead>
												<th>Product</th>
												<th>Total</th>
											</thead>
											<tbody>
												<c:forEach items="${pdInCart}" var="p">
													<tr>
														<td>${p.productName }<strong class="mx-2">x</strong>
															${p.ammount }
														</td>
														<td>$${p.price * p.ammount }</td>
													</tr>
												</c:forEach>
												<tr>
													<td class="text-black font-weight-bold"><strong>Cart
															Subtotal</strong></td>
													<td class="text-black">$${tt }</td>
												</tr>
												<tr>
													<td class="text-black font-weight-bold"><strong>Order
															Total</strong></td>
													<td class="text-black font-weight-bold"><strong>$${tt }</strong></td>
												</tr>
											</tbody>
										</table>



										<div class="form-group">
											<button class="btn btn-primary btn-lg py-3 btn-block"
												type="submit">Place Order</button>
										</div>

									</div>
								</div>
							</div>

						</div>
					</div>
				</form>
				<!-- </form> -->
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