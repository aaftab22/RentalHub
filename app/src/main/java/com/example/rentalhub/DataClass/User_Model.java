package com.example.rentalhub.DataClass;

public class User_Model {

    private String Password;
    private Integer Mobile_No;

    public User_Model() {
    }

    public User_Model(Integer mobile_No, String password) {

        Mobile_No = mobile_No;
        Password = password;
    }

    public Integer getMobile_No() {
        return Mobile_No;
    }

    public void setMobile_No(int mobile_No) {
        Mobile_No = mobile_No;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
