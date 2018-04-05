package services;

import dao.JPA.Interface.IUserGroupDao;
import dao.JPA.Interface.JPAKwetter;
import domain.UserGroup;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UserGroupService {

    @Inject
    @JPAKwetter
    private IUserGroupDao groupDao;

    public UserGroupService(){

    }
    public UserGroup create(UserGroup userGroup){ return this.groupDao.add(userGroup);}
}
