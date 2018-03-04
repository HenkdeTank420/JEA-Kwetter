package dao.JPA.Implementation;

import dao.JPA.Interface.IGenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

public class GenericDao<T> implements IGenericDao<T> {

    @PersistenceContext(name = "Kwetter")
    protected EntityManager em;

    private Class<T> type;

    @Override
    public void add(T object) {
        em.persist(object);
    }

    @Override
    public void delete(T object) {
        em.remove(object);
    }

    @Override
    public T findById(int id) {
        return em.find(type, id);
    }

    @Override
    public T findObject(T object) {
        return em.find(type, object);
    }

    @Override
    public ArrayList<T> getAllObjects() {
        em.createEntityGraph(type);
        return null;
    }
}
