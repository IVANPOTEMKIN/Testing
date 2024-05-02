package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.util.List;

/**
 * Сервис фильтрации рейсов.
 */
public interface FlightFilter {

    /**
     * Фильтрация вылета до текущего момента
     */
    List<Flight> departureBeforeCurrentTime(List<Flight> flights);

    /**
     * Фильтрация прибытия до отправки
     */
    List<Flight> arrivalBeforeDeparture(List<Flight> flights);

    /**
     * Фильтрация превышения времени пребывания на земле
     */
    List<Flight> exceedingTimeStay(List<Flight> flights);
}