package com.cts.intcdb22jf003.pms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.intcdb22jf003.pms.dao.ProductRepository;
import com.cts.intcdb22jf003.pms.exceptions.DuplicateProductException;
import com.cts.intcdb22jf003.pms.exceptions.ProductNotFoundException;
import com.cts.intcdb22jf003.pms.models.Product;

@Service
public class ProductServiceImpl implements ProductService {
   @Autowired
	private ProductRepository repo;
	@Override
	public Product createNewProduct(Product product) {
		
 Optional<Product> existingProduct =		repo.findById(product.getId());
 
    if(existingProduct.isPresent())
    {
    	throw new DuplicateProductException("Product Already saved");
    }else
    {
		
		
		return repo.save(product); // insert 
    }
	}

	

	@Override
	public Product updateNewProduct(Product product) {
		
		Optional<Product> existingProduct =		repo.findById(product.getId());
		if(existingProduct.isPresent())
		{
			return repo.save(product); // update	
		}
		else
		{
			throw new ProductNotFoundException("Product Not Found to update ");
		}
		
	}

	@Override
	public Product getProduct(int pid) {
		
		return repo.findById(pid).get();
	}

	@Override
	public List<Product> getProduct() {
		
		return repo.findAll();
	}

	@Override
	public void deleteProduct(int id) {
		
		Product p = repo.findById(id).get();
		repo.delete(p);
	}

}
