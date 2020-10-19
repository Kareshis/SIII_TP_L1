package pixel.draw.pixtredra;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Starter extends Frame
{
    private Panel params, par1, par2, par3, par4;
    private Field field;
    
	public static void main(String[] args) 
	{
		new Starter();
	}
	
	public Starter()
	{
		prepare_GUI();
		field_window();
		add_param();
		show_panels();
	}
	
	private void prepare_GUI()
	{
		setTitle("Starter");
		setBounds(1000, 100, 280, 280);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		setVisible(true);
        addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
	}

    private void field_window()
    {
    	Frame window = new JFrame();
    	window.setTitle("PixTreDra");
		window.setBounds(100, 100, 900, 900);
		window.setVisible(true);
		
		this.field = new Field();
		window.add(this.field);
    }
    
	private void add_param()
    {

        params = new Panel();
        params.setLayout(new GridLayout(4,2));

        add(params);

        par1 = new Panel();
        par2 = new Panel();
        par3 = new Panel();
        par4 = new Panel();

        Label lab1 = new Label("drawermans (1 ~ 100)");
        Label lab2 = new Label("size (1 ~ 100)");
        Label lab3 = new Label("speed (miliseconds)");
        Label lab4 = new Label("lifespan (1 ~ 100)");

        params.add(lab1);
        params.add(par1);
        params.add(lab2);
        params.add(par2);
        params.add(lab3);
        params.add(par3);
        params.add(lab4);
        params.add(par4);
    }
	
    private void show_panels()
    {
        TextArea par_drawm = new TextArea("1", 1, 10, TextArea.SCROLLBARS_NONE);
        TextArea par_size = new TextArea("10", 1, 10, TextArea.SCROLLBARS_NONE);
        TextArea par_speed = new TextArea("25", 1, 10, TextArea.SCROLLBARS_NONE);
        TextArea par_life = new TextArea("10", 1, 10, TextArea.SCROLLBARS_NONE);
        Button accept = new Button("Accept Parametres");
        Label status_label = new Label("Wrong or good?");

        accept.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int drawm, size, speed, life;
                try
                {
                    drawm = Integer.parseInt(par_drawm.getText());
                    size = Integer.parseInt(par_size.getText());
                    speed = Integer.parseInt(par_speed.getText());
                    life = Integer.parseInt(par_life.getText());

                    status_label.setText("All Clear");
                    passed(drawm, size, speed, life);
                
                }
                catch(NumberFormatException ex)
                {
                    status_label.setText("Something is wrong");
                }
                catch(OutOfMemoryError ome)
                {
                    status_label.setText("Too much memory used, restart app");
                }
            }
        });

        par1.add(par_drawm);
        par2.add(par_size);
        par3.add(par_speed);
        par4.add(par_life);
        add(accept);
        add(status_label);
        setVisible(true);
    }
    private void passed(int drawm, int size, int speed, int life)
    {
        for(int i = 0; i < drawm; i++)
        	this.field.add_drawerman(size, life, speed);
    }
}
