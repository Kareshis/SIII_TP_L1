package pixel.draw.pixtredra;

import java.awt.Color;

public class Drawerman extends Thread 
{
	public int x, y, w, main_dir, last_dir, lifespan, speed;
	public Color col;
    public Field ptdwin;
    private float spread;
	
	public Drawerman(int x, int y, int w, int lifespan, int speed, Color col, Field ptdwin)
	{
        lifespan = Math.round((float)(Math.random() * 0.4 + 0.8) * lifespan);
        if (lifespan < 1) lifespan = 1;
        int main_dir = Math.round((float)Math.random() * 4);

        this.x = x;
		this.y = y;
		this.w = w;
		this.lifespan = lifespan;
		this.main_dir = main_dir;
		last_dir = 4;
		this.speed = speed;
		this.col = col;
        this.ptdwin = ptdwin;
        spread = (float)(0.15 - lifespan * 0.005);
	}
	
	public void run()
	{
		while(lifespan >= 0)
		{
			move_time();
			sleep_time();
		}
	}
	
	private void move_time()
	{
        if(Math.random() <= spread)
        {
        	Drawerman guy = new Drawerman(x, y, w, lifespan, speed, col, ptdwin);
        	guy.start();
        }
        
        float c1 = (float)(col.getRed() * 0.9875) / 255;
        float c2 = (float)(col.getGreen() * 0.9875) / 255;
        float c3 = (float)(col.getBlue() * 0.9875) / 255;
        this.col = new Color(c1, c2, c3);
        
        int dir = Math.round((float)Math.random() * 4);
        while(dir == main_dir) dir = Math.round((float)Math.random() * 4);
        
        if(dir == 0 || dir == 4)	this.x -= w;
        if(dir == 1)	this.x += w;
        if(dir == 2)	this.y -= w;
        if(dir == 3)	this.y += w;
        
        ptdwin.add_square(x, y, w, col);
        if(Math.random() <= 0.95) last_dir = dir;
        lifespan -= 1;
	}
	
	private void sleep_time()
	{
        try
        {
            sleep(speed);
        }
        catch(InterruptedException e) {};
	}
}
