package com.cts.intcdb22jf003.pms.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cts.intcdb22jf003.pms.models.Product;
import com.cts.intcdb22jf003.pms.services.ProductService;

@RestController // @Controller + @ResponseBody
@RequestMapping("/pms/api")
//@Validated
public class ProductController {
	@Autowired
	private ProductService service;

	@RequestMapping(value="/welcome",method = RequestMethod.GET)
	public String welcome()
	{
		return "Welcome to PMS REST API";
	}
	@PostMapping(value="/product")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Product> createProduct(@Valid   @RequestBody Product product)
	{
		return new ResponseEntity<Product>(service.createNewProduct(product), HttpStatus.CREATED);
		
	}
	
	@PutMapping(value="/product")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Product> updateProduct(@RequestBody Product product)
	{
		return new ResponseEntity<Product>(service.updateNewProduct(product), HttpStatus.OK);
		
	}
	
	
	  @GetMapping(value="/product")
	  
	  @ResponseStatus(HttpStatus.OK) 
	  public List<Product> products()
	  { return service.getProduct();
	  }
	 
	@GetMapping(value="/product/{pid}") // Path Variable
	@ResponseStatus(HttpStatus.OK)
	public Product product(   @PathVariable("pid")  int pid)
	{
		return service.getProduct(pid);
	}
	@DeleteMapping("/product")
	public ResponseEntity<?> deleteProduct(@RequestParam(name="pid",defaultValue = "101",required  = false) int pid)
	{
		service.deleteProduct(pid);
		
		return ResponseEntity.ok().build();
	}
	
}
/*
 * http://localhost:8080/pms/api/welcome - GET  - should return "Welcome to PMS REST API" status OK 200
 * http://localhost:8080/pms/api/product - POST - should return Product after saving to db status Created 201 - should take json product request body 
 * 
 {
"id":101,
"name":"RAM",
"description":"Intel 4GB",
"price":3000,
"qunatity":20

}

http://localhost:8080/pms/api/product - PUT - should return Product after modifying to db status OK 200 - should take json product request body 
 * 
 {
"id":101,
"name":"RAM",
"description":"Intel 4GB",
"price":3000,
"qunatity":20

}
http://localhost:8080/pms/api/product - GET - return All products as List of Products

http://localhost:8080/pms/api/product/{id} - GET PathVariable return  product matching with id

http://localhost:8080/pms/api/product?pid = 101 delete product matching with id then OK 

 * 
 * */
 