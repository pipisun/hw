package hwfpp.lesson4;

//push button handle action events
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class ButtonDemo1 {//implements ActionListener {
	JLabel jlbl;

	ButtonDemo1() {
		// create a jframe container
		JFrame jfrm = new JFrame("A Button Example");
		// Specify Flowlayout for the layout manager
		jfrm.setLayout(new FlowLayout());
		// give the frame an initial size
		jfrm.setSize(220, 90);
		// terminate the program when the user closes the application
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Make two buttons
		JButton jbtnUp = new JButton("UP");
		JButton jbtnDown = new JButton("Down");
		// add action listener
		//jbtnUp.addActionListener(this);
		//jbtnDown.addActionListener(this);

		// Add the buttons to the content pane
		jfrm.add(jbtnUp);
		jfrm.add(jbtnDown);
		// Create a label
		 jlbl = new JLabel("Press a Button");
		// Add the label to the frame
		jfrm.add(jlbl);
		// Display the frame
		jfrm.setVisible(true);
		//for anonymous class
		jbtnUp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if (e.getActionCommand().equals("UP"))
					jlbl.setText("You pressed up for anonymous class");
				else
					jlbl.setText("You pressed down");
	
			}
		});
		//for lambda expression
		jbtnUp.addActionListener((aoo) ->{
			if (aoo.getActionCommand().equals("UP"))
				jlbl.setText("You pressed up for Lambda Expressions");
			else
				jlbl.setText("You presseed down");
		});
	}
	
	/*@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (ae.getActionCommand().equals("UP"))
			jlbl.setText("You pressed up");
		else
			jlbl.setText("You presseed down");

	}
*/
	public static void main(String args[]) {
		// create the frame on the event dispatching thread
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ButtonDemo1();
			}

		});
	}
}
