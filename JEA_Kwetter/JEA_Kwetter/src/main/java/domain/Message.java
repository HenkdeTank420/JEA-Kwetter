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

    public Message(String owner, List<Account> mentions, List<Trend> trends){
        this.Owner = owner;
        this.Mentions = mentions;
        this.Trends = trends;
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
}
