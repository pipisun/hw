package group2.GreedSnake1.javawj.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Snake_Lab extends JLabel {
	
	public Snake_Lab(){
			
		this.setSize(10,10);
		this.setOpaque(true);
		this.setBackground(java.awt.Color.BLACK);
		this.setBorder(BorderFactory.createEtchedBorder(5,
				Color.WHITE.brighter(), Color.BLACK));
		
	}

}
