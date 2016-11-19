package controllers;

import java.util.*;
import play.libs.Json;

import model.User;
import model.Product;
import model.LineBasket;
import java.text.*;
import play.mvc.*;
import views.html.*;
import java.util.*;
import play.api.libs.Codecs;
import play.libs.Json;
import model.Diary;
import com.fasterxml.jackson.databind.JsonNode;



/**
 * This controller contains an action to handle HTTP requests
 * to the application's diary.
*/
public class DiaryController extends Controller {
    
    
    /** To create an diary
     * 
     * call with $http.post('/user/:idUser/diary', data)
     * 
     */
    public Result createDiary(Long idUser){
        System.out.println("CREATE DIARY");
	    /*JsonNode json = request().body().asJson();
	    if(json == null) {
	        return badRequest("Expecting Json data");
	     } else {
	    	  String name = json.findPath("name").textValue();
	    	  String description = json.findPath("description").textValue();*/
              Map<String, String[]> values = request().body().asFormUrlEncoded();  
	          String name = values.get("name")[0];
	          String description = values.get("description")[0];
	          User u = User.getUserById(idUser);
	          if(u==null){
	              return badRequest("User not found");
	          }
	          Diary d = new Diary(name,description,u);
	          d.save();
	    	  return ok("200 - ok");
	      }
	      
	 public Result getAllDiaryByUserId(Long idUser){
	     List<Diary> diaries = Diary.getAllDiaryByUserId(idUser);
	     if(diaries==null){
	         return badRequest("No Diaries");
	     }
	     return ok(Json.toJson(diaries));
	    }
	}
	
