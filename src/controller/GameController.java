/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.GameView;
import view.TileView;

/**
 * @author Frank J. Mitropoulos
 *
 */
public class GameController {
	// These aren't used, but could be depending on your gme and what you want to do
	private int score;
	private int gameStatus;
	private int rows;
	private int cols;
	
	private int moveNumber = 0;
	
	private GameView gameView;
	
	

	/**
	 * Create the GameView and pass in the appropriate listeners
	 */
	public GameController() {
		super();		
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
			
				gameView = new GameView("Title",6,6,null,new NewGameListener(), new TileTouchedListener());
				gameView.setVisible(true);	
				
			}
		});
		
	}
	
	// Listener used to process touches on TileView
	
	class TileTouchedListener implements ActionListener {
		@Override 
		public void actionPerformed(ActionEvent event) {
			TileView tv = (TileView) event.getSource();
			System.out.println("Tile touched..." + tv.toString());
			// TODO -- you implement this
			// delegate to GameView!
			gameView.processTouchedTile(tv);

			// If no move is available display a message
			//resets game
			if (!gameView.isMoveAvailable()) {
				JOptionPane.showMessageDialog(gameView,
					    "No more moves...");

			}
		}
		
	}
	
	// Listener used to process click on New Game Button
	
	class NewGameListener implements ActionListener {
		@Override 
		public void actionPerformed(ActionEvent event) {
			System.out.println("Starting new game...");
			//System.out.println("Not yet implemented..");
			// TODO
			// You implement this method. Delegate to GameView!
			gameView.newGame();
		}
		
	}
}
