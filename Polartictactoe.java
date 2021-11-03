/* This is a game I wrote in high school (oops, there are no comments explaining what the code does).
  This class was intended to implement all the classes and components that ran the program. 
  The code is very bad at maintaining cohesion. I have a lot of variables, but only the 
  first method, the constructor, includes most of the variables. The variables player1turn 
  and player2turn are not used at all (again this was one of the first programs I wrote so I 
  did not know what I was doing). However, despite have a confusing number and use of variables
  the class is pretty short and is clearly used to initialize the board and then run the program. 
  These two functions, initializing and running the program should probably be separated. 
*/

import javax.swing.JFrame;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;

public class Polartictactoe extends JFrame {
	
	private PolarMenu menuBar;
	private PolarPanel whiteboard;
	private String player1turn= "Player one's turn";
	private String player2turn= "Player two's turn";
	private PlayerPanel board;
	private boolean player1, player2;
	
	public Polartictactoe()
	{
		super("Polar Tic-Tac-Toe");
		
		menuBar = new PolarMenu(this);
		setJMenuBar(menuBar);
		player1=true;
		player2=false;
		int p;
		if(player1)
			 p= 1;
		else p=2;
		
		board = new PlayerPanel(this,p);
		whiteboard = new PolarPanel(this,p, board);
		
		Box box = Box.createVerticalBox();
		box.add(board);
		box.add(whiteboard);
		getContentPane().add(box);
		
		newGame();
	}
	
	public void newGame()
	{
		board.newGame();
		whiteboard.newGame();
		requestFocus();
	}
	
	public void initialize()
	{
		whiteboard.initialize();
	}
	
	
	public static void main(String[] args)
	{
		String plafName = UIManager.getSystemLookAndFeelClassName();
		try
		{
			UIManager.setLookAndFeel(plafName);
		}
		catch(Exception ex)
		{
			System.out.println("***" + plafName + " PLAF not installed ***");
		}
		
		Polartictactoe window = new Polartictactoe();
		
		window.setBounds(300,300,300,350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);
		window.initialize();
	}

}
