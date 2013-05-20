package net.electronexchange.minemath.math;

/**
 * Interface implemented by integrator classes.
 */
public interface Integrator
{
    /**
     * Integrate the function from a to b,
     * and return an approximation to the area.
     * @param a the lower limit
     * @param b the upper limit
     * @param intervals the number of equal-width intervals
     * @return an approximation to the area
     */
    double integrate(double a, double b, int intervals);
}