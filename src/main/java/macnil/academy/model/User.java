package macnil.academy.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    @Column(name= "generatedCode")
    private Long generatedCode;
    @Column(name="dataGeneratedCode", nullable = false)
    private LocalDate dateGeneratedCode;
    @Column(name ="created_at", nullable = false)
    private LocalDate created_at;
    @Column(name = "workingTime", nullable= false)
    private String workingTime;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;



    

    


    public User() {
    }
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
    public Long getGeneratedCode() {
        return generatedCode;
    }
    public void setGeneratedCode(Long generatedCode) {
        this.generatedCode = generatedCode;
    }
    public LocalDate getDateGeneratedCode() {
        return dateGeneratedCode;
    }
    public void setDateGeneratedCode(LocalDate dateGeneratedCode) {
        this.dateGeneratedCode = dateGeneratedCode;
    }
    public LocalDate getCreated_at() {
        return created_at;
    }
    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }
    public String getWorkingTime() {
        return workingTime;
    }
    public void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }
    public Tenant getTenant() {
        return tenant;
    }
    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    
   
    



    



}