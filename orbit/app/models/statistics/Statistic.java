package models.statistics;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Statistic extends Model {

    @Id
    public Long id;
    
    @Constraints.Required
    public String name;

    public String description;

    public String format;

    public Integer num_visits;

    @ManyToOne(optional=false)
    public Widget widget;

    @ManyToOne(optional=false)
    public DataSet dataset;

    @ManyToMany(mappedBy="statistics")
    public Set<Report> reports;

    public static Finder<Long,Statistic> find = new Finder<Long, Statistic>(
      Long.class, Statistic.class
    );

    @Override
    public String toString() {
        return this.name;
    }

    
    /**
     * Serializes the object into a JSON, suitable for
     * being interpreted by the displaying/plotting engine.
     * Useful if the plotting is done at client-side.
     */
    public org.codehaus.jackson.JsonNode toJson()
	throws models.statistics.DataSet.InvalidClassNameException {
	
	Map res = new HashMap();
	res.put("title", this.name);
	res.put("description", this.description);
	res.put("type", this.widget.description);
	datasets.DataSet dataset = this.dataset.getDataSetInstance();
	res.put("columns", dataset.getColumns());
	res.put("data", dataset.getData());
	// TODO: support widget options and dataset options
	return play.libs.Json.toJson(res);
    }
}
