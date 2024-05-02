package com.gridnine.testing;

import com.gridnine.testing.builder.FlightBuilder;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightFilter;
import com.gridnine.testing.service.impl.FlightFilterImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FlightFilter filter = new FlightFilterImpl();

        List<Flight> flights = FlightBuilder.createFlights();

        System.out.println("Список всех полетов:");
        flights.forEach(System.out::println);

        System.out.println("\nСписок полетов, исключающих полеты с вылетами до текущего момента времени:");
        filter.departureBeforeCurrentTime(flights).forEach(System.out::println);

        System.out.println("\nСписок полетов, исключающих полеты с сегментами с датой прилёта раньше даты вылета:");
        filter.arrivalBeforeDeparture(flights).forEach(System.out::println);

        System.out.println("\nСписок полетов, исключающих полеты, где общее время, проведённое на земле, превышает два часа:");
        filter.exceedingTimeStay(flights).forEach(System.out::println);

        System.out.println("\nСписок всех отфильтрованных полетов:");
        flights = filter.departureBeforeCurrentTime(flights);
        flights = filter.arrivalBeforeDeparture(flights);
        flights = filter.exceedingTimeStay(flights);
        flights.forEach(System.out::println);
    }
}