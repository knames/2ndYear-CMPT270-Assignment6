package invaderScore;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
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

	/**
	 * Create an Invader scores panel, with the invader scores, 
	 * @param width   	the width of the panel
	 * @param height  	the height of the panel
	 * @param listener	the class listening for the event 
	 *                	that signals the button was pressed
	 */
	public InvaderScorePanel(int width, int height, ActionListener listener)
	{
		setSize(width, height);
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JLabel titleLabel = new JLabel("Invader Score");
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(titleLabel);
		
		JPanel scorePanel = new JPanel();
		add(scorePanel,BorderLayout.CENTER);
		JTextArea scoreArea = new JTextArea(invaderScore,42,35);
		scoreArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(scoreArea);
		scorePanel.add(scrollPane);
		gameInfo.addObserver(this);
	}

	@Override
	public void gameChanged() 
	{
		List<model.InvaderScore> invaderList;
		invaderList = gameInfo.getInvaderScore();
		invaderScore = invaderList.toString();
		
		
	}
	


}
