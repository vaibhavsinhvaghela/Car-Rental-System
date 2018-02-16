package com.car.rental.controller.car;

import com.car.rental.controller.Observer.CarIssueObserver;
import com.car.rental.controller.payment.CreditCardStrategy;
import com.car.rental.controller.payment.PayPalStrategy;
import com.car.rental.controller.payment.PaymentController;
import com.car.rental.model.car.*;
import com.car.rental.model.car.CoupeCar;
import com.car.rental.model.car.LuxuryCar;
import com.car.rental.model.car.SUVCar;
import com.car.rental.model.car.SedanCar;
import com.car.rental.model.car.Location;
import com.car.rental.model.rent.Rental;
import com.car.rental.model.user.Owner;
import com.car.rental.model.user.Renter;
import com.car.rental.model.user.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CarController {

    private static Scanner scanner;
    //List<Car> carList=new ArrayList<>();
    private CarList carList=new CarList();
    private static CarController carController = new CarController();

    private CarController() {

    }

    public static CarController getInstance() {
        return carController;
    }

    public CarList getCarList() {
        return carList;
    }

    public void setCarList(CarList carList) {
        this.carList = carList;
    }

    public Car buildCar(String vehicleColor, String registrationNumber, int passengerCapacity, String location, String carType, String carMake, String fuelType, String transmissionType, Owner owner, Float price){

        Car car=null;

        CarType carTypeEnum=CarType.fromCarType(carType);
        CarMake carMakeEnum=CarMake.fromFuelMake(carMake);
        FuelType fuelTypeEnum=FuelType.fromFuelType(fuelType);
        TransmissionType transmissionTypeEnum=TransmissionType.fromTransmissionType(transmissionType);
        Location locationEnum=Location.fromLocation(location);
        switch (carTypeEnum){

            case COUPE:
                car=new CoupeCar(vehicleColor,registrationNumber,passengerCapacity,locationEnum,carTypeEnum,carMakeEnum,fuelTypeEnum,transmissionTypeEnum,owner,price);
                break;
            case SEDAN:
                car=new SedanCar(vehicleColor,registrationNumber,passengerCapacity,locationEnum,carTypeEnum,carMakeEnum,fuelTypeEnum,transmissionTypeEnum,owner,price);
                break;
            case SUV:
                car=new SUVCar(vehicleColor,registrationNumber,passengerCapacity,locationEnum,carTypeEnum,carMakeEnum,fuelTypeEnum,transmissionTypeEnum,owner,price);
                break;
            case LUXURY:
                car=new LuxuryCar(vehicleColor,registrationNumber,passengerCapacity,locationEnum,carTypeEnum,carMakeEnum,fuelTypeEnum,transmissionTypeEnum,owner,price);
                break;
        }
       

        carList.add(car);

        return car;

    }

    public void addCar(User user){

        System.out.println("List your car");

        System.out.println("Enter the location(city):");
        scanner=new Scanner(System.in);
        String location=scanner.nextLine();

        System.out.println("Enter the Car Type (Luxury,Sedan,SUV,Coupe):");
        scanner=new Scanner(System.in);
        String carType=scanner.nextLine();

        System.out.println("Enter the Car Make (Audi,Fiat,Nissan,Honda):");
        scanner=new Scanner(System.in);
        String carMake=scanner.nextLine();

        System.out.println("Enter the Fuel Type (Electric,Gas):");
        scanner=new Scanner(System.in);
        String fuelType=scanner.nextLine();

        System.out.println("Enter the Transmission Type (Automatic,Manual)");
        scanner=new Scanner(System.in);
        String transmissionType=scanner.nextLine();

        System.out.println("Enter the price");
        scanner=new Scanner(System.in);
        Float price=scanner.nextFloat();

        System.out.println("Enter the car color:");
        scanner=new Scanner(System.in);
        String color=scanner.nextLine();

        System.out.println("Enter the registation number:");
        scanner=new Scanner(System.in);
        String regisNumber=scanner.nextLine();

        System.out.println("Enter the passenger capacity:");
        scanner=new Scanner(System.in);
        int passengerCapacity=scanner.nextInt();

        Car car=buildCar(color,regisNumber,passengerCapacity,location,carType,carMake,fuelType,transmissionType,(Owner) user,price);

        System.out.println(" CarType:"+car.getCarType()+" CarColor:"+car.getVehicleColor()+" CarMake:"+car.getCarMake()+" Price:"+car.getPrice()+" Location:"+car.getLocation());


        System.out.println("Your Car is listed successfully");

    }

    public void displayCar(List<Car> carList){

        for(Car car:carList)
            System.out.println("User:"+car.getOwner().getUserName() +" CarLocation:"+car.getLocation()+" Color: "+car.getVehicleColor()+" CarMake: "+car.getCarMake()+" CarType:"+car.getCarType()+" Price:"+car.getPrice());
    }

    public List<Car> sortingStrategy(SortingStrategy sortingStrategy){

        return sortingStrategy.sortCar(carList.getCarList());
    }

    public void sortCars(){

        System.out.println("Sort Cars");
        System.out.println("Sort By 1.Owner Rating 2.Price");
        scanner=new Scanner(System.in);
        int sortOption=scanner.nextInt();

        if(sortOption==1){
            displayCar(sortingStrategy(new RateSortingStrategy()));
        }else if(sortOption==2){
            displayCar(sortingStrategy(new PriceSortingStrategy()));
        }

    }


    public void searchCar(){

        if(carList.getCarList().size()==0){
            System.out.println("No cars to search");

        }else {

            System.out.println("Search Cars");
            System.out.println("Search By 1.Car Type 2.Car Make 3:Car Color");
            scanner = new Scanner(System.in);
            int searchType = scanner.nextInt();


            if (searchType == 1) {
                System.out.println("Enter the car type:");
                scanner = new Scanner(System.in);
                String carType = scanner.nextLine();
                this.displayCar(this.searchByCarType(carType));

            } else if (searchType == 2) {
                System.out.println("Enter the car make:");
                scanner = new Scanner(System.in);
                String carMake = scanner.nextLine();
                this.displayCar(this.searchByCarMake(carMake));

            } else if (searchType == 3) {
                System.out.println("Enter the car color:");
                scanner = new Scanner(System.in);
                String carColor = scanner.nextLine();
                this.displayCar(this.searchByCarColor(carColor));

            }
        }


    }

    public List<Car> filterCarByAvailability(){
        System.out.println("Filtering cars by availability");
        List<Car> carResultList=new ArrayList<>();
        CriteriaBase baseCriteria = new CriteriaBase();
        carResultList = baseCriteria.meetCriteria(carList.getCarList());
        return carResultList;
    }

    public List<Car> searchByCarType(String carType){

        System.out.println("Searching by Car Type");
        List<Car> carResultList=new ArrayList<>();
        CriteriaCarType carTypeCriteria = new CriteriaCarType(carType);
        carResultList = carTypeCriteria.meetCriteria(filterCarByAvailability());
        return carResultList;
    }

    public List<Car> searchByCarMake(String carMake){

        System.out.println("Searching by Car Make");
        List<Car> carResultList=new ArrayList<>();
        CriteriaCarMake carMakeCriteria=new CriteriaCarMake(carMake);
        carResultList = carMakeCriteria.meetCriteria(filterCarByAvailability());
        return carResultList;
    }

    public List<Car> searchByCarColor(String carColor){

        System.out.println("Searching by Car Color");
        List<Car> carResultList=new ArrayList<>();
        CriteriaCarColor carColorCriteria=new CriteriaCarColor(carColor);
        carResultList=carColorCriteria.meetCriteria(filterCarByAvailability());
        return carResultList;
    }

    public void displayCarsOfUser(String user_name){

        Iterator<Car> carIterator=carList.iterator();
        while(carIterator.hasNext()){
            Car car=carIterator.next();
            if(car.getOwner().getUserName().equals(user_name)){
                System.out.println(" CarType:"+car.getCarType()+" CarColor:"+car.getVehicleColor()+" CarMake:"+car.getCarMake()+" Amount:"+car.getPrice()+" Location:"+car.getLocation()+" Amount:"+car.getPrice());
            }
        }
    }

    public void rentCar(User user){


        System.out.println("Rent Car");

        CriteriaLocation criteriaLocation=new CriteriaLocation(user.getAddress().getCity());
        List<Car> carResultList=criteriaLocation.meetCriteria(filterCarByAvailability());

        for(int i=0;i<carResultList.size();i++){
            System.out.println(i+" CarType:"+carResultList.get(i).getCarType()+" CarColor:"+carResultList.get(i).getVehicleColor()+" CarMake:"+carResultList.get(i).getCarMake()+" Amount:"+carResultList.get(i).getPrice()+" Location:"+carResultList.get(i).getLocation());
        }

        System.out.println("Select car:");
        scanner=new Scanner(System.in);
        int car_id=scanner.nextInt();

        Vehicle car= (Vehicle) carResultList.get(car_id);

        SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");

        System.out.println("Enter the start date(dd-MM-yyyy):");
        scanner=new Scanner(System.in);
        String start_date=scanner.nextLine();
        Date startDate=null;
        try {
            startDate = format.parse(start_date);

        }catch (ParseException e){
            System.out.println("Parse exception");
        }

        System.out.println("Enter the end date(dd-MM-yyyy)");
        scanner=new Scanner(System.in);
        String end_date=scanner.nextLine();
        Date endDate=null;
        try {
            endDate = format.parse(end_date);

        }catch (ParseException e){
            System.out.println("Parse exception");
        }

        PaymentController paymentController=new PaymentController();
        float total_amt=paymentController.calculateRent(startDate,endDate,car.getPrice());


        Rental rental=new Rental(startDate,endDate,(Renter)user,car,total_amt);

        car.getRentalList().add(rental);

        rental.getRenter().getRentalList().add(rental);

        System.out.println("Start Date:"+start_date+" End Date:"+end_date+" TotalAmount:"+total_amt);

        System.out.println("Select the Payment method:");
        System.out.println("1.CreditCard Method 2.Paypal Method");
        scanner=new Scanner(System.in);
        int option=scanner.nextInt();

        if(option==1){

            System.out.println("Enter the card number");
            scanner=new Scanner(System.in);
            String cardNum=scanner.nextLine();

            System.out.println("Enter the cvv number");
            scanner=new Scanner(System.in);
            String cvvNum=scanner.nextLine();

            System.out.println("Enter the expiry date");
            scanner=new Scanner(System.in);
            String date=scanner.nextLine();

            paymentController.payRent(new CreditCardStrategy(date,cvvNum,date),total_amt);
        }else if(option==2){

            System.out.println("Enter the emailid:");
            scanner=new Scanner(System.in);
            String email=scanner.nextLine();

            System.out.println("Enter the pwd:");
            scanner=new Scanner(System.in);
            String pwd=scanner.nextLine();

            paymentController.payRent(new PayPalStrategy(email,pwd),total_amt);
        }

        System.out.println(car.getState().requestCar());
        System.out.println(car.getState().rentCar());
        new CarIssueObserver((Renter) user, (Car)car);


        System.out.println("Car is booked successfully");
        System.out.println("Issues with car? - Y/N");
        String issue=scanner.nextLine();
        if (issue.equals("Y")){
            System.out.println("Describe issue:");
            String issueDesc=scanner.nextLine();
            ((Renter) user).setIssue(issueDesc);
        }


    }

    public void returnCar(User user){

        Renter renter=(Renter)user;

        Vehicle vehicle=null;
        for(int i=0;i<renter.getRentalList().size();i++){
            vehicle=renter.getRentalList().get(i).getVehicle();
            if(vehicle.getState() instanceof RentedState){
                Car car=(Car)vehicle;
                break;
            }
        }

        if(vehicle!=null) {

            System.out.println(vehicle.getState().returnCar());
        }else{
            System.out.println("This renter has not rented any vehicles");
        }

    }



}
