package model;


import java.util.*;

import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

	@Entity
	public class Product extends Model {

	    @Id
	    @GeneratedValue
	    @Column(name = "id", updatable = false, nullable = false)
	    public long id;
	    
	    @Constraints.Required
	    public String ref;
	    
	    @Constraints.Required
	    public String name;
	    
	    @Constraints.Required
	    public Double price;
	    
	    @Constraints.Required
	    public Integer availableQuantity;
	    
	    @Constraints.Required
	    public String description;
	    
	    @ManyToMany(cascade=CascadeType.PERSIST)
	    public LineShoppingCart lineShoppingCart;
	    
	    	public Product(String ref, String name, Double price, Integer availableQuantity, String description) {
			super();
			this.ref = ref;
			this.name = name;
			this.price = price;
			this.availableQuantity = availableQuantity;
			this.description = description;
		}
		
		 public static Finder<Long, Product> find = new Finder<Long,Product>(Product.class);
		 
		 public void setRef(String ref)
		 {
		     this.ref=ref;
		 }
		 
		 public void setName(String name)
		 {
		     this.name=name;
		 }
		 
		 public String getName()
		 {return this.name;}
		 
		 public void setPrice(Double price)
		 {
		     this.price=price;
		 }
		 
		 public void setQuantity(Integer quantity)
		 {
		     this.availableQuantity = quantity;
		 }
		 
		 public void setDescription(String description)
		 {
		     this.description = description;
		 }
		 
		  public static List<Product> getAllProduct()
		 {
		     return Product.find.all();
		 }
		 
		 public static Product getProductById(long id)
		 {
		     return Product.find.byId(id);
		 }
		 
        
}