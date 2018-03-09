package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Account implements Serializable{

    @Id
    @GeneratedValue
    private Long Id;

    @Column(unique = true)
    private String Username;

    @ManyToMany
    private List<Account> Followers;

    @ManyToMany
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
}
