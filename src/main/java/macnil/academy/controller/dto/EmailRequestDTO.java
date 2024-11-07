package macnil.academy.controller.dto;

public class EmailRequestDTO {
    private String email;

    // Costruttore, getter e setter
    public EmailRequestDTO() {}

    public EmailRequestDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
