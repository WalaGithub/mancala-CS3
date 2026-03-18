import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//
class BackgammonPanel extends JPanel implements Runnable, KeyListener{
    Dice d1, d2;
    private static final int w   = 1024;
    private static final int h   = 768;
    private static final int mar  = 30;   // outer margin
    private static final int fr   = 35;   // frame w
    private static final int bar  = 70;   // center bar w
    private static final int off  = 140;  // offboard panel w
    private static final int in_x = mar + fr;// 65
    private static final int in_y = mar + fr;// 65
    private static final int in_w = w - 2 * (mar + fr) - off;// 644
    private static final int in_h = h - 2 * (mar + fr);// 628
    private static final int mid_x = in_x + (in_w - bar) / 2;// left edge of bar
    private static final int off_x  = in_x + in_w;// left edge of offboard
    private static final int pw    = (in_w - bar) / 12;// point width
    private static final int ph    = (int) ((double) in_h / 2 * 0.90);// point height
    private static final int d1_x = mid_x - bar / 4 - 35;
    private static final int d2_x = mid_x + bar / 4 + 35;
    private static final int d_y  = h / 2;
    private String mouse_button;
    private int mouse_x, mouse_y;
    private triangle[] triangles;
    Player plW;
    Player plB;
    Player cPlayer;
    int iii=500000;
    int a;
    int cursorP = 0;
    int selectedP = -1;
    String moveError=null;
    public BackgammonPanel() {
        d1 = new Dice(d1_x,d_y);
        d2 = new Dice(d2_x,d_y);
        triangles=new triangle[26];
        for(int i=0; i<26; i++){
            triangles[i]=new triangle(i<12,i>23);
        }
        startCheck();
        plW=new Player('w');
        plB=new Player('b');
        cPlayer = plW;
        cPlayer.beginTurn();
        // this for loop runs once and paints initial checker positions
        // this for loop runs oxnce and paints initial checker positions
        /*for (int i = 0; i < triangles.length; i++) {

            int col = i % 12;
            int x = 88 + col * 57;
            if (col > 5) x += 70;
            boolean topRow = (i < 12);

            int baseY = topRow ? 88 : (640);
            int dir   = topRow ? 55 : -55;

            //5
            if (i == 0) {                 // 5 (white)
                for (int k = 0; k < 5; k++) {
                    triangles[i].add(new Checker(x, baseY + dir * k, 'w'));
                }
            }
            else if (i == 6) {            // 5 (black)
                for (int k = 0; k < 5; k++) {
                    triangles[i].add(new Checker(x, baseY + dir * k, 'b'));
                }
            }
            else if (i == 12) {           // 5 (black)
                for (int k = 0; k < 5; k++) {
                    triangles[i].add(new Checker(x, baseY + dir * k, 'b'));
                }
            }
            else if (i == 18) {           // 5 (white)
                for (int k = 0; k < 5; k++) {
                    triangles[i].add(new Checker(x, baseY + dir * k, 'w'));
                }

            }

            else if (i == 4) {            // 3 (black)
                for (int k = 0; k < 3; k++) triangles[i].add(new Checker(x, baseY + dir * k, 'b'));
            }
            else if (i == 16) {           // 3 (white)
                for (int k = 0; k < 3; k++) triangles[i].add(new Checker(x, baseY + dir * k, 'w'));
            }

            // 2
            else if (i == 11) {           // 2 (white)
                for (int k = 0; k < 2; k++) triangles[i].add(new Checker(x, baseY + dir * k, 'w'));
            }
            else if (i == 23) {           // 2 (black)
                for (int k = 0; k < 2; k++) triangles[i].add(new Checker(x, baseY + dir * k, 'b'));
            }
        }*/
        //DO NOT TOUCH these 3 lines
        //these lines load the listener that listens for the keyboard presses
//		addKeyListener( this );   	//
        setFocusable(true);        // Do NOT DELETE these three lines
        addKeyListener(this);
        new Thread(this).start();    //
    }
    void startCheck() {
        // [point ] = {count,color}
        int[][] s = {
                {0,  5, 'w'},
                {6,  5, 'b'},
                {12, 5, 'b'},
                {18, 5, 'w'},
                {4,  3, 'b'},
                {16, 3, 'w'},
                {11, 2, 'w'},
                {23, 2, 'b'}
        };
        for (int[] ss : s) {
            int i = ss[0];
            int c = ss[1];
            char col = (char)ss[2];
            int c12=i%12;
            int x = in_x+c12*pw+pw/2;
            if(c12>=6)x+=bar;
            boolean top = i < 12;
            int base = top ? in_y : in_y + in_h;
            int dir=top?1:-1;
            for (int j = 0; j < c; j++) {
                triangles[i].add(new Checker(x,(int) (base+dir*((j*0.60)*pw+pw/2)),col));
            }
        }
    }
    //fix/check logic here
    int travelIndex(int bI,char c) {
        if(c=='w') {
            if (bI < 12) {
                return 11-bI;
            } else {
                return bI;
            }
        }
        else {
            if (bI >= 12) {
                return 23-bI;
            }
            else return 12+bI;
        }
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
        window.setColor(new Color(110, 60, 30));
        window.fillRect(mar, mar, w - 2 * mar, h - 2 * mar);
        window.setColor(new Color(170,140,90));
        window.fillRect(in_x,in_y,in_w,in_h);
        window.setColor(new Color(90, 50, 25));
        window.fillRect(mid_x,in_y,bar,in_h);
        window.setColor(new Color(80, 45, 25));
        window.fillRect(off_x,in_y,off,in_h);
        window.setColor(Color.BLACK);
        window.drawRect(off_x,in_y,off,in_h);
        //board end
        for (int i = 0; i < 12; i++) {
            int p = in_x + i * pw + (i >= 6 ? bar : 0);
            window.setColor((i%2==0)?new Color(120,80,45):new Color(235,230,210));
            fillTriangle(window, p, in_y, pw, ph, false);
            fillTriangle(window, p, in_y+in_h, pw, ph, true);

        }
//        triangles[0].add(new Checker(88,88,'w'));
//        triangles[0].paint(window);
        window.setColor(Color.BLACK);
        window.drawRect(mar,mar,w-2*mar,h-2*mar);
        d1.x = d1_x;
        d1.y=d_y;
        d2.y=d_y;
        d2.x=d2_x;
        d1.paiut(window);
        d2.paiut(window);
        int i=0;
        for (triangle t : triangles) {
            if(i==24) break;
            t.paint(window);
            i++;
        }
        pCursor(window);
        pHUD(window);
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
    void pCursor(Graphics window) {
        pointHigh(window, cursorP, new Color(255, 220, 0, 180), 4);
        if (selectedP != -1) {
            pointHigh(window,selectedP,new Color(0,255,80,180),4);
        }
    }
    private void pointHigh(Graphics window, int i, Color color, int t) {
        int c12=i%12;
        int p = in_x+c12*pw+(c12>=6?bar:0);
        boolean top = i<12;
        int[] xs = {p, p + pw, p + pw / 2};
        int[] ys;
        if (top) {
            ys = new int[]{in_y, in_y, in_y+ ph};
        }
        else {
            ys = new int[]{in_y + in_h, in_y + in_h, in_y + in_h - ph};
        }
        Graphics2D second = (Graphics2D) window;
        Stroke old = second.getStroke();
        second.setColor(color);
        second.setStroke(new BasicStroke(t));
        second.drawPolygon(xs, ys, 3);
        second.setStroke(old);
    }
    private void pHUD(Graphics window) {
        window.setFont(new Font("Arial", Font.BOLD, 14));
        window.setColor(Color.WHITE);
        window.drawString("Player " + cPlayer.c + "'s turn", 30, 20);
        if (!cPlayer.rolled) {
            window.setColor(Color.YELLOW);
            window.drawString("Press G to roll", 200, 20);
        }
        else {
            window.setColor(Color.WHITE);
            window.drawString("Dice: " + d1.number + " + " + d2.number, 200, 20);
            window.drawString("left or right to choose, d to pick, f to move",330,20);
        }
        if(moveError!=null) {
            if(iii==500000 || iii==499999) a = (int) (Math.random() * 2) +1;;
            if(--iii>0) {
                if(a%2==0) {
                    window.setColor(Color.BLACK);
                    window.fillRect(30,735-12,500,14);
                }
                else {
                    window.setColor(Color.GRAY);
                    window.fillRect(30,735-12,500,14);
                }

            }
            else a = (int) (Math.random() * 2) +1; iii=500000;
            window.setColor(Color.RED);
            window.drawString(moveError,30,735);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_G) {
            if (cPlayer.mturn && !cPlayer.rolled) {
                d1.roll();;
                d2.roll();
                cPlayer.onDiceRolled();
                moveError=null;
                System.out.println("Rolled: "+d1.number+" + "+d2.number);
            }
            return;
        }
        if(!cPlayer.rolled) return;
        if (key == KeyEvent.VK_LEFT) {
            cursorP = (cursorP+23)%24;
            moveError=null;
        } else if (key == KeyEvent.VK_RIGHT) {
            cursorP=(cursorP+1)%24;
            moveError=null;
        } else if (key == KeyEvent.VK_DOWN) {
            cursorP = cursorP<=11?cursorP+12:cursorP;
            moveError = null;
        } else if (key == KeyEvent.VK_UP) {
            cursorP = cursorP>11?cursorP-12:cursorP;
            moveError = null;
        } else if (key == KeyEvent.VK_D) {
            triangle t = triangles[cursorP];
            if (!t.x.isEmpty() && t.x.peek().color == cPlayer.c) {
                selectedP = cursorP;
                moveError = null;
                System.out.println("Picked checker on point " + selectedP);
            } else moveError = "No checker of yours on the point " + cursorP;
        } else if (key == KeyEvent.VK_F) {
            if (selectedP == -1) {
                moveError = "Pick a checker with D";
            } else if (selectedP == cursorP) {
                moveError = "Already here, move yo cursor";

            } else tryMove(selectedP, cursorP);
        } else if (key == KeyEvent.VK_E) {
            if (d1.used && d2.used) {
                endTurn();
                ;
            } else if (!d1.used && !d2.used) {
                moveError = "Use your dice";
            } else endTurn();
        }
    }
    void tryMove(int f, int t) {
        int tF = travelIndex(f, cPlayer.c);
        int tT = travelIndex(t, cPlayer.c);
        int dist = tT-tF;
        if (dist <= 0) {
            moveError = "Move forward  " +
                    (cPlayer.c == 'w' ? "(follow top row right then bottom row right" : "(follow bottom row left then top row left)");
            return;
        }
        triangle dest = triangles[t];
        char o = cPlayer.c == 'w' ? 'b' : 'w';
        if (dest.x.size() >= 2 && dest.x.peek().color == o) {
            moveError = "Point is blocket by opp";
            return;
        }
        if (!d1.used && d1.number == dist) {
            moveChecker(f, t, cPlayer.c);
            d1.used=true;
            moveError=null;
        } else if (!d2.used && d2.number == dist) {
            moveChecker(f, t, cPlayer.c);
            d2.used=true;
            moveError=null;
        }
        else {
            String a="";
            if(!d1.used) a += d1.number + " ";
            if(!d2.used) a += d2.number + " ";
            moveError="move dist "+dist+" doesnt match available dice ("+ a.trim() + ")";
        }
        if (d1.used && d2.used) {
            endTurn();
        }
    }
    private void moveChecker(int f, int t, char cl) {
        triangle src = triangles[f];
        triangle des = triangles[t];
        if(src.x.isEmpty()) return;
        if(des.x.size()>1 && des.x.peek().color!=cl) return;
        if(!des.x.isEmpty() && des.x.peek().color!=cl){
            char o = cl == 'w' ? 'b' : 'w';
            if(cl=='w'){
                moveChecker(t,24, o);
            }
            else{
                moveChecker(t,25, o);
            }
        }
        int c12=t%12;
        int newX  = in_x + c12 * pw+ pw / 2 + (c12 >= 6 ? bar : 0);
        boolean top  = t < 12;
        int base = top ? in_y : in_y + in_h;
        int dir  = top ? 1 : -1;
        int newY =(int) (base + dir * (des.x.size()*0.60 * pw + pw / 2));

        Checker c = src.x.pop();
        c.x = newX;

        c.y = newY;
        des.x.push(c);

        System.out.println("Moved from " + f + " to " + t);
        selectedP = -1;
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    private void endTurn() {
        cPlayer.endTurn();
        cPlayer = cPlayer == plW ? plB : plW;
        selectedP=-1;
        cursorP=0;
        cPlayer.beginTurn();
    }
    //
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