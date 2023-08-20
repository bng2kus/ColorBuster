/**
 * 
 */
package view;
import javax.swing.JFrame;
import java.awt.*;

//import view.ScoreView;
//import view.ButtonView;
import view.BoardView;
import java.awt.event.*;

/**
 * @author Frank J. Mitropoulos
 *
 */
public class GameView extends JFrame {
	// Create the HUD Panel
	// Create the Board


	private static final long serialVersionUID = 1L;
	private ScoreView scoreView;
	private ButtonView buttonView;
	private BoardView boardView;

	private int score;

	// Setting defaul to 8x8

	int rows = 8, cols = 8;
	int width, height;


	ActionListener newGameListener;
	ActionListener tileTouchedListener;

	/**
	 * @param title
	 * @throws HeadlessException
	 */


	public GameView(String title, int rows, int cols, MouseListener listener, ActionListener newGameListener, ActionListener tileTouched) throws HeadlessException {
		super(title);
		setResizable(false);

		width = 400;
		height = 500;
		score = 0;
		this.rows = rows;
		this.cols = cols;

		this.newGameListener = newGameListener;
		this.tileTouchedListener = tileTouched;

		// Set up some reasonable sizes for the gameview

		setBounds(100,50,width, height);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		scoreView = new ScoreView();
		add(scoreView, BorderLayout.NORTH);

		buttonView = new ButtonView(newGameListener);
		add(buttonView, BorderLayout.SOUTH);

		boardView = new BoardView(rows,cols, tileTouchedListener);
		add(boardView, BorderLayout.CENTER);

		setVisible(true);

	}

	// Delegate to boardView
	public boolean isMoveAvailable() {
		// TODO you need to delegate this behavior to the boardView
		if(boardView.isMoveAvailable()){
			return true;
		}
		else{
			return false;
		}
	}

	// Call this method to start a new Game

	public void newGame() {
		// Recreate some components and update the GUI.

		Container c = getContentPane();
		c.remove(boardView);
		c.invalidate();
		pack();

		boardView = null;
		score = 0;
		scoreView.resetTotalScore();
		scoreView.updateScore(score);

		boardView = new BoardView(rows,cols, tileTouchedListener);

		add(boardView, BorderLayout.CENTER);
		pack();
		revalidate();
		setBounds(100,50,width, height);

		System.out.println(boardView);  // debug
	}

	public void processTouchedTile(TileView tv) {
		// TODO
		// You need to implement this method. It is called when a tileview is touched
		int score;
		System.out.println("GameView == processing tile touch");
		score = boardView.processTouchedTile(tv);
		//score update here
		scoreView.updateScore(score);

		System.out.println(boardView); // debug
	}


}
