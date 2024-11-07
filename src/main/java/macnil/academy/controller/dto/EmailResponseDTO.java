package macnil.academy.controller.dto;

public class EmailResponseDTO {
    private boolean exists;

    // Costruttore, getter e setter
    public EmailResponseDTO() {}

    public EmailResponseDTO(boolean exists) {
        this.exists = exists;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }
}
