package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.cartDAO;
import DAO.productDAO;
import Model.Product_Cart_Model;
import Model.accountModel;
import Model.productModel;

@WebServlet(name = "CheckOutServlet", value = "/checkOut")
public class CheckOutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		accountModel acc = (accountModel) session.getAttribute("acc");

		if (acc == null) {
			resp.sendRedirect("loginPage");
			return;
		}

		List<Product_Cart_Model> listP = new productDAO().getProductInCart(acc.getAccID());

		int totalMoney = 0;
		for (Product_Cart_Model p : listP) {
			totalMoney += p.getPrice() * p.getAmmount();
		}
		
		req.setAttribute("pdInCart", listP);
		req.setAttribute("tt", totalMoney);
		getServletContext().getRequestDispatcher("/checkout.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
}
