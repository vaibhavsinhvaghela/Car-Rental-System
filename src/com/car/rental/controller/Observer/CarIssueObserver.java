package com.car.rental.controller.Observer;

import com.car.rental.model.car.Car;
import com.car.rental.model.user.Renter;

import java.util.Observable;
import java.util.Observer;

public class CarIssueObserver implements Observer{

    Renter renter;
    Car car;

    public CarIssueObserver(Renter rentedCar, Car car){
        this.renter = rentedCar;
        this.renter.attach(this);
        this.car = car;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println( "Notifying owner: " );
        car.getOwner().notify((String)arg);
    }
}
