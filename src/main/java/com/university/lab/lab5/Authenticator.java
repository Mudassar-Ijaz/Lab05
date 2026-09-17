package com.university.lab.lab5;

/**
 * Lab Task 4 - Immutability for Safer Contracts
 *
 * Demonstrates why returning a mutable object (char[]) from a method
 * exposes internal state to accidental corruption by the client, and how
 * returning an immutable object (String) instead acts as a safer
 * "firewall" between the internals of a class and the outside world.
 */
public class Authenticator {

    // Simulated cached ID, stored internally as a char array.
    private char[] cachedId = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * INSECURE: returns the actual internal char[] array, not a copy.
     * Any modification the caller makes to the returned array directly
     * corrupts this object's internal cached state, because arrays are
     * mutable and this method hands out a reference to the real one.
     *
     * @param username the username to look up (unused in this simplified demo)
     * @return the 9-digit ID as a mutable char array (a direct reference
     *         to internal state — DO NOT modify)
     */
    public char[] getMitId(String username) {
        return cachedId;
    }

    /**
     * SECURE: returns the ID as an immutable String. Strings in Java
     * cannot be mutated after creation, so no matter what the caller does
     * with the returned value, this object's internal state stays safe.
     * The immutable return type acts as a firewall: there is no API on
     * String that lets a caller reach back and alter this object's data.
     *
     * @param username the username to look up (unused in this simplified demo)
     * @return the 9-digit ID as an immutable String
     */
    public String getMitIdSecure(String username) {
        return new String(cachedId);
    }

    /** For test/demo purposes: lets us see the current cached value. */
    public String peekCachedId() {
        return new String(cachedId);
    }

    public static void main(String[] args) {
        Authenticator auth = new Authenticator();

        System.out.println("=== Insecure getMitId() ===");
        char[] insecureId = auth.getMitId("student1");
        System.out.println("Client received: " + new String(insecureId));

        // Client "innocently" modifies what they think is their own copy.
        for (int i = 0; i < 5; i++) {
            insecureId[i] = '*';
        }
        System.out.println("Client's array after modifying first 5 chars: " + new String(insecureId));
        System.out.println("Authenticator's internal cache is now CORRUPTED: " + auth.peekCachedId());

        // Reset for the secure demo
        auth = new Authenticator();

        System.out.println("\n=== Secure getMitIdSecure() ===");
        String secureId = auth.getMitIdSecure("student1");
        System.out.println("Client received: " + secureId);
        // There is no way to "modify" a String in place - any operation
        // (like toUpperCase()) creates a brand new String object.
        String attemptedChange = secureId.toUpperCase();
        System.out.println("Client's transformed copy: " + attemptedChange);
        System.out.println("Authenticator's internal cache is UNCHANGED: " + auth.peekCachedId());
    }
}
