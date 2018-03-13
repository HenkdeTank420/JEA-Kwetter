package dao.JPA.Interface;

import domain.Account;

import java.util.ArrayList;

public interface IAccountDao extends IGenericDao<Account> {
    Account findByName(String name);

    ArrayList<Account> getAllFollowersOfAccount(String userName);

    ArrayList<Account> getAllFolloweesOfAccount(String userName);

    Account addFollower(Account user, Account follower);

    Account addFollowee(Account user, Account followee);
}
