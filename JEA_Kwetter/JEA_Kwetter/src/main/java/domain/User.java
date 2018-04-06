package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import utils.EncryptionHelper;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "user.findByName", query = "SELECT u FROM User u WHERE u.username = :Username"),
        @NamedQuery(name = "user.findByCredentials", query = "SELECT u FROM User u " +
                "WHERE u.username = :username AND u.password = :password")})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @JsonProperty("username")
    private String username;

    @JsonIgnore
    private String password;

    @Email
    @JsonProperty("email")
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "users")
    private List<UserGroup> userGroups;

    public User() {
        this.userGroups = new ArrayList<>();
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.email = email;
        try {
            this.password = EncryptionHelper.encryptData(password);
        } catch (Exception ex) {
            System.out.println("exception message = " + ex.getMessage());
        }
    }

    public JsonObject convertToJson() {
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
        try {
            this.password = EncryptionHelper.encryptData(password);
        } catch (Exception ex) {
            System.out.println("exception message = " + ex.getMessage());
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(Id, user.Id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.Id);
        return hash;
    }
}
