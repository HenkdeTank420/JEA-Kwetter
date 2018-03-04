package dao.JPA.Implementation;

import dao.JPA.Interface.IGenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

public class GenericDao implements IGenericDao {

    @PersistenceContext(name = "Kwetter")
    protected EntityManager em;

    private class<T> type;

    @Override
    public void add(Object object) {

    }

    @Override
    public void delete(Object object) {

    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public Object findObject(Object object) {
        return null;
    }

    @Override
    public ArrayList getAllObjects() {
        return null;
    }
}
