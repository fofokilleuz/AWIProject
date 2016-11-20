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


/* Class Seller : This model represent in our application a Seller.
    The ebean anotation permit to create directly in the database the table Seller
*/

	@Entity
	public class Seller extends Model {

        // Unique identifiant of the seller
	    @Id
	    @GeneratedValue
	    @Column(name = "id", updatable = false, nullable = false)
	    public long id;
	    
	    // UserName of Seller, permit to connect to the website with de password, max 50 character  
	    @Constraints.MaxLength(50)
	    @Constraints.Required
	    public String userName;
	    
	    // email of Seller, max 80 character 
	    @Constraints.MaxLength(80)
	    @Constraints.Required
	    public String email;
	    
	    // firstname of Seller, max 50 character 
	    @Constraints.MaxLength(50)
	    @Constraints.Required
	    public String firstname;
	    
	    // lastname of Seller, max 80 character 
	    @Constraints.MaxLength(80)
	    @Constraints.Required
	    public String lastname;
	    
	    // password of Seller, hash with sha-256
	    @Constraints.Required
	    public String password;
	    
	    //moble of Seller, max 12 character  (To permit mobile in +33)
	    @Constraints.MaxLength(12)
	    @Constraints.Required
	    public String mobile;
	    
	    //address of Seller, max 80 character 
	    @Constraints.MaxLength(80)
	    @Constraints.Required
	    public String address;
	    
	    //postalCode of Seller, 5 character 
	    @Constraints.MaxLength(5)
	    @Constraints.Required
	    public String postalCode;
	    
	    //city of Seller, max 40 character 
	    @Constraints.MaxLength(40)
	    @Constraints.Required
	    public String city;
	    
	    // urlWebof the siteWeb of Seller, max 70 character 
	    @Constraints.MaxLength(70)
	    @Constraints.Required
	    public String urlweb;
	    
	    // Siret number of Seller, 14 character  : The siret number is a offical number unique for each Seller
	    @Constraints.MaxLength(14)
	    @Constraints.Required
	    public String siret;
	    
	    // token of Seller, permit to manage the connection to the application
	    public String token;
	    
	    //products : List of all products of Seller
	    @JsonManagedReference
	    @OneToMany(cascade=CascadeType.ALL)
	    public List<Product> products = new ArrayList<Product>();
	    
	    		
		// Finder : This attribut permit to link the model class of Seller with the database and make queries.
		 public static Finder<Long, Seller> find = new Finder<Long,Seller>(Seller.class);
		
		//////////////
		////Setter////
		//////////////
	    
	    /*
	    Constructor of Seller Class : 
	    
	    public Seller(String userName, String email, String firstname, String lastname, String password, String mobile, String address,
				String postalCode, String city, String siret, String urlweb) : Seller
				
	        Input : userName : Pseudo which permit to connect to the website
	                email : email of Seller
	                firstname : firstname of Seller
	                lastname : lastname of Seller
	                password : password of Seller which permit to connect to the website,
	                mobile : mobile of Seller
	                address : address of Seller
	                postalCode : Code Postal of Seller
	                city : city of Seller
	                siret : Siret number of Seller 
	                urlweb : Url of the website of Seller
	        Output : One instance of Seller
	    
	    */
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

		//////////////
		////Setter////
		//////////////
		
		/*
		public void setEmail(String email)
		    Input : email : email of Seller
		    Output : void
		*/
		
		 public void setEmail(String email)
		 {
		     this.email=email;
		 }
		 
		 /*
		public void setUserName(String userName)
		    Input : username : UserName of Seller, permit to connect to the website with de password, max 50 caractere 
		    Output : void
		*/
		
		 public void setUserName(String userName)
		 {
		     this.userName=userName;
		 }
		 
		 /* public void setFirstname(String firstname)
    		    Input : firstname : firstname of Seller
		        Output : void
		 */
		 
		 public void setFirstname(String firstname)
		 {
		     this.firstname=firstname;
		 }
		 
		 /* public void setLastname(String lastname)
		        Input : lastname : lastname of Seller
		        Output : void
		 */
		 
		 public void setLastname(String lastname)
		 {
		     this.lastname=lastname;
		 }
		 
		 /* public void setPassword(String password)
		        Input : password of Seller has with sha-256
		        Output : void
		 */
		 
		 public void setPassword(String password)
		 {
		     this.password=password;
		 }
		 
		 /* public void setMobile(String mobile)
		        Input : mobile of Seller
		        Output : void
		 */
		 public void setMobile(String mobile)
		 {
		     this.mobile=mobile;
		 }
		 
		 /* public void setMobile(String mobile)
		        Input : mobile of Seller
		        Output : void
		 */
		 public void setAddress(String address)
		 {
		     this.address=address;
		 }
		 
		 /* public void setPostalCode(String postalCode)
		        Input : postalCode of Seller
		        Output : void
		 */
		 public void setPostalCode(String postalCode)
		 {
		     this.postalCode=postalCode;
		 }
		 
		 /* public void setCity(String city)
		        Input : city of Seller
		        Output : void
		 */
		 public void setCity(String city)
		 {
		     this.city=city;
		 }
		 
		 /* public void setSiret(String siret)
		        Input : siret of Seller
		        Output : void
		 */
		 public void setSiret(String siret)
		 {
		     this.siret=siret;
		 }
		 
		 /* public void setUrlweb(String urlweb)
		        Input : urlweb of Seller
		        Output : void
		 */
		 public void setUrlweb(String urlweb)
		 {
		     this.urlweb=urlweb;
		 }
		 
		 /* public void setToken(String token)
		        Input : token of Seller
		        Output : void
		 */
		 public void setToken(String token)
		 {
		     this.token = token;
		 }
		 
		 	 public void addProduct(Product p)
		 {
		     this.products.add(p);
		 }
		 
		 /*
		     public static List<Seller> getAllSeller()
		        Return all the seller of the application
		        Inpurt : Void
		        Output : List<Seller>
		 
		 */
		 	 public static List<Seller> getAllSeller()
		 {
		     return Seller.find.all();
		 }
		 
		  /*
		     public static Seller> getSellerById(Long id)
		        Return the seller which own the input id
		        Inpurt : id of Seller
		        Output : Seller
		 
		 */
		 public static Seller getSellerById(long id)
		 {
		     return Seller.find.byId(id);
		 }
		 
		 /*
		    public static List<Product> getAllProduct(long idSeller)
		        Return all the product of seller which own the input idSeller
		        Input : idSeller of Seller
		        Output : List<Product>
		 
		 */
		 public static List<Product> getAllProduct(long idSeller)
		 {
		     Seller s = Seller.getSellerById(idSeller);
		     return s.products;
		 }
		 
		 
		 /*
		    public static Seller verification(String userName, String password)
		        Check if the tuple userName / password given during the connection corresponds to an existing Seller in database
		        and return the Seller if he is found, else return null
		        Input : username and password of Seller
		        Output : Seller
		    
		 */
		 public static Seller verification(String userName, String password){
		     Seller s = Seller.find.where().eq("userName",userName).eq("password",password).findUnique();
		     return s;
	 }
		 
		 /*
		    public static Seller isConnected(Long id, String token)
		        Check if the token present in the cookie of the seller (which own the input id) correspond to the token in database.
		        If yes the seller is connected to the web site and return the seller, else the seller isn't connected to the web site and return null
		        Input : id and token of Seller
		        Output : Seller
		 */
		 
	 public static Seller isConnected(Long id,String token)
		 {
		     
		     Seller s = Seller.find.byId(id);
		     if(s.token.equals(token))
		     {
		        return s;
		     }
		        return null;
		 }
	

	}
