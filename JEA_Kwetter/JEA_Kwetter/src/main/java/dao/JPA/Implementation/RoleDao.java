package dao.JPA.Implementation;

import dao.JPA.Interface.IRoleDao;
import domain.Account;
import domain.Role;

import java.util.ArrayList;

public class RoleDao extends GenericDao<Role> implements IRoleDao {

    public ArrayList<Account> getAccountsWithRole(String RoleName) {
        return null;
    }
}
