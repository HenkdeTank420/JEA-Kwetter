package services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.EncryptionHelper;

import java.security.InvalidKeyException;

public class stressTests {

    @Before
    public void setUp(){

    }

    @Test
    public void HashingStressTest() {
        for(int i = 0; i < 1000000; i++){
            EncryptionHelper.encryptData("Nyello");
        }
        Assert.assertTrue(true);
    }
}
