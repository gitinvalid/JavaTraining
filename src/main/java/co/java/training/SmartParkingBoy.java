package co.java.training;

import java.util.List;

public class SmartParkingBoy extends ParkingMan {
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        ParkingLot saveParkingLog = parkingLots.get(0);
        for (int i = 1; i < parkingLots.size(); i++) {
            if (saveParkingLog.getVacancy() < parkingLots.get(i).getVacancy()) {
                saveParkingLog = parkingLots.get(i);
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
