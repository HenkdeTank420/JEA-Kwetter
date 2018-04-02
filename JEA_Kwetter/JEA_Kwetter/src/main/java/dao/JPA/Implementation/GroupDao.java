package dao.JPA.Implementation;

import dao.JPA.Interface.IGroupDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Group;

import javax.ejb.Stateless;

@Stateless
@JPAKwetter
public class GroupDao extends GenericDao<Group> implements IGroupDao {
}
