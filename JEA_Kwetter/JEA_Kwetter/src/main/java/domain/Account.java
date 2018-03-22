package domain;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "account.findFollowers", query = "SELECT a.Followers FROM Account a WHERE a.user.Username = :name"),
        @NamedQuery(name = "account.findFollowees", query = "SELECT a.Followees FROM Account a WHERE a.user.Username = :name"),
        @NamedQuery(name = "account.findByName", query = "SELECT a FROM Account a WHERE a.user.Username = :name")})
public class Account implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "accounts")
    private List<Account> Followers;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "accounts")
    private List<Account> Followees;

    private String Web;

    private String Location;

    private String Bio;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Message> messages;

    @OneToOne(cascade = CascadeType.ALL)
    private Role role;

    public Account(){

    }

    public Account(User user, String web, String location, String bio){
        this.user = user;
        this.Web = web;
        this.Location = location;
        this.Bio = bio;
    }

    public JsonObject convertToJson(){
        return Json.createObjectBuilder()
                .add("id", this.Id)
                .add("user", this.user.getUsername())
                .add("followers", this.Followers.size())
                .add("followees", this.Followees.size())
                .add("web", this.Web)
                .add("location", this.Location)
                .add("bio", this.Bio)
                .add("messages", this.messages.size())
                .add("role", this.role.getId())
                .build();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Account> getFollowers() {
        return Followers;
    }

    public void setFollowers(List<Account> followers) {
        Followers = followers;
    }

    public List<Account> getFollowees() {
        return Followees;
    }

    public void setFollowees(List<Account> followees) {
        Followees = followees;
    }

    public String getWeb() {
        return Web;
    }

    public void setWeb(String web) {
        Web = web;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getBio() {
        return Bio;
    }

    public void setBio(String bio) {
        Bio = bio;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @ManyToMany
    private Collection<Account> accounts;

    public Collection<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<Account> accounts) {
        this.accounts = accounts;
    }
}
