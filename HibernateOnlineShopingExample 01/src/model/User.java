package model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int User_ID;


	@Column(name = "UserName")
	private String First_Name;

	@Transient
	private String Last_Name;

	private long Mobile_Number;

	private String Email_Id;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_cart_ID")
	private AddToChart cart;

	@Transient
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "User_Product_ID")
	List<Product> product_list = new ArrayList<>();

	
	public int getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public long getMobile_Number() {
		return Mobile_Number;
	}

	public void setMobile_Number(long mobile_Number) {
		Mobile_Number = mobile_Number;
	}

	public String getEmail_Id() {
		return Email_Id;
	}

	public void setEmail_Id(String email_Id) {
		Email_Id = email_Id;
	}

	public AddToChart getCart() {
		return cart;
	}

	public void setCart(AddToChart cart) {
		this.cart = cart;
	}

	public List<Product> getProduct_list() {
		return product_list;
	}

	public void setProduct_list(List<Product> product_list) {
		this.product_list = product_list;
	}

	@Override
	public String toString() {
		return "User [User_ID=" + User_ID + ", First_Name=" + First_Name + ", Last_Name=" + Last_Name
				+ ", Mobile_Number=" + Mobile_Number + ", Email_Id=" + Email_Id + ", cart=" + cart + ", product_list="
				+ product_list + "]";
	}

	
	

}
