package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Message implements Serializable {

    @Id
    @GeneratedValue
    private Long Id;

    private String Owner;

    @OneToMany
    private List<Account> Mentions;

    @OneToMany
    private List<Trend> Trends;

    private String Text;

    @OneToMany
    private List<Heart> Hearts;

    public Message(){

    }

    public Message(String owner, List<Account> mentions, List<Trend> trends, String text, List<Heart> hearts){
        this.Owner = owner;
        this.Mentions = mentions;
        this.Trends = trends;
        this.Text = text;
        this.Hearts = hearts;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
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
