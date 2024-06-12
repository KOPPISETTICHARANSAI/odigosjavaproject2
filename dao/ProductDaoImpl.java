package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import model.Product;


public class ProductDaoImpl implements ProductDao{
	Connection conn=null;
	public  ProductDaoImpl() {
		try {
		conn=Jdbcs.getConnection();
		}catch(SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	HashMap<Integer,Product>products = new HashMap<Integer,Product>();
	
	@Override
	public String addProduct(Product product) throws SQLException {
		try {
		PreparedStatement psmt=conn.prepareStatement("insert into products values(?,?,?,?,?,?)");
		psmt.setInt(1, product.getProductByid());
		psmt.setString(2,product.getProductName());
		psmt.setInt(3, product.getProductPrice());
		psmt.setString(4, product.getProductCategory());
		psmt.setString(5,product.getProductBrand());
		psmt.setInt(6, product.getProductQuantity());
		psmt.executeUpdate();}
		catch(SQLException e) {
			System.out.println(e);
		}
		return "product saved successfully with id:"+ Product.getProductByid();
	}

	@Override
	public String updateProduct(Product product)throws SQLException {
		        String result;
		        try {
		            PreparedStatement psmt = conn.prepareStatement("UPDATE products SET Pname = ?,Price = ?,Category = ?,Brand = ?, Quantity = ? WHERE Id = ?");
		            psmt.setString(1, product.getProductName());
		            psmt.setInt(2, product.getProductPrice());
		            psmt.setString(3, product.getProductCategory());
		            psmt.setString(4, product.getProductBrand());
		            psmt.setInt(5, product.getProductQuantity());
		            psmt.setInt(6, product.getProductByid());
		            psmt.executeUpdate();
		            result = "Product updated successfully with id: " + product.getProductByid();
		        } catch (SQLException e) {
		            System.out.println(e);
		            result = "Error updating product: " + e.getMessage();
		        }
		        return result;
		    }

	@Override
	public String deleteProduct(int productId)throws SQLException {
		 String result;
	        try {
	            PreparedStatement psmt = conn.prepareStatement("DELETE FROM products WHERE Id = ?");
	            psmt.setInt(1, productId);
	            psmt.executeUpdate();
	            result = "Product deleted successfully with id: " + productId;
	        } catch (SQLException e) {
	            System.out.println(e);
	            result = "Error deleting product: " + e.getMessage();
	        }
	        return result;
	    }
		

	@Override
	public String getProductById(int productId)throws SQLException  {
		  String result;
	        try {
	            PreparedStatement psmt = conn.prepareStatement("SELECT Pname FROM products WHERE Id = ?");
	            psmt.setInt(1, productId);
	            ResultSet rs = psmt.executeQuery();
	            if (rs.next()) {
	                result = rs.getString("Pname");
	            } else {
	                result = "Product not found";
	            }
	        } catch (SQLException e) {
	            System.out.println(e);
	            result = "Error retrieving product: " + e.getMessage();
	        }
	        return result;
	    }  

	@Override
	public Set<String> getAllProducts()throws SQLException {
		Set<Integer>keys=products.keySet();
		HashSet<String> values= new HashSet<String>();
		 try {
	            PreparedStatement psmt = conn.prepareStatement("SELECT Pname FROM products");
	            ResultSet rs = psmt.executeQuery();
	            while (rs.next()) {
	                values.add(rs.getString("Pname"));
	            }
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	        return values;
	    }

	@Override
	public Set<String> getAllProductsByPricerange(int initialPrice, int finalPrice) throws SQLException{
		Set<String> values = new HashSet<String>();
		 try {
	            PreparedStatement psmt = conn.prepareStatement("SELECT Pname FROM products WHERE Price BETWEEN ? AND ?");
	            psmt.setInt(1, initialPrice);
	            psmt.setInt(2, finalPrice);
	            ResultSet rs = psmt.executeQuery();
	            while (rs.next()) {
	                values.add(rs.getString("Pname"));
	            }
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	        return values;
	    }

	@Override
	public Set<String> getAllProductsByCategory(String category)throws SQLException {
		 Set<String> values = new HashSet<>();
	        try {
	            PreparedStatement psmt = conn.prepareStatement("SELECT Pname FROM products WHERE Category = ?");
	            psmt.setString(1, category);
	            ResultSet rs = psmt.executeQuery();
	            while (rs.next()) {
	                values.add(rs.getString("Pname"));
	            }
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	        return values;
	    }
	@Override
	public Set<String> getAllProductsByBrandName(String brandName)throws SQLException {
		Set<String> values = new HashSet<String>();

		try {
            PreparedStatement psmt = conn.prepareStatement("SELECT Pname FROM products WHERE Brand = ?");
            psmt.setString(1, brandName);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                values.add(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return values;
    }

		
	public String getAllDetailsById(int productid)throws SQLException {
		 String result = null;
	        try {
	        	 System.out.println("Fetching details for product ID: " + productid);

	            PreparedStatement psmt = conn.prepareStatement("SELECT * FROM products WHERE Id = ?");
	            psmt.setInt(1, productid);
	            ResultSet rs = psmt.executeQuery();
	            if(rs.next()) {
	            	int id=rs.getInt(1);
	            	String name=rs.getString(2);
	            	int price=rs.getInt(3);
	            	String category=rs.getString(4);
	            	String brand=rs.getString(5);
	            	int quantity=rs.getInt(6);
	            	result= "	Productid: "+id+"\n	ProductName: "+name+"\n	ProductPrice: "+price+"\n	ProductCategory: " +category+"\n	ProductBrand: "+brand+"\n	ProductQuantity: "+quantity;
	            } 
	            else {
	            	result=" Not Found";
	            }
	        } catch (SQLException e) {
	            System.out.println(e);
	            result = "Error retrieving product details: " + e.getMessage();
	        }
	        return result;
	    }
}

			

	  
	  
	  
	  
		
