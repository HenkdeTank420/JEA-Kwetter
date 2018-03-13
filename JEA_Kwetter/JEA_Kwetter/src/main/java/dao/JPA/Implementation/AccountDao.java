package dao.JPA.Implementation;

import dao.JPA.Interface.IAccountDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Account;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
@JPAKwetter
public class AccountDao extends GenericDao<Account> implements IAccountDao{

    public ArrayList<Account> getAllFollowersOfAccount(String userName) {
        return null;
    }

    public ArrayList<Account> getAllFolloweesOfAccount(String userName) {
        return null;
    }

    @Override
    public Account findByName(String name){
        TypedQuery<Account> query = em.createNamedQuery("account.findByname", Account.class);
        query.setParameter("name", name);
        List<Account> result = query.getResultList();
        return result.get(0);
    }

    @Override
    public Account addFollower(Account user, Account follower) {
        return null;
    }

    @Override
    public Account addFollowee(Account user, Account followee) {
        return null;
    }
}
