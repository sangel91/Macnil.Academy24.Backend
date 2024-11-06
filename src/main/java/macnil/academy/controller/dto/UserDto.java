package macnil.academy.controller.dto;

import java.time.LocalDate;

import javax.persistence.Column;

public class UserDto {
    private Long id;
     private String firstname;
    private String city;
    private String email;
    private String role;
    private String password;
    private Long generatedCode;
    private LocalDate dateGeneratedCode;
    private LocalDate created_at;
    private String workingTime;
    public UserDto() {
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
}
