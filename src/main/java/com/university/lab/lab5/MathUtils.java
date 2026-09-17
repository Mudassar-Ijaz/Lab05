package com.university.lab.lab5;

/**
 * Lab Task 2 - Failing Fast on Precondition Violations
 *
 * Demonstrates throwing an unchecked exception immediately when a caller
 * violates a method's documented precondition, rather than allowing the
 * method to silently produce a wrong or nonsensical result.
 */
public class MathUtils {

    private static final double GRAVITY = 9.81; // m/s^2
    private static final double MASS = 1.0;     // kg (assumed unit mass for this exercise)

    /**
     * Calculates the gravitational potential energy of an object at the
     * given altitude, using PE = m * g * h with unit mass.
     *
     * @param altitude altitude in meters relative to sea level.
     *                 Requires altitude &gt;= 0.
     * @return the gravitational potential energy in joules
     * @throws IllegalArgumentException if altitude is negative
     */
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
