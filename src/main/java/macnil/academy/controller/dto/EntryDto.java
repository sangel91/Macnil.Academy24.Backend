package macnil.academy.controller.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class EntryDto {
        private Long Id;

    private LocalDate date;

    private LocalTime hour_in;

    private LocalTime hour_out;

    private String notes;

    private String location;


    public EntryDto(){

    }


    public Long getId() {
        return Id;
    }


    public void setId(Long id) {
        Id = id;
    }


    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }


    public LocalTime getHour_in() {
        return hour_in;
    }


    public void setHour_in(LocalTime hour_in) {
        this.hour_in = hour_in;
    }


    public LocalTime getHour_out() {
        return hour_out;
    }


    public void setHour_out(LocalTime hour_out) {
        this.hour_out = hour_out;
    }


    public String getNotes() {
        return notes;
    }


    public void setNotes(String notes) {
        this.notes = notes;
    }


    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location;
    }

    
}
