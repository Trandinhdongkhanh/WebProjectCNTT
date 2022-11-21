package Controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.SoLuongDaBanDAO;
import DAO.cartDAO;
import DAO.invoiceDAO;
import DAO.invoiceDetailDAO;
import DAO.productDAO;
import DAO.shippingDetailDAO;
import Model.Email;
import Model.EmailUtils;
import Model.Product_Cart_Model;
import Model.accountModel;

@WebServlet(name = "ConfirmOrderServlet", value = "/confirmOrder")
public class ConfirmOrderServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			accountModel acc = (accountModel) session.getAttribute("acc");

			if (acc == null) {
				resp.sendRedirect("loginPage");
				return;
			}

			List<Product_Cart_Model> listP = new productDAO().getProductInCart(acc.getAccID());

			int totalMoney = 0;
			for (Product_Cart_Model p : listP) {
				totalMoney += p.getPrice() * p.getAmmount();
			}

			int accID = acc.getAccID();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date(System.currentTimeMillis());

			cartDAO dao = new cartDAO();
			invoiceDAO Idao = new invoiceDAO();
			shippingDetailDAO Sdao = new shippingDetailDAO();
			invoiceDetailDAO Idetaildao = new invoiceDetailDAO();
			SoLuongDaBanDAO solddao = new SoLuongDaBanDAO();

			Idao.insertInvoice(accID, totalMoney, date);

			int invoiceID = Idao.getInvoiceID(accID);
			String country = req.getParameter("country");
			String Fname = req.getParameter("c_fname");
			String Lname = req.getParameter("c_lname");
			String address = req.getParameter("c_address");
			String state = req.getParameter("c_state_country");
			String zip = req.getParameter("c_postal_zip");
			String email_address = req.getParameter("c_email_address");
			String phone = req.getParameter("c_phone");
			
			String deliveryAddress = address + ", " + state +", " + country + "."; 

			Sdao.insert_shippingDetail(invoiceID, country, Fname, Lname, address, state, zip, email_address, phone);

			Email email = new Email();
			email.setTo(email_address);
			email.setSubject("Dat hang thanh cong tu Shoppers");
			StringBuilder sb = new StringBuilder();
			sb.append("Dear ").append(Fname).append(" ").append(Lname).append("<br>");
			sb.append("Ban vua dat hang tu Shoppers. <br> ");
			sb.append("Dia chi nhan hang cua ban la: <b>").append(deliveryAddress).append("<br>");
			sb.append("So dien thoai khi nhan hang cua ban la: <b>").append(phone).append(" </b> <br>");
			sb.append("Cac san pham ban dat la: <br>");
			for (Product_Cart_Model p : listP) {
				Idetaildao.insert_invoiceDetail(invoiceID, p.getProductID(), p.getAmmount());
				solddao.updateSLdaban(p.getProductID(), p.getAmmount());
				sb.append(p.getProductName()).append(" | ").append("Price:").append(p.getPrice()).append("$").append(" | ").append("Ammount:").append(p.getAmmount()).append("<br>");
			}
			sb.append("Tong tien: ").append(totalMoney).append("$").append("<br>");
			sb.append("Cam on ban da dat hang tai Shoppers<br>");
			sb.append("From: Chu cua hang");
			
			email.setContent(sb.toString());
			EmailUtils.send(email);
			
			dao.deleteAllinCart(accID);
			session.setAttribute("nbItemsCart", 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/thankyou.jsp").forward(req, resp);
	}
}
