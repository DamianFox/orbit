package controllers;

import play.*;
import play.mvc.*;
import views.html.*;
import models.global.*;
import models.statistics.*;
import java.util.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }
    
    // test
    public static Result aboutPage() {
        return ok(about.render());
    }    

    public static Result testPage() {
        return ok(test.render());
    }
   
    public static Result prova() {
        return ok(prova.render("Ho vinto."));
    }

    public static Result dbtest() {
        List<Country> l = Country.find.all();
        StringBuffer ret_val = new StringBuffer();
        for (Country c2: l){
            ret_val.append(c2.toString());
        }
        
        return ok(ret_val.toString());
        
    }
  
}
