/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trafficSignal;

import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author vshl
 */
public class VehicleTest {

    @Test
    public void shouldCreateVehicleWithId() {
        Vehicle vehicle = new Vehicle(1);
        Assert.assertEquals("Should be equal", "vehicle:1", vehicle.getName());
    }
}
