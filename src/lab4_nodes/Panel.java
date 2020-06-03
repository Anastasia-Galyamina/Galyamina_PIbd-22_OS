package lab4_nodes;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel {	
    Memory nodes;
    DrawingManager manager  = new DrawingManager();

    public Panel(Memory nodes) {
        this.nodes = nodes;
    }

    public void paint(Graphics g) {
        super.paint(g);        
       manager.Draw(g, this.getWidth(), this.getHeight());
    }
}