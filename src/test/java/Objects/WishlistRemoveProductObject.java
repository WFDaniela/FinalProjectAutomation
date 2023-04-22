package Objects;

import java.util.HashMap;

public class WishlistRemoveProductObject {
    private String email;
    private String password;
    private String message;

    public WishlistRemoveProductObject(HashMap<String, String> TestData) {
        populateObject(TestData);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    private void populateObject(HashMap<String, String> TestData){
        for (String Key : TestData.keySet()){
            switch (Key){
                case "email":
                    setEmail(TestData.get(Key));
                    break;
                case "password":
                    setPassword(TestData.get(Key));
                    break;
                case "message":
                    setMessage(TestData.get(Key));
                    break;
            }
        }
    }
}
