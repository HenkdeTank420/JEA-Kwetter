package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "HelloUser")
@NamedQueries({
        @NamedQuery(name = "user.findByName", query = "SELECT u FROM User u WHERE u.username = :Username"),
        @NamedQuery(name = "user.findByCredentials", query = "SELECT u FROM User u " +
                "WHERE u.username = :username AND u.password = :password")})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    @JsonProperty("username")
    private String username;

    @Size(min = 6)
    @JsonProperty("password")
    private String password;

    @Email
    @JsonProperty("email")
    private String email;

    @ManyToMany(mappedBy = "users")
    private List<Group> groups;
    // getters, setters, no‐arg constructor

    public User(){

    }

    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public JsonObject convertToJson(){
        return Json.createObjectBuilder()
            .add("username", this.getUsername())
            .add("email", this.getEmail())
            .build();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
