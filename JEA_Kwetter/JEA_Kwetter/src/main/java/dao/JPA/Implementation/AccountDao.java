package dao.JPA.Implementation;

import dao.JPA.Interface.IAccountDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Account;

import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless
@JPAKwetter
public class AccountDao extends GenericDao<Account> implements IAccountDao{

    public ArrayList<Account> getAllFollowersOfAccount(String userName) {
        return null;
    }


    public ArrayList<Account> getAllFolloweesOfAccount(String userName) {
        return null;
    }
}
