package com.car.rental.model.user;

import java.util.ArrayList;

public class Owner extends User{


    private Float ownerRating;
    private int numOfRatings;
    private int totalPoints;
    private ArrayList<String> ownerComments;

    public Owner(int user_id,String user_name,String user_email,String user_password,Address user_address,String user_contact){
        super(user_id,user_name,user_email,user_password,user_address,user_contact);
    }

    public Float getOwnerRating() {
        //System.out.println("From Owner");
        return ownerRating;
    }

    public void setOwnerRating(Float ownerRating) {
        this.ownerRating = ownerRating;
    }

    public ArrayList<String> getOwnerComments() {
        return ownerComments;
    }

    public void setOwnerComments(ArrayList<String> ownerComments) {
        this.ownerComments = ownerComments;
    }
}
