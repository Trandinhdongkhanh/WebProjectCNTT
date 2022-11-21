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

import DAO.categoryDAO;
import DAO.productDAO;
import Model.categoryModel;
import Model.productModel;

@WebServlet(name = "ShopServlet", value = "/shopPage")
public class ShopServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "/shop.jsp";

		List<productModel> products = new ArrayList<>();
		List<categoryModel> categories = new ArrayList<>();
		categories = new categoryDAO().getAllCategory();
		
		int curPage = 1;
		if (req.getParameter("p") != null) {
			req.setAttribute("tag", req.getParameter("p"));
			curPage = Integer.parseInt(req.getParameter("p"));
			
		} else {
			req.setAttribute("tag", 1);
		}
		
		products = new productDAO().pagingProduct(curPage);

		int count = new productDAO().getNumberofProduct();
		int endPage = count / 6;
		if (count % 6 != 0 || count / 6 <= 0) {
			endPage++;
		}
		
		req.setAttribute("endP", endPage);
		req.setAttribute("productList", products);
		req.setAttribute("categoryList", categories);
		req.setAttribute("cateName", "All");
		getServletContext().getRequestDispatcher(url).forward(req, resp);
	}
}
