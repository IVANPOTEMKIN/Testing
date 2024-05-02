package com.gridnine.testing.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Bean that represents a flight segment.
 */
public record Segment(LocalDateTime departureDate, LocalDateTime arrivalDate) {
    @Override
    public String toString() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return '[' + departureDate.format(formatter) + '|' + arrivalDate.format(formatter) + ']';
    }
}