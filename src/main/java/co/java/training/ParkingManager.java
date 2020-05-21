package co.java.training;

import java.util.List;

public class ParkingManager extends ParkingMan {
    private final List<ParkingMan> parkingMen;

    public ParkingManager(List<ParkingMan> parkingMen, List<ParkingLot> parkingLots) {
        this.parkingMen = parkingMen;
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

    public Ticket delegatePark(Car car) {
        Ticket ticket = null;

        for (ParkingMan parkingMAN : parkingMen) {
            try {
                ticket = parkingMAN.park(car);
            } catch (Exception ignored) { }
        }

        if (ticket == null) {
            throw new RuntimeException("parking lot is full");
        }

        return ticket;
    }

    public List<ParkingMan> getParkingMen() {
        return parkingMen;
    }
}
