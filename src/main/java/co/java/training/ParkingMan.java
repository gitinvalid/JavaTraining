package co.java.training;

import java.util.List;

public abstract class ParkingMan {
    protected List<ParkingLot> parkingLots = List.of();

    abstract Ticket park(Car car);

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
