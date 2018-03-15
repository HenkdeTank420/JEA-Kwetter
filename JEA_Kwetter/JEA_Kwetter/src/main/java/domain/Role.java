package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQuery(name = "role.accountsWithRole", query = "SELECT r.AccountsWithThisRole FROM Role r WHERE r.Name = :name")

public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Name;

    @OneToMany
    private List<Account> AccountsWithThisRole;

    public Role(){

    }

    public Role(String name, List<Account> accountsWithThisRole){
        this.Name = name;
        this.AccountsWithThisRole = accountsWithThisRole;
    }

    public long getId() {
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

    public List<Account> getAccountsWithThisRole() {
        return AccountsWithThisRole;
    }

    public void setAccountsWithThisRole(List<Account> accountsWithThisRole) {
        AccountsWithThisRole = accountsWithThisRole;
    }
}
