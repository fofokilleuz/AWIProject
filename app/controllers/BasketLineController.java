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
import java.util.UUID;
import play.api.libs.Codecs;
import play.libs.Json;
import java.math.BigInteger;
import play.api.http.HeaderNames.*;

import com.fasterxml.jackson.databind.JsonNode;
import model.LineBasket;
import model.LineCommand;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's user.
 */

public class BasketLineController extends Controller {
    
		public Result createLineBasket(long idUser,long idProduct){
	    Product p = Product.getProductById(idProduct);
	    User u = User.getUserById(idUser);
	    if(u==null || p == null)
	    {
	        return ok("404 - Not Found");
	    }
	    else
	    {
	        LineBasket lsc = new LineBasket(1,p.price,p,u);
	        lsc.save();
	        return ok("200 - ok");
	    }
	    
	}
	
	
	public Result getBasketByUser(long idUser){
	    List<LineBasket> Llb= LineBasket.getBasketByUser(idUser);
	    if(Llb==null){
	        return ok("404 - Basket Not Found");
	    }else{
	        return ok(Json.toJson(Llb));  
	    }
	}
	
	public Result deleteBasketByUser(long idUser){
	    LineBasket.deleteBasketByUser(idUser);
	    return ok("200 - ok");
	}
	
	public Result getAllLineBasket()
	{
	   List<LineBasket> l = LineBasket.find.all();
	   return ok(Json.toJson(l));
	}
    
}