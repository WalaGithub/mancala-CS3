import javax.swing.*;

/*
Centipede objects:
centipede body - 10
centidepe head - 100
spider - 300-900
flea - 200
scorpion - 1000
mushroom - 4
 */
class BreakOutRunner extends JFrame {
	private static final int WIDTH = 558;
	private static final int HEIGHT = 640;
	ImageIcon icon = new ImageIcon("images/middle.gif");
	JLabel label1 = new JLabel("Image and Text", icon, JLabel.CENTER);
	public BreakOutRunner()
	{
		super("Brick Breaker BreakOut");

		setSize(WIDTH,HEIGHT);

		//use the ClassTester to test your classes
		//before you start to write the full game

		getContentPane().add( new BreakOut() );

		//uncomment this when ready to start
		//building the game
		//getContentPane().add( new BreakOut() );
				
		setVisible(true);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		BreakOutRunner run = new BreakOutRunner();
	}
}