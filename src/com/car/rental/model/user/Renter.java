package com.car.rental.model.user;

import com.car.rental.controller.Observer.CarIssueObserver;
import com.car.rental.model.car.Car;
import com.car.rental.model.rent.Rental;

import java.util.ArrayList;

public class Renter extends User{


    private Float renterRating;
    private int numOfRatings;
    private int totalPoints;
    private ArrayList<String> renterComments;
    private ArrayList<Rental> rentalList;

    public Renter(int user_id,String user_name,String user_email,String user_password,Address user_address,String user_contact){
        super(user_id,user_name,user_email,user_password,user_address,user_contact);
        rentalList=new ArrayList<>();
    }

    public Float getRenterRating() {
        return renterRating;
    }

    public void setRenterRating(Float renterRating) {
        this.renterRating = renterRating;
    }

    public void attach(CarIssueObserver observer){
        addObserver(observer);
    }

    public ArrayList<String> getRenterComments() {
        return renterComments;
    }

    public void setRenterComments(ArrayList<String> renterComments) {
        this.renterComments = renterComments;
    }

    public ArrayList<Rental> getRentalList() {
        return rentalList;
    }

    public void setRentalList(ArrayList<Rental> rentalList) {
        this.rentalList = rentalList;
    }

    public void setIssue(String issue) {
        setChanged();
        notifyObservers(issue);
    }
}
