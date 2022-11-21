package Controller;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
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

@WebServlet(name = "CartServlet", value = "/cartPage")
public class CartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "/cart.jsp";
		HttpSession session = req.getSession();
		accountModel acc = (accountModel) session.getAttribute("acc");
		
		if(acc == null) {
			resp.sendRedirect("loginPage");
			return;
		}
		
		List<cartModel> items = new cartDAO().getAllitemsInCart(acc.getAccID());
		List<productModel> products = new productDAO().getAllProduct();
		
		int totalMoney = 0;
		
		for (productModel p : products) {
			for (cartModel c : items) {
				if(p.getProductID() == c.getProductID()) {
					totalMoney += p.getPrice() * c.getAmmount();
				}
			}
		}
		req.setAttribute("productList", products);
		req.setAttribute("cartList", items);
		req.setAttribute("totalMoney", totalMoney);
		
		getServletContext().getRequestDispatcher(url).forward(req, resp);

	}
}
