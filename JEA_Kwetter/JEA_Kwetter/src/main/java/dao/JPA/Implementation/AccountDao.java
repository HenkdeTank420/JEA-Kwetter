package dao.JPA.Implementation;

import dao.JPA.Interface.IAccountDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Account;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
@JPAKwetter
public class AccountDao extends GenericDao<Account> implements IAccountDao{

    public List<Account> getAllFollowersOfAccount(String userName) {
        TypedQuery<Account> query = em.createNamedQuery("account.findFollowers", Account.class);
        query.setParameter("name", userName);
        List<Account> result = query.getResultList();
        return result;
    }

    public List<Account> getAllFolloweesOfAccount(String userName) {
        TypedQuery<Account> query = em.createNamedQuery("account.findFollowees", Account.class);
        query.setParameter("name", userName);
        List<Account> result = query.getResultList();
        return result;
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
        ArrayList<Account> followers = new ArrayList<>();
        followers.add(follower);
        user.setFollowers(followers);
        em.persist(user);
        return user;
    }

    @Override
    public Account addFollowee(Account user, Account followee) {
        ArrayList<Account> followees = new ArrayList<>();
        followees.add(followee);
        user.setFollowees(followees);
        em.persist(user);
        return user;
    }

    public ArrayList<Account> getAllObjects() {
        Query query = em.createQuery("SELECT a FROM Account a");
        return new ArrayList<>(query.getResultList());
    }
}
