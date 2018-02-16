package com.car.rental.controller.payment;

public class CreditCardStrategy implements PaymentStrategy {

    private String cardNumber;
    private String cvvNumber;
    private String dateOfExpiry;

    public CreditCardStrategy(String cardNum, String cvv, String expiryDate){
        this.cardNumber=cardNum;
        this.cvvNumber=cvv;
        this.dateOfExpiry=expiryDate;
    }
    @Override
    public void pay(float amount) {
        System.out.println("Paid using credit/debit card");
        System.out.println("Amount:"+amount);
    }

}
