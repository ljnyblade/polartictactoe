import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PlayerPanel extends JPanel implements MouseListener{
	
	private String player1turn= "Player one's turn";
	private String player2turn= "Player two's turn";
	private boolean player1, player2;
	private Polartictactoe game;
	private int winner;

	public PlayerPanel(Polartictactoe game, int p)
	{
		this.game=game;
		setPreferredSize(new Dimension(300,50));
		if(p==1)
		{
			player1=true;
			player2=false;
		}
		else 
			{
			player2=true;
			player1=false;
			}
		winner=0;
		addMouseListener(this);
	}
	
	public void switchPlayer(int x)
	{
		if(x==1)
		{
			player1=false;
			player2=true;
		}
		else 
			{
			player2=false;
			player1=true;
			}
			
		repaint();
	}
	
	public void setWinner(int x)
	{
		winner =x;
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(winner==0)
			setBackground(Color.WHITE);
		else if(winner==1)
			setBackground(Color.BLUE);
		else setBackground(Color.RED);
		paintPlayer(g, winner);
	}
	
	private void paintPlayer(Graphics g, int x)
	{
		if(x==0)
		{
		if(player1)
			{
			g.setColor(Color.BLUE);
			g.drawString(player1turn, 5*getWidth()/16, getHeight()/2);
			}
		
		else 
			{
			g.setColor(Color.RED);
			g.drawString(player2turn, 5*getWidth()/16, getHeight()/2);
			}
		}
		else if(x==1)
		{
			g.setColor(Color.WHITE);
			g.drawString("Player one has won!", 5*getWidth()/16, getHeight()/2);
		}
		
		else if(x==2)
		{
			g.setColor(Color.WHITE);
			g.drawString("Player two has won!", 5*getWidth()/16, getHeight()/2);
		}
	}
	
	public void newGame()
	{
		winner=0;
		player1=true;
		player2=false;
		repaint();
	}
	
	public void mouseClicked(MouseEvent e) {
		if(player1)
		{
			player1=false;
			player2=true;
			repaint();
		}
		else{
			player1=true;
			player2=false;
			repaint();
		}
	}

	public void mousePressed(MouseEvent e) {		
	}

	public void mouseReleased(MouseEvent e) {		
	}

	public void mouseEntered(MouseEvent e) {		
	}

	public void mouseExited(MouseEvent e) {		
	}
	
}
