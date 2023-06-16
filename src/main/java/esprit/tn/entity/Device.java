package esprit.tn.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Entity

@Data

public class Device {
	


	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id_device;
	  
	  
	    private String name;
	
	    private String adresse;
	    private String ville ;
	    private int code_postal ;
	     private int telephone;
	     
	     private String serie;
	     private Type type;
	     
	     private String description ;
	    
	     private  Date date_exp;

	    private LocalDateTime createdAt;

	    private LocalDateTime updatedAt;


	


}

 enum Type {
	capteur,camera , lampe 

}

