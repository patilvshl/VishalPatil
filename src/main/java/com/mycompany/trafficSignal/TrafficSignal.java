/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trafficSignal;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This is Main class which will start the population of vehicles in each
 * direction at specified time interval and also start the signaling unit which
 * will control the traffic.
 *
 * @author vshl
 */
public class TrafficSignal {

    public static void main(String[] args) {
        BlockingQueue<Vehicle> snellN = new LinkedBlockingQueue<>();
        BlockingQueue<Vehicle> snellS = new LinkedBlockingQueue<>();
        BlockingQueue<Vehicle> weaverE = new LinkedBlockingQueue<>();
        BlockingQueue<Vehicle> weaverW = new LinkedBlockingQueue<>();

        Road snell = new Road(snellN, snellS, false, false);
        Road weaver = new Road(weaverE, weaverW, false, false);

        new Thread(new TrafficProducer(snellN, snellS, weaverE, weaverW)).start();
        new Thread(new SignalController(snell, weaver)).start();
    }
}
