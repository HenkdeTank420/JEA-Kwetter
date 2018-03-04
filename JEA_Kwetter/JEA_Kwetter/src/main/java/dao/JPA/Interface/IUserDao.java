package dao.JPA.Interface;

import domain.User;

public interface IUserDao extends IGenericDao<User>{

    User findUserByName(String userName);
}
