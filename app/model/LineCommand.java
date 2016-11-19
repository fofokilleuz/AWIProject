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
import model.LineBasket;

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
	    
	    public LineCommand(int quantity, Double sellPrice, Product product,User user) {
			super();
			this.product=product;
			this.quantity=quantity;
			this.sellPrice=sellPrice;
			this.user=user;
			this.etat="En cours de validation";
			
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
	    
	    public static List<LineCommand> getLineCommandByUser(long idUser){
	        return LineCommand.find.where().eq("user.idUser",idUser).findList();
	    }
	    
	    public static List<LineCommand> getLineCommandValidate(long idUser){
	        return LineCommand.find.where().eq("etat","validate").orderBy("user.idUser").findList();
	    }
	    
	    public static void createLineCommand(LineBasket lb){
	        LineCommand lc = new LineCommand(lb.quantity,lb.sellPrice,lb.product,lb.user);
	        lc.save();
	    }
	    
	    
	}
