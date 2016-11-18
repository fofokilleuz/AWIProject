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


import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;;

	@Entity
	public class Product extends Model {

	    @Id
	    @GeneratedValue
	    @Column(name = "idProduct", updatable = false, nullable = false)
	    public long idProduct;
	    
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
	    
	    @JsonBackReference
	    @OneToMany(cascade=CascadeType.ALL)
	    public List<LineBasket> basket;
	    
	    @JsonBackReference
	    @OneToMany(cascade=CascadeType.ALL)
	    public List<Seller> sellers;
	    
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