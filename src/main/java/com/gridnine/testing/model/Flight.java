package com.gridnine.testing.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Компонент, представляющий собой полет.
 */
public record Flight(List<Segment> segments) {

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}