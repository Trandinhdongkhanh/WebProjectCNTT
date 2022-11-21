<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="site-navbar" role="banner">
	<div class="site-navbar-top">
		<div class="container">
			<div class="row align-items-center">
				<div
					class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
					<form action="search" method="post" class="site-block-top-search">
						<span class="icon icon-search2"></span> <input name="txt"
							type="text" class="form-control border-0" placeholder="Search">
					</form>
				</div>

				<div
					class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
					<div class="site-logo">
						<a href="homePage" class="js-logo-clone">Shoppers</a>
					</div>
				</div>

				<div class="col-6 col-md-4 order-3 order-md-3 text-right">
					<div class="site-top-icons">
						<ul>
							<li><a href="profile"><span class="icon icon-person"></span></a></li>
							<li><a href="#"><span class="icon icon-heart-o"></span></a></li>
							<li><a href="cartPage" class="site-cart"> <span
									class="icon icon-shopping_cart"></span> <c:if
										test="${sessionScope.nbItemsCart != null}">
										<span class="count">${sessionScope.nbItemsCart}</span>
									</c:if> <c:if test="${sessionScope.nbItemsCart == null}">
										<span name="nbCart" class="count">0</span>
									</c:if>
							</a></li>
							<li class="d-inline-block d-md-none ml-md-0"><a href="#"
								class="site-menu-toggle js-menu-toggle"><span
									class="icon-menu"></span></a></li>
						</ul>
					</div>
				</div>

			</div>
		</div>
	</div>
	<nav class="site-navigation text-right text-md-center"
		role="navigation">
		<div class="container">
			<ul class="site-menu js-clone-nav d-none d-md-block">
				<li><a href="homePage">Home</a>
				<li><a href="about.jsp">About</a></li>
				<li><a href="shopPage">Shop</a></li>
				<li><a href="contact.jsp">Contact</a></li>
				<c:if test="${sessionScope.acc == null }">
					<li><a href="loginPage">Log In</a></li>
				</c:if>
				<c:if test="${sessionScope.acc != null }">
					<li><a href="profile">Hello ${sessionScope.acc.userName}</a></li>
					<li><a href="logOut">Log Out</a></li>
				</c:if>
			</ul>
		</div>
	</nav>
</header>