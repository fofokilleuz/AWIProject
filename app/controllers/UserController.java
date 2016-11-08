package controllers;

import java.util.List;

import model.User;
import play.mvc.*;
import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's user.
 */

public class UserController extends Controller {

	public Result createUser()
	{
		return ok("St");
		
	}
	public 	Result getAllUser()
	{
		List<User> user = User.find.all();
		return ok("St");
		
	}
	
	public Result getUserById(long id){
		return ok("St");
	}
}