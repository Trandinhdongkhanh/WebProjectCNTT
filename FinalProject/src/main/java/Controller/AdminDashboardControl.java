package Controller;

import DAO.revenueDAO;
import DAO.accountDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AdminDashboardControl", urlPatterns = {"/adminDashboard"})
public class AdminDashboardControl extends HttpServlet {
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
        revenueDAO dao =new revenueDAO();
        accountDAO dao1 = new accountDAO();
        
        double soluongdaban = dao.dashboardsoluongdaban();     
        double tongthunhap = dao.dashboardtongthunhap();
        int soluonguser = dao1.numberOfAccount();
        
        request.setAttribute("soluongdaban", soluongdaban);
        request.setAttribute("tongthunhap", tongthunhap);
        request.setAttribute("soluonguser", soluonguser);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
}
