package controllers;

import java.util.*;
import play.libs.Json;

import model.User;
import model.Product;
import java.text.*;
import play.mvc.*;
import views.html.*;


import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import play.api.libs.Codecs;
import play.libs.Json;
import java.math.BigInteger;
import play.api.mvc.Cookie;
import play.api.http.HeaderNames.*;
import play.api.mvc.DiscardingCookie;
import java.security.SecureRandom;

import com.fasterxml.jackson.databind.JsonNode;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's user.
 */

public class ConnectionController extends Controller {
  
  
  public Result authenticate(){
	      
	    Map<String, String[]> values = request().body().asFormUrlEncoded();  
	    String email = values.get("email")[0];
	    String mdp = values.get("mdp")[0];
	    User u = User.verification(email,mdp);
	    System.out.println(u.id);
	    SecureRandom random = new SecureRandom();
	    String token = new BigInteger(130, random).toString(32);
	    if(u !=null){
	       u.setToken(token);
	       u.save();
	       String id = Long.toString(u.id);
	       return ok("Success").withCookies(new Http.Cookie("tokenGoldFish", token, null, "/", "localhost",false,false)).withCookies
	       (new Http.Cookie("idGoldFish",id , null, "/", "localhost", false, false));
	    }
	    return ok("ok");
  } 
  
  public Result isConnnected(String token,Long id){
      	      User u = User.isConnected(id,token);
	      if(u==null){
	          System.out.println("false");
	          return ok(Json.toJson(false));
	      }else{
	          System.out.println("true");
	          return ok(Json.toJson(true));
	      }
    }
    
}