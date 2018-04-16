package services;

import dao.JPA.Interface.IRoleDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Account;
import domain.Role;

import javax.inject.Inject;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

public class RoleService {

    @Inject
    @JPAKwetter
    private IRoleDao roleDao;

    public RoleService(){    }

    public RoleService(IRoleDao roleDao){
        this.roleDao = roleDao;
    }

    public Role create(Role role){ return this.roleDao.add(role); }

    public void remove(Role role){ this.roleDao.delete(role);}

    public ArrayList<Role> getAllRoles(){return this.roleDao.getAllObjects();}

    public List<Role> getAllAccountsWithRole(String roleName){return this.roleDao.getAccountsWithRole(roleName);}

    public List<JsonObject> convertAllToJson(List<Role> roles) {
        List<JsonObject> convertedObjects = new ArrayList<>();
        for (Role role : roles) {
            convertedObjects.add(role.convertToJson());
        }
        return convertedObjects;
    }
}
