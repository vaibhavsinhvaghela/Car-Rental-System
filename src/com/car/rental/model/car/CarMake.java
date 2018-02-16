package com.car.rental.model.car;

public enum CarMake {

    BMW("BMW"),
    AUDI("Audi"),
    FERRARI("Ferrari"),
    FIAT("Fiat"),
    NISSAN("Nissan"),
    HONDA("Honda"),
    TOYOTA("Toyota"),
    VOLKSWAGEN("Volkswagen"),
    PORSCHE("Porsche");

    private String carModelName;

    CarMake(String modelName){
        this.carModelName=modelName;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public static CarMake fromFuelMake(String car_make){
        for(CarMake carMake:values()){
            if(carMake.carModelName.equalsIgnoreCase(car_make)){
                return carMake;
            }
        }
        return null;
    }

}
