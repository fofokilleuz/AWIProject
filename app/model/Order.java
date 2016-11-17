package model;


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
	public class Order extends Model {
	    
	    @Id
	    @GeneratedValue
	    @Column(name = "id", updatable = false, nullable = false)
	    public long id;
	    
	    @Constraints.Required
	    public String etat;
	    
	    @Constraints.Required
	    public Date date;
	    
	    @Constraints.Required
	    @ManyToMany(cascade=CascadeType.ALL)
	    public List<Product> products = new ArrayList<Product>();
	    
	    
	    public static Finder<Long, Order> find = new Finder<Long,Order>(Order.class);
	    
	    
	    public Order(List<Product> products) {
			super();
            this.products=products;
            Long millis = System.currentTimeMillis();
            Date date = new Date(millis);
            this.date = date;
            this.etat="En cours de validation par un admin";
		}
	    
	    public void setDate(Date date){
	        this.date = date;
	    }
	    
	    public void setEtat(String etat){
	        this.etat=etat;
	    }
	    
	    public static Order getOrderbyId(Long id)
	    {
	        return Order.find.byId(id);
	    }
	    
	    public static List<Order> getAllOrder(){
	        return Order.find.all();
	    }
	    
	}
