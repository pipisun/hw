package group2.GreedSnake1.javawj.view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.Random;


import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import group2.GreedSnake1.javawj.direction.Direction;


public class Snake_View extends JFrame implements Runnable{
	
	
	//构造器
	public Snake_View(){
		
		init();
	}
	//自定义构造器
	private void init(){
		
		pan.setBounds(10,10,300,400);
		pan.setBackground(Color.white);
		//pan.setBorder()
		pan.setLayout(null);
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		initSnake();
		
		
		this.addKeyListener(directionKeyListener);
		this.getContentPane().add(pan);
		this.setBounds(100,100,500,450);
		this.setVisible(true);
		
	}
	
	//初始化蛇身
	private void  initSnake(){
		
		for(int i = 0;i<snakeLabCount;i++){
			
			Snake_Lab l = new Snake_Lab();
			l.setLocation(i*10,0);
			pan.setBorder(BorderFactory.createEtchedBorder(5,
					Color.WHITE.brighter(), Color.BLACK));
			pan.add(l);
			snake.put((snakeLabCount-i)+"", l);
		}
		
	}
	
	public int  direction = Direction.right;
	private boolean flag = true;
	private int snakeLabCount = 3;
	
	Map snake = new java.util.HashMap<String, Snake_Lab>();
	
	
	
	javax.swing.JPanel pan = new JPanel();



	//线程体
	public void run() {
		
		while (flag){
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			snakemove();
		}
		
		
	}
	
	//蛇身移动的方法
	public void snakemove(){
		
		
		//产生食物
		randomFoodLocation();
		
		//记录蛇身每一个lab的位置
		
		int locations [][] = new int[snakeLabCount][2];
		
		int index = 1;
		for(int i = 0;i<snakeLabCount;i++){
				Snake_Lab lab = (Snake_Lab)snake.get(index+"");
				locations[i][0]  = lab.getX();
				locations[i][1]  = lab.getY();
				index++;
		
		}
		
		
		
		//根据蛇移动的方向　使蛇头移动
		
		Snake_Lab slab = (Snake_Lab)snake.get(1+"");
		
		int x = slab.getX();
		int y = slab.getY();
		if(Direction.right == direction){
			slab.setLocation(x+10, y);
		}
		if(Direction.up == direction){
			slab.setLocation(x, y-10);
		}
		if(Direction.down == direction){
			slab.setLocation(x, y+10);
		}
		if(Direction.left == direction){
			slab.setLocation(x-10, y);
		}
		
		//替换蛇头
		snake.put("1",slab);
		
		
		//Snake_Lab ss = (Snake_Lab)snake.get(1+"");
		//System.out.println(":::::  x:"+ss.getX()+"  y:"+ss.getY());
		
		//移动蛇身　从蛇身的第二个身子　等于　前一个身子的位置　依次类推
		for(int  i=1;i<snakeLabCount;i++){
			
			Snake_Lab l = (Snake_Lab)snake.get((i+1)+"");
			
			//System.out.println((i+1)+ "---  x:"+l.getX()+"  y:"+l.getY());
			
			//System.out.println("x:"+locations[i-1][0]+""+ locations[i-1][1]);
			l.setLocation(locations[i-1][0], locations[i-1][1]);
			//System.out.println((i+1)+ " +++++ x:"+l.getX()+"  y:"+l.getY());
			
			snake.put((i+1)+"", l);
			
		}
		
		//得到蛇头 
		//判断 蛇头是否超出有效范围
		Snake_Lab ss = (Snake_Lab)snake.get(1+"");
		int sx = ss.getX();
		int sy = ss.getY();
		
		if(sx > pan.getWidth() - ss.getWidth()  || sx < 0 ){
			
			gameover();
		}
		if(sy > pan.getHeight()-ss.getHeight() || sy <0) {
			gameover();
		}
		
		
		
		
		//判断蛇头是否和蛇身重合
		for(int i = 0;i<locations.length-1 ;i ++)
		{
			if(sx == locations[i][0]&& sy == locations[i][1] ){
				gameover();
			}
			
			
		}
			
		
		//判断是否吃到食物
		
		
		if(f != null){
			
			if(f.getX() == sx && f.getY() == sy){
				
				pan.remove(f);
				isCheck = true;
				randomFoodLocation();
				
				Snake_Lab lab = new Snake_Lab();
				lab.setLocation(locations[locations.length-1][0], locations[locations.length-1][1]);
				snake.put((snakeLabCount+1)+"", lab);
				snakeLabCount++;
				pan.add(lab);
				
			}
			
		}
		
		
		
		this.repaint();
		
		
		
		
	}
	
	//随即产生食物
	Snake_FoodLab  f = null;
	
	private boolean isCheck = true;
	
	
	public void randomFoodLocation(){
		boolean isture = false;
		
		if(isCheck == true){
		
			f = new Snake_FoodLab();
			Random r = new Random();
			
			int x =((int)((r.nextFloat()*(pan.getWidth()/f.getWidth()) ))-1)*f.getWidth();
			int y =((int)((r.nextFloat()*(pan.getHeight()/f.getHeight())) )-1)*f.getHeight(); 
			
			//System.out.println("x:"+x+"  y:"+y);
			
			//判断食物是否在蛇身上
			int locations [][] = new int[snakeLabCount][2];
			
			int index = 1;
			for(int i = 0;i<snakeLabCount;i++){
					Snake_Lab lab = (Snake_Lab)snake.get(index+"");
					locations[i][0]  = lab.getX();
					locations[i][1]  = lab.getY();
					index++;
			
			}
			
			for(int i= 0;i<locations.length;i++){
				
				if(x ==locations[i][0] && y == locations[i][1] ){
					
					randomFoodLocation();
				}else{
					
					isture = true;
				}
			}
			
			if(isture == true){
			
			
				f.setLocation(x,y);
				pan.add(f);
				
				isCheck = false;
			}
		}
		
		
		
	}
	
	// game over 
	public void gameover(){
		JOptionPane.showMessageDialog(this,"game over!","系统提示",JOptionPane.INFORMATION_MESSAGE);
		
		flag = false;
		
	}
	
	java.awt.event.KeyListener directionKeyListener = new java.awt.event.KeyListener(){

		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
				int i = direction;
			
			if(e.getKeyCode() == KeyEvent.VK_LEFT){
				if(i != Direction.right){
					direction = Direction.left;
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT){
				if(i != Direction.left){
				direction = Direction.right;
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_UP){
				if(i != Direction.down){
				direction = Direction.up;
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_DOWN){
				if(i != Direction.up){
				direction = Direction.down;
				}
			}
			
		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
}
