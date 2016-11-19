package model;


import java.util.*;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import play.api.libs.Codecs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

	@Entity
	public class Seller extends Model {

	    @Id
	    @GeneratedValue
	    @Column(name = "id", updatable = false, nullable = false)
	    public long id;
	    
	    @Constraints.MaxLength(50)
	    @Constraints.Required
	    public String userName;
	    
	    @Constraints.MaxLength(80)
	    @Constraints.Required
	    public String email;
	    
	    @Constraints.MaxLength(50)
	    @Constraints.Required
	    public String firstname;
	    
	    @Constraints.MaxLength(80)
	    @Constraints.Required
	    public String lastname;
	    
	    @Constraints.Required
	    public String password;
	    
	    @Constraints.MaxLength(12)
	    @Constraints.Required
	    public String mobile;
	    
	    @Constraints.MaxLength(80)
	    @Constraints.Required
	    public String address;
	    
	    @Constraints.MaxLength(5)
	    @Constraints.Required
	    public String postalCode;
	    
	    @Constraints.MaxLength(40)
	    @Constraints.Required
	    public String city;
	    
	    @Constraints.MaxLength(70)
	    @Constraints.Required
	    public String urlweb;
	    
	    @Constraints.MaxLength(14)
	    @Constraints.Required
	    public String siret;
	    
	    public String token;
	    
	    @JsonManagedReference
	    @OneToMany(cascade=CascadeType.ALL)
	    public List<Product> products = new ArrayList<Product>();
	    
		public Seller(String userName, String email, String firstname, String lastname, String password, String mobile, String address,
				String postalCode, String city, String siret, String urlweb) {
			super();
			this.userName = userName;
			this.email = email;
			this.firstname = firstname;
			this.lastname = lastname;
			this.password = password;
			this.mobile = mobile;
			this.address = address;
			this.postalCode = postalCode;
			this.city = city;
			this.siret = siret;
			this.urlweb = urlweb;
			this.token = null;
		}
		
		 public static Finder<Long, Seller> find = new Finder<Long,Seller>(Seller.class);
		
		 public void setEmail(String email)
		 {
		     this.email=email;
		 }
		 
		 public void setUserName(String userName)
		 {
		     this.userName=userName;
		 }
		 
		 public void setFirstname(String firstname)
		 {
		     this.firstname=firstname;
		 }
		 
		 public void setLastname(String lastname)
		 {
		     this.lastname=lastname;
		 }
		 
		 public void setPassword(String password)
		 {
		     this.password=password;
		 }
		 
		 public void setMobile(String mobile)
		 {
		     this.mobile=mobile;
		 }
		 
		 public void setAddress(String address)
		 {
		     this.address=address;
		 }
		 
		 public void setPostalCode(String postalCode)
		 {
		     this.postalCode=postalCode;
		 }
		 
		 public void setCity(String city)
		 {
		     this.city=city;
		 }
		 
		 public void setSiret(String siret)
		 {
		     this.siret=siret;
		 }
		 
		 public void setUrlweb(String urlweb)
		 {
		     this.urlweb=urlweb;
		 }
		 
		 public void setToken(String token)
		 {
		     this.token = token;
		 }
		 
		 	 public void addProduct(Product p)
		 {
		     this.products.add(p);
		 }
		 
		 	 public static List<Seller> getAllSeller()
		 {
		     return Seller.find.all();
		 }
		 
		 public static Seller getSellerById(long id)
		 {
		     return Seller.find.byId(id);
		 }
		 
		 public static List<Product> getAllProduct(long id)
		 {
		     Seller s = Seller.getSellerById(id);
		     return s.products;
		 }
		 
		 public static Seller verification(String userName, String password){
		     Seller s = Seller.find.where().eq("userName",userName).eq("password",password).findUnique();
		     return s;
	 }
		 
	 public static Seller isConnected(Long id,String token)
		 {
		     
		     Seller s = Seller.find.byId(id);
		     System.out.println(s.token);
		     System.out.println(token);
		     if(s.token.equals(token))
		     {
		        return s;
		     }
		        return null;
		 }
	

	}
