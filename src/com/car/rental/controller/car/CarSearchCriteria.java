package com.car.rental.controller.car;

import com.car.rental.model.car.Car;

import java.util.List;

public interface CarSearchCriteria {

    public List<Car> meetCriteria(List<Car> carList);

}
