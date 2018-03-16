package services;

import dao.JPA.Interface.IHeartsDao;
import domain.Account;
import domain.Heart;
import domain.Message;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HeartServiceTest {

    private Heart heart;
    private Account account;
    private Account owner;
    private Message message;
    private HeartService heartService;

    @Mock
    private IHeartsDao heartsDao;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        heartService = new HeartService(heartsDao);
        account = new Account("first", null, null, "web", "location", "bio");
        owner = new Account("second", null, null, "web", "location", "bio");
        message = new Message();
        heart = new Heart(null, null);
    }
}
