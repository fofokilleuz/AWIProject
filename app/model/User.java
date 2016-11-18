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


	@Entity
	public class User extends Model {

	    @Id
	    @GeneratedValue
	    @Column(name = "idUser", updatable = false, nullable = false)
	    public long idUser;
	    
	    @Constraints.Required
	    public String email;
	    
	    @Constraints.Required
	    public String userName;
	    
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
	    
	    public String token;
    
        @OneToMany(cascade=CascadeType.ALL)
        @JsonBackReference
	    public List<LineBasket> basket;
	    
	    
		public User(String email, String userName, String firstname, String lastname, String password, String mobile, String address,
				String postalCode, String city,int status) {
			super();
			this.email = email;
			this.userName = userName;
			this.firstname = firstname;
			this.lastname = lastname;
			this.password = password;
			this.mobile = mobile;
			this.address = address;
			this.postalCode = postalCode;
			this.city = city;
			this.status = status;
			this.token = null;
		}
		
		 public static Finder<Long, User> find = new Finder<Long,User>(User.class);
		
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
	    
	    public void setStatus(int status)
		 {
		     this.status=status;
		 }
		 
		 public void setToken(String token)
		 {
		     this.token = token;
		 }
		 
		 
		 public static List<User> getAllUser()
		 {
		     return User.find.all();
		 }
		 
		 public static User getUserById(long id)
		 {
		     return User.find.byId(id);
		 }
		 
		 /*
		 public Product getProductShoppingCartByNum(long numP){
		     int num = (int) numP;
		     return this.shoppingCart.get(num);
		 }
		 
		 public void deleteProductShoppingCartByNum(long numP){
		     int num = (int) numP;
		     this.shoppingCart.remove(num);
		 }
		 
		 public Double sommeProductShoppingCart(){
		     Double total = 0.0;
		     for(int i=0;i<this.shoppingCart.size();i++){
		         total = total + this.shoppingCart.get(i).price;
		     }
		     return total;
		 }*/
		 
		 public static User verification(String userName, String password){
		     User u = User.find.where().eq("userName",userName).eq("password",password).findUnique();
		     return u;
		 }
		 
		 public static User isConnected(Long id,String token)
		 {
		     
		     User u = User.find.byId(id);
		     System.out.println(u.token);
		     System.out.println(token);
		     if(u.token.equals(token))
		     {
		        return u;
		     }
		        return null;
		 }
	}
