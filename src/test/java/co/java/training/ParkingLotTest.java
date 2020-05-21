package co.java.training;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_save_car() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        var ticket = parkingLot.park(car);
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_given_ticket() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        var ticket = parkingLot.park(car);

        var getCar = parkingLot.take(ticket);
        assertEquals(car, getCar);
    }
}
