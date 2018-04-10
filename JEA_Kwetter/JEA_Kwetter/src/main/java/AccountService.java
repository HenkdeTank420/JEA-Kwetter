package services;

import dao.JPA.Interface.IAccountDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Account;
import domain.Message;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class AccountService {

    @Inject
    @JPAKwetter
    private IAccountDao accountDao;

    public AccountService(){

    }

    public AccountService(IAccountDao accountDao){
        this.accountDao = accountDao;
    }

    public Account create(Account account){
        return this.accountDao.add(account);
    }

    public void delete(Account account){
        this.accountDao.delete(account);
    }

    public Account findByName(String name){ return this.accountDao.findByName(name); }

    public Account findById(Long id){
        return this.accountDao.findById(id);
    }

    public Account findAccount(Account account){
        return this.accountDao.findObject(account);
    }

    public ArrayList<Account> getAllAccounts(){return this.accountDao.getAllObjects();}

    public List<Account> getAllFollowers(String userName){return this.accountDao.getAllFollowersOfAccount(userName);}

    public List<Account> getAllFollowees(String userName){return this.accountDao.getAllFolloweesOfAccount(userName);}

    public Account addFollower(Account user, Account follower){return this.accountDao.addFollower(user, follower);}

    public Account addFollowee(Account user, Account followee){return this.accountDao.addFollowee(user, followee);}

    public Account addMessage(Account account, Message message){return this.accountDao.addMessage(account, message);}

    public List<JsonObject> convertAllToJson(List<Account> accounts){
        List<JsonObject> convertedObjects = new ArrayList<>();
        for (Account account : accounts) {
            convertedObjects.add(account.convertToJson());
        }
        return convertedObjects;
    }
}
