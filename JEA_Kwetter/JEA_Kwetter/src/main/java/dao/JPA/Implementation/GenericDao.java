package dao.JPA.Implementation;

import dao.JPA.Interface.IGenericDao;
import dao.JPA.Interface.JPAKwetter;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;

@Stateless
@JPAKwetter
public class GenericDao<T> implements IGenericDao<T> {

    @PersistenceContext(unitName = "KwetterPU")
    protected EntityManager em;

    private Class<T> type;

    @Override
    public T add(T object) {
        em.persist(object);
        return object;
    }

    @Override
    public void delete(T object) {
        em.remove(object);
    }

    @Override
    public T findById(Long id) {
        return em.find(type, id);
    }

    @Override
    public T findObject(T object) {
        return em.find(type, object);
    }

    @Override
    public ArrayList<T> getAllObjects() {
        Query query = em.createQuery("SELECT a FROM Account a");
        return new ArrayList<>(query.getResultList());
    }
}
