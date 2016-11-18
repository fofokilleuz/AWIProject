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

import com.fasterxml.jackson.databind.JsonNode;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's Seller.
 */

public class SellerController extends Controller {


	/** To create a seller
     * 
     * call with $http.post('/seller', data)
     * 
     */
    public Result createSeller() {
	    JsonNode json = request().body().asJson();
	    if(json == null) {
	        return badRequest("Expecting Json data");
	     } else {
	          String userName = json.findPath("userName").textValue();
	    	  String firstname = json.findPath("firstname").textValue();
	    	  String lastname = json.findPath("lastname").textValue();
	    	  String email = json.findPath("email").textValue();
	    	  String password = json.findPath("password").textValue();
	    	  String mobile = json.findPath("mobile").textValue();
	    	  String address = json.findPath("address").textValue();
	    	  String postalCode = json.findPath("postalCode").textValue();
	    	  String city = json.findPath("city").textValue();
	    	  String siret = json.findPath("siret").textValue();
	    	  String urlweb = json.findPath("urlweb").textValue();
	    	  
              Seller s = new Seller(userName,email,firstname,lastname,password,mobile,address,postalCode,city,siret,urlweb);
              s.save();
	    	  return ok("200 - OK");
	      }
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
	
	/** To delete a seller by id
     * 
     * call with $http.post('/seller/' + id, data)
     * 
     */
	public Result deleteSellerById(long id) {
	    Seller s = Seller.getSellerById(id);
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
	
	
	/** To update a seller by id
     * 
     * call with $http.post('/seller/' + id, data)
     * 
     */
	public Result UpdateSellerById(long id) {
	    JsonNode json = request().body().asJson();
	    if(json == null) {
	        return badRequest("Expecting Json data");
	     } else {
	    	  String firstname = json.findPath("firstname").textValue();
	    	  String lastname = json.findPath("lastname").textValue();
	    	  String email = json.findPath("email").textValue();
	    	  String password = json.findPath("password").textValue();
	    	  String mobile = json.findPath("mobile").textValue();
	    	  String address = json.findPath("address").textValue();
	    	  String postalCode = json.findPath("postalCode").textValue();
	    	  String city = json.findPath("city").textValue();
	    	  String siret = json.findPath("siret").textValue();
	    	  String urlweb = json.findPath("urlweb").textValue();
              System.out.println("Fonction UpdateSellerById");
              Seller s = Seller.getSellerById(id);
	    if(s!=null){
	        if(firstname != null)
	            {s.setFirstname(firstname);}
	        if(lastname != null)
	            {s.setLastname(lastname);}
	        if(password != null)
	            {s.setPassword(password);}
	        if(email != null)
	            {s.setEmail(email);}
	        if(mobile != null)
	            {s.setMobile(mobile);}
	        if(address != null)
	            {s.setAddress(address);}
	        if(postalCode != null)
	            {s.setPostalCode(postalCode);}
	        if(city != null)
	            {s.setCity(city);}
	        if(siret != null)
	            {s.setSiret(siret);}
	        if(urlweb != null)
	            {s.setUrlweb(urlweb);}
	        s.save();
	        return ok("200 - OK");
	   } else {
	        return ok("404 - Not Found");
	   }
	   }
	    
	}
	
	/** To add a product to a Seller by Seller id
     * 
     * call with $http.post('/seller/' + id, data)
     * 
     */
	public Result addProduct(long id){
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
	
	public Result getAllProduct(long id)
	{
	    Seller s = Seller.getSellerById(id);
	    if (s==null)
	    {
	        return ok("404 - Not Found");
	    }
	    else
	    {
	        return ok(Json.toJson(s.products));
	    }
	}
	
}