package domain;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String Username;

    @Size(min = 6, max = 30)
    private String Password;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    public User(){

    }

    public User(String username, String password){
        this.Username = username;
        this.Password = password;
    }

    public JsonObject convertToJson(){
        return Json.createObjectBuilder()
                .add("id", this.Id)
                .add("name", this.Username)
                .add("password", this.Password)
                .build();
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
