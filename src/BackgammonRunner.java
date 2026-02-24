import javax.swing.*;

class BackgammonRunner extends JFrame {
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 768;
	ImageIcon icon = new ImageIcon("images/middle.gif");
	JLabel label1 = new JLabel("Image and Text", icon, JLabel.CENTER);
	public BackgammonRunner()
	{
		super("Backgammon");
        //yes
		//hello
		setSize(WIDTH,HEIGHT);

		//use the ClassTester to test your classes
		//before you start to write the full game

		getContentPane().add( new BackgammonPanel() );

		//uncomment this when ready to start
		//building the game
		//getContentPane().add( new BreakOut() );
				
		setVisible(true);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		BackgammonRunner run = new BackgammonRunner();
	}
}