package controllers;

import java.util.*;
import play.libs.Json;

import model.Seller;
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
	    System.out.println("CREATE SELLER");
	    
	    
	    Seller s = new Seller(email,firstname,lastname,password,mobile,address,postalCode,city,siret,urlweb);
	    
	    s.save();

	    return ok(Json.toJson(s));
	}
	
	public 	Result getAllSeller()
	{
	    List<Seller> sellers = Seller.find.all();
		return ok(Json.toJson(sellers));
	}
	
	
	public Result getSellerById(long id){
		return ok(Json.toJson(Seller.find.byId(id)));
	}
	
	public Result deleteSellerById(long id) {
	    System.out.println("FONCTION DELETE");
	    Seller s = Seller.find.byId(id);
	    
	    if(s!=null)
	    {
	        System.out.println("JE DELETE Le SELLER");
	        s.delete();
	        return ok("HTTP status 200 (OK)");
	    }
	    else
	    {
	        return ok("404 (Not Found)");
	    }
	}
	
	public Result UpdateSellerById(long id) {
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
        System.out.println("Fonction UdapteSeller");
	    Seller s = Seller.find.byId(id);
	    
	    if(s!=null)
	    {
	        if(!firstname.isEmpty())
	            {s.setFirstname(firstname);}
	        if(!lastname.isEmpty())
	            {s.lastname=lastname;}
	        if(!email.isEmpty())
	            {s.password=password;}
	        if(!mobile.isEmpty())
	            {s.mobile=mobile;}
	        if(!address.isEmpty())
	            {s.address=address;}
	        if(!postalCode.isEmpty())
	            {s.postalCode=postalCode;}
	        if(!city.isEmpty())
	            {s.city=city;}
	        if(!siret.isEmpty())
	            {s.siret=siret;}
	        if(!urlweb.isEmpty())
	            {s.urlweb=urlweb;}
	            
	        s.save();
	   }
	   System.out.println(s.firstname);
	   
	   return ok("ok");
	    

	}
	
}