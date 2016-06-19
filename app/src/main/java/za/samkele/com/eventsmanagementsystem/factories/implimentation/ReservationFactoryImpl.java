package za.samkele.com.eventsmanagementsystem.factories.implimentation;

import java.util.Date;

import za.samkele.com.eventsmanagementsystem.domain.Reservation;
import za.samkele.com.eventsmanagementsystem.factories.ReservationFactory;

/**
 * Created by Samkele on 4/29/2016.
 */
public class ReservationFactoryImpl implements ReservationFactory {
    private static ReservationFactoryImpl reserveFactory = null;

    private ReservationFactoryImpl(){

    }

    public static ReservationFactoryImpl getInstance(){
        if(reserveFactory == null)
            reserveFactory = new ReservationFactoryImpl();
        return reserveFactory;
    }

    public Reservation createEvent(String reserveDate, String depositDue, String amountPaid){
        Reservation reserve = new Reservation
                .Builder()
                //.reserveDate(reserveDate.toString())
                //.depositDue(depositDue)
                //.amountPaid(amountPaid)
                .build();
        return reserve;
    }
}
