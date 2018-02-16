package com.car.rental.model.car;

import com.car.rental.model.user.Owner;

public class Car extends Vehicle {


    private CarMake carMake;
    private CarType carType;
    private FuelType fuelType;
    private TransmissionType transmissionType;


    public Car(){
        super();
    }

    public Car(String vehicleColor, String registrationNumber, int passengerCapacity, Location location, CarType carType, CarMake carMake, FuelType fuelType, TransmissionType transmissionType,Owner owner,Float price){
        super(vehicleColor,registrationNumber,passengerCapacity,location,owner,price);
        this.carType=carType;
        this.carMake=carMake;
        this.fuelType=fuelType;
        this.transmissionType=transmissionType;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public CarMake getCarMake() {
        return carMake;
    }

    public void setCarMake(CarMake carMake) {
        this.carMake = carMake;
    }



}
