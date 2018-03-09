package dao.JPA.Implementation;

import dao.JPA.Interface.IRoleDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Account;
import domain.Role;

import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless
@JPAKwetter
public class RoleDao extends GenericDao<Role> implements IRoleDao {

    public ArrayList<Account> getAccountsWithRole(String RoleName) {
        return null;
    }
}
