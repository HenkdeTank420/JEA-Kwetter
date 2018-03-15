package dao.JPA.Interface;

import domain.Account;

import java.util.ArrayList;
import java.util.List;

public interface IAccountDao extends IGenericDao<Account> {

    Account findByName(String name);

    List<Account> getAllFollowersOfAccount(String userName);

    List<Account> getAllFolloweesOfAccount(String userName);

    Account addFollower(Account user, Account follower);

    Account addFollowee(Account user, Account followee);

    ArrayList<Account> getAllObjects();
}
