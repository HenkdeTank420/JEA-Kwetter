package services;

import com.mysql.jdbc.StringUtils;
import dao.JPA.Interface.IUserDao;
import dao.JPA.Interface.JPAKwetter;
import domain.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;
import utils.EncryptionHelper;

@Stateless
public class UserService {

    @Inject
    @JPAKwetter
    private IUserDao userDao;

    public UserService(){

    }

    public User create(User user){ return this.userDao.add(user);}

    public void remove(User user){this.userDao.delete(user);}

    public User findByName(String username){
        User user = this.userDao.findUserByName(username);
        return user;
    }

    public User findByCredentials(String username, String password) {
        if (!StringUtils.isNullOrEmpty(username) && !StringUtils.isNullOrEmpty(password)) {
            return this.userDao.findByCredentials(username, password);
        }
        return null;
    }

    public ArrayList<User> getAllUsers(){ return this.userDao.getAllObjects();}

    public List<JsonObject> convertAllToJson(List<User> users){
        List<JsonObject> convertedObjects = new ArrayList<>();
        for (User user : users) {
            convertedObjects.add(user.convertToJson());
        }
        return convertedObjects;
    }

    public User login(String username, String password) {
        if (!StringUtils.isNullOrEmpty(username) && !StringUtils.isNullOrEmpty(password)) {
            String lowerCaseUsername = username.toLowerCase();
            lowerCaseUsername = lowerCaseUsername.trim();

            User possibleUser = this.findByCredentials(lowerCaseUsername, password);

            if (possibleUser != null) return possibleUser;
        }
        return null;
    }
}
