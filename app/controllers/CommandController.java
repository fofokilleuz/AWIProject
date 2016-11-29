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

public class CommandController extends Controller {
    
  
    public Result validateOrder(Long idUser){
      List<LineBasket> basket = LineBasket.getBasketByUser(idUser);
      for(int i =0; i < basket.size(); i++){
          LineCommand.createLineCommand(basket.get(i));
        }
       List<LineCommand> Llc = LineCommand.getLineCommandByUser(idUser);
       LineBasket.deleteBasketByUser(idUser);
       return ok(Json.toJson(Llc));
    }
    
    public Result getAllSellerfromLineBaskettByIdUser(Long idUser){
      List<LineBasket> basket = LineBasket.getAllSellerfromLineBaskettByIdUser(idUser);
 
      return ok(Json.toJson(basket));
    }
    
    public Result getLineCommandByUser(Long idUser){
        List<LineCommand> Llc = LineCommand.getLineCommandByUser(idUser);
        return ok(Json.toJson(Llc));
    }
    
    public Result getLineCommandValidate(long idUser){
        List<LineCommand> Llc = LineCommand.getLineCommandValidate(idUser);
        return ok(Json.toJson(Llc));
    }
    
    
  
    

    
}