package macnil.academy.model;
import java.sql.Date;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name ="entry")
public class EntryModel {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date", nullable=false)
    private Date date;
    @Column(name = "hourIn", nullable=false)
    private LocalDateTime hourIn;
    @Column (name = "hourOut", nullable=false)
    private LocalDateTime hourOut;
    @Column(name="location", nullable=false)
    private String location;
   
    @JsonIgnore  
    private int durataMinuti;

    @JsonIgnore 
    private String status;

    @JsonIgnore  
    private String Colore;


    public EntryModel(Long id, Date date, LocalDateTime hourIn, LocalDateTime hourOut, String location,
            int durataMinuti, String status, String colore) {
        this.id = id;
        this.date = date;
        this.hourIn = hourIn;
        this.hourOut = hourOut;
        this.location = location;
        this.durataMinuti = durataMinuti;
        this.status = status;
        Colore = colore;
    }
  
    
    
}
