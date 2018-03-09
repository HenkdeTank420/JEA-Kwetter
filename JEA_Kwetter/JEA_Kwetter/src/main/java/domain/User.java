package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable{

    @Id
    @GeneratedValue
    private Long Id;

    @Column(unique = true)
    private String Username;

    @Column(name = "password")
    private String Password;

    public User(){

    }

    public User(String username, String password){
        this.Username = username;
        this.Password = password;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
