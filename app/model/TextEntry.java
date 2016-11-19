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
	public class TextEntry extends Model {
	    
	    @Id
	    @GeneratedValue
	    @Column(name = "id", updatable = false, nullable = false)
	    public long id;
	    
	    @Constraints.MaxLength(500)
	    @Constraints.Required
	    public String content;
	    
	    @Constraints.Required
	    public String dateCreation;
	   
	    @ManyToOne(cascade=CascadeType.ALL)
	    @JsonBackReference
	    public Diary diary;
	    
	    public TextEntry(String content,Diary diary) {
			super();
			this.content=content;
			Date actuelle = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dat = dateFormat.format(actuelle);
            this.dateCreation = dat;
            this.diary=diary;
		}
		
	   public static Finder<Long, TextEntry> find = new Finder<Long,TextEntry>(TextEntry.class);
	    
	   public void setContent(String content){
	        this.content = content;
	    }
	    

	    
	}
