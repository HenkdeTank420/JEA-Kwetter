package JPA;

import dao.JPA.Implementation.AccountDao;
import domain.Account;
import domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountDaoTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("KwetterTestPU");
    private EntityManager em;
    private EntityTransaction tx;

    private AccountDao accountDao;
    private Account account;
    private User user;

    @Before
    public void setUp(){

        em = emf.createEntityManager();
        tx = em.getTransaction();

        this.accountDao = new AccountDao();
        accountDao.setEm(em);

        user = new User("Violet", "password", "violet@email.com");
        account = new Account(user, "my_web.com", "Tilburg", "my bio");

    }

    @Test
    public void create_ClassType_TypeCreated(){
        tx.begin();
        accountDao.add(account);
        tx.commit();

        tx.begin();
        List<Account> accounts = accountDao.getAllObjects();
        tx.commit();

        Assert.assertEquals(1, accounts.size());
        Assert.assertNotEquals(2, accounts.size());
    }
}
