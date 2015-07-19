/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trafficSignal;

import java.util.concurrent.BlockingQueue;

/**
 * This class will populate the vehicles in each direction at specified
 * interval.
 *
 * @author vshl
 */
class TrafficProducer implements Runnable {

    public BlockingQueue<Vehicle> snellN;
    public BlockingQueue<Vehicle> snellS;
    public BlockingQueue<Vehicle> weaverE;
    public BlockingQueue<Vehicle> weaverW;

    public TrafficProducer() {
    }

    public TrafficProducer(BlockingQueue<Vehicle> snellN, BlockingQueue<Vehicle> snellS, BlockingQueue<Vehicle> weaverE, BlockingQueue<Vehicle> weaverW) {
        this.snellN = snellN;
        this.snellS = snellS;
        this.weaverE = weaverE;
        this.weaverW = weaverW;
    }

    @Override
    public void run() {
        try {
            populateVehicles();
        } catch (InterruptedException ex) {
            System.out.println("Exception occured while adding Vehicles to roads" + ex);
        }
    }

    public void populateVehicles() throws InterruptedException {
        System.out.println("Adding Vehicles to each direction:");
        int i = 0;
        StringBuffer statusAtIntersection = new StringBuffer();
        while (true) {
            statusAtIntersection.append(i).append(getStatusForSnell()).append(getStatusForWeaver()).append("\n");
            this.snellN.put(new Vehicle(i));
            this.snellS.put(new Vehicle(i));
            this.weaverE.put(new Vehicle(i));
            this.weaverW.put(new Vehicle(i));
            i++;
            if (21 == i) {
                System.out.println(statusAtIntersection);
                break;
            }
            Thread.sleep(Constants.CAR_ADD_INTERVAL);
        }
    }

    private String getStatusForWeaver() {
        return " E:= "+this.weaverE.size()+" W:= " + this.weaverE.size();
    }

    private String getStatusForSnell() {
        return ": N:= " + this.snellN.size()+ " S:= " + this.snellS.size();
    }
}
