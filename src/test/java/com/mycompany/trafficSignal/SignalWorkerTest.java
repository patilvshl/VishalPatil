/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trafficSignal;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import junit.framework.Assert;
import org.mockito.Mockito;
import org.testng.annotations.Test;

/**
 *
 * @author vshl
 */
public class SignalWorkerTest {

    @Test
    public void shouldMoveVehicle() throws InterruptedException {
        BlockingQueue<Vehicle> roadLane = new LinkedBlockingQueue<>();
        roadLane.add(new Vehicle(1));
        roadLane.add(new Vehicle(2));
        
        SignalWorker p = Mockito.spy(new SignalWorker(roadLane));
        Thread worker = Mockito.spy(new Thread(p));
        
        Assert.assertEquals("Before start ", 2, roadLane.size());
        worker.start();
        p.run();
        //Mockito.verify(worker).run();
        Assert.assertEquals("After start ", 1, roadLane.size());
    }
}
