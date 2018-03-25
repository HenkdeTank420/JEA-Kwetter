package JPA;

import dao.JPA.Implementation.AccountDao;
import dao.JPA.Implementation.UserDao;
import domain.Account;
import domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class UserDaoTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("KwetterTestPU");
    private EntityManager em;
    private EntityTransaction tx;

    private UserDao userDao;
    private User user;

    @Before
    public void setUp() {

        em = emf.createEntityManager();
        tx = em.getTransaction();

        this.userDao = new UserDao();
        userDao.setEm(em);

        user = new User("Violet", "password", "violet@email.com");
    }

        @Test
        public void create_ClassType_TypeCreated(){
            tx.begin();
            userDao.add(user);
            tx.commit();

            tx.begin();
            List<User> users = userDao.getAllObjects();
            tx.commit();

            Assert.assertEquals(1, users.size());
            Assert.assertNotEquals(2, users.size());
        }

    @Test
    public void delete_Type_TypeDeleted(){
        tx.begin();
        userDao.add(user);
        tx.commit();

        List<User> usersFound = userDao.getAllObjects();

        Assert.assertEquals(1, usersFound.size());
        Assert.assertNotEquals(0, usersFound.size());

        tx.begin();
        userDao.delete(user);
        tx.commit();

        List<User> userFoundDeleted = userDao.getAllObjects();

        Assert.assertEquals(0, userFoundDeleted.size());
        Assert.assertNotEquals(1, userFoundDeleted.size());
    }


    @Test
    public void findById_TypeLongId_TypeFound(){
        tx.begin();
        userDao.add(user);
        tx.commit();

        User userFound = userDao.findById(1L);

        Assert.assertEquals(user.getUsername(), userFound.getUsername());
    }

    @Test
    public void findAll_None_ListOfTypeFound(){
        User user1 = new User("Koen", "password", "koen@email.com");

        tx.begin();
        userDao.add(user);
        userDao.add(user1);
        tx.commit();

        List<User> usersFound = userDao.getAllObjects();

        Assert.assertEquals(2, usersFound.size());
        Assert.assertNotEquals(0, usersFound.size());
        Assert.assertNotEquals(1, usersFound.size());
    }
}
