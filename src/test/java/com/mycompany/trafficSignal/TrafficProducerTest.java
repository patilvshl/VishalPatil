/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trafficSignal;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author vshl
 */
public class TrafficProducerTest {

    @Test
    public void shouldAddVehiclesToAllDirections() throws InterruptedException {
        TrafficProducer p = Mockito.spy(new TrafficProducer(new LinkedBlockingQueue<Vehicle>(), new LinkedBlockingQueue<Vehicle>(), new LinkedBlockingQueue<Vehicle>(), new LinkedBlockingQueue<Vehicle>()));
        Thread producer = Mockito.spy(new Thread(p));
        producer.start();
        Thread.sleep(500);
        // Mockito.verify(producer).run();
        Mockito.verify(p).populateVehicles();
    }
    
    @Test(enabled =false)
    public void testTheNumberOfVehiclesAdded() throws InterruptedException {
        BlockingQueue snellN = new LinkedBlockingQueue();
        BlockingQueue snellS = new LinkedBlockingQueue();
        BlockingQueue weaverE = new LinkedBlockingQueue();
        BlockingQueue weaverW = new LinkedBlockingQueue();
        TrafficProducer producer = new TrafficProducer(snellN, snellS, weaverE, weaverW);

        producer.populateVehicles();
        
        Assert.assertEquals(snellN.size(), 21);
        Assert.assertEquals(snellS.size(), 21);
        Assert.assertEquals(weaverE.size(), 21);
        Assert.assertEquals(weaverW.size(), 21);
    }
    
    @Test
    public void shouldThrowInterruptedExceptiOnAddVehicle() throws InterruptedException {
        BlockingQueue snellN = Mockito.mock(BlockingQueue.class);
        BlockingQueue snellS = Mockito.mock(BlockingQueue.class);
        BlockingQueue weaverE = Mockito.mock(BlockingQueue.class);
        BlockingQueue weaverW = Mockito.mock(BlockingQueue.class);
        TrafficProducer producer = new TrafficProducer(snellN, snellS, weaverE, weaverW);
        Mockito.when(snellN.size()).thenReturn(1);
        Mockito.when(snellS.size()).thenReturn(1);
        Mockito.when(weaverE.size()).thenReturn(1);
        Mockito.when(weaverW.size()).thenReturn(1);

        Mockito.doThrow(new InterruptedException()).when(snellN).put((Vehicle) Mockito.anyObject());
        //check for catched exception
        producer.run();
    }
}
