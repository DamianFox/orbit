package controllers;

import play.*;
import play.mvc.*;
import views.html.*;
import models.*;
import java.util.*;
import org.json.*;


public class Report extends Controller {

    public static Result by_id(Integer report_id) {
        return TODO;
    }

    public static Result most_common() {
    	JSONObject json = new JSONObject();
		
    	
    	json.put("name","nome");
    	json.put("title",2);
    	json.put("url",3);
    	
    	
    	
     return json;
    }

}
