/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trafficSignal;

/**
 * This is controller class for signaling system. it controls the traffic at
 * both road/Intersection of roads.
 *
 * @author vshl
 */
public class SignalController implements Runnable {

    private Road snell;
    private Road weaver;

    public SignalController(Road snell, Road weaver) {
        this.snell = snell;
        this.weaver = weaver;
    }

    @Override
    public void run() {
        try {
            snell.setToggled(Boolean.FALSE);
            long startTime = System.currentTimeMillis();
            while (true) {
                snell.startGreen();
                snell.startRed();

                snell.setToggled(Boolean.TRUE);
                weaver.setToggled(Boolean.TRUE);

                weaver.startGreen();
                weaver.startRed();

                if (((System.currentTimeMillis() - startTime) / 1000) > 1) {
                    System.out.println(" Stopping signal at:" + (System.currentTimeMillis() - startTime) / 1000);
                    System.exit(0);
                }
            }

        } catch (InterruptedException ex) {
            System.out.println("Exception occured while simulating  the signal" + ex);
        }
    }

}
