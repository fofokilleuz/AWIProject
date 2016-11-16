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
	public class LineShoppingCart extends Model {
	    
	    @Id
	    @GeneratedValue
	    @Column(name = "id", updatable = false, nullable = false)
	    public long id;
	    
	    @Constraints.Required
	    public int quantity;
	    
	    @Constraints.Required
	    public Double sellPrice;
	    
	    @ManyToMany(cascade=CascadeType.ALL)
	    public Product product;
	    
	    public LineShoppingCart(int quantity, Double sellPrice, Product product) {
			super();
			this.product=product;
			this.quantity=quantity;
			this.sellPrice=sellPrice;
		}
		
	   public static Finder<Long, LineShoppingCart> find = new Finder<Long,LineShoppingCart>(LineShoppingCart.class);
	    
	   public void setQuantity(int quantity){
	        this.quantity = quantity;
	    }
	    
	    public void setSellePrice(Double sellPrice){
	        this.sellPrice=sellPrice;
	    }
	    
	    public void setProduct(Product product){
	        this.product=product;
	    }
	    
	    public static LineShoppingCart getLineShoppingCartId(Long id)
	    {
	        return LineShoppingCart.find.byId(id);
	    }
	    
	}
