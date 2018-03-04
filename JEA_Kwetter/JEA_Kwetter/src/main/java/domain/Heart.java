package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Heart implements Serializable{

    @Id
    @GeneratedValue
    private Long Id;

    private Account Liker;

    private Message Liked;

    public Heart(Account liker, Message liked){
        this.Liker = liker;
        this.Liked = liked;
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
