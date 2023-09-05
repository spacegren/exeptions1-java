package application;

import model.entities.Reservation;
import model.exeptions.DomainExeption;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Exeptions {
    public static void main(String[] args) {

        System.out.println();

        try {
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

            System.out.println("ROOM NUMBER : ");
            int number = sc.nextInt();
            System.out.println("CHE-KIN  DATE (dd/MM/yyyy : ) ");
            Date chekin = SDF.parse(sc.next());
            System.out.println("CHEKOUT DATE (dd//MM/yyyy : ) ");
            Date chekout = SDF.parse(sc.next());

            Reservation reservation = new Reservation(number, chekin, chekout);
            System.out.println("RESERVATION" + reservation);

            System.out.println("UPDATE RESERVATION : ");
            System.out.println("CHECK-IN DATE (dd/MM/yyyy  : )");
            chekin = SDF.parse(sc.next());
            System.out.println("CHECK-OUT (dd/MM/yyyy) ");
            chekout = SDF.parse(sc.next());

            reservation.UpdateDates(chekin, chekout);
            System.out.println("RESERVATION : " + reservation);
            sc.close();
        }
        catch (ParseException e ){
            System.out.println("ERROR INVALIDE DATE FORMAT : ");
        }
        catch (DomainExeption e){
            System.out.println("ERROR IN RESERVATION : " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("UNEXPECTED ERROR : ");
        }
    }

}
