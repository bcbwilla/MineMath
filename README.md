MineMath
========

(Minecraft*Math)/craft

This bukkit plugin adds some basic chat command mathematics capabilities
to Minecraft.  Hurray!

Using MineMath
==============
Basic Calculations - "/calc"
----------------------------------------
Do arithmetic using the command "/calc".

Usage:
/calc [expression]

Examples:  
/calc (2+8)/5  
(2+8)/5 = 2.0

/calc sin(pi/2)^2  
cos(pi)^2 = 1.0

Numerical Derivatives - "/derivative"
-------------------------------------
Differentiate a function at a point

Usage:  
/derivative [function] [variable] [point]

Example:
/derivative sin(x) x 0  
Derivative of sin(x) at 0:  
1.0

Numerical Integration - "/integrate"
------------------------------------
Differentiate a function at a point

Usage:  
/derivative [function] [variable] [point]

Example:  
/integrate 3*x^2 x 0 1  
Integral of 2*x^2 from 0.0 to 1.0:  
1.0000000000000004

(note the tiny amount of numerical noise at the end)

Other Stuff
===========

The plugin uses [expr](https://github.com/darius/expr) to parse the
math input.

Many of the numerical classes are based on examples in the great book
[Java Number Cruncher](http://www.apropos-logic.com/nc/) by Ronald Mak.
