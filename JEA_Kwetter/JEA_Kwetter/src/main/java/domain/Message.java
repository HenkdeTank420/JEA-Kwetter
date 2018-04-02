package domain;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "message.findMessageByName", query = "SELECT m FROM Message m WHERE m.Owner.user.username = :name"),
        @NamedQuery(name = "message.findMessageByWord", query = "SELECT m FROM Message m WHERE m.Text = :word")})
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Account Owner;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Account> Mentions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "message")
    private List<Trend> Trends;

    private String Text;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Heart> Hearts;

    public Message(){

    }

    public Message(Account owner, String text){
        this.Owner = owner;
        this.Text = text;
    }

    public JsonObject convertToJson(){
        return Json.createObjectBuilder()
                .add("id", this.Id)
                .add("owner", this.Owner.getUser().getUsername())
                .add("mentions", this.Mentions.size())
                .add("trend", this.Trends.size())
                .add("text", this.Text)
                .add("hearts", this.Hearts.size())
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
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public List<Heart> getHearts() {
        return Hearts;
    }

    public void setHearts(List<Heart> hearts) {
        Hearts = hearts;
    }
}
