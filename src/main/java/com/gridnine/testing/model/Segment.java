package com.gridnine.testing.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Компонент, представляющий собой сегмент полета.
 */
public class Segment {

    private final LocalDateTime departureDate;

    private final LocalDateTime arrivalDate;

    public Segment(LocalDateTime dep,
                   LocalDateTime arr) {

        this.departureDate = Objects.requireNonNull(dep);
        this.arrivalDate = Objects.requireNonNull(arr);
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        return '[' + departureDate.format(fmt) + " | " + arrivalDate.format(fmt) + ']';
    }
}