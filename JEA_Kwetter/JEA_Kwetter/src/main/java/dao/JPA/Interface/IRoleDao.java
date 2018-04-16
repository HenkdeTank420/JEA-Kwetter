package dao.JPA.Interface;

import domain.Account;
import domain.Role;

import java.util.ArrayList;
import java.util.List;

public interface IRoleDao extends IGenericDao<Role> {

    List<Role> getAccountsWithRole(String RoleName);

    ArrayList<Role> getAllObjects();
}
