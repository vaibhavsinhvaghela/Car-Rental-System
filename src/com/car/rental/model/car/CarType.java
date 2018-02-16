package com.car.rental.model.car;

public enum CarType {

    SEDAN("Sedan"),
    COUPE("Coupe"),
    SUV("SUV"),
    LUXURY("Luxury");

    private String car_type;

    CarType(String carType){
        this.car_type=carType;
    }

    public static CarType fromCarType(String car_type){
        for(CarType carType:values()){
            if(carType.car_type.equalsIgnoreCase(car_type)){
                return carType;
            }
        }
        return null;
    }

}
