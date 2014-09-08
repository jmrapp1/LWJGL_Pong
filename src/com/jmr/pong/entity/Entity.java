package com.jmr.pong.entity;

import org.lwjgl.util.Rectangle;

import com.jmr.engine.render.RenderBatch;
import com.jmr.engine.vec.Vector2;

public abstract class Entity {

	/** The position and velocity of the entity. */
	protected Vector2 pos, vel;
	
	/** Entity extended by objects that want to be drawn and updated in the game.
	 * @param pos The position.
	 */
	public Entity(Vector2 pos) {
		this.pos = pos;
		vel = new Vector2(0, 0);
	}
	
	/** Entity extended by objects that want to be drawn and updated in the game.
	 * @param x The x position.
	 * @param y The y position.
	 */
	public Entity(float x, float y) {
		this(new Vector2(x, y));
	}
	
	/** Updates the entity.
	 * @param delta The delta time.
	 */
	public abstract void update(double delta);
	
	/** Draws the entity.
	 * @param rb The rendering information.
	 */
	public abstract void render(RenderBatch rb);
	
	/** @return The collision rectangle. */
	public abstract Rectangle getBounds();
	
	/** @return The position. */
	public Vector2 getPos() {
		return pos;
	}
	
	/** @return The velocity. */
	public Vector2 getVel() {
		return vel;
	}
	
}
