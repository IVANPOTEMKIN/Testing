package com.gridnine.testing.builder;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Фабричный класс для получения рейсов.
 */
public class FlightBuilder {

    /**
     * Метод создания списка полетов.
     */
    public static List<Flight> createFlights() {

        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);

        return Arrays.asList(
                // Обычный полет продолжительностью в два часа
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                // Обычный многосегментный полет
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)),
                // Рейс, вылетевший в прошлом
                createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow),
                // Рейс, который отправляется раньше, чем прибывает
                createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6)),
                // Рейс с пребыванием на земле более двух часов
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)),
                // Очередной рейс с пребыванием на земле более двух часов
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4),
                        threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7)));
    }

    /**
     * Метод создания полета.
     */
    private static Flight createFlight(final LocalDateTime... dates) {
        if ((dates.length % 2) != 0) {
            throw new IllegalArgumentException(
                    "you must pass an even number of dates");
        }

        List<Segment> segments = new ArrayList<>(dates.length / 2);

        for (int i = 0; i < (dates.length - 1); i += 2) {
            segments.add(new Segment(dates[i], dates[i + 1]));
        }
        return new Flight(segments);
    }
}