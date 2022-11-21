<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Bootstrap 5 Forgot Password</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<div class="container d-flex flex-column">
		<div
			class="row align-items-center justify-content-center
          min-vh-100">
			<div class="col-12 col-md-8 col-lg-4">
				<div class="card shadow-sm">
					<div class="card-body">
						<div class="mb-4">
							<h5>Forgot Password?</h5>
							<p class="mb-2">Enter your registered email ID to reset the
								password</p>
						</div>
						<form action="resetPassword" method="post">
							<div class="mb-3">
								<label for="email" class="form-label">Email</label>
								<c:if test="${error != null }">
									<div class="alert alert-danger">${error}</div>
								</c:if>
								<c:if test="${mess != null }">
									<div class="alert alert-success">${mess}</div>
								</c:if>
								<input type="email" id="email" class="form-control" name="email"
									placeholder="Enter Your Email" required="">
							</div>
							<div class="mb-3 d-grid">
								<button type="submit" class="btn btn-primary">Reset
									Password</button>
							</div>
							<span>Already a member ? <a href="loginPage">sign in</a></span>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>