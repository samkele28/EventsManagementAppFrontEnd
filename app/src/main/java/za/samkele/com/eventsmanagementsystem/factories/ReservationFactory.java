package za.samkele.com.eventsmanagementsystem.factories;

import za.samkele.com.eventsmanagementsystem.domain.Reservation;

/**
 * Created by Samkele on 4/29/2016.
 */
public interface ReservationFactory {
    Reservation createEvent(String reserveDate, String depositDue, String amountPaid);
}
