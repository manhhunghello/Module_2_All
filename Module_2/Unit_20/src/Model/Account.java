package Model;

import java.io.Serializable;

public class Account implements Serializable {
    static final long serialVersionUID = 1L;
    private int id;
    public  static  int idUpAccount;
    private String userName;
    private String passWord;
    private String fullName;
    private String phoneNumber;

    public Account() {
    }

    public Account(String userName, String passWord, String fullName, String phoneNumber) {
        this.id = ++idUpAccount;
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }
    public Account(int i, String s) {
    }


    public Account(String id, String userName, String password, String fullName, String phoneNumber, String address) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
