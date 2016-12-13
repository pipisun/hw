package group2.GreedSnake1.javawj.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;

public class Snake_FoodLab extends JLabel {

	public Snake_FoodLab(){
		
		this.setSize(10,10);
		this.setOpaque(true);
		this.setBackground(java.awt.Color.red);
		this.setBorder(BorderFactory.createEtchedBorder(5,
				Color.WHITE.brighter(), Color.blue));
	}

}
