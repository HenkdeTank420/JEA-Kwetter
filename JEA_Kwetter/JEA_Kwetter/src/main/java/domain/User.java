package domain;

public class User {

    private String Username;
    private String Password;

    public User(String username, String password){
        this.Username = username;
        this.Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
