package Objects;

import java.util.HashMap;

public class UnsuccessfulLoginObject {
    private String email;
    private String password;
    private String error;
    public UnsuccessfulLoginObject(HashMap<String, String> TestData) {
        populateObject(TestData);

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

                case "error":
                    setError(TestData.get(Key));
                    break;
            }
        }
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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
