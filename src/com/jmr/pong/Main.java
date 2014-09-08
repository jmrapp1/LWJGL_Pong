package com.jmr.pong;

import org.lwjgl.input.Keyboard;

import com.jmr.engine.Game;
import com.jmr.engine.render.RenderBatch;
import com.jmr.pong.entity.Ball;
import com.jmr.pong.entity.Paddle;

public class Main extends Game {

	/** The pong ball. */
	private Ball ball;
	
	/** The player and opponent paddle that hit the ball. */
	private Paddle playerPaddle, opponentPaddle;
	
	/** The rendering information object. */
	private RenderBatch rb;
	
	/** Creates a new game instance.
	 * @param title Window title.
	 * @param width The width of the window.
	 * @param height The height of the window.
	 */
	public Main(String title, int width, int height) {
		super(title, width, height);
	}

	/** Instantiates the ball, player paddle, and opponent paddle for the game. Also creates
	 * a new render batch to be used throughout the program.
	 */
	@Override
	public void create() {
		ball = new Ball(Game.getWidth() / 2, Game.getHeight() / 2);
		playerPaddle = new Paddle(30, Game.getHeight() / 2 - 50);
		opponentPaddle = new Paddle(Game.getWidth() - 30 - 30, Game.getHeight() / 2 - 50);
		rb = new RenderBatch();
	}

	/** Updates all of the entities. Checks for collisions between the entities and for input.
	 * @param delta The delta time.
	 */
	@Override
	public void update(double delta) {
		ball.update(delta);
		playerPaddle.update(delta);
		opponentPaddle.update(delta);
		
		checkCollisions();
		checkInput();
	}
	
	/** Checks whether the keys were pressed to move. */
	private void checkInput() {
		if (Keyboard.isKeyDown(Keyboard.KEY_W))
			playerPaddle.getVel().add(0, -.4f);
		if (Keyboard.isKeyDown(Keyboard.KEY_S))
			playerPaddle.getVel().add(0, .4f);
	}
	
	/** Checks all collisions between the ball and paddles. */
	private void checkCollisions() {
		
		/** Moves the opponent's paddle torwards the Y of the ball. Very basic AI. */
		if (opponentPaddle.getPos().getY() < ball.getPos().getY()) {
			opponentPaddle.getVel().add(0, .4f);
		} else if (opponentPaddle.getPos().getY() > ball.getPos().getY()) {
			opponentPaddle.getVel().add(0, -.4f);
		}
		
		/** Checks if the ball intersects the players paddle. */
		if (ball.getBounds().intersects(playerPaddle.getBounds())) {
			/** Checks whether or not the ball hits the top or bottom of the paddle to reverse the y velocity value. */
			if (playerPaddle.getTopBounds().intersects(ball.getBounds())) {
				ball.getVel().mul(1, -1);
				ball.getPos().sub(0, 10); //Ball gets stuck without this
			} else if (playerPaddle.getBottomBounds().intersects(ball.getBounds())) {
				ball.getVel().mul(1, -1);
				ball.getPos().add(0, 10); //Ball gets stuck without this
			}
			/** Reverses the x velocity of the ball. */
			ball.getVel().mul(-1, 1);
		}
		
		/** Checks if the ball intersects the opponents paddle. */
		if (ball.getBounds().intersects(opponentPaddle.getBounds())) {
			/** Checks whether or not the ball hits the top or bottom of the paddle to reverse the y velocity value. */
			if (opponentPaddle.getTopBounds().intersects(ball.getBounds())) {
				ball.getVel().mul(1, -1);
				ball.getPos().sub(0, 10); //Ball gets stuck without this
			} else if (opponentPaddle.getBottomBounds().intersects(ball.getBounds())) {
				ball.getVel().mul(1, -1);
				ball.getPos().add(0, 10); //Ball gets stuck without this
			}
			/** Reverses the x velocity of the ball. */
			ball.getVel().mul(-1, 1);
		}
	}

	/** Draws all of the entities. */
	@Override
	public void render() {
		ball.render(rb);
		playerPaddle.render(rb);
		opponentPaddle.render(rb);
	}

	@Override
	public void dispose() {
		
	}

	/** Starts the program and sets the window information. */
	public static void main(String[] args) {
		new Main("Pong", 640, 480);
	}
	
}
