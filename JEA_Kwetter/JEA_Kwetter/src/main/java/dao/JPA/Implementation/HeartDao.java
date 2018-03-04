package dao.JPA.Implementation;

import dao.JPA.Interface.IHeartsDao;
import domain.Account;
import domain.Heart;
import domain.Message;

import java.util.ArrayList;

public class HeartDao extends GenericDao<Heart> implements IHeartsDao{

    public ArrayList<Heart> getAllHeartsOfMessage(Message message) {
        return null;
    }


    public ArrayList<Account> getAllHeartedAccountsOfMessage(Message message) {
        return null;
    }
}
