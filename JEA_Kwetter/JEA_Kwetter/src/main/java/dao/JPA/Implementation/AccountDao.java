package dao.JPA.Implementation;

import dao.JPA.Interface.IAccountDao;
import domain.Account;

import java.util.ArrayList;

public class AccountDao extends GenericDao<Account> implements IAccountDao{

    public ArrayList<Account> getAllFollowersOfAccount(String userName) {
        return null;
    }


    public ArrayList<Account> getAllFolloweesOfAccount(String userName) {
        return null;
    }
}
