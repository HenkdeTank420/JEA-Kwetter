package dao.JPA.Interface;

import domain.Message;

public interface IMessageDao extends IGenericDao<Message> {

    Message findMessagesOfAccount(String userName);

    Message findMessagesWithWordInText(String word);
}
