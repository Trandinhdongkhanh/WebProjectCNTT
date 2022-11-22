/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
  * author: H.M.Duc
 */
package Controller;

import DAO.accountDAO;
import Model.accountModel;



import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;


@WebServlet(name = "ManagerAccountControl", urlPatterns = {"/managerAccount"})
public class ManagerAccountControl extends HttpServlet {
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
	        accountDAO dao = new accountDAO();

	        List<accountModel> list = dao.getAllAccount();
	        request.setAttribute("listA", list);
	        request.getRequestDispatcher("managerAccount.jsp").forward(request, response);
	    }


}
