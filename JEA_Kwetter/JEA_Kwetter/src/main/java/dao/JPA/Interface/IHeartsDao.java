package dao.JPA.Interface;

import domain.Account;
import domain.Heart;
import domain.Message;

import java.util.ArrayList;

public interface IHeartsDao extends IGenericDao<Heart> {

    ArrayList<Heart> getAllHeartsOfMessage(Message message);

    ArrayList<Account> getAllHeartedAccountsOfMessage(Message message);


}
