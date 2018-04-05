package dao.JPA.Implementation;

import dao.JPA.Interface.IUserGroupDao;
import dao.JPA.Interface.JPAKwetter;
import domain.UserGroup;

import javax.ejb.Stateless;

@Stateless
@JPAKwetter
public class UserGroupDao extends GenericDao<UserGroup> implements IUserGroupDao {
}
