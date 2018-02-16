package com.car.rental.controller.car;

import com.car.rental.model.car.Car;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CriteriaCarType implements CarSearchCriteria {

    private String carType;

    public CriteriaCarType(String carType){
        this.carType=carType;
    }

    @Override
    public List<Car> meetCriteria(List<Car> carList) {
        List<Car> carResultList=new ArrayList<>();

        Iterator<Car> carIterator=carList.iterator();
        while(carIterator.hasNext()){
            Car car=carIterator.next();
            if(car.getCarType().name().equalsIgnoreCase(carType)){
                carResultList.add(car);
            }
        }
        return carResultList;
    }

}
