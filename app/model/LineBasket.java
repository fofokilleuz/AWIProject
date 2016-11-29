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
	public class LineBasket extends Model {
	    
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
	    
	    public LineBasket(int quantity, Double sellPrice, Product product,User user) {
			super();
			this.product=product;
			this.quantity=quantity;
			this.sellPrice=sellPrice;
			this.user=user;
		}
		
	   public static Finder<Long, LineBasket> find = new Finder<Long,LineBasket>(LineBasket.class);
	    
	   public void setQuantity(int quantity){
	        this.quantity = quantity;
	    }
	    
	    public void setSellePrice(Double sellPrice){
	        this.sellPrice=sellPrice;
	    }
	    
	    public void setProduct(Product product){
	        this.product=product;
	    }
	    
	    public static LineBasket getLineShoppingCartId(Long id)
	    {
	        return LineBasket.find.byId(id);
	    }
	    
	    
	    public static List<LineBasket> getAllSellerfromLineBaskettByIdUser(Long idUser){
	        return LineBasket.find.select("product.seller.id").where().eq("user.idUser",idUser).findList();
	    }
	    
	    public static List<LineBasket> getBasketByUser(Long idUser){
	        return LineBasket.find.where().eq("user.idUser",idUser).findList();
	    }
	    
	    public static void  deleteBasketByUser(long idUser){
	        Ebean.deleteAll(LineBasket.find.where().eq("user.idUser",idUser).findList());
	    }
	    
	}
