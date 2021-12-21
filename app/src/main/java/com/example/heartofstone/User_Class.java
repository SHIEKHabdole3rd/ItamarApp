package com.example.heartofstone;

public class User_Class {
    public String Username;
    public String Password;
    public String Email;
    public Integer PhoneNum;
    public Integer Age;
    public boolean admin;

    public User_Class(String username, String password, String email, Integer phoneNum, Integer age) {
        Username = username;
        Password = password;
        Email = email;
        PhoneNum = phoneNum;
        Age = age;
        admin= false;
    }

    public User_Class(){}

    /*public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(Integer phoneNum) {
        PhoneNum = phoneNum;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }
     */
}

