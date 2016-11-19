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
	public class LineCommand extends Model {
	    
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
	    
	    @ManyToOne(cascade=CascadeType.ALL)
	    @JsonManagedReference
	    public Product product;
	    
	    @ManyToOne(cascade=CascadeType.ALL)
	    @JsonManagedReference
	    public User user;
	    
	    @Constraints.Required
	    public String etat;
	    
	    @Constraints.Required
	    public Date date;
	    
	    public LineCommand(int quantity, Double sellPrice, Product product,User user,String etat) {
			super();
			this.product=product;
			this.quantity=quantity;
			this.sellPrice=sellPrice;
			this.user=user;
			this.etat=etat;
			
		}
		
	   public static Finder<Long, LineCommand> find = new Finder<Long,LineCommand>(LineCommand.class);
	    
	   public void setQuantity(int quantity){
	        this.quantity = quantity;
	    }
	    
	    public void setSellePrice(Double sellPrice){
	        this.sellPrice=sellPrice;
	    }
	    
	    public void setProduct(Product product){
	        this.product=product;
	    }
	    
	    public List<LineCommand> getLineCommandBySeller(Long idUser){
	        return LineCommand.find.select("product.seller.idSeller").where().eq("user.idUser",idUser).orderBy("product.seller.idSeller").findList();
	    }
	    
	}
