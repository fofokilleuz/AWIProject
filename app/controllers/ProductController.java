package controllers;

import java.util.*;
import java.lang.*;
import play.libs.Json;

import model.Product;
import java.text.*;
import play.mvc.*;
import views.html.*;
import model.Seller;

import com.fasterxml.jackson.databind.JsonNode;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's user.
 */

public class ProductController extends Controller {
    
    
	public Result createProduct(long id){
	    JsonNode json = request().body().asJson();
	    if(json == null) {
	        return badRequest("Expecting Json data");
	     } else {
	    	  String ref = json.findPath("ref").textValue();
	    	  String name = json.findPath("name").textValue();
	    	  double price = json.findPath("price").doubleValue();
	    	  int qty = json.findPath("qty").intValue();
	    	  String desc = json.findPath("desc").textValue();
              Seller s = Seller.getSellerById(id);
	          if(s==null) {
	                return ok("404 - Not Found");
	          } else {
	                Product p = new Product(ref,name,price,qty,desc,s);
                    p.save();
	                return ok("200 - ok");
	          }
	     }
	}
	
	public 	Result getAllProduct()
	{
		List<Product> products = Product.getAllProduct();
	    if(products == null)
	    {
	        return ok("400 - Not Found");
	    }
	    else
	    {
	    	return ok(Json.toJson(products));
	    }
		
	}
	
	public Result getProductById(long id){
		Product p = Product.getProductById(id);
		if(p==null)
		{
		    return ok("404 - Not Found");
		}
		else
		{
		    return ok(Json.toJson(p));
		}
	}
	
	public Result deleteProductById(long id) {
	    Product p = Product.getProductById(id);
	    if(p!=null)
	    {
	        p.delete();
	        return ok("200 - OK");
	    }
	    else
	    {
	        return ok("404 - Not Found");
	    }
	}
	
	public Result updateProductById(long id) {
	    Map<String, String[]> values = request().body().asFormUrlEncoded();  
	    String ref = values.get("ref")[0];
	    String name = values.get("name")[0];
	    Double price = Double.parseDouble(values.get("price")[0]);
	    Integer qty = Integer.parseInt(values.get("qty")[0]);
	    String desc = values.get("desc")[0];
	    Product p = Product.getProductById(id);
	    if(p!=null)
	    {
            if(!ref.isEmpty())
            {
                p.setRef(ref);
            }
            if(!name.isEmpty())
            {
                p.setName(name);
            }
            if(price!=null)
            {
                p.setPrice(price);
            }
            if(qty!=null)
            {
                p.setQuantity(qty);
            }
            if(!desc.isEmpty())
            {
                p.setDescription(desc);
            }
            p.save();
            return ok("20 - OK");
	    }
	    else
	    {
	        return ok("400 - Not Found");
	    }
	}
	
	public Result getQuantityByProductId(long id){
	    return ok("ok");
	}
	
}