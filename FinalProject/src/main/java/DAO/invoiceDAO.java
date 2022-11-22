package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import Model.invoiceModel;
import Util.DBConnect;

public class invoiceDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public void insertInvoice(int accID, int total, Date create_date) {
		String sql = "insert into invoice(accID, total, create_date) values(?, ?, ?)";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, accID);
			ps.setInt(2, total);
			ps.setDate(3, create_date);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getInvoiceID(int accID) {
		String sql = "select invoiceID from invoice where accID = ? order by invoiceID desc limit 1";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, accID);
			rs = ps.executeQuery();
			rs.next();
			return rs.getInt("invoiceID");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return -1;
	}
	public double sumAllinvoiceModel() {
        String query = "select SUM(total) from invoice";
        try {
            con = new DBConnect().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
               return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
	public void deleteinvoiceByAccountId(String id) {
        String query = "delete from invoice\n"
                + "where [accID] = ?";
        try {
            con = new DBConnect().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
	public List<invoiceModel> getAllinvoiceModel() {
        List<invoiceModel> list = new ArrayList<>();
        String query = "select * from invoice";
        try {
            con = new DBConnect().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new invoiceModel(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4)
                       ));
            }
        } catch (Exception e) {
        }
        return list;
    }
	public List<invoiceModel> searchByCreateDate(String create_date) {
        List<invoiceModel> list = new ArrayList<>();
        String query = "select * from invoice\r\n"
        		+ "where create_date ='"+create_date+"'";
        try {
            con = new DBConnect().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new invoiceModel(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDate(4)
                       ));
            }
        } catch (Exception e) {
        }
        return list;
    }
	
	
}
