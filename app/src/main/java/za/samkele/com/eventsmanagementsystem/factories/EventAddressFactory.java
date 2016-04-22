package za.samkele.com.eventsmanagementsystem.factories;

import za.samkele.com.eventsmanagementsystem.domain.EventAddress;

/**
 * Created by Samkele on 4/22/2016.
 */
public class EventAddressFactory {
    public static EventAddress getAddress(String streetAddress, String surburb, String postalCode){
        return new EventAddress.Builder()
                .streetAddress(streetAddress)
                .surburb(surburb)
                .postalCode(postalCode)
                .build();
    }
}
