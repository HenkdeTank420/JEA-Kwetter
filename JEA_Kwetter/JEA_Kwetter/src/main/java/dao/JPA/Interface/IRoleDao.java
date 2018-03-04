package dao.JPA.Interface;

import domain.Account;
import domain.Role;

import java.util.ArrayList;

public interface IRoleDao extends IGenericDao<Role> {

    ArrayList<Account> getAccountsWithRole(String RoleName);
}
