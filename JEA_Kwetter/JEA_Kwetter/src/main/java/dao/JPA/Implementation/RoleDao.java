package dao.JPA.Implementation;

import dao.JPA.Interface.IRoleDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Account;
import domain.Role;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
@JPAKwetter
public class RoleDao extends GenericDao<Role> implements IRoleDao {

    public List<Role> getAccountsWithRole(String RoleName) {
        TypedQuery<Role> query = em.createNamedQuery("role.accountsWithRole", Role.class);
        query.setParameter("name", RoleName);
        List<Role> result = query.getResultList();
        return result;
    }

    public void addAccountToRole(Account account, Role role){
        ArrayList<Account> accounts = new ArrayList<Account>();
        accounts.add(account);
        role.setAccountsWithThisRole(accounts);
        em.persist(role);
    }
}
