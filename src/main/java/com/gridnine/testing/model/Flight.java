package com.gridnine.testing.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Компонент, представляющий собой полет.
 */
public class Flight {

    private final List<Segment> segments;

    public Flight(List<Segment> segments) {
        this.segments = segments;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}