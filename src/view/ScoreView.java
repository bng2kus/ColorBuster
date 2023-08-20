/**
 * 
 */
package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;


/**
 * @author Frank J. Mitropoulos
 * 
 *  A very simple score panel
 *  call updateScore and pass in the score to update the display
 */
public class ScoreView extends JPanel {

	int matches;

	int totalScore;

	private static final long serialVersionUID = 1L;
	
	private JLabel scoreLabel;
	
	public ScoreView() {
		scoreLabel = new JLabel("Score: 0");
		add(scoreLabel);

	}

	public void resetTotalScore(){
		totalScore = 0;
	}
	
	public void updateScore(int matches) {
		int scoreCounter = getScore(matches);
		totalScore += scoreCounter;
		scoreLabel.setText("Score: " + totalScore);
	}

	public int getScore(int matches){
		if(matches <= 2){
			return 0;
		}
		else if(matches == 3){
			return 200;
		}
		else if(matches == 4){
			return 400;
		}
		else if(matches == 5){
			return 600;
		}
		else{
			return 800;
		}

	}
}
