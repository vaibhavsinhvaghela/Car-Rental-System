package com.car.rental.controller.car;

import com.car.rental.model.car.Car;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CriteriaCarColor implements CarSearchCriteria {

    String carColor;
    public CriteriaCarColor(String carColor){
        this.carColor=carColor;
    }

    @Override
    public List<Car> meetCriteria(List<Car> carList) {
        List<Car> carResultList=new ArrayList<>();

        Iterator<Car> carIterator=carList.iterator();
        while(carIterator.hasNext()){
            Car car=carIterator.next();
            if(car.getVehicleColor().equalsIgnoreCase(carColor)){
                carResultList.add(car);
            }
        }
        return carResultList;
    }

}
