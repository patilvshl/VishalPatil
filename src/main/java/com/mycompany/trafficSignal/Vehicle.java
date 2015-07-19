/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trafficSignal;

/**
 * This class represents the moving vehicles on road and added to each direction
 * on junction. This can be evolved in future to perform any operation while
 * moving the vehicle.
 *
 * @author vshl
 */
public class Vehicle {

    private String name;

    Vehicle(int number) {
        this.name = "vehicle:" + number;
    }

    public String getName() {
        return name;
    }
    
}
