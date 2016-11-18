package controllers;

import java.util.*;
import play.libs.Json;

import model.User;
import model.Product;

import model.LineCommand;
import model.LineBasket;
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
public class CommandController extends Controller {
  
  	public Result validateOrder(long idUser){
        List<LineBasket> basket = LineBasket.getBasketByUser(idUser);
	    //c.save();
	    return ok("200 - ok");
	}
	
    /*public Result getAllOrder(){
        List<Command> commands = Command.getAllCommand();
        if(commands != null){
            return ok(Json.toJson(commands));
        }
        else{
            return badRequest("404 : Not Found");
        }
    }*/
	
    
}