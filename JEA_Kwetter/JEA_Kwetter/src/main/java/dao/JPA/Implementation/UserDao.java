package dao.JPA.Implementation;

import dao.JPA.Interface.IUserDao;
import dao.JPA.Interface.JPAKwetter;
import domain.User;

import javax.ejb.Stateless;

@Stateless
@JPAKwetter
public class UserDao extends GenericDao<User> implements IUserDao{

    public User findUserByName(String userName) {
        return null;
    }
}
