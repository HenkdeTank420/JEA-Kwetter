package dao.JPA.Implementation;

import dao.JPA.Interface.IUserDao;
import dao.JPA.Interface.JPAKwetter;
import domain.User;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
@JPAKwetter
public class UserDao extends GenericDao<User> implements IUserDao {

    public User findUserByName(String userName) {
        TypedQuery<User> query = em.createNamedQuery("user.findByName", User.class);
        query.setParameter("Username", userName);
        List<User> result = query.getResultList();
        return result.get(0);
    }

    @Override
    public ArrayList<User> getAllObjects() {
        Query query = em.createQuery("SELECT u FROM User u");
        return new ArrayList<>(query.getResultList());
    }

    public User findByCredentials(String username, String encryptedPassword) {
        return em.createNamedQuery("user.findByCredentials", User.class)
                .setParameter("username", username)
                .setParameter("password", encryptedPassword)
                .getSingleResult();
    }
}

