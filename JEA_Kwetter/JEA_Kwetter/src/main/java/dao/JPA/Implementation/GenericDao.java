package dao.JPA.Implementation;

import dao.JPA.Interface.IGenericDao;
import dao.JPA.Interface.JPAKwetter;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Stateless
@JPAKwetter
public class GenericDao<T> implements IGenericDao<T> {

    @PersistenceContext(unitName = "KwetterPU")
    protected EntityManager em;

    private Class<T> type;

    public GenericDao() {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.type = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
    }

    @Override
    public T add(T object) {
        this.em.persist(object);
        return object;
    }

    @Override
    public T update(T t) {
        return this.em.merge(t);
    }

    @Override
    public void delete(T t) {
        t = em.merge(t);
        em.remove(t);
    }

    public void deleteById(Long id) {
        this.delete(findById(id));
    }

    @Override
    public T findById(Long id) {
        return em.find(type, id);
    }

    @Override
    public T findObject(T object) {
        return em.find(type, object);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}

