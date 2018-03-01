package UnitTests;

import dao.UserDaoColl;
import domain.User;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.assertEquals;

public class TestUserDaoColl {

    private UserDaoColl userDaoColl;
    private CopyOnWriteArrayList<User> users;

    @BeforeClass
    public void testSetupUserDaoColl(){
        //userDaoColl = new UserDaoColl();

        users = new CopyOnWriteArrayList<>();
    }

    @Test
    public void testAddUser_WithCompleteUser_SuccesfulSaved(){
        User newUser = new User("IamNew", "myPassword");
        users = new CopyOnWriteArrayList<>();

        userDaoColl = new UserDaoColl(users);

        userDaoColl.addUser(newUser);

        assertEquals("The added users are the same", newUser, userDaoColl.findUserByName("IamNew"));
    }

    @Test
    public void testRemoveUser_WithCompleteUser_SuccesfullRemoved(){

    }
}
