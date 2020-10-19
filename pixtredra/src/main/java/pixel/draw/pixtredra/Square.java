package pixel.draw.pixtredra;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Square
{
    private int x, y, w;
    private Color col;

    public Square(int x, int y, int w, Color col)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.col = col;
    }

    public void draw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(col);
        g2d.fillRect(x, y, w, w);
    }
}