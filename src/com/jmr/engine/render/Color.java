package com.jmr.engine.render;

public class Color {

	/** The RGBA values. */
	private float r, g, b, a;
	
	/** Represents a RGB color with an alpha value. */
	public Color(float r, float g, float b, float a) {
		set(r, g, b, a);
	}
	
	/** Sets the RGBA values of the color.
	 * @param r The red value.
	 * @param g The green value.
	 * @param b The blue value.
	 * @param a The alpha value.
	 */
	public void set(float r, float g, float b, float a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	/** @return The red value. */
	public float getR() {
		return r;
	}

	/** @return The green value. */
	public float getG() {
		return g;
	}

	/** @return The blue value. */
	public float getB() {
		return b;
	}

	/** @return The alpha value. */
	public float getA() {
		return a;
	}
	
}
