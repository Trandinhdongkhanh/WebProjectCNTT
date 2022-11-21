package Model;

import java.sql.Date;

public class reviewModel {
	private int reviewID;
	private int accID;
	private int productID;
	private String contentReview;
	private Date dateReview;
	
	public reviewModel() {
		
	}
	
	public reviewModel(int reviewID, int accID, int productID, String contentReview, Date dateReview) {
		this.reviewID = reviewID;
		this.accID = accID;
		this.productID = productID;
		this.contentReview = contentReview;
		this.dateReview = dateReview;
	}
	public int getReviewID() {
		return reviewID;
	}
	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}
	public int getAccID() {
		return accID;
	}
	public void setAccID(int accID) {
		this.accID = accID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getContentReview() {
		return contentReview;
	}
	public void setContentReview(String contentReview) {
		this.contentReview = contentReview;
	}
	public Date getDateReview() {
		return dateReview;
	}
	public void setDateReview(Date dateReview) {
		this.dateReview = dateReview;
	}
	
	
}
