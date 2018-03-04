package domain;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

@Entity
public class Role implements Serializable {

    private String Name;
    private List<Account> AccountsWithThisRole;

    public Role(String name, List<Account> accountsWithThisRole){
        this.Name = name;
        this.AccountsWithThisRole = accountsWithThisRole;
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
