package model;


import java.util.*;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
	    
	    @Constraints.MaxLength(80)
	    @Constraints.Required
	    public String email;
	    
	    @Constraints.MaxLength(20)
	    @Constraints.Required
	    public String userName;
	    
	    @Constraints.MaxLength(30)
	    @Constraints.Required
	    public String firstname;
	    
	    @Constraints.MaxLength(30)
	    @Constraints.Required
	    public String lastname;
	    
	    @Constraints.MaxLength(30)
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
	    
	    // 0 SimpleUser | 1 Admind
	    @Constraints.MaxLength(1)
	    @Constraints.Required
	    public int status;
	    
	    public String token;
    
        @OneToMany(cascade=CascadeType.ALL)
        @JsonBackReference
	    public List<LineBasket> basket;
	    
	    @OneToMany(cascade=CascadeType.ALL)
	    @JsonManagedReference
	    public List<Diary> diaries;
	    
	    
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
