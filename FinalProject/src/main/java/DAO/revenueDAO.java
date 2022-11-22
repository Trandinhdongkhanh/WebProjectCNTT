package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.SoLuongDaBanModel;
import Util.DBConnect;
import Model.tongChiTieuKhachHangModel;

public class revenueDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<SoLuongDaBanModel> getTop10Product() {
        List<SoLuongDaBanModel> list = new ArrayList<>();
        String query = "select *\r\n"
        		+ "from soLuongDaBan\r\n"
        		+ "order by sold desc limit 0,10";
        try {
            con = new DBConnect().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SoLuongDaBanModel(rs.getInt(1),
                		rs.getInt(2)
                  ));
            }
        } catch (Exception e) {
        }
        return list;
    }
	public List<tongChiTieuKhachHangModel> getTop10User() {
	        List<tongChiTieuKhachHangModel> list = new ArrayList<>();
	        String query = "select * \r\n"
	        		+ "from tongChiTieuKhachHang\r\n"
	        		+ "order by total desc limit 0,10";
	        try {
	            con = new DBConnect().getConnection();
	            ps = con.prepareStatement(query);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                list.add(new tongChiTieuKhachHangModel(rs.getInt(1),
	                        rs.getFloat(2)
	                       ));
	            }
	        } catch (Exception e) {
	        }
	        return list;
	    }
	public double totalMoneyDay(int day) {
        String query = "select \r\n"
        		+ "	SUM(total) \r\n"
        		+ "from invoice\r\n"
        		+ "where DAY(create_date)= ?\r\n"
        		+ "Group by create_date ";
        try {
            con = new DBConnect().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, day);
            rs = ps.executeQuery();
            while (rs.next()) {
               return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public double totalMoneyMonth(int month) {
        String query = "select SUM(total) from invoice\r\n"
        		+ "where MONTH(create_date)=?\r\n"
        		+ "Group by MONTH(create_date)";
        try {
            con = new DBConnect().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, month);
            rs = ps.executeQuery();
            while (rs.next()) {
               return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    public double dashboardsoluongdaban() {
        String query = "select SUM(sold) from soluongdaban";
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
    public double dashboardtongthunhap() {
        String query = "SELECT sum(total) FROM tongchitieukhachhang";
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
}
