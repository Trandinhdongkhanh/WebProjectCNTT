package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.productDAO;
import Model.productModel;

@WebServlet(name = "HomeServlet", value = "/homePage")
public class HomeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "/index.jsp";
		List<productModel> products = new productDAO().getLastestProduct();
		req.setAttribute("lastestProducts", products);
		getServletContext().getRequestDispatcher(url).forward(req, resp);
	}
}
