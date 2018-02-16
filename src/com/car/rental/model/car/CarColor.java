package com.car.rental.model.car;

public enum CarColor {

    BLACK("black"),
    WHITE("white"),
    RED("red"),
    BLUE("blue");

    private String carColor;

    CarColor(String color){
        this.carColor=color;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public static CarColor fromCarColor(String cal_color){
        for(CarColor carColor:values()){
            if(carColor.carColor.equalsIgnoreCase(cal_color)){
                return carColor;
            }
        }
        return null;
    }

}
