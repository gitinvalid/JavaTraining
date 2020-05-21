package co.java.training;

import java.util.List;

public class SuperParkingBoy extends ParkingMan {
    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        ParkingLot saveParkingLog = parkingLots.get(0);
        for(ParkingLot parkingLot: parkingLots) {
            if (saveParkingLog.getVacancy() < parkingLot.getVacancy()) {
                saveParkingLog = parkingLot;
            }
        }
        return saveParkingLog.park(car);
    }

    public Car take(Ticket ticket) {
        ParkingLot parkingLot = parkingLots.stream().filter(item -> item.hasCar(ticket)).findFirst().orElseThrow(() -> {
            throw new RuntimeException("car not found");
        });
        return parkingLot.take(ticket);
    }
}
