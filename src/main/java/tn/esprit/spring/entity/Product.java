package tn.esprit.spring.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Product_Id;
	private String Name;

	private double Buy_Price;
	private double Sell_Price;
	@Lob
	private byte[] Images;
	private String Description;
	private String Brand;
	private Long BarCode;
	
	private long sold;

	@ManyToOne
	private Category category;

	@ManyToOne
	private Ray ray;

	@OneToMany(mappedBy="product")
	@JsonIgnore
	private List<Product_In_Ray> product_in_ray;
	
	@OneToMany(mappedBy="product")
	@JsonIgnore
	private List<Stock> stocks;

	

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String name, double buy_Price, double sell_Price, byte[] images, String description, String brand,
			Category category) {
		super();
		Name = name;
		Buy_Price = buy_Price;
		Sell_Price = sell_Price;
		Images = images;
		Description = description;
		Brand = brand;
		this.category = category;
	}

	public Product(long product_Id, String name, double buy_Price, double sell_Price, byte[] images, String description,
			String brand, Category category) {
		super();
		Product_Id = product_Id;
		Name = name;
		Buy_Price = buy_Price;
		Sell_Price = sell_Price;
		Images = images;
		Description = description;
		Brand = brand;
		this.category = category;
	}

	public long getProduct_Id() {
		return Product_Id;
	}

	public void setProduct_Id(long product_Id) {
		Product_Id = product_Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getBuy_Price() {
		return Buy_Price;
	}

	public void setBuy_Price(double buy_Price) {
		Buy_Price = buy_Price;
	}

	public double getSell_Price() {
		return Sell_Price;
	}

	public void setSell_Price(double sell_Price) {
		Sell_Price = sell_Price;
	}

	public byte[] getImages() {
		return Images;
	}

	public void setImages(byte[] images) {
		Images = images;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Ray getRay() {
		return ray;
	}

	public void setRay(Ray ray) {
		this.ray = ray;
	}

	public Long getBarCode() {
		return BarCode;
	}

	public void setBarCode(Long barCode) {
		BarCode = barCode;
	}

	public List<Product_In_Ray> getProduct_in_ray() {
		return product_in_ray;
	}

	public void setProduct_in_ray(List<Product_In_Ray> product_in_ray) {
		this.product_in_ray = product_in_ray;
	}

	public long getSold() {
		return sold;
	}

	public void setSold(long sold) {
		this.sold = sold;
	}

	
}