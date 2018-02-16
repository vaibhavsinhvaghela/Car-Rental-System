package com.car.rental.controller.car;

import com.car.rental.model.car.Car;
import com.car.rental.model.car.AvailableState;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CriteriaBase implements CarSearchCriteria{

    public CriteriaBase(){

    }

    public List<Car> meetCriteria(List<Car> carList){
        List<Car> carResultList=new ArrayList<>();

        Iterator<Car> carIterator=carList.iterator();
        while(carIterator.hasNext()){
            Car car=carIterator.next();
            if((car.getState()) instanceof AvailableState) {
                carResultList.add(car);
            }
        }

        return carResultList;
    }
}
