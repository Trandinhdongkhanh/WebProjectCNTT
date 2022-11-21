package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.cartDAO;
import DAO.productDAO;
import Model.accountModel;
import Model.cartModel;
import Model.productModel;

@WebServlet(name = "loadCartAjax", value = "/loadcartAjax")
public class loadCartAjax extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		accountModel acc = (accountModel) session.getAttribute("acc");
		
		if(acc == null) {
			resp.sendRedirect("loginPage");
			return;
		}
		
		List<productModel> products = new productDAO().getAllProduct();
		List<cartModel> carts = new cartDAO().getAllitemsInCart(acc.getAccID());
		
		PrintWriter out = resp.getWriter();
		int totalMoney = 0;
		
		if(!carts.isEmpty()) {
			out.append("<div class=\"container\">\r\n"
					+ "					<div class=\"row mb-5\">\r\n"
					+ "						<form class=\"col-md-12\" method=\"post\">\r\n"
					+ "							<div class=\"site-blocks-table\">\r\n"
					+ "								<table class=\"table table-bordered\">\r\n"
					+ "									<thead>\r\n"
					+ "										<tr>\r\n"
					+ "											<th class=\"product-thumbnail\">Image</th>\r\n"
					+ "											<th class=\"product-name\">Product</th>\r\n"
					+ "											<th class=\"product-price\">Price</th>\r\n"
					+ "											<th class=\"product-quantity\">Quantity</th>\r\n"
					+ "											<th class=\"product-total\">Total</th>\r\n"
					+ "											<th class=\"product-remove\">Remove</th>\r\n"
					+ "										</tr>\r\n"
					+ "									</thead>\r\n"
					+ "									<tbody>");
			for (productModel p : products) {
				for (cartModel c : carts) {
					if(p.getProductID() == c.getProductID()) {
						totalMoney += p.getPrice() * c.getAmmount();
						out.append("<tr>\r\n"
								+ "														<td class=\"product-thumbnail\"><img src=\""+p.getImage()+"\"\r\n"
								+ "															alt=\"Image\" class=\"img-fluid\"></td>\r\n"
								+ "														<td class=\"product-name\">\r\n"
								+ "															<h2 class=\"h5 text-black\">"+p.getProductName()+"</h2>\r\n"
								+ "														</td>\r\n"
								+ "														<td>$"+p.getPrice()+"</td>\r\n"
								+ "														<td>\r\n"
								+ "															<div class=\"input-group mb-3\" style=\"max-width: 120px;\">\r\n"
								+ "																<div class=\"input-group-prepend\">\r\n"
								+ "																	<button\r\n"
								+ "																		onclick=\"subAmmount("+c.getProductID()+")\"\r\n"
								+ "																		class=\"btn btn-outline-primary js-btn-minus\"\r\n"
								+ "																		type=\"button\">&minus;</button>\r\n"
								+ "																</div>\r\n"
								+ "																<input id=\"ammountValue\" type=\"text\" class=\"form-control text-center\"\r\n"
								+ "																	value=\""+c.getAmmount()+"\" placeholder=\"\"\r\n"
								+ "																	aria-label=\"Example text with button addon\"\r\n"
								+ "																	aria-describedby=\"button-addon1\">\r\n"
								+ "																<div class=\"input-group-append\">\r\n"
								+ "																	<button\r\n"
								+ "																		onclick=\"addAmmount("+c.getProductID()+")\"\r\n"
								+ "																		class=\"btn btn-outline-primary js-btn-plus\"\r\n"
								+ "																		type=\"button\">&plus;</button>\r\n"
								+ "																</div>\r\n"
								+ "															</div>\r\n"
								+ "														</td>\r\n"
								+ "														<td>$"+p.getPrice() * c.getAmmount()+"</td>\r\n"
								+ "														<td><button onclick=\"deleteProCart("+p.getProductID()+")\"\r\n"
								+ "															class=\"btn btn-primary btn-sm\" type=\"button\">X</button></td>\r\n"
								+ "													</tr>");
					}
				}
			}
			
			out.append("</tbody>\r\n"
					+ "								</table>\r\n"
					+ "							</div>\r\n"
					+ "						</form>\r\n"
					+ "					</div>\r\n"
					+ "\r\n"
					+ "					<div class=\"row\">\r\n"
					+ "						<div class=\"col-md-6\">\r\n"
					+ "							<div class=\"row mb-5\">\r\n"
					+ "								<div class=\"col-md-6\">\r\n"
					+ "									<button class=\"btn btn-primary btn-sm btn-block\"\r\n"
					+ "										onclick=\"window.location='shopPage'\"\r\n"
					+ "										class=\"btn btn-outline-primary btn-sm btn-block\">Continue\r\n"
					+ "										Shopping</button>\r\n"
					+ "								</div>\r\n"
					+ "							</div>\r\n"
					+ "							<div class=\"row\">\r\n"
					+ "								<div class=\"col-md-12\">\r\n"
					+ "									<label class=\"text-black h4\" for=\"coupon\">Coupon</label>\r\n"
					+ "									<p>Enter your coupon code if you have one.</p>\r\n"
					+ "								</div>\r\n"
					+ "								<div class=\"col-md-8 mb-3 mb-md-0\">\r\n"
					+ "									<input type=\"text\" class=\"form-control py-3\" id=\"coupon\"\r\n"
					+ "										placeholder=\"Coupon Code\">\r\n"
					+ "								</div>\r\n"
					+ "								<div class=\"col-md-4\">\r\n"
					+ "									<button class=\"btn btn-primary btn-sm\">Apply Coupon</button>\r\n"
					+ "								</div>\r\n"
					+ "							</div>\r\n"
					+ "						</div>\r\n"
					+ "						<div class=\"col-md-6 pl-5\">\r\n"
					+ "							<div class=\"row justify-content-end\">\r\n"
					+ "								<div class=\"col-md-7\">\r\n"
					+ "									<div class=\"row\">\r\n"
					+ "										<div class=\"col-md-12 text-right border-bottom mb-5\">\r\n"
					+ "											<h3 class=\"text-black h4 text-uppercase\">Cart Totals</h3>\r\n"
					+ "										</div>\r\n"
					+ "									</div>\r\n"
					+ "									<div class=\"row mb-3\">\r\n"
					+ "										<div class=\"col-md-6\">\r\n"
					+ "											<span class=\"text-black\">Subtotal</span>\r\n"
					+ "										</div>\r\n"
					+ "										<div class=\"col-md-6 text-right\">\r\n"
					+ "											<strong class=\"text-black\">$"+totalMoney+"</strong>\r\n"
					+ "										</div>\r\n"
					+ "									</div>\r\n"
					+ "									<div class=\"row mb-5\">\r\n"
					+ "										<div class=\"col-md-6\">\r\n"
					+ "											<span class=\"text-black\">Total</span>\r\n"
					+ "										</div>\r\n"
					+ "										<div class=\"col-md-6 text-right\">\r\n"
					+ "											<strong class=\"text-black\">$"+totalMoney+"</strong>\r\n"
					+ "										</div>\r\n"
					+ "									</div>\r\n"
					+ "\r\n"
					+ "									<div class=\"row\">\r\n"
					+ "										<div class=\"col-md-12\">\r\n"
					+ "											<button class=\"btn btn-primary btn-lg py-3 btn-block\"\r\n"
					+ "												onclick=\"window.location='checkOut'\">Proceed To\r\n"
					+ "												Checkout</button>\r\n"
					+ "										</div>\r\n"
					+ "									</div>\r\n"
					+ "								</div>\r\n"
					+ "							</div>\r\n"
					+ "						</div>\r\n"
					+ "					</div>\r\n"
					+ "				</div>\r\n"
					+ "			</div>");
			out.println();
			return;
		}
		
		out.append("<div class=\"container-fluid  mt-100\">\r\n"
				+ "				<div class=\"row\">\r\n"
				+ "\r\n"
				+ "					<div class=\"col-md-12\">\r\n"
				+ "\r\n"
				+ "						<div class=\"card\">\r\n"
				+ "							<div class=\"card-body cart\">\r\n"
				+ "								<div class=\"col-sm-12 empty-cart-cls text-center\">\r\n"
				+ "									<img\r\n"
				+ "										src=\"https://media.istockphoto.com/vectors/empty-shopping-bag-icon-online-business-vector-icon-template-vector-id861576608?k=20&m=861576608&s=612x612&w=0&h=UgHaPYlYrsPTO6BKKTzizGQqFgqEnn7eYK9EOA16uDs=\"\r\n"
				+ "										width=\"250\" height=\"250\" class=\"img-fluid mb-4 mr-3\">\r\n"
				+ "									<h3>\r\n"
				+ "										<strong>Your Cart is Empty</strong>\r\n"
				+ "									</h3>\r\n"
				+ "									<h4>Add something to make us happy :)</h4>\r\n"
				+ "									<a href=\"shopPage\" class=\"btn btn-primary cart-btn-transform m-3\"\r\n"
				+ "										data-abc=\"true\">Continue shopping</a>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "						</div>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "					</div>\r\n"
				+ "\r\n"
				+ "				</div>\r\n"
				+ "\r\n"
				+ "			</div>");
		out.println();
	}
}
