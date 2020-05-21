package co.java.training;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingManagerTest {
    @Test
    void should_save_car_by_parking_boy() {
        ParkingLot parkingLot = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(parkingLot));
        ParkingManager parkingManager = new ParkingManager(List.of(smartParkingBoy), List.of());
        parkingManager.delegatePark(new Car());

        assertEquals(1, parkingLot.getVacancy());
    }

    @Test
    void should_save_car_by_self() {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingManager parkingManager = new ParkingManager(List.of(), List.of(parkingLot));
        parkingManager.park(new Car());

        assertEquals(1, parkingLot.getVacancy());
    }
}
