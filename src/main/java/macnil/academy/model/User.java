package macnil.academy.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "fullname", nullable = true)
    private String firstname;
    
    @Column(name = "city", nullable = true)
    private String city;
    
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Column(name = "role", nullable = false, unique = true)
    private String role;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "generated_code", length = 6) // Impostato il tipo come 'character(6)'
    private String generatedCode;  // Ora è una stringa
    
    @Column(name = "data_generated_Code", nullable = false)
    private LocalDateTime dateGeneratedCode;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;
    
    @Column(name = "working_time", nullable = false)
    private String workingTime;

    public User() {
    }

    // Getter e Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGeneratedCode() {
        return generatedCode;
    }

    public void setGeneratedCode(String generatedCode) {
        this.generatedCode = generatedCode;
    }

    public LocalDateTime getDateGeneratedCode() {
        return dateGeneratedCode;
    }

    public void setDateGeneratedCode(LocalDateTime dateGeneratedCode) {
        this.dateGeneratedCode = dateGeneratedCode;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }
}
