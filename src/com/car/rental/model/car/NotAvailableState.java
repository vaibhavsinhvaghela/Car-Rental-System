package com.car.rental.model.car;

public class NotAvailableState implements VehicleState {

    Vehicle rentCar;

    public NotAvailableState(Vehicle rentObj){
        this.rentCar=rentObj;
    }

    @Override
    public String requestCar() {
        return "This car is not available";
    }

    @Override
    public String denyCarRequest() {
        return "This car is not available and there are no requests for this car";
    }

    @Override
    public String activateCarListing() {
        rentCar.setState(new AvailableState(rentCar));
        return "Car listing Activated. This car is in available state now.";
    }

    @Override
    public String inactivateCarListing() {
        return "This car is already not available";
    }

    @Override
    public String rentCar() {
        return "This car is not available for renting";
    }

    @Override
    public String returnCar() {
        return "The car is not rented";
    }
}
