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



/**
 * This controller contains an action to handle HTTP requests
 * to the application's user.
 */

public class CommandController extends Controller {
  
  public Result validateOrder(Long idUser){
      
      return ok("200 - ok");
  }

    
}