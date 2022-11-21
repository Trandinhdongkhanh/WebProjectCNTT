package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.cartDAO;
import Model.accountModel;

@WebServlet(name = "DeleteCartAjax", value = "/delete_cart_ajax")
public class DeleteCartAjax extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		accountModel acc = (accountModel) session.getAttribute("acc");

		if (acc == null) {
			resp.sendRedirect("loginPage");
			return;
		}

		int productID = Integer.parseInt(req.getParameter("productID"));

		cartDAO cDAO = new cartDAO();

		cDAO.deleteProductCart(acc.getAccID(), productID);
		int nb = cDAO.number_of_items_inCart(acc.getAccID());
		session.setAttribute("nbItemsCart", nb);
		PrintWriter out = resp.getWriter();
		out.println("");
	}
}
