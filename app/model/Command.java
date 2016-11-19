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

import model.Product;

	@Entity
	public class Command extends Model {
	    
	    @Id
	    @GeneratedValue
	    @Column(name = "id", updatable = false, nullable = false)
	    public long id;
;
	    
	    @ManyToOne(cascade=CascadeType.ALL)
	    @JsonManagedReference
	    public LineCommand commands;
	    
	    @Constraints.Required
	    public String etat;
	    
	    @Constraints.Required
	    public Date date;
	    
	    public Command() {
			super();
			this.etat="En cours de validation";
			
		}
		
	   public static Finder<Long, Command> find = new Finder<Long,Command>(Command.class);
	    
	   public void setEtat(int quantity){
	        this.etat = etat;
	    }

	    
	}
