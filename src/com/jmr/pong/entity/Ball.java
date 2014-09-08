package com.jmr.pong.entity;

import javax.swing.JOptionPane;

import org.lwjgl.util.Rectangle;

import com.jmr.engine.Game;
import com.jmr.engine.render.RenderBatch;
import com.jmr.engine.vec.Vector2;

public class Ball extends Entity {
	
	/** The ball used for pong.
	 * @param pos The position to set it at. 
	 */
	public Ball(Vector2 pos) {
		super(pos);
		vel.set(4, 4);
	}
	
	/** The ball used for pong.
	 * @param x The x value.
	 * @param y The y value.
	 */
	public Ball(float x, float y) {
		super(x, y);
		vel.set(4, 4);
	}
	
	/** Updates the position of the ball and checks to see if the game is won.
	 */
	public void update(double delta) {
		/** Adds the velocity to the position. */
		pos.add(vel);
		
		/** Checks whether the ball hits the left or right side of the window behind the paddles. */
		if (pos.getX() <= -25) {
			JOptionPane.showMessageDialog(null, "You have lost!");
			System.exit(0);
		} else if (pos.getX() + 75 >= Game.getWidth()) {
			JOptionPane.showMessageDialog(null, "You have beat your opponent!");
			System.exit(0);
		}
		/** Checks if the ball hits the top or bottom and reverses the Y velocity value. */
		if (pos.getY() <= 0 - 25) {
			vel.mul(1, -1);
			pos.setY(0 - 25);
		} else if (pos.getY() + 75 >= Game.getHeight()) {
			vel.mul(1, -1);
			pos.setY(Game.getHeight() - 75);
		}
	}
	
	/** Draws the circle.
	 * @param rb The rendering information.
	 */
	public void render(RenderBatch rb) {
		rb.drawCircle(pos.getX(), pos.getY(), 25);
	}

	/** @return The collision rectangle. */
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)pos.getX(), (int)pos.getY(), 75, 75);
	}
	
}
