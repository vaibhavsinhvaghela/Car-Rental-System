package com.car.rental.model.car;

public enum Location {
    SANFRANCISCO("San Francisco", "CALIFORNIA"),
    DALLAS("Dallas", "TEXAS"),
    SEATTLE("Seattle", "WASHINGTON"),
    PORTLAND("Portland", "OREGON"),
    LOSANGELES("Los Angeles", "CALIFORNIA"),
    NEWYORK("New York", "NEW YORK"),
    SANJOSE("San Jose", "CALIFORNIA");

    private String city;
    private String state;

    Location(String city,String state){
        this.state=state;
        this.city=city;
    }

    public static Location fromLocation(String loc){
        for(Location location:values()){
            if(location.city.equalsIgnoreCase(loc)){
                return location;
            }
        }
        return null;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
