package co.java.training;

import java.util.List;

public class ParkingBoy extends ParkingMan {
    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        ParkingLot parkingLot = parkingLots.stream().filter(item -> !item.isFull()).findFirst().orElseThrow(() -> {
            throw new RuntimeException("parking lot is full");
        });
        return parkingLot.park(car);
    }

    public Car take(Ticket ticket) {
        ParkingLot parkingLot = parkingLots.stream().filter(item -> item.hasCar(ticket)).findFirst().orElseThrow(() -> {
            throw new RuntimeException("car not found");
        });
        return parkingLot.take(ticket);
    }
}
