package controllers;

import java.util.*;
import play.libs.Json;

import model.User;
import java.text.*;
import play.mvc.*;
import views.html.*;
import java.util.*;
import play.api.libs.Codecs;
import play.libs.Json;
import model.Diary;
import model.Goal;
import com.fasterxml.jackson.databind.JsonNode;



/**
 * This controller contains an action to handle HTTP requests
 * to the application's diary.
*/
public class GoalController extends Controller {
    
    
    /** To create an goal
     * 
     * call with $http.post('/user/:idUser/diary', data)
     * 
     */
    public Result createGoal(Long idUser, Long idDiary){
        System.out.println("CREATE Goal");
	    JsonNode json = request().body().asJson();
	    if(json == null) {
	        return badRequest("Expecting Json data");
	     } else {
	          System.out.println(json);
	    	  String name = json.findPath("nameGoal").textValue();
	    	  String description = json.findPath("description").textValue();
	          Diary d = Diary.getDiaryById(idDiary);
	          if(d==null){
	              return badRequest("Diary not found");
	          }
	          Goal g = new Goal(name,description,d);
	          g.save();
	    	  return ok("200 - ok");
	      }
	}
	
}
	
