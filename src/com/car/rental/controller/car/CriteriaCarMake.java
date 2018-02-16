package com.car.rental.controller.car;

import com.car.rental.model.car.Car;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CriteriaCarMake implements CarSearchCriteria {

    private String carMake;

    public CriteriaCarMake(String carMake){
        this.carMake=carMake;
    }

    @Override
    public List<Car> meetCriteria(List<Car> carList) {
        List<Car> carResultList=new ArrayList<>();

        Iterator<Car> carIterator=carList.iterator();
        while(carIterator.hasNext()){
            Car car=carIterator.next();
            if(car.getCarMake().name().equalsIgnoreCase(carMake)){
                carResultList.add(car);
            }
        }
        return carResultList;
    }
}
