package stressTests;

import com.google.common.hash.Hashing;
import org.junit.Assert;
import org.junit.Test;
import utils.EncryptionHelper;

import java.security.InvalidKeyException;

public class stressTests {

    @Test
    public void HashingStressTest() throws InvalidKeyException{
        for(int i = 0; i < 100; i++){
            EncryptionHelper.encryptData("Nyello");
        }
        Assert.assertTrue(true);
    }
}
