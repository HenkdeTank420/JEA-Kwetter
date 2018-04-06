package dao.JPA.Implementation;

import dao.JPA.Interface.IUserGroupDao;
import dao.JPA.Interface.JPAKwetter;
import domain.UserGroup;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@JPAKwetter
public class UserGroupDao extends GenericDao<UserGroup> implements IUserGroupDao {

    public UserGroup findUserByName(String groupName) {
        TypedQuery<UserGroup> query = em.createNamedQuery("userGroup.findByGroupName", UserGroup.class);
        query.setParameter("groupName", groupName);
        List<UserGroup> result = query.getResultList();
        return result.get(0);
    }
}
