package com.university.lab.lab5;


public class MathUtils {

    private static final double GRAVITY = 9.81; 
    private static final double MASS = 1.0;    

  
    public static double calculateGravitationalPotentialEnergy(double altitude) {
        if (altitude < 0) {
            throw new IllegalArgumentException(
                    "altitude must be >= 0, but was: " + altitude);
        }
        return MASS * GRAVITY * altitude;
    }

    public static void main(String[] args) {
        System.out.println("PE at 0m:    " + calculateGravitationalPotentialEnergy(0));
        System.out.println("PE at 10m:   " + calculateGravitationalPotentialEnergy(10));
        System.out.println("PE at 100m:  " + calculateGravitationalPotentialEnergy(100));

        try {
            calculateGravitationalPotentialEnergy(-5);
            System.out.println("No exception thrown (unexpected!)");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}
