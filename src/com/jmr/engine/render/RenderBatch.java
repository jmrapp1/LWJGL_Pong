package com.jmr.engine.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.opengl.Texture;

public class RenderBatch {

	/** Holds a color that is used when drawing shapes. */
	private Color color;
	
	/** Holds rendering information and draws shapes and textures. */
	public RenderBatch() {
		color = new Color(1, 1, 1, 1);
	}
	
	/** Draws a rectangle. 
	 * @param r The rectangle model. 
	 */
	public void drawRect(Rectangle r) {
		drawRect(r.getX(), r.getY(), r.getWidth(), r.getHeight());
	}
	
	/** Draws a rectangle.
	 * @param x The x position.
	 * @param y The y position.
	 * @param width The width.
	 * @param height The height.
	 */
	public void drawRect(float x, float y, float width, float height) {
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(x, y, 0);
			GL11.glBegin(GL11.GL_POLYGON);
			GL11.glColor4f(color.getR(), color.getG(), color.getB(), color.getA());
			GL11.glVertex2f(width, 0);
			GL11.glVertex2f(0, 0);
			GL11.glVertex2f(0, height);
			GL11.glVertex2f(width, height);
			GL11.glEnd();
		}
		GL11.glPopMatrix();
	}
	
	/** Draws a circle.
	 * @param circle The circle model.
	 */
	public void drawCircle(Circle circle) {
		drawCircle(circle.getX(), circle.getY(), circle.getRadius(), 360);
	}
	
	/** Draws a circle.
	 * @param circle The circle model.
	 * @param numSegs The amount of segments to put in the circle. 
	 */
	public void drawCircle(Circle circle, int numSegs) {
		drawCircle(circle.getX(), circle.getY(), circle.getRadius(), numSegs);
	}
	
	/** Draws a circle.
	 * @param x The x position.
	 * @param y The y position.
	 * @param radius The radius.
	 * @param numSegs The amount of segments to put in the circle.
	 */
	public void drawCircle(float x, float y, float radius, int numSegs) {
		/** Pushes the matrix to not effect any other part of the matrix. */
		GL11.glPushMatrix();
		{
			/** Translates to the position. */
			GL11.glTranslatef(x + (radius * 2), y + (radius * 2), 0);
			/** Begins drawing the circle. */
			GL11.glBegin(GL11.GL_LINE_LOOP);
			/** Sets the color to the render batch color. */
			GL11.glColor4f(color.getR(), color.getG(), color.getB(), color.getA());
			
			/** Draws each segment. */
			for (int i = 0; i < numSegs; i++) {
				double theta = ((2.0f * Math.PI * i) / numSegs); //get the current angle 

				float nx = (float) (radius * Math.cos(theta));//calculate the x component 
				float ny = (float) (radius * Math.sin(theta));//calculate the y component
				
				GL11.glVertex2f(nx, ny);
			}
			GL11.glEnd();
		}
		GL11.glPopMatrix();
	}
	
	/** Draws a circle.
	 * @param x The x position.
	 * @param y The y position.
	 * @param radius The radius. 
	 */
	public void drawCircle(float x, float y, float radius) {
		drawCircle(x, y, radius, 360);
	}
	
	/** Draws a texture.
	 * @param tex The texture to draw.
	 * @param x The x position.
	 * @param y The y position.
	 */
	public void drawTexture(Texture tex, float x, float y) {
		/** Binds the texture. (same as glBind). */
		tex.bind();
		/** Pushes the matrix to not affect any other parts. */
		GL11.glPushMatrix();
		{
			/** Gets the width and height of the image. */
			float width = tex.getImageWidth();
			float height = tex.getImageHeight();

			/** Translates to the position. */
			GL11.glTranslatef(x, y, 0);
			
			/** Draws a rectangle according to the image size. */
			GL11.glBegin(GL11.GL_POLYGON);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2f(0, 0);
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2f(0, height);
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2f(width, height);
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2f(width, 0);
			GL11.glEnd();
		}
		GL11.glPopMatrix();
	}
	
	/** Sets the color.
	 * @param color The color to set.
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/** @return The current color being used. */
	public Color getColor() {
		return color;
	}
	
}
