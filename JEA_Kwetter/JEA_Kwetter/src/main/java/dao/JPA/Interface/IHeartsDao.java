package dao.JPA.Interface;

import domain.Account;
import domain.Heart;
import domain.Message;

import java.util.ArrayList;
import java.util.List;

public interface IHeartsDao extends IGenericDao<Heart> {

    List<Heart> getAllHeartsOfMessage(Long id);

    List<Heart> getAllHeartedAccountsOfMessage(Long id);


}
