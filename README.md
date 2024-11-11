# Macnil.Academy.Backend

## Environment Setup
Create a copy of the file `.env.dist` and rename it `.env`:

``` Bash
cp .env.dist .env
```

## Start Environment
```
docker compose up -d
```




entry 
// package macnil.academy.model;


// import java.time.LocalDate;
// import java.time.LocalTime;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.Lob;
// import javax.persistence.ManyToOne;
// import javax.persistence.Table;


// @Entity
// @Table(name = "entry")
// public class Entry {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long Id;

//     @Column(name = "date")
//     private LocalDate date;
    
//     @Column(name = "hour_in")
//     private LocalTime hour_in;

//     @Column(name = "hour_out")
//     private LocalTime hour_out;

//     @Lob // Questo campo conterrà testo lungo
//     @Column(name= "notes")
//     private String notes;

//     @Column(name = "location")
//     private String location;

    
//     @ManyToOne
//     @JoinColumn(name = "user_id")
//     private User user_id;


//     public Entry(){

//     }


//     public Long getId() {
//         return Id;
//     }


//     public void setId(Long id) {
//         Id = id;
//     }


//     public LocalDate getDate() {
//         return date;
//     }


//     public void setDate(LocalDate date) {
//         this.date = date;
//     }


//     public LocalTime getHour_in() {
//         return hour_in;
//     }


//     public void setHour_in(LocalTime hour_in) {
//         this.hour_in = hour_in;
//     }


//     public LocalTime getHour_out() {
//         return hour_out;
//     }


//     public void setHour_out(LocalTime hour_out) {
//         this.hour_out = hour_out;
//     }


//     public String getNotes() {
//         return notes;
//     }


//     public void setNotes(String notes) {
//         this.notes = notes;
//     }


//     public String getLocation() {
//         return location;
//     }


//     public void setLocation(String location) {
//         this.location = location;
//     }


//     public User getUser_id() {
//         return user_id;
//     }


//     public void setUser_id(User user_id) {
//         this.user_id = user_id;
//     }


//     public Object getHour() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'getHour'");
//     }




    

    
// }


ENTRY SERVICE 
// package macnil.academy.service;



// import macnil.academy.controller.dto.EntryDto;
// import macnil.academy.model.Entry;

// public interface EntryService {

//     EntryDto create(Entry entry);

    
// } 
    

    ENTRY SERVICE IMPL
    // package macnil.academy.service;



// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import macnil.academy.controller.dto.EntryDto;
// import macnil.academy.model.Entry;
// import macnil.academy.repository.EntryRepository;

// @Service
// public class EntryServiceImpl implements EntryService {
      
//       @Autowired
//     private EntryRepository entryRepository;

//     @Override
//     public EntryDto create(Entry entry) {
//         // Salva la nuova entry nel DB
//         Entry savedEntry = entryRepository.save(entry);  

//         // Mappatura manuale da Entry a EntryDto
//         EntryDto entryDto = new EntryDto();
//         entryDto.setId(savedEntry.getId());  // Esegui la mappatura manuale

//         return entryDto;
//     }
    
// }


ENTRY DTO
// package macnil.academy.controller.dto;

// import java.time.LocalDate;
// import java.time.LocalTime;

// public class EntryDto {
//         private Long Id;

//     private LocalDate date;

//     private LocalTime hour_in;

//     private LocalTime hour_out;

//     private String notes;

//     private String location;


//     public EntryDto(){

//     }


//     public Long getId() {
//         return Id;
//     }


//     public void setId(Long id) {
//         Id = id;
//     }


//     public LocalDate getDate() {
//         return date;
//     }


//     public void setDate(LocalDate date) {
//         this.date = date;
//     }


//     public LocalTime getHour_in() {
//         return hour_in;
//     }


//     public void setHour_in(LocalTime hour_in) {
//         this.hour_in = hour_in;
//     }


//     public LocalTime getHour_out() {
//         return hour_out;
//     }


//     public void setHour_out(LocalTime hour_out) {
//         this.hour_out = hour_out;
//     }


//     public String getNotes() {
//         return notes;
//     }


//     public void setNotes(String notes) {
//         this.notes = notes;
//     }


//     public String getLocation() {
//         return location;
//     }


//     public void setLocation(String location) {
//         this.location = location;
//     }

    
// }