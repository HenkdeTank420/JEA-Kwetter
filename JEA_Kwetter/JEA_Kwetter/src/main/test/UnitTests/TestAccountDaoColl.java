package UnitTests;

import dao.AccountDaoColl;
import domain.Account;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

public class TestAccountDaoColl {

    private static AccountDaoColl accountDaoColl;
    private static Account accountOne;
    private static Account accountTwo;
    private static Account accountThree;

    private static List<Account> followers = null;
    private static List<Account> followees = null;

    @BeforeClass
    public static void testSetupAccountDaoColl() {
        accountDaoColl = new AccountDaoColl();

        accountOne = new Account("Violet", followers, followees, "myWebsite", "Tilburg", "my bio");
        accountTwo = new Account("Thomas", followers, followees, "myWebsite", "Tilburg", "my bio");
        accountThree = new Account("Roy", followers, followees, "myWebsite", "Tilburg", "my bio");

        accountDaoColl.addAccount(accountOne);
        accountDaoColl.addAccount(accountTwo);
        accountDaoColl.addAccount(accountThree);
    }

    @Test
    public void testGetAccount_ExcistingAccount_FoundTheExcistingAccount(){
        assertEquals("The test was succesfull", accountOne, accountDaoColl.getAccount(accountOne));
    }

    @Test
    public void testAddAcount_NewAccount_AddedTheNewAccount(){
        Account newAccount = new Account("New", null, null, "myWebsite", "Tilburg", "my bio");
        accountDaoColl.addAccount(newAccount);
        assertEquals("New account added", newAccount, accountDaoColl.getAccount(newAccount));
    }

    @Test
    public void testRemoveAccount_ExcistingAccount_RemovedTheAccount(){
        
    }

    @Test
    public void testGetAllAccounts_ListWithAccount_TheExcistingList(){

    }

    @Test
    public void testFindAccountByName_ExcistingAcount_FoundTheExcistingAccount(){

    }

    @Test
    public void testGetAllFollowersOfAccount_ExcistingAccount_FoundListOfFollowers(){

    }

    @Test
    public void testGetAllFollowersOfAccount_ExcistingAccountWithoutFollowers_FoundEmptyList(){

    }

    @Test
    public void testGetAllFolloweesOfAccount_ExcistingAccount_FoundListOfFollowees(){

    }

    @Test
    public void testGetAllFolloweesOfAccount_ExcistingAccountWithoutFollowees_FoundEmptyList(){

    }
}
