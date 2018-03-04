package dao.JPA.Implementation;

import dao.JPA.Interface.IUserDao;
import domain.User;

public class UserDao extends GenericDao<User> implements IUserDao{

    public User findUserByName(String userName) {
        return null;
    }
}
