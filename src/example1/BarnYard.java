package example1;

import code.Properties;
import code.barnyard.Background;
import engine.Game;

public class BarnYard {
	private Game _game;

	private int _critters;
	
	private static int _numOfBarnYards = 0;

	public BarnYard() {
		if(_numOfBarnYards + 1 > Properties.BARNYARD_LIMIT){
			throw new Error("YOU OPENED THE MAX NUMBER OF BARNYARDS");
		}
		
		// create the game
		// System.setProperties(System.getProperties().getProperty("sun.java2d.opengl=True"));

		_game = new Game(Properties.SCREEN_WIDTH, Properties.SCREEN_HEIGHT,
				Properties.FRAMES_PER_SECOND, false);

		// set up the background
		_game.addEntity(new Background(), Properties.BACKGROUND_LAYER);

		_critters = 0;
		
		_numOfBarnYards++;
	}

	private void addCritter(Critter c) {
		if (_critters < Properties.CRITTER_LIMIT) {
			_game.addEntity(c, Properties.CRITTER_LAYER);
			_critters++;
		}else{
			System.err.println("You have added the maximum number of objects!");
		}
	}

	public void addButterfly(Butterfly b) {
		addCritter(b);
	}

	public void addPig(Pig p) {
		addCritter(p);
	}

	public void addChicken(Chicken c) {
		addCritter(c);
	}
}
