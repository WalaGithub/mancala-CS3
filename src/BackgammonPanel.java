import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
//
class BackgammonPanel extends JPanel implements Runnable, MouseListener, MouseMotionListener {
    Dice d1;
    Dice d2;
    private String mouse_button;
    private int mouse_x, mouse_y;

    public BackgammonPanel() {
        mouse_button = "NO BUTTON CLICKED!";
        d1 = new Dice();
        d2 = new Dice();
        //DO NOT TOUCH these 3 lines
        //these lines load the listener that listens for the keyboard presses
//		addKeyListener( this );   	//
        setFocusable(true);        // Do NOT DELETE these three lines
        addMouseListener(this); //
        mouse_x = 0;
        mouse_y = 0;
        addMouseMotionListener(this);
        new Thread(this).start();    //
    }

    public void paint(Graphics window)// all other paint methods and game logic goes in here.
    {
        //Board start
        window.setColor(Color.BLACK);
        window.fillRect(0, 0, 1024, 768); // makes the background white
        window.setColor(Color.WHITE);
        window.drawRect(0, 0, 1024, 768); // draws a black box around the outside

        window.setColor(Color.BLUE); // to change fonts, color, etc: go to the Graphics Intro Folder
        window.setColor(Color.WHITE);
        window.drawString("Mouse coordinates " + "(" + MouseInfo.getPointerInfo().getLocation().x + "   " + MouseInfo.getPointerInfo().getLocation().y + ")", 250, 20);
        window.setColor(Color.RED);
        window.drawString("Mouse coordinates " + "(" + mouse_x + "   " + mouse_y + ")", 600, 20);

        int w = getWidth();
        int h = getHeight();
        int mar = 30;
        int fr = 35;
        int barW = 70;
        window.setColor(new Color(110, 60, 30));
        window.fillRect(mar, mar, w - 2 * mar, h - 2 * mar);
        int inX = mar + fr;
        int inY = mar + fr;
        int offW = 140;
        int inW = w - 2 * (mar + fr) - offW;
        int offX = inX + inW;
        int inH = h - 2 * (mar + fr);

        window.setColor(new Color(170, 140, 90));
        window.fillRect(inX, inY, inW, inH);

        int midX = inX + (inW - barW) / 2;
        window.setColor(new Color(90, 50, 25));
        window.fillRect(midX, inY, barW, inH);
////
        window.setColor(new Color(80, 45, 25));
        window.fillRect(offX, inY, offW, inH);

        window.setColor(Color.BLACK);
        window.drawRect(offX, inY, offW, inH);
        window.drawLine(offX, inY, offX, inY + inH);

        int hal = inH / 2;
        int pH = (int) ((int) hal * .90);
        int pW = (inW - barW) / 12;
        for (int i = 0; i < 12; i++) {
            int topX;
            if (i < 6) {
                topX = inX + i * pW;
            } else topX = inX + barW + i * pW;
            Color c = (i % 2 == 0) ? new Color(120, 80, 45) : new Color(235, 230, 210);
            window.setColor(c);
            fillTriangle(window, topX, inY, pW, pH, false);
            fillTriangle(window, topX, inY + inH, pW, pH, true);
        }
        window.setColor(Color.BLACK);
        window.drawRect(mar, mar, w - 2 * mar, h - 2 * mar);
        //board end
        d1.paiut(window, 612, 382);
        d2.paiut(window, 412, 382);

//        d1.paint(window,130,130);

    }

    private void fillTriangle(Graphics window, int x, int bY, int w, int h, boolean up) {
        int[] xs = {x, x + w, x + w / 2};
        int[] ys;
        if (up) {
            ys = new int[]{bY, bY, bY - h};
        } else {
            ys = new int[]{bY, bY, bY + h};
        }
        window.fillPolygon(xs, ys, 3);
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseDragged(MouseEvent e) {
    }
    public void mouseMoved(MouseEvent e) {
        mouse_x = e.getX();
        mouse_y = e.getY();
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    /*


    import javax.swing.*;
    import java.util.*;
    import java.awt.*;
    import java.awt.event.*;
    import java.awt.image.BufferedImage;

    public class MouseBob extends JPanel implements Runnable, MouseListener, MouseMotionListener {
        private int mouse_x, mouse_y;
        private String mouse_button;
        private ArrayList<Bob> bobs;

        public MouseBob() {
            setBackground(Color.WHITE);
            mouse_x = 0;
            mouse_y = 0;
            mouse_button = "NO BUTTON CLICKED!";
            bobs = new ArrayList<Bob>();
            addMouseListener(this);
            addMouseMotionListener(this);
            new Thread(this).start();

            // Load your custom cursor image
            BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
            Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                    cursorImg, new Point(0, 0), "blank cursor");
            setCursor(blankCursor);

            // Set the custom cursor to your JPanel
            setCursor(blankCursor);
        }

        public void paintComponent(Graphics window) {
            super.paintComponent(window); // Always call the super method
            window.setColor(Color.BLACK);
            window.fillRect(0, 0, 800, 600);
            window.setColor(Color.WHITE);
            window.drawString("Mouse coordinates " + "(" + MouseInfo.getPointerInfo().getLocation().x + "   " + MouseInfo.getPointerInfo().getLocation().y + ")", 250, 30);
            window.setColor(Color.RED);
            window.drawString("Mouse coordinates " + "(" + mouse_x + "   " + mouse_y + ")", 250, 50);
            window.setColor(Color.GREEN);
            window.drawString(mouse_button, 250, 70);

            // This makes a new Bob on the mouse cursor
            Bob b = new Bob(mouse_x, mouse_y, 50, 50);

            // This paints the bob on the mouse cursor
            b.paintComponent(window);
        }
    */
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            mouse_button = "LEFT CLICK";
            // Add a Bob to the list at this location
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            mouse_button = "RIGHT CLICK";
        }
        // Write the code to remove the clicked on Bobs
    } //How can I remove the original cursor so only bob.png is visible when on
    // this window for this Java program that displays cursor information and shows bob.png:

    public void run() {
        try {
            while (true) {
                Thread.sleep(50);
                repaint();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}