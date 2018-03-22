package services;

import dao.JPA.Interface.IUserDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Account;
import domain.User;

import javax.inject.Inject;

public class UserService {

    @Inject
    @JPAKwetter
    private IUserDao userDao;

    public UserService(){

    }

    public User create(User user){ return this.userDao.add(user);}

    public void remove(User user){this.userDao.delete(user);}

    public User findByName(String userName){return this.userDao.findUserByName(userName);}
}
