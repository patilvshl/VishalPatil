/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trafficSignal;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author vshl
 */
public class SignalControllerTest {

    @Test
    public void shouldSimulateTheSignal() throws InterruptedException {

        Road road1 = Mockito.mock(Road.class);
        Road road2 = Mockito.mock(Road.class);
        Mockito.doNothing().when(road1).startGreen();
        Mockito.doNothing().when(road1).startRed();
        Mockito.doNothing().when(road2).startGreen();
        Mockito.doNothing().when(road2).startRed();

        SignalController controller = Mockito.spy(new SignalController(road1, road2));
        Thread signal = Mockito.spy(new Thread(controller));
        signal.start();
        // Mockito.verify(controller).simulate();
    }

    @Test
    public void shouldThrowInterruptedExceptionWhileSimulating() throws InterruptedException {
        Road snell = Mockito.mock(Road.class);
        Road weaver = Mockito.mock(Road.class);
        SignalController controller = new SignalController(snell, weaver);

        Mockito.doThrow(new InterruptedException()).when(snell).startGreen();
        
        controller.run();

    }

}
