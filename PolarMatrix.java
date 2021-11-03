import java.awt.Color;

public class PolarMatrix {

	private PolarObject[][] grid;
	private double[][] xPos, yPos;
	private Polartictactoe game;
	
	public PolarMatrix(Polartictactoe game, int w, int h)
	{
		this.game=game;
		grid = new PolarObject[8][4];
		xPos = xPosAlgorithm(w,h);
		yPos = yPosAlgorithm(w,h);
		
		for(int r=0; r<grid.length; r++)
		{
			for(int c=0; c<grid[0].length; c++)
			{
				PolarObject p = new PolarObject(game, xPos[r][c]-8, yPos[r][c]-8, Color.BLACK);

				grid[r][c]= p;
				
			}
		}
	}
	
	public int hasWonCircles()
	{
		int count1=0;
		int count2=0;
		Color c1 = Color.BLUE;
		Color c2 = Color.RED;
		
		for(int r=0; r<numRows(); r++)
		{
			for(int c=0; c<numCols(); c++)
			{
				PolarObject p = objectAt(r,c);
				if(c1.equals(p.getColor()))
					count1++;
				if(c2.equals(p.getColor()))
					count2++;
			}
			if(count1==4)
				return 1;
			if(count2==4)
				return 2;
			count1=0;
			count2=0;
			//check down the circles
		}	
		return 0;
	}
	
	public int hasWonRows()
	{
		int count1=0;
		int count2=0;
		Color c1 = Color.BLUE;
		Color c2 = Color.RED;
		
		for(int c=0; c<numCols(); c++)
		{
			for(int r=0; r<4; r++)
			{
				PolarObject p=objectAt(r,c);
				if(c1.equals(p.getColor()))
					count1++;
				if(c2.equals(p.getColor()))
					count2++;
			}
			if(count1==4)
				return 1;
			if(count2==4)
				return 2;
			count1=0;
			count2=0;
			//check row 0 through 3 for a string of 4
			
			for(int r=1; r<5; r++)
			{
				PolarObject p=objectAt(r,c);
				if(c1.equals(p.getColor()))
					count1++;
				if(c2.equals(p.getColor()))
					count2++;
			}
			if(count1==4)
				return 1;
			if(count2==4)
				return 2;
			count1=0;
			count2=0;
			//check row 1 through 4 for a string of 4
			
			for(int r=2; r<6; r++)
			{
				PolarObject p=objectAt(r,c);
				if(c1.equals(p.getColor()))
					count1++;
				if(c2.equals(p.getColor()))
					count2++;
			}
			if(count1==4)
				return 1;
			if(count2==4)
				return 2;
			count1=0;
			count2=0;
			//check row 2 through 5 for a string of 4
			
			for(int r=3; r<7; r++)
			{
				PolarObject p=objectAt(r,c);
				if(c1.equals(p.getColor()))
					count1++;
				if(c2.equals(p.getColor()))
					count2++;
			}
			if(count1==4)
				return 1;
			if(count2==4)
				return 2;
			count1=0;
			count2=0;
			//check row 3 through 6 for a string of 4
			
			for(int r=4; r<8; r++)
			{
				PolarObject p=objectAt(r,c);
				if(c1.equals(p.getColor()))
					count1++;
				if(c2.equals(p.getColor()))
					count2++;
			}
			if(count1==4)
				return 1;
			if(count2==4)
				return 2;
			count1=0;
			count2=0;
			//check row 4 through 7 for a string of 4 --- 
			
			for(int r=7; r<8; r++)
			{
				PolarObject p=objectAt(r,c);
				if(c1.equals(p.getColor()))
					count1++;
				if(c2.equals(p.getColor()))
					count2++;
			} //check row 7 
			for(int r=0; r<3; r++)
			{
				PolarObject p=objectAt(r,c);
				if(c1.equals(p.getColor()))
					count1++;
				if(c2.equals(p.getColor()))
					count2++;
			} //check rows 0 through 3 for a string of 3
			if(count1==4)
				return 1;
			if(count2==4)
				return 2;
			count1=0;
			count2=0;
			
			for(int r=6; r<8; r++)
			{
				PolarObject p=objectAt(r,c);
				if(c1.equals(p.getColor()))
					count1++;
				if(c2.equals(p.getColor()))
					count2++;
			} //check row 6 through 7 for a string of 2
			for(int r=0; r<2; r++)
			{
				PolarObject p=objectAt(r,c);
				if(c1.equals(p.getColor()))
					count1++;
				if(c2.equals(p.getColor()))
					count2++;
			} //check row 0 through 1 for a string of 2
			if(count1==4)
				return 1;
			if(count2==4)
				return 2;
			count1=0;
			count2=0;
			
			for(int r=5; r<8; r++)
			{
				PolarObject p=objectAt(r,c);
				if(c1.equals(p.getColor()))
					count1++;
				if(c2.equals(p.getColor()))
					count2++;
			} //check row 5 through 7 for a string of 3
			for(int r=0; r<1; r++)
			{
				PolarObject p=objectAt(r,c);
				if(c1.equals(p.getColor()))
					count1++;
				if(c2.equals(p.getColor()))
					count2++;
			} //check row 0 
			if(count1==4)
				return 1;
			if(count2==4)
				return 2;
			count1=0;
			count2=0;
		}
		return 0;
	}
	
