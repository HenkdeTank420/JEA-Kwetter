package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "message.findMessageByName", query = "SELECT m FROM Message m WHERE m.Owner.user.username = :name"),
        @NamedQuery(name = "message.findMessageByWord", query = "SELECT m FROM Message m WHERE m.text = :word")})
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private Account Owner;

    @JsonProperty("username")
    private String username;

    @OneToMany(cascade = CascadeType.DETACH)
    private List<Account> Mentions;

    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "message")
    private List<Trend> Trends;

    @JsonProperty("text")
    private String text;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Heart> Hearts;

    public Message(){

    }

    public Message(Account owner, String text){
        this.Owner = owner;
        this.text = text;
    }

    public JsonObject convertToJson(){
        return Json.createObjectBuilder()
                .add("id", this.Id)
                .add("owner", this.Owner.getUser().getUsername())
                .add("mentions", this.Mentions.size())
                .add("trend", this.Trends.size())
                .add("text", this.text)
                .add("hearts", this.Hearts.size())
                .add("username", this.username)
                .build();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Account getOwner() {
        return Owner;
    }

    public void setOwner(Account owner) {
        Owner = owner;
    }

    public List<Account> getMentions() {
        return Mentions;
    }

    public void setMentions(List<Account> mentions) {
        Mentions = mentions;
    }

    public List<Trend> getTrends() {
        return Trends;
    }

    public void setTrends(List<Trend> trends) {
        Trends = trends;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Heart> getHearts() {
        return Hearts;
    }

    public void setHearts(List<Heart> hearts) {
        Hearts = hearts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
