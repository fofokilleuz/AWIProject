package controllers;

import java.util.*;
import java.lang.*;
import play.libs.Json;

import model.Product;
import java.text.*;
import play.mvc.*;
import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's user.
 */

public class ProductController extends Controller {

	public Result createProduct()
	{
	    System.out.println("CREATE PRODUCT");
	    Map<String, String[]> values = request().body().asFormUrlEncoded();  
	    String ref = values.get("ref")[0];
	    String name = values.get("name")[0];
	    Double price = Double.parseDouble(values.get("price")[0]);
	    int qty = Integer.parseInt(values.get("qty")[0]);
	    String desc = values.get("desc")[0];
	    
	    Product p = new Product(ref,name,price,qty,desc);
	    
	    p.save();
        
	    return ok(Json.toJson(p));
	}
	
	public 	Result getAllProduct()
	{
		List<Product> products = Product.find.all();

		return ok(Json.toJson(products));
		
	}
	
	public Result getProductById(long id){
		return ok(Json.toJson(Product.find.byId(id)));
	}
	
	public Result deleteProductById(long id) {
	    System.out.println("FONCTION DELETE");
	    Product p = Product.find.byId(id);
	    
	    if(p!=null)
	    {
	        System.out.println("JE DELETE Le PRODUCT");
	        p.delete();
	        return ok("HTTP status 200 (OK)");
	    }
	    else
	    {
	        return ok("404 (Not Found)");
	    }
	}
	
	public Result UpdateProductById(long id) {
	    Map<String, String[]> values = request().body().asFormUrlEncoded();  
	    String firstname = values.get("firstname")[0];
	    String lastname = values.get("surname")[0];
	    String email = values.get("email")[0];
	    String password = values.get("password")[0];
	    String mobile = values.get("mobile")[0];
	    String address = values.get("address")[0];
	    String postalCode = values.get("postalCode")[0];
	    String city = values.get("city")[0];
	    
        System.out.println("Fonction UdapteProduct");
	    Product p = Product.find.byId(id);
	    
	    if(p!=null)
	    {
        
	   }
	   System.out.println(p.name);
	   p.save();
	   return ok("ok");
	    

	}
	
}