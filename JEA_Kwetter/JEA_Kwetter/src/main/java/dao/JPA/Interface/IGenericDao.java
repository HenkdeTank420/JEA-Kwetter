package dao.JPA.Interface;

import java.util.List;

public interface IGenericDao<T> {

    T add(T object);

    void delete(T object);

    T findById(Long id);

    T findObject(T object);
}
