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
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


	@Entity
	public class Diary extends Model {
	    
	    @Id
	    @GeneratedValue
	    @Column(name = "id", updatable = false, nullable = false)
	    public long id;
	    
	    @Constraints.MaxLength(50)
	    @Constraints.Required
	    public String nameDiary;
	    
	    @Constraints.Required
	    public String dateCreation;
	   
	    @OneToMany(cascade=CascadeType.ALL)
	    @JsonManagedReference
	    public List<Goal> goals;
	    
	    @OneToMany(cascade=CascadeType.ALL)
	    @JsonManagedReference
	    public List<TextEntry> textEntries;
	    
	    @ManyToOne(cascade=CascadeType.ALL)
	    @JsonBackReference
	    public User user;
	    
	    public Diary(String nameDiary, String description, User user) {
			super();
			this.nameDiary=nameDiary;
			Date actuelle = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dat = dateFormat.format(actuelle);
            this.dateCreation = dat;
            this.user = user;
		}
		
	   public static Finder<Long, Diary> find = new Finder<Long,Diary>(Diary.class);
	    
	   public void setNameDiary(String nameDiary){
	        this.nameDiary = nameDiary;
	    }
	    
	    public static Diary getDiaryById(long id)
		 {
		     return Diary.find.byId(id);
		 }
		 
		 public static List<Diary> getAllDiaryByUserId(long idUser)
		 {
		     return Diary.find.where().eq("user.idUser",idUser).findList();
		 }

	    
	}
