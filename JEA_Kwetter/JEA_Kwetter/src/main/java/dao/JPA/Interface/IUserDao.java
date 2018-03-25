package dao.JPA.Interface;

import domain.User;

import java.util.ArrayList;

public interface IUserDao extends IGenericDao<User>{

    User findUserByName(String userName);

    ArrayList<User> getAllObjects();

    User findByCredentials(String username, String password);
}
