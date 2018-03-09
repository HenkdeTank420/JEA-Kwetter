package dao.JPA.Implementation;

import dao.JPA.Interface.IMessageDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Message;

import javax.ejb.Stateless;

@Stateless
@JPAKwetter
public class MessageDao extends GenericDao<Message> implements IMessageDao {

    public Message findMessagesOfAccount(String userName) {
        return null;
    }


    public Message findMessagesWithWordInText(String word) {
        return null;
    }
}
