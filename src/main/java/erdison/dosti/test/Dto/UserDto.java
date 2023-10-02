package erdison.dosti.test.Dto;

public class UserDto {
    private String userId;
    private String username;
    private String email;

    // Costruttore vuoto necessario per la deserializzazione JSON
    public UserDto() {
    }

    public UserDto(String id, String username, String email) {
        this.userId = id;
        this.username = username;
        this.email = email;
    }

    // Metodi getter e setter per i campi
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

