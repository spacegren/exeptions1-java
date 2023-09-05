package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Exeptions {
    public static void main(String[] args) throws ParseException {

        System.out.println("RESOLVENDO EWSSE PROBLEMA COM UMA SOLUCAO MUITO RUIM : ");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("ROOM NUMBER : ");
        int number = sc.nextInt();
        System.out.println("CHE-KIN  DATE (dd/MM/yyyy : ) ");
        Date chekin = SDF.parse(sc.next());
        System.out.println("CHEKOUT DATE (dd//MM/yyyy : ) ");
        Date chekout = SDF.parse(sc.next());

        if (!chekout.after(chekin)){
            System.out.println("ERROR IN RESERVATION , CHECK-OUT DATE MUST BE AFTER CHECK-IN DATE ");
        }else{
            Reservation reservation = new Reservation(number , chekin , chekout);
            System.out.println("RESERVATION" + reservation);

            System.out.println();
        System.out.println("UPDATE RESERVATION : ");
        System.out.println("CHECK-IN DATE (dd/MM/yyyy  : )");
        chekin = SDF.parse(sc.next());
        System.out.println("CHECK-OUT (dd/MM/yyyy) ");
        chekout = SDF.parse(sc.next());

    System.out.println("ADICIONANDO 'MELHORIAS' NO CODIGO , UMA SOLUÇAO AINDA MUITO EUIM POR PARTES MAS USAMOS A DELEGAÇAO DE DADOS ");

    System.out.println("AINDA CONTINUA MUITO RUIM A FORMA DE SE RESOLVER ESTE PROBLEMA : ");

        String error = reservation.UpdtateDAtes(chekin, chekout);
        if (error != null){
            System.out.println("ERROR IN RESERVATION : " + error);
        }else {
            System.out.println("RESERVATION :" + reservation);
        }
        }
        sc.close();
    }

}
