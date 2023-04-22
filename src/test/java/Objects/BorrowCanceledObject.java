package Objects;

import java.util.HashMap;

public class BorrowCanceledObject {
    private String email;
    private String password;
    private String title;
    private String author;

    private String cancelConfirm;

    public BorrowCanceledObject(HashMap<String, String> TestData) {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCancelConfirm() {
        return cancelConfirm;
    }

    public void setCancelConfirm(String cancelConfirm) {
        this.cancelConfirm = cancelConfirm;
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
                case "title":
                    setTitle(TestData.get(Key));
                    break;
                case "author":
                    setAuthor(TestData.get(Key));
                    break;
                case "cancelConfirm":
                    setCancelConfirm(TestData.get(Key));
                    break;
            }
        }
    }
}
