package dao.JPA.Interface;

import domain.Message;

import java.util.List;

public interface IMessageDao extends IGenericDao<Message> {

    List<Message> findMessagesOfAccount(String userName);

    List<Message> findMessagesWithWordInText(String word);
}
