package com.mindbowser.grocery.store.management.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
//@AllArgsConstructor
@Table(name = "product", schema = "grocery_management")

public class ProductEntity {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "Please enter name !")
	@Size(min = 2, message = "Name should contain atleast 2 letters !")
	@Pattern(regexp = "^[_A-z]*((-|\\s)*[_A-z])*$", message = "Please enter valid name !")
	@Column(name = "product_name")
	private String productName;

	@NotNull(message = "Please enter name !")
	@Size(min = 2, message = "Name should contain atleast 2 letters !")
	@Column(name = "category")
	private String category;
	
	@NotNull(message = "Please enter mobile number !")
	@Column(name = "quantity")
	private String quantity;

	
	@NotNull(message = "Please enter mobile number !")
	@Column(name = "weight")
	private String weight;
	
	@Column(name = "DOR")
	private String dateOfRegistration;
	
	@Column(name = "isdelete")
	private Boolean isDelete;


	public ProductEntity(ProductEntity productEntity) {
		super();
		this.id = productEntity.getId();
		this.productName = productEntity.getProductName();
		this.category =productEntity.getCategory() ;
		this.quantity =productEntity.getQuantity() ;
		this.weight = productEntity.getWeight();
		this.dateOfRegistration = productEntity.getDateOfRegistration();
		this.isDelete = false; 
	}

	
	
}
