package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.cartDAO;
import Model.accountModel;

@WebServlet(name = "AddAmountCartServlet", value = "/addAmount")
public class AddAmountCartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		accountModel a = (accountModel) session.getAttribute("acc");
		if (a == null) {
			resp.sendRedirect("loginPage");
			return;
		}
		
		int accountID = a.getAccID();
		int productID = Integer.parseInt(req.getParameter("productID"));
		int amount = Integer.parseInt(req.getParameter("ammount"));
		amount += 1;
		
		cartDAO dao = new cartDAO();
		dao.editAmmountCart(productID, accountID, amount);
		
		getServletContext().getRequestDispatcher("/cartPage").forward(req, resp);
	}
}
