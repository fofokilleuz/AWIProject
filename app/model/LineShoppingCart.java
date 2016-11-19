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
//import model.ShoppingCart;

	@Entity
	public class LineShoppingCart extends Model {
	    
	    @Id
	    @GeneratedValue
	    @Column(name = "id", updatable = false, nullable = false)
	    public long id;
	    
	    @Constraints.MaxLength(4)
	    @Constraints.Required
	    public int quantity;
	    
	    @Constraints.MaxLength(6)
	    @Constraints.Required
	    public Double sellPrice;
	    
	    public LineShoppingCart(int quantity, Double sellPrice, Product product) {
			super();
		}
		
	   public static Finder<Long, LineShoppingCart> find = new Finder<Long,LineShoppingCart>(LineShoppingCart.class);
	    
	    
}