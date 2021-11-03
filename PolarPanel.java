
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;

import java.awt.geom.Rectangle2D;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PolarPanel extends JPanel implements ActionListener, MouseListener
{

	private Polartictactoe game;
	private PolarMatrix matrix;
	private boolean player1, player2;
	private PlayerPanel board;
	
	
	public PolarPanel(Polartictactoe game, int p, PlayerPanel b)
	{
		this.game = game;
		setPreferredSize(new Dimension(250,250));
		
		board=b;
		
		initialize();
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
		
		addMouseListener(this);
		
	}
	
	public int getPlayer()
	{
		if (player1)
			return 1;
		else return 2;
	}
	
	public void initialize()
	{
		matrix = new PolarMatrix(game, getWidth(), getHeight());
		System.out.println(getWidth()+" "+ getHeight());
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		
		setBackground(Color.WHITE);
		drawGrid(g);
		drawPolarObjects(g);
	}
	
	private void drawGrid(Graphics g)
	{
		int w = getWidth();
		int h = getHeight();
		double xCenter = w/2.0;
		double yCenter = h/2.0;
		g.drawOval((int)(xCenter-w/2.0), (int)(yCenter-h/2.0), w, h);//c3
		g.drawOval((int)(xCenter-(3*w/8.0)), (int)(yCenter-(3*h/8.0)), 3*w/4, 3*h/4); //c2
		g.drawOval((int)(xCenter-w/4.0), (int)(yCenter-h/4.0), w/2, h/2); //c1
		g.drawOval((int)(xCenter-w/8.0), (int)(yCenter-h/8.0), w/4, h/4); //c0
		
		g.drawLine(w/2, h, w/2, 0);
		g.drawLine(0, h/2, w, h/2);
		g.drawLine(0, h, w, 0);
		g.drawLine(0, 0, w, h);
	}
	
	private void drawPolarObjects(Graphics g)
	{
		for(int r=0; r<matrix.numRows(); r++)
		{
			for(int c=0; c<matrix.numCols(); c++)
			{
				PolarObject p = matrix.objectAt(r,c);
				p.draw(g);
			}
		}
	}
	
	public void newGame()
	{
		matrix.clear();
		player1=true;
		player2=false;
		repaint();
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		for(int r=0; r<matrix.numRows(); r++)
		{
			for(int c=0; c<matrix.numCols(); c++)
			{
				PolarObject p = matrix.objectAt(r, c);
				if(p.mouseIsWithin(x,y))
				{
				if(player1)
					{
					p.switchColors(1);
					board.switchPlayer(1);
					int i = matrix.hasWon();
					board.setWinner(i);
					player1=false;
					player2=true;
					matrix.setObjAt(r, c, p);
					p.setCanChange(false);
					if(i==1)
						matrix.setAllChange(false);
					repaint();			
					return;
					}
				else if(player2)
					{
					p.switchColors(2); 
					board.switchPlayer(2);
					int i = matrix.hasWon();
					board.setWinner(i);
					player2=false;
					player1=true;
					matrix.setObjAt(r, c, p);
					p.setCanChange(false);
					if(i==2)
						matrix.setAllChange(false);
					repaint();			
					return;
					}
				}
			}
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