package dao.JPA.Implementation;

import dao.JPA.Interface.IMessageDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Account;
import domain.Heart;
import domain.Message;
import domain.Trend;

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

    public Message addTrend(Message message, Trend trend){
        ArrayList<Trend> trends = new ArrayList<>();
        trends.add(trend);
        message.setTrends(trends);
        em.persist(message);
        return message;
    }

    public Message addAccount(Message message, Account account){
        message.setOwner(account);
        em.persist(message);
        return message;
    }

    public Message addHeart(Message message, Heart heart){
        ArrayList<Heart> hearts = new ArrayList<>();
        hearts.add(heart);
        message.setHearts(hearts);
        em.persist(message);
        return message;
    }

    public ArrayList<Message> getAllObjects() {
        Query query = em.createQuery("SELECT a FROM Message a");
        return new ArrayList<>(query.getResultList());
    }
}
