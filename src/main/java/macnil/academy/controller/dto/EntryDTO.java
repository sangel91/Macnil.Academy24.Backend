package macnil.academy.controller.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.Data;
@Data
public class EntryDTO {
    private Long id;
    private Date date;
    private LocalDateTime hourIn;
    private LocalDateTime hourOut;
    private String location;
    private int durataMinuti;
    private String Status;   
    private String Colore;
    public EntryDTO(Long id, Date date, LocalDateTime hourIn, LocalDateTime hourOut, String location, int durataMinuti,
            String status, String colore) {
        this.id = id;
        this.date = date;
        this.hourIn = hourIn;
        this.hourOut = hourOut;
        this.location = location;
        this.durataMinuti = durataMinuti;
        Status = status;
        Colore = colore;
    }
}
