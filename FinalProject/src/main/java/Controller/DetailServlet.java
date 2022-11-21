package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.productDAO;
import DAO.reviewDAO;
import Model.productModel;
import Model.reviewModel;

@WebServlet(name = "DetailServlet", value = "/detailPage")
public class DetailServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "/shop-single.jsp";
		int productID = Integer.parseInt(req.getParameter("productID"));
		productModel product = new productDAO().getProductByID(productID);
		List<reviewModel> reviews = new reviewDAO().getAllReviewByProductID(productID);
		List<productModel> products = new productDAO().getRelatedProducts(product.getCateID());
		
		req.setAttribute("reviewList", reviews);
		req.setAttribute("detail", product);
		req.setAttribute("relatedProducts", products);
		getServletContext().getRequestDispatcher(url).forward(req, resp);
	}
}
