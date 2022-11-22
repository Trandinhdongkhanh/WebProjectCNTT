/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
  * author: H.M.Duc
 */
package Controller;


import DAO.revenueDAO;
import DAO.accountDAO;
import Model.tongChiTieuKhachHangModel;
import Model.accountModel;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Top10UserControl", urlPatterns = {"/top10user"})
public class Top10UserControl extends HttpServlet{
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
        
        revenueDAO dao1 =new revenueDAO();
        accountDAO dao =new accountDAO();
        List<accountModel> listAllUser = dao.getAllAccount();
        List<tongChiTieuKhachHangModel> listTop10User = dao1.getTop10User();

        request.setAttribute("listAllUser", listAllUser);
        request.setAttribute("listTop10User", listTop10User);
        request.getRequestDispatcher("Top10User.jsp").forward(request, response);
    }

}
