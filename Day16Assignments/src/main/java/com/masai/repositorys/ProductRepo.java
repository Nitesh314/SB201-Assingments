package com.masai.repositorys;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.masai.models.Product;
import com.masai.models.ProductDTO;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	@Query("select p from Product p where p.category=?1")
	public List<Product>findProductByCategory(String category);
	
	
	@Query("select new com.masai.models.ProductDTO(p.productName,p.quantity,p.price) from Product p")
	public List<ProductDTO> getProductNameQtyAndPrice();

}