	public int hasWonDiagnolsPositive()
	{
		//diagnols - positive
		
		int count1=0;
		int count2=0;
		Color c1 = Color.BLUE;
		Color c2 = Color.RED;
		
		for(int r=0; r<5; r++)
		{
			
			PolarObject p1= objectAt(r,0);
			if(c1.equals(p1.getColor()))
			{
				PolarObject p2= objectAt(r+1,1);
				PolarObject p3= objectAt(r+2,2);
				PolarObject p4= objectAt(r+3,3);
				if(c1.equals(p2.getColor())&&c1.equals(p3.getColor())&&c1.equals(p4.getColor()))
					return 1;
			}
			
			if(c2.equals(p1.getColor()))
			{
				PolarObject p2= objectAt(r+1,1);
				PolarObject p3= objectAt(r+2,2);
				PolarObject p4= objectAt(r+3,3);
				if(c2.equals(p2.getColor())&&c2.equals(p3.getColor())&&c2.equals(p4.getColor()))
					return 2;
			}
		}
		
		for(int c=0; c<1; c++)
		{
			PolarObject p1= objectAt(5,0);
			if(c1.equals(p1.getColor()))
			{
				PolarObject p2= objectAt(6,1);
				PolarObject p3= objectAt(7,2);
				PolarObject p4= objectAt(0,3);
				if(c1.equals(p2.getColor())&&c1.equals(p3.getColor())&&c1.equals(p4.getColor()))
					return 1;
			}
			
			if(c2.equals(p1.getColor()))
			{
				PolarObject p2= objectAt(6,1);
				PolarObject p3= objectAt(7,2);
				PolarObject p4= objectAt(0,3);
				if(c2.equals(p2.getColor())&&c2.equals(p3.getColor())&&c2.equals(p4.getColor()))
					return 2;
			}
		}
		
		for(int c=0; c<1; c++)
		{
			PolarObject p1= objectAt(6,0);
			if(c1.equals(p1.getColor()))
			{
				PolarObject p2= objectAt(7,1);
				PolarObject p3= objectAt(0,2);
				PolarObject p4= objectAt(1,3);
				if(c1.equals(p2.getColor())&&c1.equals(p3.getColor())&&c1.equals(p4.getColor()))
					return 1;
			}
			
			if(c2.equals(p1.getColor()))
			{
				PolarObject p2= objectAt(7,1);
				PolarObject p3= objectAt(0,2);
				PolarObject p4= objectAt(1,3);
				if(c2.equals(p2.getColor())&&c2.equals(p3.getColor())&&c2.equals(p4.getColor()))
					return 2;
			}
		}
		
		for(int c=0; c<1; c++)
		{
			PolarObject p1= objectAt(7,0);
			if(c1.equals(p1.getColor()))
			{
				PolarObject p2= objectAt(0,1);
				PolarObject p3= objectAt(1,2);
				PolarObject p4= objectAt(2,3);
				if(c1.equals(p2.getColor())&&c1.equals(p3.getColor())&&c1.equals(p4.getColor()))
					return 1;
			}
			
			if(c2.equals(p1.getColor()))
			{
				PolarObject p2= objectAt(0,1);
				PolarObject p3= objectAt(1,2);
				PolarObject p4= objectAt(2,3);
				if(c2.equals(p2.getColor())&&c2.equals(p3.getColor())&&c2.equals(p4.getColor()))
					return 2;
			}
			
		}
		return 0;

	}
	
