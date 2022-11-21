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

@WebServlet(name = "AddAmmountAjax", value = "/addAmmoutAjax")
public class AddAmmountAjax extends HttpServlet{
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
		ammount += 1;
		
		cartDAO cDAO = new cartDAO();
		cDAO.editAmmountCart(productID, acc.getAccID(), ammount);
		
//		int totalMoney = 0;
		
//		List<productModel> products = new productDAO().getAllProduct();
//		List<cartModel> carts = cDAO.getAllitemsInCart(acc.getAccID());
		
		PrintWriter out = resp.getWriter();
		
//		for (productModel p : products) {
//			for (cartModel c : carts) {
//				if(p.getProductID() == c.getProductID()) {
//					totalMoney += p.getPrice() * c.getAmmount();
//				}
//			}
//		}
		
		out.println("");
	}
}
