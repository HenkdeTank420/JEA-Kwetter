package dao.JPA.Implementation;

import dao.JPA.Interface.IMessageDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Message;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
@JPAKwetter
public class MessageDao extends GenericDao<Message> implements IMessageDao {

    public List<Message> findMessagesOfAccount(String userName) {
        TypedQuery<Message> query = em.createNamedQuery("message.findMessageByName", Message.class);
        query.setParameter("name", userName);
        List<Message> result = query.getResultList();
        return result;
    }

    public List<Message> findMessagesWithWordInText(String word) {
        TypedQuery<Message> query = em.createNamedQuery("message.findMessageByWord", Message.class);
        query.setParameter("word", word);
        List<Message> result = query.getResultList();
        return result;
    }
}
