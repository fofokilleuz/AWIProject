package controllers;

import java.util.*;
import play.libs.Json;

import model.User;
import model.Product;
import java.text.*;
import play.mvc.*;
import views.html.*;

import play.api.libs.Codecs;
import play.libs.Json;

import play.api.mvc.Cookie;
import play.api.http.HeaderNames.*;
import play.api.mvc.DiscardingCookie;

import com.fasterxml.jackson.databind.JsonNode;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's user.
 */

public class ConnectionController extends Controller {
  
  
  public Result authenticate(){
      /*
      JsonNode json = request().body().asJson();
	    if(json == null) {
	        return badRequest("Expecting Json data");
	     } else {
	    	  String email = json.findPath("email").textValue();
	    	  String password = json.findPath("password").textValue();

	    	  return ok(Json.toJson(u));
	      } */
	      
	    Map<String, String[]> values = request().body().asFormUrlEncoded();  
	    String email = values.get("email")[0];
	    String mdp = values.get("mdp")[0];
	    boolean verification = User.verification(email,mdp);
	    System.out.println(verification);
	    String token = "ceci_est_un_exemple";
	    if(verification == true){
	       // Ok("Success").withCookies(Cookie("Authenticate", token));
	    }
	    return ok("ok");

  }  
    
}