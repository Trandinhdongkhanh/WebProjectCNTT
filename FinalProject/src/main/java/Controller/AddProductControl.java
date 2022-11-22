package Controller;

import DAO.productDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "AddProductControl", urlPatterns = {"/addProduct"})
public class AddProductControl extends HttpServlet {
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
        request.setCharacterEncoding("UTF-8");
        String productname = request.getParameter("productName");
        String image = request.getParameter("image");
        String pprice = request.getParameter("price");
        int price = Integer.parseInt(pprice);
        String description = request.getParameter("description");
        String pcategory = request.getParameter("category");
        int category = Integer.parseInt(pcategory);
        productDAO dao = new productDAO();
        dao.addProduct(productname, price, category, description, image);
        request.setAttribute("mess", "Product Added!");
        request.getRequestDispatcher("managerProduct").forward(request, response);
    }
}
