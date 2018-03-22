package services;

import dao.JPA.Interface.IHeartsDao;
import domain.Account;
import domain.Heart;
import domain.Message;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

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
        //account = new Account("first", null, null, "web", "location", "bio");
        //owner = new Account("second", null, null, "web", "location", "bio");
        message = new Message(owner, "text");
        heart = new Heart(account, message);
    }

    @Test
    public void getAllHeartsOfMessage_Message_GetAllHearts(){
        List<Heart> heartExpected = new ArrayList<>();
        heartExpected.add(heart);
        when(heartService.getAllHeartsOfMessage(1L)).thenReturn(heartExpected);
        List<Heart> heartFound = heartService.getAllHeartsOfMessage(1L);
        assertThat(heartFound, is(heartExpected));
    }

    @Test
    public void getAllHeartedAccountsOfMessage_Message_GetAllHearts(){
        List<Heart> heartExpected = new ArrayList<>();
        heartExpected.add(heart);
        when(heartService.getAllHeartedAccountsOfMessage(1L)).thenReturn(heartExpected);
        List<Heart> heartFound = heartService.getAllHeartsOfMessage(1L);
        assertThat(heartFound, is(heartExpected));
    }
}
