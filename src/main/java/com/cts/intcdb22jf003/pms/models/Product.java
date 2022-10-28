package com.cts.intcdb22jf003.pms.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// POJO 

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="product")
public class Product {
  @Id
	 private int id;
  @Column
  @Pattern(regexp = "^[a-zA-Z0-9]{3,15}$",message = "Invalid product name")
	 private String name;
  @Column
  @Min(value = 1,message = "Price should be greater then 1 ")
  
	 private double price;
  @Column
	 private String description;
  @Column
	 private int quantity;
//@DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date mfgDate;
	
	 // getter and setter 
	 
	 // No arg Constructor
	 
	 // all constructor
	 // tostring 
	 
	 // Equals and Hash code
}
