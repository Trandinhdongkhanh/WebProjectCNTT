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
import Model.cartModel;

@WebServlet(name = "AddCartServlet", value = "/addCart")
public class AddCartServlet extends HttpServlet {
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
		
		int accID = a.getAccID();
		int productID = Integer.parseInt(req.getParameter("productID"));
		int ammount = Integer.parseInt(req.getParameter("ammount"));
		String size = req.getParameter("shop-sizes");
		
		cartModel exsitedCart = new cartDAO().checkExistCart(accID, productID);
		cartDAO dao = new cartDAO();
		
		if(exsitedCart != null) {
			int ammountExisted = exsitedCart.getAmmount();
			dao.editAmmountCart(productID, accID, (ammountExisted + ammount));
		}
		else {
			dao.insertCart(accID, productID, ammount, size);
			int nbItemsCart = new cartDAO().number_of_items_inCart(accID);
			session.setAttribute("nbItemsCart", nbItemsCart);
		}
		req.setAttribute("mess", "Add item successfully !");
		getServletContext().getRequestDispatcher("/detailPage").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
}
