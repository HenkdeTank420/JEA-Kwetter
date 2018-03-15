package services;

import dao.JPA.Interface.IRoleDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Account;
import domain.Role;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class RoleService {

    @Inject
    @JPAKwetter
    private IRoleDao roleDao;

    public RoleService(){

    }

    public Role create(Role role){ return this.roleDao.add(role); }

    public void remove(Role role){ this.roleDao.delete(role);}

    public ArrayList<Role> getAllRoles(){return this.roleDao.getAllObjects();}

    public List<Role> getAllAccountsWithRole(String roleName){return this.roleDao.getAccountsWithRole(roleName);}

    public void addAccountToRole(Account account, Role role){this.roleDao.addAccountToRole(account, role);}
}
