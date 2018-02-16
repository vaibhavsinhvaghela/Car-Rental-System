package com.car.rental.model.rent;

import com.car.rental.model.car.Vehicle;
import com.car.rental.model.user.Renter;

import java.util.Date;

public class Rental {
    private Date startDate;
    public Date endDate;
    Renter renter;
    Vehicle vehicle;
    private float totalAmountPayable;

    public Rental(Date startDate,Date endDate,Renter renter,Vehicle vehicle,float totalAmountPayable){
        this.startDate=startDate;
        this.endDate=endDate;
        this.renter=renter;
        this.vehicle=vehicle;
        this.totalAmountPayable=totalAmountPayable;

    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getTotalAmountPayable() {
        return totalAmountPayable;
    }

    public void setTotalAmountPayable(float totalAmountPayable) {
        this.totalAmountPayable = totalAmountPayable;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Renter getRenter() {
        return renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
    }
}
