package com.university.lab.lab5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthenticatorTest {

    @Test
    public void testInsecureMethodExposesInternalStateToCorruption() {
        Authenticator auth = new Authenticator();
        String originalId = auth.peekCachedId();

        char[] leaked = auth.getMitId("student1");
        for (int i = 0; i < 5; i++) {
            leaked[i] = '*';
        }

       
        assertNotEquals(originalId, auth.peekCachedId(),
                "Modifying the returned char[] should have corrupted internal state");
        assertEquals("*****" + originalId.substring(5), auth.peekCachedId());
    }

    @Test
    public void testSecureMethodProtectsInternalState() {
        Authenticator auth = new Authenticator();
        String originalId = auth.peekCachedId();

        String secureId = auth.getMitIdSecure("student1");
        String transformed = secureId.toUpperCase(); 
        assertEquals(originalId, auth.peekCachedId(),
                "Internal state must remain unchanged after client uses the String");
        assertNotNull(transformed);
    }
}
