package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Role implements Serializable {

    @Id
    @GeneratedValue
    private Long Id;

    private String Name;

    @OneToMany
    private List<Account> AccountsWithThisRole;

    public Role(String name, List<Account> accountsWithThisRole){
        this.Name = name;
        this.AccountsWithThisRole = accountsWithThisRole;
    }

    public long getId() {
        return Id;
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
