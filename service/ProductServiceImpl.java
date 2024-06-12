package service;

import java.sql.SQLException;
import java.util.Set;

import dao.ProductDao;
import dao.ProductDaoImpl;
import model.Product;

public class ProductServiceImpl implements ProductService{
			ProductDao dao=new ProductDaoImpl();
			
			@Override
			public String addProduct(Product product) throws SQLException {
				return dao.addProduct(product);
			}
			
			@Override
			public String updateProduct(Product product)throws SQLException {
				
				return dao.updateProduct(product);
			}

			@Override
			public String deleteProduct(int productId)throws SQLException  {
				
				return dao.deleteProduct( productId);
			}

			@Override
			public String getProductById(int productId)throws SQLException  {
				
				return dao.getProductById(productId);
			}

			@Override
			public Set<String> getAllProducts()throws SQLException {
				
				return dao.getAllProducts();
			}

			@Override
			public Set<String> getAllProductsByCategory(String category)throws SQLException {
				
				return dao.getAllProductsByCategory(category);
			}

			@Override
			public Set<String> getAllProductsByBrandName(String brandName) throws SQLException{
				
				return dao.getAllProductsByBrandName(brandName);
			}

			@Override
			public Set<String> getAllProductsByPriceRange(int lowerPrice, int upperPrice) throws SQLException {
				// TODO Auto-generated method stub
				return dao.getAllProductsByPricerange(lowerPrice, upperPrice);
			}
			public String getAllDetails(int productid) throws SQLException{
				return dao.getAllDetailsById(productid);
			}


			
			

}
