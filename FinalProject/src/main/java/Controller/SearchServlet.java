package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.categoryDAO;
import DAO.productDAO;
import Model.categoryModel;
import Model.productModel;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "/shop.jsp";
		String txtSearch = req.getParameter("txt");
		List<productModel> products = new productDAO().getProductByName(txtSearch);
		List<categoryModel> categories = new categoryDAO().getAllCategory();
		req.setAttribute("productList", products);
		req.setAttribute("categoryList", categories);
		getServletContext().getRequestDispatcher(url).forward(req, resp);
	}
}
