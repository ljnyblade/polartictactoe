
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;

public class PolarMenu extends JMenuBar implements ActionListener {

	private Polartictactoe game;
	private JMenuItem newgame, exit; 

	
	public PolarMenu(Polartictactoe game)
	{
		JMenu file = new JMenu("File");
		JMenu help = new JMenu("Help");
		this.game=game;
		newgame = new JMenuItem("New Game");
		exit = new JMenuItem("Exit");
		
		newgame.addActionListener(this);
		exit.addActionListener(this);
		
		file.add(newgame);
		file.add(exit);
		this.add(file);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JMenuItem src = (JMenuItem)e.getSource();
		if (src== newgame)
	    	game.newGame();
	    if (src == exit)
	    	System.exit(0);
	}
}
