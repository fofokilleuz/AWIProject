package controllers;

import java.util.*;
import play.libs.Json;

import model.User;
import model.Seller;
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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's user.
 */

public class ConnectionController extends Controller {
  
    /*
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
	   }*/
  
  public Result authenticate() throws NoSuchAlgorithmException{
	      
	    //Map<String, String[]> values = request().body().asFormUrlEncoded();
	    JsonNode json = request().body().asJson();
	    if(json == null) {
	        return badRequest("Expecting Json data");
	     } else {
	        String userName = json.findPath("userName").textValue();
	        String password = json.findPath("mdp").textValue();
	        System.out.println(userName);
	        MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
            byte[] result = mDigest.digest(password.getBytes());
            StringBuffer mdpHash = new StringBuffer();
            for (int i = 0; i < result.length; i++) {
            mdpHash.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
            }
	        Seller s = Seller.verification(userName,mdpHash.toString());
	        User u = User.verification(userName,mdpHash.toString());
	        SecureRandom random = new SecureRandom();
	        String token = new BigInteger(130, random).toString(32);
	        if(u !=null){
	            u.setToken(token);
	            u.save();
	            String id = Long.toString(u.idUser);
	            return ok("Success").withCookies(new Http.Cookie("tokenGoldFish", token, null, "/", "localhost",false,false)).withCookies
	            (new Http.Cookie("idGoldFish",id , null, "/", "localhost", false, false)).withCookies
	            (new Http.Cookie("roleGoldFish","su" , null, "/", "localhost", false, false));
	       } else if(s != null){
	            s.setToken(token);
	            s.save();
	            String id = Long.toString(s.id);
	            return ok("Success").withCookies(new Http.Cookie("tokenGoldFish", token, null, "/", "localhost",false,false)).withCookies
	            (new Http.Cookie("idGoldFish",id , null, "/", "localhost", false, false)).withCookies
	            (new Http.Cookie("roleGoldFish","seller" , null, "/", "localhost", false, false));
	       }
	       return ok("ok");
	       }
  } 
  
  public Result isConnnected(String token, String role, Long id){
      if(role=="su"){
          User u = User.isConnected(id,token);
          if(u==null){
	          System.out.println("false");
	          return ok(Json.toJson(false));
	      }else{
	          System.out.println("true");
	          return ok(Json.toJson(true));
	      }
      }else{
      	 Seller s = Seller.isConnected(id,token);
      	 if(s==null){
	          System.out.println("false");
	          return ok(Json.toJson(false));
	      }else{
	          System.out.println("true");
	          return ok(Json.toJson(true));
	      }
      }
    }
    
  public Result deconnection(){
      response().discardCookie("idGoldFish");
      response().discardCookie("tokenGoldFish");
      return ok("200 - OK");
  }
    
}