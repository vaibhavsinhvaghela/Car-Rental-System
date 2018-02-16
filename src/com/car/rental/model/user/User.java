package com.car.rental.model.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public abstract class User extends Observable{


    private int userId;
    private String userName;
//    private String userType;
    private String contactNumber;
    private String emailId;
    private String password;
    private Address address;
    private List<String> notifications;

    public User(int user_id,String user_name,String user_email,String user_password,Address user_address,String contact_num){

        this.userId=user_id;
        this.userName=user_name;
        this.emailId=user_email;
        this.password=user_password;
        this.address=user_address;
        this.contactNumber=contact_num;
        this.notifications = new ArrayList<>();
    }

    public Float getOwnerRating() {
        System.out.println("From User");
        return 0f;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContantNumber(String contantNumber) {
        this.contactNumber = contantNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<String> notifications) {
        this.notifications = notifications;
    }

    public void notify(String issue) {
        notifications.add(issue);
        System.out.print(this.userName + " notification:");
        System.out.println(issue);
    }
}
