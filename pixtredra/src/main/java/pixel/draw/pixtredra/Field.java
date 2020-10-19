package pixel.draw.pixtredra;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

class Field extends JPanel
{
	public static ArrayList<Square> squares = new ArrayList<Square>();
    public boolean working;
	
	public Field()
	{
		this.working = true;
	}
	
	private synchronized void doDrawing(Graphics g) 
    {
        Graphics2D g2d = (Graphics2D) g;
        for (Square square : squares) square.draw(g2d);
   } 

    @Override
    public synchronized void paintComponent(Graphics g) 
    {       
        super.paintComponent(g);
        doDrawing(g);
    }
    
    public void add_drawerman(int size, int lifespan, int speed)
    {
        float c1 = (float)Math.random();
        float c2 = (float)Math.random();
        float c3 = (float)Math.random();
        int x = Math.round((float)Math.random() * 600) + 100;
        int y = Math.round((float)Math.random() * 600) + 100;

        Drawerman guy = new Drawerman(x, y, size, lifespan, speed, new Color(c1, c2, c3), this);
        guy.start();
    }
    
    public synchronized void add_square(int x, int y, int w, Color col)
    {
    	Square squary = new Square(x, y, w, col);
    	squares.add(squary);
    	repaint();
    }
}
