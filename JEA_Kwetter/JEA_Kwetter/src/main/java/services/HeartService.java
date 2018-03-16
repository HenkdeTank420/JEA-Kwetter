package services;

import dao.JPA.Implementation.HeartDao;
import dao.JPA.Interface.IHeartsDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Account;
import domain.Heart;
import domain.Message;

import javax.inject.Inject;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

public class HeartService {

    @Inject
    @JPAKwetter
    private IHeartsDao heartsDao;

    public HeartService(){

    }

    public HeartService(IHeartsDao heartsDao){
        this.heartsDao = heartsDao;
    }

    public Heart create(Heart heart){ return this.heartsDao.add(heart);}

    public void remove(Heart heart){ this.heartsDao.delete(heart);}

    public List<Heart> getAllHeartsOfMessage(Long message){ return this.heartsDao.getAllHeartsOfMessage(message);}

    public List<Heart> getAllHeartedAccountsOfMessage(Long message) {return this.heartsDao.getAllHeartedAccountsOfMessage(message);}

    public List<JsonObject> convertAllToJson(List<Heart> hearts) {
        List<JsonObject> convertedObjects = new ArrayList<>();
        for (Heart heart : hearts) {
            convertedObjects.add(heart.convertToJson());
        }
        return convertedObjects;
    }
}
