package domain;

import org.eclipse.persistence.jpa.config.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "HelloGroup")
public class UserGroup implements Serializable {
    @Id
    private String groupName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="USER_GROUP",
            joinColumns = @JoinColumn(name = "groupName",
                    referencedColumnName = "groupname"),
            inverseJoinColumns = @JoinColumn(name = "userName",
                    referencedColumnName = "username"))
    private List<User> users;
    // getters, setters, no‐arg constructor

    public UserGroup(){
        this.users = new ArrayList<>();
    }

    public UserGroup(String groupName) {
        this();
        this.groupName = groupName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void addUser(User user) {
        this.users.add(user);
    }
}
