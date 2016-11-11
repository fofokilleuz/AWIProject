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

	@Entity
	public class ShoppingCart extends Model {

	    @Id
	    @GeneratedValue
	    @Column(name = "id", updatable = false, nullable = false)
	    public long id;
	    
	    @ManyToMany(cascade = CascadeType.ALL)
        public List<Product> products = new ArrayList<Product>();

	    
	    
		public ShoppingCart() {
			super();
		}
	
		 public static Finder<Long, ShoppingCart> find = new Finder<Long,ShoppingCart>(ShoppingCart.class);
		 
		 public void saveShoppingCart()
		 {
		     this.save();
		 }
		 
		 public void deleteShoppingCart()
		 {
		     this.delete();
		 }
	}
