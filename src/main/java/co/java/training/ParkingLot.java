package co.java.training;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int maxCount;
    private final Map<Ticket, Car> cars = new HashMap<>();

    public ParkingLot() {
        this.maxCount = 1;
    }

    public ParkingLot(int max) {
        maxCount = max;
    }

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        this.cars.put(ticket, car);
        return ticket;
    }

    public Car take(Ticket ticket) {
        Car car = this.cars.get(ticket);
        if (car != null) {
            this.cars.remove(ticket);
        }
        return car;
    }

    public int getMaxVacancy() {
        return this.maxCount;
    }

    public int getVacancy() {
        return this.maxCount - this.cars.size();
    }

    public BigDecimal getVacancyRate() {
        return BigDecimal.valueOf((this.maxCount - this.cars.size()) / this.maxCount);
    }

    public boolean isFull() {
        return this.cars.size() == maxCount;
    }

    public boolean hasCar(Ticket ticket) {
        return this.cars.containsKey(ticket);
    }
}
