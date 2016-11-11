package controllers;

import java.util.*;
import play.libs.Json;

import model.User;
import java.text.*;
import play.mvc.*;
import views.html.*;

import play.api.libs.Codecs;
import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's user.
 */

public class UserController extends Controller {
    
    public Result createUser() {
	    JsonNode json = request().body().asJson();
	    if(json == null) {
	        return badRequest("Expecting Json data");
	     } else {
	    	  String firstname = json.findPath("firstname").textValue();
	    	  String lastname = json.findPath("surname").textValue();
	    	  String email = json.findPath("email").textValue();
	    	  String password = json.findPath("password").textValue();
	    	  String mobile = json.findPath("mobile").textValue();
	    	  String address = json.findPath("address").textValue();
	    	  String postalCode = json.findPath("postalCode").textValue();
	    	  String city = json.findPath("city").textValue();
	    	  int status = 0 ;
	    	  System.out.println("CREATEUSER");
	    	  
	    	  User u = new User(email,firstname,lastname,password,mobile,address,postalCode,city,status);
	    	  u.save();
	    	  return ok(Json.toJson(u));
	      }
	}
	
	public 	Result getAllUser()
	{
	    List<User> users = User.find.where().eq("status", 0).findList();
		return ok(Json.toJson(users));
		
	}
	
	
	public Result getUserById(long id){
		return ok(Json.toJson(User.find.byId(id)));
	}
	
	public Result deleteUserById(long id) {
	    System.out.println("FONCTION DELETE");
	    User u = User.find.byId(id);
	    
	    if(u!=null)
	    {
	        System.out.println("JE DELETE L USER");
	        u.delete();
	        return ok("HTTP status 200 (OK)");
	    }
	    else
	    {
	        return ok("404 (Not Found)");
	    }
	}
	
	public Result UpdateUserById(long id) {
	    Map<String, String[]> values = request().body().asFormUrlEncoded();  
	    String firstname = values.get("firstname")[0];
	    String lastname = values.get("surname")[0];
	    String email = values.get("email")[0];
	    String password = values.get("password")[0];
	    String mobile = values.get("mobile")[0];
	    String address = values.get("address")[0];
	    String postalCode = values.get("postalCode")[0];
	    String city = values.get("city")[0];
	    
        System.out.println("Fonction UdapteUser");
	    User u = User.find.byId(id);
	    
	    if(u!=null)
	    {
	        if(!firstname.isEmpty())
	            {u.setFirstname(firstname);}
	        if(!lastname.isEmpty())
	            {u.setLastname(lastname);}
	        if(!password.isEmpty())
	            {u.setPassword(password);}
	        if(!mobile.isEmpty())
	            {u.setMobile(mobile);}
	        if(!address.isEmpty())
	            {u.setAddress(address);}
	        if(!postalCode.isEmpty())
	            {u.setPostalCode(postalCode);}
	        if(!city.isEmpty())
	            {u.setCity(city);}
	            
	        u.save();
	   }
	   System.out.println(u.firstname);
	   
	   return ok("ok");
	    

	}
	
}