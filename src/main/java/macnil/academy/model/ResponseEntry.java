package macnil.academy.model;

import java.math.BigDecimal;
import java.time.LocalDate;


public class ResponseEntry {
    private Long id;
    private LocalDate date;
    private BigDecimal workTimeMinutes;

    public ResponseEntry() {
    }

    public ResponseEntry(Long id, LocalDate date, BigDecimal workTimeMinutes) {
        this.id = id;
        this.date = date;
        this.workTimeMinutes = workTimeMinutes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getWorkTimeMinutes() {
        return workTimeMinutes;
    }

    public void setWorkTimeMinutes(BigDecimal workTimeMinutes) {
        this.workTimeMinutes = workTimeMinutes;
    }

   

    

    
    
}
