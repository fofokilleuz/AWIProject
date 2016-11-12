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
	public class User extends Model {

	    @Id
	    @GeneratedValue
	    @Column(name = "id", updatable = false, nullable = false)
	    public long id;
	    
	    @Constraints.Required
	    public String email;
	    
	    @Constraints.Required
	    public String firstname;
	    
	    @Constraints.Required
	    public String lastname;
	    
	    @Constraints.Required
	    public String password;
	    
	    @Constraints.Required
	    public String mobile;
	    
	    @Constraints.Required
	    public String address;
	    
	    @Constraints.Required
	    public String postalCode;
	    
	    @Constraints.Required
	    public String city;
	    
	    // 0 SimpleUser | 1 Admind
	    @Constraints.Required
	    public int status;
	    
	    @ManyToMany(cascade=CascadeType.ALL)
	    public List<Product> shoppingCart = new ArrayList<Product>();
	    
	    
		public User(String email, String firstname, String lastname, String password, String mobile, String address,
				String postalCode, String city,int status) {
			super();
			this.email = email;
			this.firstname = firstname;
			this.lastname = lastname;
			this.password = password;
			this.mobile = mobile;
			this.address = address;
			this.postalCode = postalCode;
			this.city = city;
			this.status = status;

		}
		
		 public static Finder<Long, User> find = new Finder<Long,User>(User.class);
		
		 public void setEmail(String email)
		 {
		     this.email=email;
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
	    
	    public void setStatus(int status)
		 {
		     this.status=status;
		 }
		 
		 public void addProduct(Product p)
		 {
		     this.shoppingCart.add(p);
		 }
		 
		 public static List<User> getAllUser()
		 {
		     return User.find.all();
		 }
		 
		 public static User getUserById(long id)
		 {
		     return User.find.byId(id);
		 }
		 
		 public Product getProductShoppingCartByNum(long numP){
		     int num = (int) numP;
		     return this.shoppingCart.get(num);
		 }
	}
