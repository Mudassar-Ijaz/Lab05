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

        // The client's "innocent" edit corrupted the Authenticator's own cache.
        assertNotEquals(originalId, auth.peekCachedId(),
                "Modifying the returned char[] should have corrupted internal state");
        assertEquals("*****" + originalId.substring(5), auth.peekCachedId());
    }

    @Test
    public void testSecureMethodProtectsInternalState() {
        Authenticator auth = new Authenticator();
        String originalId = auth.peekCachedId();

        String secureId = auth.getMitIdSecure("student1");
        String transformed = secureId.toUpperCase(); // creates a new String, doesn't mutate

        assertEquals(originalId, auth.peekCachedId(),
                "Internal state must remain unchanged after client uses the String");
        assertNotNull(transformed);
    }
}
