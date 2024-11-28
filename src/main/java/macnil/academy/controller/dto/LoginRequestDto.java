package macnil.academy.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequestDto {
    @JsonProperty("user_email")
    private String email;
    @JsonProperty("user_password")
    private String password;
    public LoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public LoginRequestDto() {
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
}
