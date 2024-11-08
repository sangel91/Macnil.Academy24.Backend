package macnil.academy.controller.dto;

import java.time.LocalDateTime;
import macnil.academy.model.entryModel;

public class entryDto {

    private Integer id;
    private LocalDateTime date;
    private LocalDateTime hour_in;
    private LocalDateTime hour_out;
    private String notes;
    private String location;
    private Integer user_id;

    // Costruttore vuoto
    public entryDto() {
    }

    // Costruttore con parametri
    public entryDto(Integer id, LocalDateTime date, LocalDateTime hour_in, LocalDateTime hour_out, String notes, String location, Integer user_id) {
        this.id = id;
        this.date = date;
        this.hour_in = hour_in;
        this.hour_out = hour_out;
        this.notes = notes;
        this.location = location;
        this.user_id = user_id;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getHour_in() {
        return hour_in;
    }

    public void setHour_in(LocalDateTime hour_in) {
        this.hour_in = hour_in;
    }

    public LocalDateTime getHour_out() {
        return hour_out;
    }

    public void setHour_out(LocalDateTime hour_out) {
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

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    // Metodo per convertire da entryModel a entryDto
    public static entryDto fromModel(entryModel entry) {
        return new entryDto(
            entry.getId(),
            entry.getDate(),
            entry.getHour_in(),  // Modificato hourIn a hour_in
            entry.getHour_out(), // Modificato hourOut a hour_out
            entry.getNotes(),
            entry.getLocation(),
            entry.getUser_id()  // Modificato userId a user_id
        );
    }

    // Metodo per convertire da entryDto a entryModel
    public entryModel toModel() {
        entryModel entry = new entryModel();
        entry.setId(this.id);
        entry.setDate(this.date);
        entry.setHour_in(this.hour_in);  // Modificato hourIn a hour_in
        entry.setHour_out(this.hour_out); // Modificato hourOut a hour_out
        entry.setNotes(this.notes);
        entry.setLocation(this.location);
        entry.setUser_id(this.user_id);  // Modificato userId a user_id
        return entry;
    }
}
