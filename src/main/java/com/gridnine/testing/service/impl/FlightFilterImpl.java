package com.gridnine.testing.service.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.FlightFilter;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.Duration.ZERO;
import static java.time.Duration.between;
import static java.time.LocalDateTime.now;

public class FlightFilterImpl implements FlightFilter {

    private static final long MAX_TIME_ON_GROUND = 2;

    @Override
    public List<Flight> departureBeforeCurrentTime(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments()
                        .stream()
                        .allMatch(segment -> segment.getDepartureDate().isAfter(now())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> arrivalBeforeDeparture(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments()
                        .stream()
                        .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> exceedingTimeStay(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> checkTimeStay(flight.getSegments()))
                .collect(Collectors.toList());
    }

    /**
     * Метод проверки времени пребывания на земле.
     */
    private boolean checkTimeStay(List<Segment> segments) {
        Duration totalTimeOnGround = ZERO;

        for (int i = 1; i < segments.size(); i++) {

            Duration time = between(segments.get(i - 1).getArrivalDate(), segments.get(i).getDepartureDate());

            if (time.isNegative()) {
                return false;
            }
            totalTimeOnGround = totalTimeOnGround.plus(time);
        }
        return totalTimeOnGround.toHours() <= MAX_TIME_ON_GROUND;
    }
}