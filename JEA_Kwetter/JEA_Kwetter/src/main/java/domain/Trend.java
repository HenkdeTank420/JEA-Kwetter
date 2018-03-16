package domain;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "trend.findByname", query = "SELECT t FROM Trend t WHERE t.Name = :trendName")})
public class Trend implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String Name;

    public Trend(){}

    public Trend(String name){
        this.Name = name;
    }

    public JsonObject convertToJson(){
        return Json.createObjectBuilder()
                .add("id", this.Id)
                .add("name", this.Name)
                .build();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
