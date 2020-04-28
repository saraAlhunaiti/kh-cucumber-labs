package automationpractice;

import java.util.UUID;

public class User {
    public static final String EMAIL_START = "tester";
    public static final String EMAIL_END = "testing.com";
    private UUID uuid;
    private String email;


    public String generateEmail() {
        uuid = UUID.randomUUID();
        email = EMAIL_START + uuid.hashCode() + "@" + EMAIL_END;
        return email;

    }
    public String getPassword(){
        return "wibble";
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return uuid.hashCode() + "";
    }
}
