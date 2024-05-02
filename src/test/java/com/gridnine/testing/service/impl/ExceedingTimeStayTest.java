package com.gridnine.testing.service.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.FlightFilter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ExceedingTimeStayTest {

    private final FlightFilter filter = new FlightFilterImpl();

    @Test
    public void test() {
        List<Flight> expected = expected();
        List<Flight> actual = filter.exceedingTimeStay(createFlights());

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get(0).toString(), actual.get(0).toString());
        assertEquals(expected.get(1).toString(), actual.get(1).toString());
    }

    private List<Flight> createFlights() {
        List<Flight> flights = new ArrayList<>();

        List<Segment> segments_1 = new ArrayList<>();
        List<Segment> segments_2 = new ArrayList<>();
        List<Segment> segments_3 = new ArrayList<>();
        List<Segment> segments_4 = new ArrayList<>();

        segments_1.add(new Segment(now().plusHours(1), now().plusHours(2)));
        segments_1.add(new Segment(now().plusHours(3), now().plusHours(4)));

        segments_2.add(new Segment(now().plusHours(1), now().plusHours(2)));
        segments_2.add(new Segment(now().plusHours(5), now().plusHours(6)));

        segments_3.add(new Segment(now().plusHours(2), now().plusHours(4)));
        segments_3.add(new Segment(now().plusHours(5), now().plusHours(7)));

        segments_4.add(new Segment(now().plusHours(2), now().plusHours(4)));
        segments_4.add(new Segment(now().plusHours(7), now().plusHours(8)));

        flights.add(new Flight(segments_1));
        flights.add(new Flight(segments_2));
        flights.add(new Flight(segments_3));
        flights.add(new Flight(segments_4));

        return flights;
    }

    private List<Flight> expected() {
        List<Flight> flights = new ArrayList<>();

        List<Segment> segments_1 = new ArrayList<>();
        List<Segment> segments_2 = new ArrayList<>();

        segments_1.add(new Segment(now().plusHours(1), now().plusHours(2)));
        segments_1.add(new Segment(now().plusHours(3), now().plusHours(4)));

        segments_2.add(new Segment(now().plusHours(2), now().plusHours(4)));
        segments_2.add(new Segment(now().plusHours(5), now().plusHours(7)));

        flights.add(new Flight(segments_1));
        flights.add(new Flight(segments_2));

        return flights;
    }
}