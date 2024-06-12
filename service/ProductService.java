package service;

import java.sql.SQLException;
import java.util.Set;

import model.Product;

public abstract  interface ProductService {
public abstract String addProduct(Product product) throws SQLException;
	
	public abstract String updateProduct(Product product)throws SQLException;
	
	public abstract String deleteProduct(int productId)throws SQLException;
	
	public abstract String getProductById(int productId) throws SQLException ;
	
	public abstract Set<String>getAllProducts()throws SQLException;
	
	public abstract Set<String>getAllProductsByCategory(String category)throws SQLException;
	
	public abstract Set<String>getAllProductsByBrandName(String brandName)throws SQLException;

	public abstract Set<String> getAllProductsByPriceRange(int lowerPrice, int upperPrice)throws SQLException;
	
	public abstract String getAllDetails(int productid)throws SQLException;

	

}

