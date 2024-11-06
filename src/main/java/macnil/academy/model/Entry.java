package macnil.academy.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "entry")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "date")
    private Date date;


    @Column(name = "hourIn")
    private Time hourIn;

    
    @Column(name = "hourOut")
    private Time hourOut;

    @Lob // Questo campo conterrà testo lungo
    @Column(name= "notes")
    private String notes;

    @Column(name = "location")
    private String location;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;


    public Entry(){

    }


    public Long getId() {
        return Id;
    }


    public void setId(Long id) {
        Id = id;
    }


    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public Time getHourIn() {
        return hourIn;
    }


    public void setHourIn(Time hourIn) {
        this.hourIn = hourIn;
    }


    public Time getHourOut() {
        return hourOut;
    }


    public void setHourOut(Time hourOut) {
        this.hourOut = hourOut;
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


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

    

    
}