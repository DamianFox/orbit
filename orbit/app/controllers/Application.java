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

    public static Result categoryPage(Long id_cat) {
	return ok(category.render(id_cat));
    }

    public static Result chartPage(Long id_cat, Long id_chart) {
	return ok(chart.render(id_cat, id_chart));
    }

   
    public static Result prova() {
        return ok(prova.render("ho vinto"));
    }

    public static Result dbtest() {
        StringBuffer ret_val = new StringBuffer();
	ret_val.append("Ciao\n");
	
	List<Data_Set> l = Data_Set.find.all();
	for (Data_Set d:l){
	    ret_val.append(l.toString());
	}

        List<Country> l2 = Country.find.all();
        for (Country c2: l2){
            ret_val.append(c2.toString());
        }

        return ok(ret_val.toString());
        
    }
  
}
