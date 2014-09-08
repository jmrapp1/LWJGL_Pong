package com.jmr.engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public abstract class Game {

	/** The width and height of the window. */
	private static int width, height;
	
	/** The title of the window. */
	private final String title;
	
	/** The last frame time. */
	private long lastFrame;
	
	/** Creates a new window and setups the OpenGL information.
	 * @param title The window title. 
	 * @param width The width of the window.
	 * @param height The height of the window.
	 */
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle(title);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		setupGL();
		create();
		lastFrame = getTime();
		while(!Display.isCloseRequested()) {
			/** Clears the screen. */
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			/** Gets the delta time. */
			double delta = getDelta();
			
			/** Update and renders the information. */
			update(delta);
			render();
			Display.update();
			
			/** Syncs the game at 60 fps. */
			Display.sync(60);
		}
		dispose();
		Display.destroy();
		System.exit(0);
	}
	
	private void setupGL() {
		/** Enables the use of textures. */
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	     
		/** Enables the possibility to blend and see the alpha of textures. */
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		/** Sets the matrix mode to projection. */
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		
		/** Resets the matrix. */
		GL11.glLoadIdentity();
		
		/** Sets the orthographic "camera" to (0, 0) at the top left and (width, height) at the bottom right. */
		GL11.glOrtho(0, width, height, 0, 1, -1);
	}
	
	/** Creates the game. */
	public abstract void create();
	
	/** Updates the game.
	 * @param delta The delta time.
	 */
	public abstract void update(double delta);
	
	/** Renders the game. */
	public abstract void render();
	
	/** Disposes remaining parts of the game when shutting down. */
	public abstract void dispose();
	
	/** @return The time. */
	private long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	/** @return The delta time. */
	private double getDelta() {
		long currentTime = getTime();
		/** Gets time between the last frame for the delta value. */
		double delta = (double) currentTime - (double) lastFrame;
		lastFrame = getTime();
		return delta;
	}
	
	/** @return The width of the window. */
	public static int getWidth() {
		return width;
	}

	/** @return The height of the window. */
	public static int getHeight() {
		return height;
	}
	
}
