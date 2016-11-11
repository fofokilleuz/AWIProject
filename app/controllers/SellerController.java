package controllers;

import java.util.*;
import play.libs.Json;

import model.Seller;
import model.Product;
import java.text.*;
import play.mvc.*;
import views.html.*;

import play.api.libs.Codecs;
import play.libs.Json;



/**
 * This controller contains an action to handle HTTP requests
 * to the application's Seller.
 */

public class SellerController extends Controller {

	public Result createSeller()
	{
	    Map<String, String[]> values = request().body().asFormUrlEncoded();  
	    String firstname = values.get("firstname")[0];
	    String lastname = values.get("surname")[0];
	    String email = values.get("email")[0];
	    String password = values.get("password")[0];
	    String mobile = values.get("mobile")[0];
	    String address = values.get("address")[0];
	    String postalCode = values.get("postalCode")[0];
	    String city = values.get("city")[0];
	    String siret = values.get("siret")[0];
	    String urlweb = values.get("urlweb")[0];
	    
	    
	    Seller s = new Seller(email,firstname,lastname,password,mobile,address,postalCode,city,siret,urlweb);
	    
	    s.save();

	    return ok("200 - OK");
	}
	
	public 	Result getAllSeller()
	{
	    List<Seller> sellers = Seller.getAllSeller();
	    if(sellers == null)
	    {
	        return ok("400 - Not Found");
	    }
	    else
	    {
	    	return ok(Json.toJson(sellers));
	    }
	}
	
	
	public Result getSellerById(long id){
		Seller s = Seller.getSellerById(id);
		if(s==null)
		{
		    return ok("404 - Not Found");
		}
		else
		{
		    return ok(Json.toJson(s));
		}
	}
	
	public Result deleteSellerById(long id) {
	    Seller s = Seller.getSellerById(id);;
	    
	    if(s!=null)
	    {
	        s.delete();
	        return ok("200 - OK");
	    }
	    else
	    {
	        return ok("404 - Not Found");
	    }
	}
	
	public Result UpdateSellerById(long id) {
	    Map<String, String[]> values = request().body().asFormUrlEncoded();  
	    String firstname = values.get("firstname")[0];
	    String lastname = values.get("lastname---")[0];
	    String password = values.get("password")[0];
	    String mobile = values.get("mobile")[0];
	    String address = values.get("address")[0];
	    String postalCode = values.get("postalCode")[0];
	    String city = values.get("city")[0];
	    String siret = values.get("siret")[0];
	    String urlweb = values.get("urlweb")[0];
        System.out.println("Fonction UdapteSeller");
	    Seller s = Seller.getSellerById(id);
	    
	    if(s!=null)
	    {
	        if(!firstname.isEmpty())
	            {s.setFirstname(firstname);}
	        if(!lastname.isEmpty())
	            {s.setLastname(lastname);}
	        if(!password.isEmpty())
	            {s.setPassword(password);}
	        if(!mobile.isEmpty())
	            {s.setMobile(mobile);}
	        if(!address.isEmpty())
	            {s.setAddress(address);}
	        if(!postalCode.isEmpty())
	            {s.setPostalCode(postalCode);}
	        if(!city.isEmpty())
	            {s.setCity(city);}
	        if(!siret.isEmpty())
	            {s.setSiret(siret);}
	        if(!urlweb.isEmpty())
	            {s.setUrlweb(urlweb);}
	        s.save();
	        return ok("200 - OK");
	   }
	   else
	   {
	        return ok("404 - Not Found");
	   }
	    
	}
	
	public Result addProduct(long id)
	{
	    Map<String, String[]> values = request().body().asFormUrlEncoded();  
	    String ref = values.get("ref")[0];
	    String name = values.get("name")[0];
	    Double price = Double.parseDouble(values.get("price")[0]);
	    int qty = Integer.parseInt(values.get("qty")[0]);
	    String desc = values.get("desc")[0];
	    
	    Product p = new Product(ref,name,price,qty,desc);
	    p.save();
	    Seller s = Seller.getSellerById(id);
	    if(s==null)
	    {
	        return ok("404 - Not Found");
	    }
	    else
	    {
	        s.addProduct(p);
	        s.save();
	        return ok("200 - ok");
	    }
	    
	}
	
}