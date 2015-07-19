/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trafficSignal;

import java.util.concurrent.LinkedBlockingQueue;
import org.mockito.Mockito;
import org.testng.annotations.Test;

/**
 *
 * @author vshl
 */
public class RoadTest {

    @Test
    public void shouldMoveVehiclesOnGreenSignal() throws InterruptedException {
        Road road = Mockito.spy(new Road(new LinkedBlockingQueue<Vehicle>(), new LinkedBlockingQueue<Vehicle>(), true, true));

        Mockito.when(road.isToggled()).thenReturn(Boolean.TRUE);

        road.startGreen();

        Mockito.verify(road, Mockito.atLeast(2)).moveCars();
    }

    @Test
    public void shouldMoveVehiclesOnGreenSignalAfterRed() throws InterruptedException {
        Road road = Mockito.spy(new Road(new LinkedBlockingQueue<Vehicle>(), new LinkedBlockingQueue<Vehicle>(), true, true));

        Mockito.when(road.isToggled()).thenReturn(Boolean.FALSE);

        road.startGreen();

        Mockito.verify(road, Mockito.atLeast(3)).moveCars();
    }

    @Test
    public void shouldStopVehiclesOnRed() throws InterruptedException {
        Road road = Mockito.spy(new Road(new LinkedBlockingQueue<Vehicle>(), new LinkedBlockingQueue<Vehicle>(), true, true));
        road.startRed();
        Mockito.verify(road).startRed();
    }
}
