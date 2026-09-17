package com.university.lab.lab5;


public class Authenticator {

   
    private char[] cachedId = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

                public char[] getMitId(String username) {
        return cachedId;
    }

    
        public String getMitIdSecure(String username) {
        return new String(cachedId);
    }

   
    public String peekCachedId() {
                return new String(cachedId);
    }

    public static void main(String[] args) {
        Authenticator auth = new Authenticator();

        System.out.println("=== Insecure getMitId() ===");
        char[] insecureId = auth.getMitId("student1");
            System.out.println("Client received: " + new String(insecureId));

       
        for (int i = 0; i < 5; i++) {
            insecureId[i] = '*';
        }
            System.out.println("Client's array after modifying first 5 chars: " + new String(insecureId));
        System.out.println("Authenticator's internal cache is now CORRUPTED: " + auth.peekCachedId());

       
        auth = new Authenticator();

        System.out.println("\n=== Secure getMitIdSecure() ===");
            String secureId = auth.getMitIdSecure("student1");
                    System.out.println("Client received: " + secureId);
     
        String attemptedChange = secureId.toUpperCase();
            System.out.println("Client's transformed copy: " + attemptedChange);
        System.out.println("Authenticator's internal cache is UNCHANGED: " + auth.peekCachedId());
    }
}
