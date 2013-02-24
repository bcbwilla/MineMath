package net.electronexchange.minemath.math;


/**
 * Interface implemented by derivative classes.
 */
public interface Derivative
{
    /**
     * Take derivative of the function at a,
     * and return an approximation.
     * @param a location of derivative
     * @return an approximation to derivative
     */
    double derivative(double a);
}