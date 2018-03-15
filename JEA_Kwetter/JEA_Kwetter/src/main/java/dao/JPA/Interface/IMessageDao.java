package dao.JPA.Interface;

import domain.Account;
import domain.Heart;
import domain.Message;
import domain.Trend;

import java.util.ArrayList;
import java.util.List;

public interface IMessageDao extends IGenericDao<Message> {

    List<Message> findMessagesOfAccount(String userName);

    List<Message> findMessagesWithWordInText(String word);

    Message addTrend(Message message, Trend trend);

    Message addAccount(Message message, Account account);

    Message addHeart(Message message, Heart heart);

    ArrayList<Message> getAllObjects();
}
