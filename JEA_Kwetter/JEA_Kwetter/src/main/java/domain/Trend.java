package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Trend implements Serializable {

    @Id
    @GeneratedValue
    private Long Id;

    @Column(unique = true)
    private String Name;

    public Trend(){}

    public Trend( String name){
        this.Name = name;
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
