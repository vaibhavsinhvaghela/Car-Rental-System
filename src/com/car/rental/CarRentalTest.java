package com.car.rental;

import com.car.rental.controller.car.CarController;
import com.car.rental.controller.user.UserController;
import com.car.rental.model.car.*;
import com.car.rental.model.user.Address;
import com.car.rental.model.user.Owner;
import com.car.rental.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalTest {


    private static Scanner scanner;
    public static void main(String args[]){

        System.out.println("Car Rental Management System");
        addSampleCarDetails();

        do {
            try{


                System.out.println("*******************************");
                System.out.println("1.Create User");
                System.out.println("--Owner--");
                System.out.println("2.List Car \n3.View Cars");
                System.out.println("--Renter--");
                System.out.println("4.Search Car \n5.Sort Car \n6.Rent Car \n7.Return Car");
                System.out.println("-8.Exit-");
                System.out.println("Enter the option:");
                scanner=new Scanner(System.in);
                int option=scanner.nextInt();

                if(option==1){
                    registerUser();
                }else if(option==2){
                    listCar();
                }else if(option == 3){
                    viewCars();
                }else if(option==4){
                    CarController carController = CarController.getInstance();
                    carController.searchCar();
                }else if(option == 5){
                    CarController carController = CarController.getInstance();
                    carController.sortCars();
                }else if(option == 6){
                    rentCar();
                }else if(option == 7){
                    returnCar();
                }else if(option == 8){
                    break;
                }


            } catch(Exception e) {
                continue;
            }

        }while(1!=0);



    }

    private static User registerUser(){

        System.out.println("Choose User");
        System.out.println("1.Owner 2.Renter");
        scanner=new Scanner(System.in);
        int user_type = scanner.nextInt();

        UserController userController=UserController.getInstance();

        User user=userController.register(user_type);

        return user;
    }

    private static void listCar(){


        System.out.println("Enter the username:");
        scanner=new Scanner(System.in);
        String user_name=scanner.nextLine();
        UserController userController=UserController.getInstance();
        CarController carController = CarController.getInstance();
        if(userController.isValidUser(user_name)){
            User user=userController.getUserByUserName(user_name);
            carController.addCar(user);
        }else{
            System.out.println("Please enter a valid user name");
        }

    }

    public static void viewCars(){

        System.out.println("Enter the username:");
        scanner=new Scanner(System.in);
        String user_name=scanner.nextLine();
        UserController userController=UserController.getInstance();
        CarController carController = CarController.getInstance();
        if(userController.isValidUser(user_name)){
            carController.displayCarsOfUser(user_name);
        }else{
            System.out.println("Please enter a valid user name");
        }
    }

    public static void addSampleCarDetails(){

        CarController carController = CarController.getInstance();
        Address address=new Address("141S","San Jose","12345");
        Owner owner = new Owner(1,"Tom","sind@gmail.com","12345",address,"12345");
        ArrayList<User> userArrayList=new ArrayList<>();
        userArrayList.add(owner);
        UserController userController=UserController.getInstance();
        userController.setUserList(userArrayList);

        List<Car> carResultList=new ArrayList<>();
        Car a = new CoupeCar("blue", "1234", 4, Location.SANJOSE, CarType.COUPE, CarMake.AUDI, FuelType.ELECTRIC, TransmissionType.AUTOMATIC,owner,15.0f);
        carResultList.add(a);
        Car b = new LuxuryCar("red", "2345", 4, Location.DALLAS, CarType.LUXURY, CarMake.BMW, FuelType.ELECTRIC, TransmissionType.AUTOMATIC,owner,14f);
        carResultList.add(b);
        Car c = new LuxuryCar("black", "3456", 4, Location.SANJOSE, CarType.LUXURY, CarMake.BMW, FuelType.ELECTRIC, TransmissionType.AUTOMATIC,owner,20f);
        carResultList.add(c);
        Car d = new LuxuryCar("green", "3456", 4, Location.SANJOSE, CarType.LUXURY, CarMake.BMW, FuelType.ELECTRIC, TransmissionType.AUTOMATIC,owner,16f);
        carResultList.add(d);

        carController.setCarList(new CarList(carResultList));
    }

    public static void rentCar(){

        System.out.println("Enter the username:");
        scanner=new Scanner(System.in);
        String user_name=scanner.nextLine();
        UserController userController=UserController.getInstance();
        CarController carController = CarController.getInstance();
        if(userController.isValidUser(user_name)){
            User user=userController.getUserByUserName(user_name);
            carController.rentCar(user);
        }else{
            System.out.println("Please enter a valid user name");
        }

    }

    public static void returnCar(){
        System.out.println("Return car");

        System.out.println("Enter the username:");
        scanner=new Scanner(System.in);
        String user_name=scanner.nextLine();
        UserController userController=UserController.getInstance();
        CarController carController = CarController.getInstance();
        if(userController.isValidUser(user_name)){
            User user=userController.getUserByUserName(user_name);
            carController.returnCar(user);
        }else{
            System.out.println("Please enter a valid user name");
        }
    }
}
