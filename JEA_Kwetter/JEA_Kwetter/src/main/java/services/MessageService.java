package services;

import dao.JPA.Interface.IMessageDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Account;
import domain.Heart;
import domain.Message;
import domain.Trend;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class MessageService {

    @Inject
    @JPAKwetter
    private IMessageDao messageDao;

    public MessageService(){

    }

    public MessageService(IMessageDao messageDao){
        this.messageDao = messageDao;
    }

    public Message create(Message message){return this.messageDao.add(message);}

    public void delete(Message message){this.messageDao.delete(message);}

    public Message findById(Long id){
        return this.messageDao.findById(id);
    }

    public Message findMessage(Message message){
        return this.messageDao.findObject(message);
    }

    public ArrayList<Message> getAllMessages(){return this.messageDao.getAllObjects();}

    public List<Message> findMessagesOfAccount(String userName){return this.messageDao.findMessagesOfAccount(userName);}

    public List<Message> findMessgesWithWordInText(String word){return this.messageDao.findMessagesWithWordInText(word);}

    public Message addTrend(Message message, Trend trend){return this.messageDao.addTrend(message, trend);}

    public Message addAccount(Message message, Account account) {return this.messageDao.addAccount(message, account);}

    public Message addHeart(Message message, Heart heart) {return this.messageDao.addHeart(message, heart);}

    public Message addMention(Message message, Account mention) {return this.messageDao.addMention(message, mention);}

    public List<JsonObject> convertAllToJson(List<Message> messages) {
        List<JsonObject> convertedObjects = new ArrayList<>();
        for (Message message : messages) {
            convertedObjects.add(message.convertToJson());
        }
        return convertedObjects;
    }
}
