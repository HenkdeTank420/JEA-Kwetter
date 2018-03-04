package dao.JPA.Implementation;

import dao.JPA.Interface.IMessageDao;
import domain.Message;

public class MessageDao extends GenericDao<Message> implements IMessageDao {

    public Message findMessagesOfAccount(String userName) {
        return null;
    }


    public Message findMessagesWithWordInText(String word) {
        return null;
    }
}
