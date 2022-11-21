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

@WebServlet(name = "SubAmmountAjax", value = "/subAmmountAjax")
public class SubAmmountAjax extends HttpServlet{
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
		
		
		int productID = Integer.parseInt(req.getParameter("productID"));
		int ammount = new cartDAO().checkExistCart(acc.getAccID(), productID).getAmmount();
		ammount -= 1;
		
		cartDAO cDAO = new cartDAO();
		
		PrintWriter out = resp.getWriter();
		
		if(ammount == 0) {
			cDAO.deleteProductCart(acc.getAccID(), productID);
			int nb = cDAO.number_of_items_inCart(acc.getAccID());
			session.setAttribute("nbItemsCart", nb);
			out.println("");
			return;
		}
		
		cDAO.editAmmountCart(productID, acc.getAccID(), ammount);
		out.println();
		
//		int totalMoney = 0;
//		
//		List<productModel> products = new productDAO().getAllProduct();
//		List<cartModel> carts = cDAO.getAllitemsInCart(acc.getAccID());
		
//		for (productModel p : products) {
//			for (cartModel c : carts) {
//				if(p.getProductID() == c.getProductID()) {
//					totalMoney += p.getPrice() * c.getAmmount();
//				}
//			}
//		}
		
		
//		out.println("									<div class=\"row\">\r\n"
//				+ "										<div class=\"col-md-12 text-right border-bottom mb-5\">\r\n"
//				+ "											<h3 class=\"text-black h4 text-uppercase\">Cart Totals</h3>\r\n"
//				+ "										</div>\r\n"
//				+ "									</div>\r\n"
//				+ "									<div class=\"row mb-3\">\r\n"
//				+ "										<div class=\"col-md-6\">\r\n"
//				+ "											<span class=\"text-black\">Subtotal</span>\r\n"
//				+ "										</div>\r\n"
//				+ "										<div class=\"col-md-6 text-right\">\r\n"
//				+ "											<strong class=\"text-black\">"+totalMoney+"</strong>\r\n"
//				+ "										</div>\r\n"
//				+ "									</div>\r\n"
//				+ "									<div class=\"row mb-5\">\r\n"
//				+ "										<div class=\"col-md-6\">\r\n"
//				+ "											<span class=\"text-black\">Total</span>\r\n"
//				+ "										</div>\r\n"
//				+ "										<div class=\"col-md-6 text-right\">\r\n"
//				+ "											<strong class=\"text-black\">"+totalMoney+"</strong>\r\n"
//				+ "										</div>\r\n"
//				+ "									</div>\r\n"
//				+ "\r\n"
//				+ "									<div class=\"row\">\r\n"
//				+ "										<div class=\"col-md-12\">\r\n"
//				+ "											<button class=\"btn btn-primary btn-lg py-3 btn-block\"\r\n"
//				+ "												onclick=\"window.location='checkOut'\">Proceed To\r\n"
//				+ "												Checkout</button>\r\n"
//				+ "										</div>\r\n"
//				+ "									</div>");
		
	}
}
