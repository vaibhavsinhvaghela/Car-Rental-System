package com.car.rental.model.car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CarList implements Iterable<Car>{
    List<Car> carList;

    public CarList() {
        carList = new ArrayList<Car>();
    }

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public Iterator<Car> iterator() {
        return new CarIterator();
    }

    public void add(Car car) {
        carList.add(car);
    }

    public class CarIterator implements Iterator<Car>{
        Iterator<Car> iterator;

        public CarIterator() {
            iterator = carList.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Car next() {
            return iterator.next();
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
