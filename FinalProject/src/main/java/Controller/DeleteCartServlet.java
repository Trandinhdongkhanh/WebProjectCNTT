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

@WebServlet(name = "DeleteCartServlet", value = "/deleteCart")
public class DeleteCartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		accountModel a = (accountModel) session.getAttribute("acc");
		if (a == null) {
			resp.sendRedirect("loginPage");
			return;
		}
		
		int productID = Integer.parseInt(req.getParameter("productID"));
		cartDAO dao = new cartDAO();
		dao.deleteProductCart(a.getAccID(), productID);
		int nbItemsCart = dao.number_of_items_inCart(a.getAccID());
		session.setAttribute("nbItemsCart", nbItemsCart);
		
		getServletContext().getRequestDispatcher("/cartPage").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
}
