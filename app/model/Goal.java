package model;


import java.util.*;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.*;
import com.sun.org.apache.bcel.internal.classfile.Code;
import play.api.libs.Codecs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


	@Entity
	public class Goal extends Model {
	    
	    @Id
	    @GeneratedValue
	    @Column(name = "id", updatable = false, nullable = false)
	    public long id;
	    
	    @Constraints.MaxLength(40)
	    @Constraints.Required
	    public String nameGoal;
	    
	    @Constraints.Required
	    public String description;
	   
	   
	    @ManyToOne(cascade=CascadeType.ALL)
	    @JsonBackReference
	    public Diary diary;
	   
	    
	    public Goal(String nameGoal, String description, Diary diary) {
			super();
			this.nameGoal=nameGoal;
			this.description=description;
			this.diary=diary;
		}
		
	   public static Finder<Long, Goal> find = new Finder<Long,Goal>(Goal.class);
	    
	   public void setGoal(String nameGoal){
	        this.nameGoal = nameGoal;
	    }
	    
	    public void setDescription(String description){
	        this.description=description;
	    }
	    
	    
	    public static Goal getGoalById(Long id)
	    {
	        return Goal.find.byId(id);
	    }

	    
	}
