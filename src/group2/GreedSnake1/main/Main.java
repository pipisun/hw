package group2.GreedSnake1.main;

import group2.GreedSnake1.javawj.view.Snake_View;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Snake_View sv = new Snake_View();
		Thread th = new Thread(sv);
		th.start();
	}

}
