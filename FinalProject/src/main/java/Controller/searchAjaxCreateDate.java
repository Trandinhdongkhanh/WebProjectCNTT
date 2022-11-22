package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.accountDAO;
import Model.accountModel;
import DAO.invoiceDAO;
import Model.invoiceModel;

@WebServlet(name = "searchAjaxCreateDateControl", value = "/searchAjaxCreateDate")
public class searchAjaxCreateDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        String createdate = req.getParameter("createDate");
		List<invoiceModel> invoices = new invoiceDAO().searchByCreateDate(createdate);
		List<accountModel> accs = new accountDAO().getAllAccount();
        PrintWriter out = resp.getWriter(); 
        for (invoiceModel o : invoices) {
        	for (accountModel a : accs) {
        		if(o.getaccID() == a.getAccID()) {	
        	out.println("<tr>\r\n"
        			+ "                  <th scope=\"row\"></th>\r\n"
        			+ "                  <td>"+o.getinvoiceID()+"</td>\r\n"
        			+ "                  <td>"+a.getAccID()+"</td>\r\n"
        			+ "			         <td>"+a.getUserName()+"</td>\r\n"
					+ "			         <td>"+o.gettotal()+"</td>\r\n"
					+ "			         <td>"+o.getcreate_date()+"</td> \r\n"
        			+ "                </tr>");
        		}
        	}
        }
     }
}
