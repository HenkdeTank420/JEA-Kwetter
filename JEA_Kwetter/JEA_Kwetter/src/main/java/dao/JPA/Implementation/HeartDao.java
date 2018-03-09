package dao.JPA.Implementation;

import dao.JPA.Interface.IHeartsDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Account;
import domain.Heart;
import domain.Message;

import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless
@JPAKwetter
public class HeartDao extends GenericDao<Heart> implements IHeartsDao{

    public ArrayList<Heart> getAllHeartsOfMessage(Message message) {
        return null;
    }


    public ArrayList<Account> getAllHeartedAccountsOfMessage(Message message) {
        return null;
    }
}
