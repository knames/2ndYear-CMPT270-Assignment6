package model;

import util.RandomNumberGenerator;

public class InvaderScore extends Invader {

	protected int score;
	
	/**
	 * Initialize this instance.
	 * @param x			the initial x-coordinate
	 * @param y			the initial y-coordinate
	 * @param killWorth	the value of killing this invader
	 * @param level		the current level in the game
	 * @param game		the game being played
	 * @param score   the score of the invader
	 */
	public InvaderScore(int x, int y, int killWorth, int level, Game game) {
		super(x, y, killWorth, level, game);
		score = 0;
	}

	
	/**
	 * At each clock tick, decide whether to fire, and every
	 * changeFreq ticks move and change image.
	 */
	@Override
	protected void update()
	{
		float randomNum = RandomNumberGenerator.getInstance().getFloat();
		if (randomNum <= FIRE_PROBABILITY)
		{
			int missileX = x + (width - Missile.WIDTH)/2;
			int missileY = y + height;
			game.addMissile(new MissileScore(missileX, missileY, game, this));
		}

		int currentTick = game.getTicks();
		if (currentTick == changeDirectionTick)
		{
			moveDirection = - moveDirection;
			y = y + verticalMoveDistance;
		}

		if (currentTick % CHANGE_FREQ == 0)
		{
			x = x + (moveDirection * HORIZONTAL_MOVE_DIST);
			moveToNextImage();

			if (currentTick > changeDirectionTick)
			{
				// if next move would hit a side, switch direction and advance next move
				if (moveDirection == Invader.MOVE_RIGHT
						&& (x + width + HORIZONTAL_MOVE_DIST) > game.getWidth())
				{
					changeDirectionTick = currentTick + CHANGE_FREQ;
				}
				else if (moveDirection == Invader.MOVE_LEFT 
						&& x - HORIZONTAL_MOVE_DIST < 0)
				{
					changeDirectionTick = currentTick + CHANGE_FREQ;
				}
			}
		}
	}
}
