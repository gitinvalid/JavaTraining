package co.java.training;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperParkingBoyTest {
    @Test
    void should_save_a_car_to_max_vacancy_rate() {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(3);

        parkingLot2.park(new Car());

        SuperParkingBoy smartParkingBoy = new SuperParkingBoy(List.of(parkingLot1, parkingLot2));

        smartParkingBoy.park(new Car());
        assertEquals(1, parkingLot1.getVacancy());
    }
}
