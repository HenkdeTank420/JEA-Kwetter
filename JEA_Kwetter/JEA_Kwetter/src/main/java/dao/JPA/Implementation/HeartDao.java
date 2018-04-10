package dao.JPA.Implementation;

import dao.JPA.Interface.IHeartsDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Heart;
import domain.Message;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@JPAKwetter
public class HeartDao extends GenericDao<Heart> implements IHeartsDao{

    private Class<Message> type;

    public List<Heart> getAllHeartsOfMessage(Long id) {
        Message message = em.find(type, id);
        TypedQuery<Heart> query = em.createNamedQuery("heart.getAllHeartsOfMessage", Heart.class);
        query.setParameter("message", message);
        List<Heart> result = query.getResultList();
        return result;
    }


    public List<Heart> getAllHeartedAccountsOfMessage(Long id) {
        Message message = em.find(type, id);
        TypedQuery<Heart> query = em.createNamedQuery("heart.getAllAccountsThatHeartedOfMessage", Heart.class);
        query.setParameter("message", message);
        List<Heart> result = query.getResultList();
        return result;
    }
}
