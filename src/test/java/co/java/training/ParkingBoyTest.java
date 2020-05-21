package co.java.training;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingBoyTest {
    @Test
    void should_save_car() {
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(List.of(new ParkingLot(), new ParkingLot()));
        Ticket ticket = parkingBoy.park(car);
        assertNotNull(ticket);
    }

    @Test
    void should_get_car() {
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(List.of(new ParkingLot(), new ParkingLot()));
        Ticket ticket = parkingBoy.park(car);
        Car getCar = parkingBoy.take(ticket);
        assertEquals(car, getCar);
    }

    @Test
    void should_throw_error_when_parking_lot_is_full() {
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(List.of(new ParkingLot()));
        Ticket ticket1 = parkingBoy.park(car1);
        assertThrows(RuntimeException.class, () -> {
            Ticket ticket2 = parkingBoy.park(car2);
        });
    }

    @Test
    void should_throw_error_when_car_not_found() {
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(List.of(new ParkingLot()));
        Ticket ticket = parkingBoy.park(car);
        Ticket notExistTicket = new Ticket();
        assertThrows(RuntimeException.class, () -> {
            Car getCar = parkingBoy.take(notExistTicket);
        });
    }
}
