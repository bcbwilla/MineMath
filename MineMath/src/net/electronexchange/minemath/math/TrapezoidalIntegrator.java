package net.electronexchange.minemath.math;

import expr.expr.Evaluatable;

/**
 * Function integrator that implements the trapezoidal algorithm.
 */
public class TrapezoidalIntegrator implements Integrator
{
    /** the function to integrate */  private Evaluatable integrand;

    /**
     * Constructor.
     * @param integrand the function to integrate
     */
    public TrapezoidalIntegrator(Evaluatable integrand)
    {
        this.integrand = integrand;
    }

    /**
     * Integrate the function from a to b using the trapezoidal
     * algorithm, and return an approximation to the area.
     * (Integrator implementation.)
     * @param a the lower limit
     * @param b the upper limit
     * @param intervals the number of equal-width intervals
     * @return an approximation to the area
     */
    public double integrate(double a, double b, int intervals)
    {
        if (b <= a) return 0;

        double h         = (b - a)/intervals;    // interval width
        double totalArea = 0;

        // Compute the area using the current number of intervals.
        for (int i = 0; i < intervals; ++i) {
            double x1 = a + i*h;
            totalArea += areaOf(x1, h);
        }

        return totalArea;
    }

    /**
     * Compute the area of the ith trapezoidal region.
     * @param x1 the left bound of the region
     * @param h the interval width
     * @return the area of the region
     */
    private double areaOf(double x1, double h)
    {
        double x2   = x1 + h;            // right bound of the region
        double y1   = integrand.at(x1);  // value at left bound
        double y2   = integrand.at(x2);  // value at right bound
        double area = h*(y1 + y2)/2;     // area of the region

        return area;
    }
}