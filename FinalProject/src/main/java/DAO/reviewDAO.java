package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.reviewModel;
import Util.DBConnect;

public class reviewDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<reviewModel> getAllReviewByProductID(int productID){
		List<reviewModel> reviews = new ArrayList<>();
		String sql = "SELECT * FROM review WHERE productID = ?";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, productID);
			rs = ps.executeQuery();
			while(rs.next()) {
				reviewModel review = new reviewModel();
				review.setReviewID(rs.getInt("reviewID"));
				review.setAccID(rs.getInt("accID"));
				review.setProductID(rs.getInt("productID"));
				review.setContentReview(rs.getString("contentReview"));
				review.setDateReview(rs.getDate("dateReview"));
				reviews.add(review);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return reviews;
	}
}
