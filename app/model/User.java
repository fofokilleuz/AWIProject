package model;


import java.util.*;

import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

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
	    
	    
	    @Constraints.Required
	    public String nameProfilImage;
	    
		public User(String email, String firstname, String lastname, String password, String mobile, String address,
				String postalCode, String city,String nameProfilImage) {
			super();
			this.email = email;
			this.firstname = firstname;
			this.lastname = lastname;
			this.password = password;
			this.mobile = mobile;
			this.address = address;
			this.postalCode = postalCode;
			this.city = city;
			this.nameProfilImage = nameProfilImage;
		}
		
		 public static Finder<Long, User> find = new Finder<Long,User>(User.class);
		
	    
	   
	}
