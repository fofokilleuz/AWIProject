package controllers;

import java.util.*;
import play.libs.Json;

import model.User;
import java.text.*;
import play.mvc.*;
import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's user.
 */

public class UserController extends Controller {

	public Result createUser()
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
	    System.out.println("CREATEUSER");
	    
	    
	    User u = new User(email,firstname,lastname,password,mobile,address,postalCode,city,"image");
	    
	    u.save();

	    return ok(Json.toJson(u));
	}
	
	public 	Result getAllUser()
	{
		List<User> users = User.find.all();

		return ok(Json.toJson(users));
		
	}
	
	public Result getUserById(long id){
	   // User u = User.find.byId(id);
	    //System.out.println(u.firstname);
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
	        if(firstname!=null)
	            {
	                System.out.println("Fistname non nul");
	                u.firstname=firstname;}
	        else if(lastname!=null)
	            {
	                System.out.println("lastname nul");
	                u.lastname=lastname;}
	        else if(password!=null)
	            {u.password=password;}
	        else if(mobile!=null)
	            {u.mobile=mobile;}
	        else if(address!=null)
	            {u.address=address;}
	        else if(postalCode!=null)
	            {u.postalCode=postalCode;}
	        else if(city!=null)
	            {u.city=city;}
	   }
	   System.out.println(u.firstname);
	   u.save();
	   return ok("ok");
	    

	}
	
}