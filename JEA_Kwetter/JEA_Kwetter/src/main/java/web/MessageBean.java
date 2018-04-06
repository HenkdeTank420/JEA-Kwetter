package web;

import domain.Message;
import services.MessageService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("messageBean")
@ViewScoped
public class MessageBean implements Serializable {

    @Inject
    private MessageService messageService;
    private List<Message> messageList;
    private Message message;

    @PostConstruct
    public void init(){
        this.messageList = messageService.getAllMessages();
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
