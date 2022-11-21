package Model;

public class productModel {
	private int productID;
	private String productName;
	private int price;
	private int cateID;
	private String description;
	private String image;
	
	public productModel() {
		
	}
	
	public productModel(int productID, String productName, int price, int cateID, String description, String image) {
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.cateID = cateID;
		this.description = description;
		this.image = image;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCateID() {
		return cateID;
	}
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
