package macnil.academy.model;
import java.sql.Date;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name ="entry")
public class EntryModel {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date", nullable=true)
    private Date date;
    @Column(name = "hourIn", nullable=true)
    private LocalDateTime hourIn;
    @Column (name = "hourOut", nullable=true)
    private LocalDateTime hourOut;
    @Column(name="location", nullable= true)
    private String location;
    private int durataMinuti;
    private String status;
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
