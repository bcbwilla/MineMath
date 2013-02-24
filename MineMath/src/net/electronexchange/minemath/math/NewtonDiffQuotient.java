package net.electronexchange.minemath.math;

import expr.expr.Evaluatable;


/**
 * Function differentiator that implements
 * Newton's difference quotient method
 */
public class NewtonDiffQuotient implements Derivative {
    /** the function to differentiate */  private Evaluatable func;
    /** small change in variable */  private double h = Math.sqrt(Epsilon.doubleValue());

    /**
     * Constructor.
     * @param func the function to differentiate
     */
    public NewtonDiffQuotient(Evaluatable func)
    {
        this.func = func;
    }
    /**
     * Find derivative of func at a using Newton's difference
     * quotient and return an approximation.
     * (Derivative implementation.)
     * @param a position of derivative
     * @return an approximation to the derivative at a
     */
    @Override
	public double derivative(double a) {
		double f1 = func.at(a+h);
		double f2 = func.at(a);
		return (f1 - f2) / h;
	}
}