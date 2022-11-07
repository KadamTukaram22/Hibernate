package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Cart")
public class AddToChart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Cart_Id;

	@Temporal(TemporalType.DATE)
	private Date Purchase_Date;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "User_ID") // ===============================================
	private User user;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "Product_ID") // ===============================================
	private Product product;

	public int getCart_Id() {
		return Cart_Id;
	}

	public void setCart_Id(int cart_Id) {
		Cart_Id = cart_Id;
	}

	public Date getPurchase_Date() {
		return Purchase_Date;
	}

	public void setPurchase_Date(Date purchase_Date) {
		Purchase_Date = purchase_Date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "AddToCart [Cart_Id=" + Cart_Id + ", Purchase_Date=" + Purchase_Date + ", user=" + user + ", product="
				+ product + "]";
	}

}
