MineMath
========

(Minecraft*Math)/craft

This bukkit plugin adds some basic chat command mathematics capabilities
to Minecraft.

Using MineMath
==============
Basic Calculations - "/calc"
---------------------------
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


Other Stuff
===========

The plugin uses [expr](https://github.com/darius/expr) to parse the
math input.

Many of the numerical classes are based on examples in the great book
[Java Number Cruncher](http://www.apropos-logic.com/nc/) by Ronald Mak.
