package lab4_nodes;

import java.awt.Color;
import java.awt.Graphics;

//класс, отвечающий за отрисовку
public class DrawingManager {	
	int cellHeight = 20;
    int cellWidth = 20;
	int chsize = 0;
    int left = 0;
    int top = 0;
	
	Memory memory = new Memory();
	int count = Memory.count;
	
	public void Draw(Graphics g, int width, int height) {        
       
        for (int i = 0; i < count; i++) {
            left = chsize * cellWidth;
            chsize++;
            if (Memory.nodes.get(i).getId() == -1) {
                g.setColor(Color.GRAY);
            } else {
                g.setColor(Color.BLUE);
            }
            if (memory.nodes.get(i).getSelectFlag()) {
                g.setColor(Color.RED);
            }
            g.fillRect(left, top, cellWidth, cellHeight);
            g.setColor(Color.WHITE);
            g.drawRect(left, top, cellWidth, cellHeight);
            g.drawString(Memory.nodes.get(i).getId()+1 + "", left + 5, top + 20);
            if (chsize == 20) {
                top += cellHeight;
                chsize = 0;
                left = 0;
            }
        }
    }
	
}
