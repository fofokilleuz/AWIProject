package controllers;

import java.util.*;

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
	    
	    
	    User u = new User(email,firstname,lastname,password,mobile,address,postalCode,city,"image");
	    
	    
	    u.save();

		return ok("St");
	}
	
	public 	Result getAllUser()
	{
		List<User> users = User.find.all();
		System.out.println(users.get(0).firstname);
		return ok("St");
		
	}
	
	public Result getUserById(long id){
	    User u = User.find.byId(id);
	    System.out.println(u.firstname);
		return ok(u.firstname);
	}
}