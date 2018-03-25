package dao.JPA.Interface;


public interface IGenericDao<T> {

    T add(T object);

    void delete(T object);

    void deleteById(Long id);

    T findById(Long id);

    T findObject(T object);
}
