package com.jmr.engine.vec;

public class Vector2 {

	/** The x and y values. */
	private float x, y;
	
	/** Holds x and y values to do different mathematical equations. */
	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/** Sets the position.
	 * @param x The x value.
	 * @param y The y value.
	 */
	public void set(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/** Sets the x position. 
	 * @param x The x value.
	 */
	public void setX(float x) {
		this.x = x;
	}
	
	/** Sets the y position. 
	 * @param y The y value.
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	/** Adds another vector's values to this.
	 * @param vec The vector.
	 */
	public void add(Vector2 vec) {
		add(vec.getX(), vec.getY());
	}
	
	/** Adds a certain amount to the x and y value.
	 * @param amount The amount.
	 */
	public void add(float amount) {
		add(amount, amount);
	}
	
	/** Adds an amount to the x and y value.
	 * @param x The x amount.
	 * @param y The y amount.
	 */
	public void add(float x, float y) {
		this.x += x;
		this.y += y;
	}
	
	/** Subtracts another vector's values from this.
	 * @param vec The vector.
	 */
	public void sub(Vector2 vec) {
		sub(vec.getX(), vec.getY());
	}
	
	/** Subtracts a certain amount from the x and y value.
	 * @param amount The amount.
	 */
	public void sub(float amount) {
		sub(amount, amount);
	}
	
	/** Subtracts an amount from the x and y value.
	 * @param x The x amount.
	 * @param y The y amount.
	 */
	public void sub(float x, float y) {
		this.x -= x;
		this.y -= y;
	}
	
	/** Multiplies another vector's values to this.
	 * @param vec The vector.
	 */
	public void mul(Vector2 vec) {
		mul(vec.getX(), vec.getY());
	}
	
	/** Multiplies a certain scalar to the x and y value.
	 * @param scalar The scalar.
	 */
	public void mul(float scalar) {
		mul(scalar, scalar);
	}
	
	/** Multiplies an amount to the x and y value.
	 * @param x The x amount.
	 * @param y The y amount.
	 */
	public void mul(float x, float y) {
		this.x *= x;
		this.y *= y;
	}
	
	/** Divides another vector's values from this.
	 * @param vec The vector.
	 */
	public void div(Vector2 vec) {
		div(vec.getX(), vec.getY());
	}
	
	/** Divides a certain scalar from the x and y value.
	 * @param scalar The scalar.
	 */
	public void div(float scalar) {
		div(scalar, scalar);
	}

	/** Divides an amount from the x and y value.
	 * @param x The x amount.
	 * @param y The y amount.
	 */
	public void div(float x, float y) {
		this.x /= x;
		this.y /= y;
	}
	
	/** @return The x value. */
	public float getX() {
		return x;
	}
	
	/** @return The y value. */
	public float getY() {
		return y;
	}
	
	/** @return The x and y in a string. */
	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
	
}
