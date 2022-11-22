package Controller;

import DAO.productDAO;
import DAO.revenueDAO;
import Model.productModel;
import Model.SoLuongDaBanModel;


import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Top10ProductControl", urlPatterns = {"/top10product"})
public class Top10ProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
            
        productDAO dao = new productDAO();
        revenueDAO dao1 =new revenueDAO();
        List<productModel> listAllProduct = dao.getAllProduct();
        List<SoLuongDaBanModel> listTop10Product = dao1.getTop10Product();
        

        request.setAttribute("listAllProduct", listAllProduct);
        request.setAttribute("listTop10Product", listTop10Product);

        request.getRequestDispatcher("Top10Product.jsp").forward(request, response);
    }
}
