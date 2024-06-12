package dao;
import java.sql.SQLException;
import java.util.Set;

import model.Product;
//import productmanagement.model.Product;
//import productmanagement.service.String;
public interface ProductDao {
		public abstract String addProduct(Product product) throws SQLException;
		
		public abstract String updateProduct(Product product)throws SQLException;
		
		public abstract String deleteProduct(int productId)throws SQLException;
		
		public abstract String getProductById(int productId)throws SQLException ;
		
		public abstract Set<String>getAllProducts()throws SQLException;
		
		public abstract Set<String>getAllProductsByPricerange(int initialPrice, int finalPrice)throws SQLException;
		
		public abstract Set<String>getAllProductsByCategory(String category)throws SQLException;
		
		public abstract Set<String>getAllProductsByBrandName(String brandName)throws SQLException;
		
		public abstract String getAllDetailsById(int productid)throws SQLException;

	}

