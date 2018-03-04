package dao.JPA.Interface;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface IGenericDao<T> {

    void add(T object);

    void delete(T object);

    T findById(int id);

    T findObject(T object);

    ArrayList<T> getAllObjects();
}
