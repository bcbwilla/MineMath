package net.electronexchange.minemath.math;

import expr.expr.Evaluatable;

public class FivePointStencil implements Derivative {
    /** the function to differentiate */  private Evaluatable func;
    /** small change in variable */  private double h = Math.sqrt(Epsilon.doubleValue());

    /**
     * Constructor.
     * @param integrand the function to differentiate
     */
    public FivePointStencil(Evaluatable func)
    {
        this.func = func;
    }
	
    /**
     * Find derivative of func at a using the five point
     * stencil and return an approximation.
     * (Derivative implementation.)
     * @param a position of derivative
     * @return an approximation to the derivative at a
     */	
	@Override
	public double derivative(double a) {
		if(a!=0){
			h = h*a;
		}
		double f1 = -func.at(a+2*h);
		double f2 = 8*func.at(a+h);
		double f3 = -8*func.at(a-h);
		double f4 = func.at(a-2*h);		
		return (f1 + f2 + f3 + f4) / (12*h);
	}
	

}
