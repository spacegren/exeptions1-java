package model.entities;

import model.exeptions.DomainExeption;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Reservation {
    private Integer RollNumber;
    private Date Checkout;
    private Date Chekin;

    private static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");


    public Reservation(){

    }
    public Reservation(Integer rollNumber , Date chekin , Date checkout) {

        if (!checkout.after(chekin)){
            throw new DomainExeption("CHECK-OUT DATE MUST BE AFTER CHECK-IN DATE ");
        }
        this.RollNumber = rollNumber;
        this.Chekin = chekin;
        this.Checkout = checkout;
    }

    public Integer getRollNumber() {
        return RollNumber;
    }

    public void setRollNumber(Integer rollNumber) {
        RollNumber = rollNumber;
    }

    public Date getChekin() {
        return Chekin;
    }

    public Date getCheckout(Date checkout){
        return checkout;
    }

    public long duration(){
        long diff = Checkout.getTime() - Chekin.getTime();
        return TimeUnit.DAYS.convert(diff , TimeUnit.MILLISECONDS);
    }

    public void UpdateDates(Date  chekin  , Date  chekout){
        Date now = new Date();
        if(chekin.before(now) || chekout.before(now)){
           throw new DomainExeption("RESERVATION DATES FOR UPDATES MUST A FUTURE : ");
        }
        if (!chekout.after(chekin)){
             throw new DomainExeption("CHECK-OUT DATE MUST BE AFTER CHECK-IN DATE ");
        }
        this.Chekin = chekin;
        this.Checkout = chekout;
    }
    @Override
    public String toString(){
        return " ROOM "
                +RollNumber
                + ", CHE-KIN : "
                +SDF.format(Chekin)
                +"CHEKOUT : "
                +SDF.format(Checkout)
                +", "
                +duration()
                +" NIGHTS : "
                ;

    }
}
