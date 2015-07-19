/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trafficSignal;

/**
 * Defines all the constants.
 *
 * @author vshl
 */
public class Constants {

    public static final int CAR_ADD_INTERVAL = 1 * 50;
    public static final int RED_INTERVAL = 1 * 50;
    public static final int BLOCK_INTERVAL = 3 * 50;
    public static final int INITIAL_DELAY_FOR_FIRST_MOVE = 2;
    public static final int INITIAL_DELAY_FOR_SECOND_MOVE = 1;
    public static final int FIRST_PASS_INTERVAL_ON_TOGGLE = INITIAL_DELAY_FOR_FIRST_MOVE * 50;
    public static final int CAR_PASS_INTERVAL = INITIAL_DELAY_FOR_SECOND_MOVE * 50;

}
