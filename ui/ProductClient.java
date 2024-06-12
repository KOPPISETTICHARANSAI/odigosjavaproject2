package ui;
	import java.sql.SQLException;
import java.util.Scanner;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

	public class ProductClient {
		static ProductService service = new ProductServiceImpl();
		public static  void main(String[] args) {
			int productid=0;
			String productname=null;
			int productprice=0;
			String productcategory=null;
			String productbrand=null;
			int productquantity=0;
			boolean loop=true;
			while(loop) {
			            System.out.println("*****SHOPSY(ONLINE PRODUCT STORE)****");
			            System.out.println("CHOOSE OPTION");
			            System.out.println("1)ADD PRODUCT");
			            System.out.println("2)UPDATE PRODUCT");
			            System.out.println("3)DELETE PRODUCT");
			            System.out.println("4)GET PRODUCT BY ID");
			            System.out.println("5)GET ALL PRODUCTS");
			            System.out.println("6)GET ALL PRODUCTS BY PRICE RANGE");
			            System.out.println("7)GET ALL PRODUCTS BY CATEGORY");
			            System.out.println("8)GET ALL PRODUCTS BY BRAND NAME");
			            System.out.println("9)GET ALL DETAILS USING PRODUCT ID");
			            System.out.println("10)EXIT");
			            Scanner sc = new Scanner(System.in);
				        int option=sc.nextInt();
				        switch(option) {
			                case 1:
			                    System.out.println("ENTER PRODUCT DETAILS");
			                    System.out.println("ENTER PRODUCT ID");
			                     productid = sc.nextInt();
			                    System.out.println("ENTER PRODUCT NAME");
			                     productname = sc.next();
			                    System.out.println("ENTER PRODUCT PRICE");
			                    productprice = sc.nextInt();
			                    System.out.println("ENTER PRODUCT CATEGORY");
			                     productcategory = sc.next();
			                    System.out.println("ENTER PRODUCT BRAND");
			                     productbrand = sc.next();
			                    System.out.println("ENTER PRODUCT QUANTITY");
			                    productquantity = sc.nextInt();
			                    Product product = new Product(productid,productname,productprice,productcategory,productbrand,productquantity);
									try {
										System.out.println(service.addProduct(product));
									} catch (Exception e) {
										e.printStackTrace();
									}
			                    break;
			                case 2:
			                    System.out.println("enter the product id to update the product");
			                    int updateProductId = sc.nextInt();
			                    System.out.println("name of the product");
			                    String updateProductName = sc.next();
			                    System.out.println("price of the product");
			                    int updateProductPrice = sc.nextInt();
			                    System.out.println("category of the product");
			                    String updateProductCategory = sc.next();
			                    System.out.println("brand of the product");
			                    String updateProductBrand = sc.next();
			                    System.out.println("quantity of the product");
			                    int updateProductQuantity = sc.nextInt();
			                    Product updatedProduct = new Product(updateProductId,updateProductName,updateProductPrice,updateProductCategory,updateProductBrand,updateProductQuantity);
							try {
								System.out.println(service.updateProduct(updatedProduct));
							} catch (SQLException e) {
								e.printStackTrace();
							}
			                    break;
			                case 3:
			                    System.out.println("enter the product id to delete the product");
			                    int deleteProductId = sc.nextInt();
							try {
								System.out.println(service.deleteProduct(deleteProductId));
							} catch (SQLException e) {
								e.printStackTrace();
							}
			                    break;
			                case 4:
			                    System.out.println("enter the product id to get the product");
			                    int getProductId = sc.nextInt();
							try {
								System.out.println(service.getProductById(getProductId));
							} catch (SQLException e) {
								e.printStackTrace();
							}
			                    break;
			                case 5:
							try {
								System.out.println(service.getAllProducts());
							} catch (SQLException e) {
								e.printStackTrace();
							}
			                    break;
			                case 6:
			                    System.out.println("enter the lower price range");
			                    int lowerPrice = sc.nextInt();
			                    System.out.println("enter the upper price range");
			                    int upperPrice = sc.nextInt();
							try {
								System.out.println(service.getAllProductsByPriceRange(lowerPrice, upperPrice));
							} catch (SQLException e) {
								e.printStackTrace();
							}
			                    break;
			                case 7:
			                    System.out.println("enter the productcategory");
			                    String getProductCategory = sc.next();
							try {
								try {
									System.out.println(service.getAllProductsByCategory(getProductCategory));
								} catch (SQLException e) {
									e.printStackTrace();
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
			                    break;
			                case 8:
			                    System.out.println("enter the product brand");
			                    String getProductBrand = sc.next();
							try {
								System.out.println(service.getAllProductsByBrandName(getProductBrand));
							} catch (SQLException e) {
								e.printStackTrace();
							}
			                    break;
			                case 9:
			                	System.out.println("Enter the product id");
			                	int getproductid=sc.nextInt();
							try {
								System.out.println(service.getAllDetails(getproductid));
							} catch (SQLException e) {
								e.printStackTrace();
							}
			                	break;
			                case 10:
			                    System.out.println("Thank you for using Shopsy!");
			                    loop=false;
			                    break;
			                    
			                default:
			                    System.out.println("Invalid option, please choose a valid option.");
			            
			        sc.close();
			    }
			
			}
			}
			}



