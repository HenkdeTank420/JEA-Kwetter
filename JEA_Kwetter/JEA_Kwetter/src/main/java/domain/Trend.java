package domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Trend {

    @Id
    @GeneratedValue
    private Long Id;
    @Column(unique = true)

    private String Name;

    public Trend( String name){
        this.Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
