package services;

import dao.JPA.Interface.IAccountDao;
import domain.Account;
import domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

    private Account first;
    private Account second;
    private AccountService accountService;
    private User userOne;
    private User userTwo;

    @Mock
    private IAccountDao accountDao;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        accountService = new AccountService(accountDao);

        userOne = new User("Violet", "password", "violet@email.com");
        userTwo = new User("Thomas", "password", "thomas@email.com");

        first = new Account(userOne, "web", "location", "bio");
        second = new Account(userTwo, "web", "location", "bio");
    }

    @Test
    public void createAccount_FullAccount_AccountAdded(){
        accountService.create(first);
        verify(accountDao, Mockito.times(1)).add(first);
    }

    @Test
    public void findAccount_AccountUserName_AccountFound(){
        when(accountService.findByName("Violet")).thenReturn(first);
        Account accountFound = accountService.findByName("Violet");
        assertThat(accountFound, is(first));
    }

    @Test
    public void findAccount_AccountId_AccountFound(){
        when(accountService.findById(1L)).thenReturn(first);
        Account accountFound = accountService.findById(1L);
        assertThat(accountFound, is(first));
    }

    @Test
    public void findAccount_Account_AccountFound(){
        when(accountService.findAccount(first)).thenReturn(first);
        Account accountFound = accountService.findAccount(first);
        assertThat(accountFound, is(first));
    }

    @Test
    public void getAllAccounts_Non_AcountsFound(){
        accountService.getAllAccounts();
        verify(accountDao, Mockito.times(1)).getAllObjects();
    }

    @Test
    public void addFollower_AccountAndFollower_FollowerAdded(){
        accountService.addFollower(first, second);
        verify(accountDao, Mockito.times(1)).addFollower(first, second);
    }

    @Test
    public void addFollowee_AccountAndFollowee_FolloweeAdded(){
        accountService.addFollowee(first, second);
        verify(accountDao, Mockito.times(1)).addFollowee(first, second);
    }

    @Test
    public void findFollower_AccountUsername_FollowersFound(){
        List<Account> accountExpected = new ArrayList<>();
        accountExpected.add(second);
        when(accountService.getAllFollowers("first")).thenReturn(accountExpected);
        List<Account> accountFound = accountService.getAllFollowers("first");
        assertThat(accountFound, is(accountExpected));
    }

    @Test
    public void findFollowee_AccountUsername_FolloweesFound(){
        List<Account> accountExpected = new ArrayList<>();
        accountExpected.add(second);
        when(accountService.getAllFollowees("first")).thenReturn(accountExpected);
        List<Account> accountFound = accountService.getAllFollowees("first");
        assertThat(accountFound, is(accountExpected));
    }

    @Test
    public void removeAccount_Account_AccountRemoved(){
        verify(accountDao, Mockito.times(0)).delete(first);
    }
}
