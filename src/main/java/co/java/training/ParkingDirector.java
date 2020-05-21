package co.java.training;

import java.util.List;

public class ParkingDirector {
    private final List<ParkingManager> parkingManagers;

    public ParkingDirector(List<ParkingManager> parkingManagers) {
        this.parkingManagers = parkingManagers;
    }

    public String getReport() {
        StringBuilder resultBuilder = new StringBuilder();
        parkingManagers.forEach(parkingManager -> {
            parkingManager.getParkingLots().forEach(parkingLot -> resultBuilder.append(parkingLotReport(parkingLot)));
            parkingManager.getParkingMen().forEach(parkingMan -> parkingMan.getParkingLots().forEach(parkingLot -> resultBuilder.append(parkingLotReport(parkingLot))));
        });
        return resultBuilder.toString();
    }

    private String parkingLotReport(ParkingLot parkingLot) {
        return String.format("id:%d max vacancy:%d vacancy:%d vacancy rate:%s\n",
                parkingLot.hashCode(),
                parkingLot.getMaxVacancy(),
                parkingLot.getVacancy(),
                parkingLot.getVacancyRate().toString());
    }
}