	public int hasWonDiagnolsNegative()
	{
		int count1=0;
		int count2=0;
		Color c1 = Color.BLUE;
		Color c2 = Color.RED;
		for(int r=7; r>2; r--)
		{
			PolarObject p1= objectAt(r,0);
			if(c1.equals(p1.getColor()))
			{
				PolarObject p2= objectAt(r-1,1);
				PolarObject p3= objectAt(r-2,2);
				PolarObject p4= objectAt(r-3,3);
				if(c1.equals(p2.getColor())&&c1.equals(p3.getColor())&&c1.equals(p4.getColor()))
					return 1;
			}
			
			if(c2.equals(p1.getColor()))
			{
				PolarObject p2= objectAt(r-1,1);
				PolarObject p3= objectAt(r-2,2);
				PolarObject p4= objectAt(r-3,3);
				if(c2.equals(p2.getColor())&&c2.equals(p3.getColor())&&c2.equals(p4.getColor()))
					return 2;
			}
		}
		
		for(int c=0; c<1; c++)
		{
			PolarObject p1= objectAt(2,0);
			if(c1.equals(p1.getColor()))
			{
				PolarObject p2= objectAt(1,1);
				PolarObject p3= objectAt(0,2);
				PolarObject p4= objectAt(7,3);
				if(c1.equals(p2.getColor())&&c1.equals(p3.getColor())&&c1.equals(p4.getColor()))
					return 1;
			}
			
			if(c2.equals(p1.getColor()))
			{
				PolarObject p2= objectAt(1,1);
				PolarObject p3= objectAt(0,2);
				PolarObject p4= objectAt(7,3);
				if(c2.equals(p2.getColor())&&c2.equals(p3.getColor())&&c2.equals(p4.getColor()))
					return 2;
			}
		}
		
		for(int c=0; c<1; c++)
		{
			PolarObject p1= objectAt(1,0);
			if(c1.equals(p1.getColor()))
			{
				PolarObject p2= objectAt(0,1);
				PolarObject p3= objectAt(7,2);
				PolarObject p4= objectAt(6,3);
				if(c1.equals(p2.getColor())&&c1.equals(p3.getColor())&&c1.equals(p4.getColor()))
					return 1;
			}
			
			if(c2.equals(p1.getColor()))
			{
				PolarObject p2= objectAt(0,1);
				PolarObject p3= objectAt(7,2);
				PolarObject p4= objectAt(6,3);
				if(c2.equals(p2.getColor())&&c2.equals(p3.getColor())&&c2.equals(p4.getColor()))
					return 2;
			}
		}
		
		for(int c=0; c<1; c++)
		{
			PolarObject p1= objectAt(0,0);
			if(c1.equals(p1.getColor()))
			{
				PolarObject p2= objectAt(7,1);
				PolarObject p3= objectAt(6,2);
				PolarObject p4= objectAt(5,3);
				if(c1.equals(p2.getColor())&&c1.equals(p3.getColor())&&c1.equals(p4.getColor()))
					return 1;
			}
			
			if(c2.equals(p1.getColor()))
			{
				PolarObject p2= objectAt(7,1);
				PolarObject p3= objectAt(6,2);
				PolarObject p4= objectAt(5,3);
				if(c2.equals(p2.getColor())&&c2.equals(p3.getColor())&&c2.equals(p4.getColor()))
					return 2;
			}
			
		}
		return 0;

	}
	
	public int hasWon()
	{
		int count1=0;
		int count2=0;
		Color c1 = Color.BLUE;
		Color c2 = Color.RED;
		
		if(hasWonCircles() !=0)
			{
			System.out.println("Cirlces");
			return hasWonCircles();
			}
		if(hasWonRows()!=0)
			{
			System.out.println("Rows");
			return hasWonRows();
			}
		if(hasWonDiagnolsPositive()!=0)
			{
			System.out.println("DiagnolsPositive");
			return hasWonDiagnolsPositive();
			}
		if(hasWonDiagnolsNegative()!=0)
			{
			System.out.println("DiagnolsNegative");
			return hasWonDiagnolsNegative();
			}
		return 0;
		
		
	}
	
	public void setAllChange(boolean b)
	{
		for(int r=0; r<numRows(); r++)
		{
			for(int c=0; c<numCols(); c++)
			{
				PolarObject p = objectAt(r,c);
				p.setCanChange(false);
			}
		}
	}
	
	public double[][] xPosAlgorithm(int w, int h)
	{
		double[][] a = new double[8][4];
		double xCenter = w/2.0;

		for(int angle=0; angle<8; angle++)
			{ 
			double r=w/8.0;
			for(int circle= 0; circle<4; circle++)
			{
				a[angle][circle]=xCenter+r*Math.cos(Math.toRadians(angle*45.0));
				r+=w/8.0;
			}
			}				
		return a;
	}
	
	public double[][] yPosAlgorithm(int w, int h)
	{
		 
		double[][] b = new double[8][4];
		double yCenter = h/2.0;
		
		for(int angle=0; angle<8; angle++)
		{ 
		double r=h/8.0;
		for(int circle= 0; circle<4; circle++)
		{
			b[angle][circle]=yCenter-r*Math.sin(Math.toRadians(angle*45.0));
			r+=h/8.0;
		}
		}		
		return b;
	}
	
	public int numRows()
	{
		return grid.length;
	}
	
	public int numCols()
	{
		return grid[0].length;
	}
	
	public void setObjAt(int row, int col, PolarObject p)
	{
		grid[row][col] = p;
	}
	
	public boolean isEmpty(int row, int col)
	{
		return objectAt(row, col) == null;
	}
	
	public PolarObject objectAt(int row, int col)
	{
		return grid[row][col];
	}
	
	public void clear()
	{
		for(int r=0; r<numRows(); r++)
		{
			for(int c=0; c<numCols(); c++)
			{
				double xP= xPos[r][c];
				double yP = yPos[r][c];
				PolarObject p = new PolarObject(game, xP-8, yP-8, Color.BLACK);
				setObjAt(r,c, p);
			}
		}
	}
	
}
