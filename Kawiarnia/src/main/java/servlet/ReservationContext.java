package servlet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import entities.Reservation;



public class ReservationContext implements Serializable {

    private final SortedMap<Integer, Reservation> reservations;

    public List<Reservation> findAllReservations() {
        return new ArrayList<>(reservations.values());
    }

    public ReservationContext() {
        reservations = Collections.synchronizedSortedMap(new TreeMap<Integer, Reservation>());
        reservations.put(1, new Reservation(1, "22.01.2018", "17"));
        reservations.put(2, new Reservation(2, "23.01.2018", "16"));
        reservations.put(3, new Reservation(3, "24.01.2018", "19"));
    }
    
    public void saveReservation(Reservation reservation) {
        if (reservation.getNumer() == null) {
            reservation.setNumer(reservations.lastKey() + 1);
        }
        reservations.put(reservation.getNumer(), reservation);
    }

    public Reservation findReservation(Integer nr) {
        return reservations.get(nr);
    }
}
