package com.car.rental.model.car;

public class AvailableState implements VehicleState {

    Vehicle rentCar;

    public AvailableState(Vehicle rentObj){
        this.rentCar=rentObj;
    }

    @Override
    public String requestCar() {

        rentCar.setState(new RequestedState(rentCar));
        return "Car is requested";
    }

    @Override
    public String denyCarRequest() {
        return "This car is not requested";
    }

    @Override
    public String activateCarListing() {
        return "This car is already in available state";
    }

    @Override
    public String inactivateCarListing() {

        rentCar.setState(new NotAvailableState(rentCar));
        return "The car is inactivated";
    }

    @Override
    public String rentCar() {
        return "The car is not requested";
    }

    @Override
    public String returnCar() {
        return "The car is not rented";
    }
}
