package domain;

import javax.json.Json;
import javax.json.JsonObject;
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

    @ManyToOne(cascade = CascadeType.ALL)
    private Account Liker;

    @ManyToOne(cascade = CascadeType.ALL)
    private Message Liked;

    public Heart(){

    }

    public Heart(Account liker, Message liked){
        this.Liker = liker;
        this.Liked = liked;
    }

    public JsonObject convertToJson(){
        return Json.createObjectBuilder()
                .add("id", this.Id)
                .add("liker", this.Liker.getUsername())
                .add("liked", this.Liked.getId())
                .build();
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
