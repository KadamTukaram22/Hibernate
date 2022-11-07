package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Orders")
public class ProductOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_Id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "User_ID")                  //===============================================
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Product_ID")                  //===============================================
	private Product product;
	
	
	@Temporal(TemporalType.DATE)
	private Date Order_date;

	public int getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getOrder_date() {
		return Order_date;
	}

	public void setOrder_date(Date order_date) {
		Order_date = order_date;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductOrder [order_Id=" + order_Id + ", user=" + user + ", product=" + product + ", Order_date="
				+ Order_date + "]";
	}
	}