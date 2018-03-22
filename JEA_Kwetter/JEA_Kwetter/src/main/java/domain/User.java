package domain;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "account.findByname", query = "SELECT u FROM User u WHERE u.Username = :name")})
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String Username;

    @Size(min = 6, max = 30)
    private String Password;

    private String email;

    public User(){

    }

    public User(String username, String password, String email){
        this.Username = username;
        this.Password = password;
        this.email = email;
    }

    public JsonObject convertToJson(){
        return Json.createObjectBuilder()
                .add("id", this.Id)
                .add("name", this.Username)
                .add("password", this.Password)
                .add("email", this.email)
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
