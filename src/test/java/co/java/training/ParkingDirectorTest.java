package co.java.training;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingDirectorTest {
    @Test
    void should_print_info_when_has_manager_and_parking_boy() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(parkingLot2));
        ParkingManager parkingManager = new ParkingManager(List.of(smartParkingBoy), List.of(parkingLot1));
        ParkingDirector parkingDirector = new ParkingDirector(List.of(parkingManager));

        StringBuilder expectResultBuilder = new StringBuilder();
        List.of(parkingLot1, parkingLot2).forEach(parkingLot -> {
            expectResultBuilder.append("id:").append(parkingLot.hashCode());
            expectResultBuilder.append(" max vacancy:").append(parkingLot.getMaxVacancy());
            expectResultBuilder.append(" vacancy:").append(parkingLot.getVacancy());
            expectResultBuilder.append(" vacancy rate:").append(parkingLot.getVacancyRate());
            expectResultBuilder.append("\n");
        });

        assertEquals(expectResultBuilder.toString(), parkingDirector.getReport());
    }
}
