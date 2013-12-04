package invaderScore;

import java.awt.BorderLayout;


import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import view.ViewPanel;

import model.GameInfoProvider;
import model.GameObserver;

/**
 * A panel to display the Invader scores
 */
public class InvaderScorePanel extends ViewPanel implements GameObserver
{
	static final int FONT_SIZE = 72;

	public static final long serialVersionUID = 1;
	
	/**
	 * The object that provides information about the game.
	 */
	private GameInfoProvider gameInfo;
	
	/** The printout of Invaders and their Scores*/
	private String invaderScore;


	public InvaderScorePanel(int width, int height, ActionListener listener)
	{
		JPanel scorePanel = new JPanel();
		add(scorePanel,BorderLayout.CENTER);
		JTextArea scoreArea = new JTextArea(invaderScore,42,35);
		scoreArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(scoreArea);
		scorePanel.add(scrollPane);
		//gameInfo.addObserver(scorePanel);
	}

	@Override
	public void gameChanged() 
	{
		List<model.InvaderScore> invaderList;
		invaderList = gameInfo.getInvaderScore();
		invaderScore = invaderList.toString();
	}
	


}
