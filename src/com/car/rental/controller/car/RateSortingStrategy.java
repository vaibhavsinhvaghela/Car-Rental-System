package com.car.rental.controller.car;

import com.car.rental.model.car.Car;

import java.util.Collections;
import java.util.List;

public class RateSortingStrategy implements SortingStrategy {


    @Override
    public List<Car> sortCar(List<Car> carList) {

        if(carList.size()!=0) {

            Collections.sort(carList,(c1,c2)->Double.compare(c1.getOwner().getOwnerRating() ,c2.getOwner().getOwnerRating()));
        }

        return carList;
    }
}
