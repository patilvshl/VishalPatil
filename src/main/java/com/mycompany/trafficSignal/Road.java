/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trafficSignal;

import java.util.concurrent.BlockingQueue;

/**
 * This class represents Road having two lanes for each direction. The
 * startGreen() and startRed() will be signaled from controller to move the
 * traffic on road in each direction.
 *
 * @author vshl
 */
public class Road {

    private boolean toggled = false;
    private boolean isBlocked = false;

    private BlockingQueue<Vehicle> rightLane; //north & east
    private BlockingQueue<Vehicle> leftLane;  //south & west

    public Road(BlockingQueue<Vehicle> rightLane, BlockingQueue<Vehicle> leftLane, boolean toggled, boolean isBlocked) {
        this.rightLane = rightLane;
        this.leftLane = leftLane;
        this.toggled = toggled;
        this.isBlocked = isBlocked;
    }

    public void startGreen() throws InterruptedException {
        if (isToggled()) {
            Thread.sleep(Constants.CAR_PASS_INTERVAL);
            moveCars();
            Thread.sleep(Constants.CAR_PASS_INTERVAL);
        } else {
            moveCars();
            Thread.sleep(Constants.CAR_PASS_INTERVAL);
            moveCars();
            Thread.sleep(Constants.CAR_PASS_INTERVAL);
        }
        moveCars();
        Thread.sleep(Constants.CAR_PASS_INTERVAL);
    }

    public void moveCars() {
        new Thread(new SignalWorker(rightLane)).start();
        new Thread(new SignalWorker(leftLane)).start();
    }

    public void startRed() throws InterruptedException {
        Thread.sleep(Constants.RED_INTERVAL);
    }
    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

}
