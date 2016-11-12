package controllers;

import java.util.*;
import play.libs.Json;

import model.User;
import model.Product;
import model.ShoppingCart;
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
    
    
    /** To create an user
     * 
     * call with $http.post('/user', data)
     * 
     */
    public Result createUser() {
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
	    	  int status = 0 ;
	    	  System.out.println("CREATEUSER");
	    	  User u = new User(email,firstname,lastname,password,mobile,address,postalCode,city,status);  
	    	  u.save();
	    	  return ok(Json.toJson(u));
	      }
	}
	
	/** To get all users
     * 
     * call with $http.get('/users')
     * 
     */
	public 	Result getAllUser()
	{
	    List<User> users = User.find.where().eq("status", 0).findList();
		return ok(Json.toJson(users));
	}
	
	/** To get one user by Id
     * 
     * call with $http.get('/user/' + id)
     * 
     */
	public Result getUserById(long id){
		return ok(Json.toJson(User.find.byId(id)));
	}
	
	
	/** To delete an user by id
     * 
     * call with $http.delete('/user/' + id)
     * 
     */
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
	
	/** To update an user by id
     * 
     * call with $http.put('/user/' + id, data)
     * 
     */
	public Result UpdateUserById(long id) {
	    
	    JsonNode json = request().body().asJson();
	    if(json == null) {
	        return badRequest("Expecting Json data");
	     } else {
	    	  String firstname = json.findPath("firstname").textValue();
	    	  String lastname = json.findPath("lastname").textValue();
	    	  String password = json.findPath("password").textValue();
	    	  String mobile = json.findPath("mobile").textValue();
	    	  String address = json.findPath("address").textValue();
	    	  String postalCode = json.findPath("postalCode").textValue();
	    	  String city = json.findPath("city").textValue();
              System.out.println("Fonction UdapteUser");
	          User u = User.find.byId(id);
	    if(u!=null) {
	        if(firstname != null)
	            {u.setFirstname(firstname);}
	        if(lastname != null)
	            {u.setLastname(lastname);}
	        if(password != null)
	            {u.setPassword(password);}
	        if(mobile != null)
	            {u.setMobile(mobile);}
	        if(address != null)
	            {u.setAddress(address);}
	        if(postalCode != null)
	            {u.setPostalCode(postalCode);}
	        if(city != null)
	            {u.setCity(city);}
	        u.save();
	   }
	   return ok("200 - ok");
	   }
	}
	
	
		public Result addProduct(long idUser,long idProduct)
	{
	    System.out.println("addProduct");

	    
	    Product p = Product.getProductById(idProduct);
	    User u = User.getUserById(idUser);
	    if(u==null)
	    {
	        return ok("404 - Not Found");
	    }
	    else
	    {
	        u.addProduct(p);
	        u.save();
	        return ok("200 - ok");
	    }
	    
	}
	
}
