/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trafficSignal;

import java.util.concurrent.BlockingQueue;

/**
 * This is Worker Thread to move the vehicle. This class will be evolved in
 * future to perform any operation while moving the car.
 *
 * @author vshl
 */
class SignalWorker implements Runnable {

    private BlockingQueue<Vehicle> roadLane;

    public SignalWorker(BlockingQueue<Vehicle> roadLane) {
        this.roadLane = roadLane;
    }

    @Override
    public void run() {
        try {
            roadLane.take();
        } catch (InterruptedException ex) {
            System.out.println("Exception occured while moving the vehicles" + ex);
        }
    }

}
