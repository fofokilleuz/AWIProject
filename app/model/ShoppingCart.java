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

import model.LineShoppingCart;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import model.Product;

	@Entity
	public class ShoppingCart extends Model {
	    
	    @Id
	    @GeneratedValue
	    @Column(name = "id", updatable = false, nullable = false)
	    public long id;
	    
	    
	    @OneToMany(cascade=CascadeType.ALL)
	    public List<LineShoppingCart> lineShoppingCarts = new ArrayList<LineShoppingCart>();
	    
	 
	    public ShoppingCart() {
			super();
		}
		
	   public static Finder<Long, ShoppingCart> find = new Finder<Long,ShoppingCart>(ShoppingCart.class);
	    
	   public void addLineShoppingCart(LineShoppingCart lineShoppingCart){
	        this.lineShoppingCarts.add(lineShoppingCart);
	    }
	  
	    public static ShoppingCart getShoppingCartId(Long id)
	    {
	        return ShoppingCart.find.byId(id);
	    }
	    
	    public ShoppingCart addLineShoppingCart(int q, Double sp,Product p){
	        
	        LineShoppingCart lsc = new LineShoppingCart(q,sp,p);
	        //lsc.save();
	        this.lineShoppingCarts.add(lsc);
	        return this;
	    }
	    
	}
