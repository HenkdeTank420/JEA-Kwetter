package dao.JPA.Interface;

import domain.Account;

import java.util.ArrayList;

public interface IAccountDao extends IGenericDao<Account> {

    ArrayList<Account> getAllFollowersOfAccount(String userName);

    ArrayList<Account> getAllFolloweesOfAccount(String userName);
}
