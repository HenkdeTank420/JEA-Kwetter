package dao.JPA.Interface;

import domain.UserGroup;

public interface IUserGroupDao extends IGenericDao<UserGroup>  {
    UserGroup findUserByName(String groupName);
}
