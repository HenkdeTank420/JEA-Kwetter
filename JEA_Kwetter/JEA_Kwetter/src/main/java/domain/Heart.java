package domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Heart {

    @Id
    @GeneratedValue
    private Long Id;
    @Column(unique = true)

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
