/*package model;


import java.util.*;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
	    
	    @Constraints.Required
	    public String etat;
	    
	    @Constraints.Required
	    public Date dateOrder;
	    
	    @ManyToMany(cascade=CascadeType.ALL)
	    public List<Product> products = new ArrayList<Product>();
	    
	 
	    public Command(List<Product> products) {
			super();
            this.products=products;
            Long millis = System.currentTimeMillis();
            Date date = new Date(millis);
            this.dateOrder = date;
            this.etat="En cours de validation par un admin";
		}
		
		public static Finder<Long, Command> find = new Finder<Long,Command>(Command.class);
	    
	   public void setDate(Date date){
	        this.dateOrder = date;
	    }
	    
	    public void setEtat(String etat){
	        this.etat=etat;
	    }
	    
	    public static Command getCommandbyId(Long id)
	    {
	        return Command.find.byId(id);
	    }
	    
	    public static List<Command> getAllCommand(){
	        return Command.find.all();
	    }
	    
	}
*/