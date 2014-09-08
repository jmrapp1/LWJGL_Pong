package com.jmr.pong.entity;

import org.lwjgl.util.Rectangle;

import com.jmr.engine.Game;
import com.jmr.engine.render.RenderBatch;
import com.jmr.engine.vec.Vector2;

public class Paddle extends Entity {

	/** The max velocity of the paddle. */
	private static final float MAX_VEL = 4;
	
	/** The paddle used by the player and opponent to hit the ball. 
	 * @param pos The position.
	 */
	public Paddle(Vector2 pos) {
		super(pos);
	}

	/** The paddle used by the player and opponent to hit the ball. 
	 * @param x The x position.
	 * @param y The y position.
	 */
	public Paddle(float x, float y) {
		super(x, y);
	}

	/** Updates the paddle and does checks on the position and velocity.
	 * @param delta The delta time.
	 */
	@Override
	public void update(double delta) {
		/** Checks if the velocity goes over the max velocity specified. */
		if (vel.getY() < -MAX_VEL)
			vel.setY(-MAX_VEL);
		if (vel.getY() > MAX_VEL)
			vel.setY(MAX_VEL);
		
		/** Adds the velocity to the position. */
		pos.add(vel);
		
		/** Subtracts a small amount from the velocity to give the effect it's slowing down. */ 
		vel.sub(0, (vel.getY() < 0 ? -1 : 1) * .3f);
		
		/** Checks if the paddle hits the top or bottom of the window and stops it. */
		if (pos.getY() < 0)
			pos.setY(0);
		if (pos.getY() > Game.getHeight() - 100)
			pos.setY(Game.getHeight() - 100);
	}

	/** Draws the rectangle paddle.
	 * @param rb The render information.
	 */
	@Override
	public void render(RenderBatch rb) {
		rb.drawRect(pos.getX(), pos.getY(), 30, 100);
	}
	
	/** @return The collision rectangle of the paddle. */
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)pos.getX(), (int)pos.getY(), 30, 100);
	}

	/** @return The top collision rectangle of the paddle. */
	public Rectangle getTopBounds() {
		return new Rectangle((int)pos.getX() + 7, (int)pos.getY(), 15, 5);
	}

	/** @return The bottom collision rectangle of the paddle. */
	public Rectangle getBottomBounds() {
		return new Rectangle((int)pos.getX() + 7, (int)pos.getY() + 100, 15, 5);
	}
	
}
