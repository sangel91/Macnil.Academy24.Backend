package macnil.academy.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import net.bytebuddy.asm.Advice.Return;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fullname", nullable = true)
    private String firstname;
    @Column(name = "city", nullable = true)
    private String city;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
     @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;
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
    public User() {
    }
    public User(String firstname, Role role, String password) {
        this.firstname = firstname;
        this.role = role;
        this.password = password;
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
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return authorities;
    }
    @Override
    public String getUsername() {
        return this.email;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
       return true;
    }
    public enum Role {
        USER,
        ADMIN
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    


}