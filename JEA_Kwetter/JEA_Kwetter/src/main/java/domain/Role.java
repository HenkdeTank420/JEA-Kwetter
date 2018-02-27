package domain;

import java.util.List;

public class Role {

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
