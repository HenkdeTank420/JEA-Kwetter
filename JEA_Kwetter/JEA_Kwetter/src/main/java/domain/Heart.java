package domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "heart.getAllHeartsOfMessage", query = "SELECT h FROM Heart h WHERE h.Liked = :message"),
        @NamedQuery(name = "heart.getAllAccountsThatHeartedOfMessage", query = "SELECT h.Liker FROM Heart h WHERE h.Liked = :message")
})
public class Heart implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    private Account Liker;

    @ManyToOne
    private Message Liked;

    public Heart(){

    }

    public Heart(Account liker, Message liked){
        this.Liker = liker;
        this.Liked = liked;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Account getLiker() {
        return Liker;
    }

    public void setLiker(Account liker) {
        Liker = liker;
    }

    public Message getLiked() {
        return Liked;
    }

    public void setLiked(Message liked) {
        Liked = liked;
    }
}
