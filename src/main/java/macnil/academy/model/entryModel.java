package macnil.academy.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "entries")
public class entryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime date;
    private LocalDateTime hour_in;
    private LocalDateTime hour_out;
    private String notes;
    private String location;
    private Integer user_id;

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
}
