package Controller;

import DAO.productDAO;
import DAO.categoryDAO;
import DAO.SoLuongDaBanDAO;
import Model.productModel;
import Model.categoryModel;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ManagerProductControl", urlPatterns = {"/managerProduct"})
public class ManagerProductControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
          
        productDAO dao = new productDAO();
        categoryDAO dao1 = new categoryDAO();
        
        List<productModel> list = dao.getAllProduct();
        List<categoryModel> listcategory = dao1.getAllCategory();
        request.setAttribute("listP", list);
        request.setAttribute("listC", listcategory);
        request.getRequestDispatcher("managerProduct.jsp").forward(request, response);
    }
}
