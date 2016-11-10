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
	    Product p = Product.find.byId(id);
	    
	    if(p!=null)
	    {
	        p.delete();
	        return ok("HTTP status 200 (OK)");
	    }
	    else
	    {
	        return ok("404 (Not Found)");
	    }
	}
	
	public Result updateProductById(long id) {
	    Map<String, String[]> values = request().body().asFormUrlEncoded();  
	    String ref = values.get("ref")[0];
	    String name = values.get("name")[0];
	    Double price = Double.parseDouble(values.get("price")[0]);
	    Integer qty = Integer.parseInt(values.get("qty")[0]);
	    String desc = values.get("desc")[0];
	    Product p = Product.find.byId(id);
	    
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
	    }
	   p.save();
	   return ok("ok");

	}
	
}