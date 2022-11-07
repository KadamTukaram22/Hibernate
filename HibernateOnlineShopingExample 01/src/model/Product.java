package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(query = "from Product where Product_Name=:pname" , name = "singleProduct"),
	@NamedQuery(query = "from Product where Product_Price=:price" , name = "singleProduct2"),

})
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Product_Id;

	
	private String Product_Name;

	private String Product_Type;
	
	private long Product_Price;
	
	@ManyToOne
	@JoinColumn(name = "cart_Id")                                            //====================================
	private AddToChart Cart_Id; 
	

	public int getProduct_Id() {
		return Product_Id;
	}

	public void setProduct_Id(int product_Id) {
		Product_Id = product_Id;
	}

	public String getProduct_Name() {
		return Product_Name;
	}

	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}

	public String getProduct_Type() {
		return Product_Type;
	}

	public void setProduct_Type(String product_Type) {
		Product_Type = product_Type;
	}

	public long getProduct_Price() {
		return Product_Price;
	}

	public void setProduct_Price(long product_Price) {
		Product_Price = product_Price;
	}

	public AddToChart getCart_Id() {
		return Cart_Id;
	}

	public void setCart_Id(AddToChart cart_Id) {
		Cart_Id = cart_Id;
	}

	@Override
	public String toString() {
		return "Product [Product_Id=" + Product_Id + ", Product_Name=" + Product_Name + ", Product_Type=" + Product_Type
				+ ", Product_Price=" + Product_Price + ", Cart_Id=" + Cart_Id + "]";
	}
	
}