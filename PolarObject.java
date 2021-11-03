import java.awt.Color;
import java.awt.Graphics;

public class PolarObject {

	private double xPos,yPos;
	private Color c;
	private double radius = 8;
	private Polartictactoe game;
	private boolean canChange;
	
	public PolarObject(Polartictactoe game, double x, double y, Color b)
	{
		this.game=game;
		xPos=x;
		yPos=y;
		c=b;
		canChange=true;
	}
	
	public double getX()
	{
		return xPos;
	}
	
	public double getY()
	{
		return getY();
	}
	
	public Color getColor()
	{
		return c;
	}
	
	public void setCanChange(boolean f)
	{
		canChange=f;
	}
	
	public void switchColors(int x)
	{
		if(canChange)
		{
		if(x==1)
			c=Color.BLUE;
		else if(x==2)
			c=Color.RED;
		}
		
	}
	
	public double getRadius()
	{
		return radius;
	}
	
	public boolean mouseIsWithin(int x, int y)
	{
		double distance = Math.sqrt(Math.pow(x-xPos, 2)+Math.pow(y-yPos, 2));
		//double distanceX= Math.abs(x-xPos+radius);
		//double distanceY= Math.abs(y-yPos+radius);
		if(x<(xPos+2*radius) && x>xPos && y<(yPos+2*radius) && y>yPos)
			return true;
		else return false;
	}
	
	
	public void draw(Graphics g)
	{
		
			g.setColor(c);
			g.fillOval((int)(xPos+.5), (int)(yPos+.5), (int)(2*radius), (int)(2*radius));
		
	}
	
}
