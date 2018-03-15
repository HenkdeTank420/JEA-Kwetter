package services;

import dao.JPA.Interface.IMessageDao;
import dao.JPA.Interface.JPAKwetter;
import domain.Message;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class MessageService {

    @Inject
    @JPAKwetter
    private IMessageDao messageDao;

    public MessageService(){

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
}
