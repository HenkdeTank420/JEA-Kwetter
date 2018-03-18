package services;

import dao.JPA.Interface.IMessageDao;
import domain.Message;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest {

    private Message message;
    private MessageService messageService;

    @Mock
    private IMessageDao messageDao;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        messageService = new MessageService(messageDao);
    }
}
