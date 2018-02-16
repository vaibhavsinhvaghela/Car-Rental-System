package com.car.rental.controller.car;

import com.car.rental.model.car.Car;

import java.util.List;

public interface SortingStrategy {

    public List<Car> sortCar(List<Car> carList);
}
