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

    @Override
    public List<Message> findMessagesOfAccount(String userName) {
        TypedQuery<Message> query = em.createNamedQuery("message.findMessageByName", Message.class);
        query.setParameter("name", userName);
        List<Message> result = query.getResultList();
        return result;
    }

    @Override
    public List<Message> findMessagesWithWordInText(String word) {
        TypedQuery<Message> query = em.createNamedQuery("message.findMessageByWord", Message.class);
        query.setParameter("word", word);
        List<Message> result = query.getResultList();
        return result;
    }

    @Override
    public Message addTrend(Message message, Trend trend){
        ArrayList<Trend> trends = new ArrayList<>();
        trends.add(trend);
        message.setTrends(trends);
        em.persist(message);

        trend.setMessage(message);
        em.persist(trend);
        return message;
    }

    @Override
    public Message addAccount(Message message, Account account){
        message.setOwner(account);
        em.persist(message);

        ArrayList<Message> messages = new ArrayList<>();
        messages.add(message);
        account.setMessages(messages);
        em.persist(account);
        return message;
    }

    @Override
    public Message addHeart(Message message, Heart heart){
        ArrayList<Heart> hearts = new ArrayList<>();
        hearts.add(heart);
        message.setHearts(hearts);
        em.persist(message);

        heart.setLiked(message);
        em.persist(heart);
        return message;
    }

    @Override
    public Message addMention(Message message, Account mention){
        ArrayList<Account> mentions = new ArrayList<>();
        mentions.add(mention);
        message.setMentions(mentions);
        em.persist(message);
        return message;
    }

    @Override
    public ArrayList<Message> getAllObjects() {
        Query query = em.createQuery("SELECT a FROM Message a");
        return new ArrayList<>(query.getResultList());
    }
}
