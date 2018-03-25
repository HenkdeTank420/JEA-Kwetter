package dao.JPA.Implementation;

import dao.JPA.Interface.IAccountDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Account;
import domain.Message;

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
        query.setParameter("Username", userName);
        List<Account> result = query.getResultList();
        return result;
    }

    public List<Account> getAllFolloweesOfAccount(String userName) {
        TypedQuery<Account> query = em.createNamedQuery("account.findFollowees", Account.class);
        query.setParameter("Username", userName);
        List<Account> result = query.getResultList();
        return result;
    }

    @Override
    public Account findByName(String name){
        TypedQuery<Account> query = em.createNamedQuery("account.findByName", Account.class);
        query.setParameter("Username", name);
        List<Account> result = query.getResultList();
        return result.get(0);
    }

    @Override
    public Account addFollower(Account user, Account follower) {
        ArrayList<Account> followers = new ArrayList<>();
        followers.add(follower);
        user.setFollowers(followers);
        em.persist(user);

        ArrayList<Account> followees = new ArrayList<>();
        followees.add(user);
        follower.setFollowees(followees);
        em.persist(follower);
        return user;
    }

    @Override
    public Account addFollowee(Account user, Account followee) {
        ArrayList<Account> followees = new ArrayList<>();
        followees.add(followee);
        user.setFollowees(followees);
        em.persist(user);

        ArrayList<Account> followers = new ArrayList<>();
        followers.add(user);
        followee.setFollowers(followers);
        em.persist(followee);
        return user;
    }

    @Override
    public Account addMessage(Account account, Message message) {
        ArrayList<Message> messages = new ArrayList<>();
        messages.add(message);
        account.setMessages(messages);
        em.persist(account);

        message.setOwner(account);
        em.persist(message);
        return account;
    }

    @Override
    public ArrayList<Account> getAllObjects() {
        Query query = em.createQuery("SELECT a FROM Account a");
        return new ArrayList<>(query.getResultList());
    }
}
