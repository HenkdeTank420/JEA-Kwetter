package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
public class Account implements Serializable{

    @Id
    @GeneratedValue
    private Long Id;

    @Column(unique = true)
    private String Username;

    private List<Account> Followers;

    private List<Account> Followees;

    private String Web;

    private String Location;

    private String Bio;

    public Account(String username, List<Account> followers, List<Account> followees, String web, String location, String bio){
        this.Username = username;
        this.Followers = followers;
        this.Followees = followees;
        this.Web = web;
        this.Location = location;
        this.Bio = bio;
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
