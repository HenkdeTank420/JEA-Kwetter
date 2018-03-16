package domain;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Named
@NamedQueries({
        @NamedQuery(name = "account.findByname", query = "SELECT a FROM Account a WHERE a.Username = :name"),
        @NamedQuery(name = "account.findFollowers", query = "SELECT a.Followers FROM Account a WHERE a.Username = :name"),
        @NamedQuery(name = "account.findFollowees", query = "SELECT a.Followees FROM Account a WHERE a.Username = :name")})
public class Account implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String Username;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "accounts")
    private List<Account> Followers;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "accounts")
    private List<Account> Followees;

    private String Web;

    private String Location;

    private String Bio;

    public Account(){

    }

    public Account(String username, List<Account> followers, List<Account> followees, String web, String location, String bio){
        this.Username = username;
        this.Followers = followers;
        this.Followees = followees;
        this.Web = web;
        this.Location = location;
        this.Bio = bio;
    }

    public JsonObject convertToJson(){
        return Json.createObjectBuilder()
                .add("id", this.Id)
                .add("username", this.Username)
                .add("followers", this.Followers.size())
                .add("followees", this.Followees.size())
                .add("web", this.Web)
                .add("location", this.Location)
                .add("bio", this.Bio)
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

    @ManyToOne(optional = false)
    private Message messages;

    public Message getMessages() {
        return messages;
    }

    public void setMessages(Message messages) {
        this.messages = messages;
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
