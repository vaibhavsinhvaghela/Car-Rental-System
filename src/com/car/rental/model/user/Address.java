package com.car.rental.model.user;

public class Address {

    private String street;
    private String city;
    private String zipCode;

    public Address(String street,String city,String zip_code){
        this.street=street;
        this.city=city;
        this.zipCode=zip_code;
    }


    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

}
