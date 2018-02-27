package domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

public class Message {

    @Id
    @GeneratedValue
    private Long Id;
    @Column(unique = true)

    private String Owner;
    private List<Account> Mentions;
    private List<Trend> Trends;
    private String Text;
    private List<Heart> Hearts;

    public Message(String owner, List<Account> mentions, List<Trend> trends, String text, List<Heart> hearts){
        this.Owner = owner;
        this.Mentions = mentions;
        this.Trends = trends;
        this.Text = text;
        this.Hearts = hearts;
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
