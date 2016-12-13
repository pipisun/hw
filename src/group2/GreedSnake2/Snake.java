package group2.GreedSnake2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Snake extends JFrame implements ActionListener, KeyListener, Runnable {
	private JMenuBar menuBar;
	private JMenu youXiMenu, nanDuMenu, fenShuMenu, guanYuMenu;
	private JMenuItem kaiShiYouXi, exitItem, zuoZheItem, fenShuItem;
	private JMenuItem cJianDan, cPuTong, cKunNan;
	private int length = 6;
	private Toolkit toolkit;
	private int i,
			// 因为新增加的 头部是添加在 食物的位置，所以要先保存新的头部位置
			// 原先的身体需要移动到后面
			NewHeadLeftTopX, NewHeadLeftTopY,

			// 移动的方向
			m_SnakeDirection,
			// 随机的食物 方格的 左上角的坐标
			FoodLeftTopX, FoodLeftTopY,

			// 是否需要随机新的食物?
			IsNeedNewFood = 1,
			// 蛇迟到了新的食物了么?
			m_IsNeedEnLength = 0, time;// bojectX,Y为食物坐标,m_SnakeDirection为蛇前进方向
	private int difficult = 2;
	// x方向50个格子，m n,存放了蛇身体的每个格子的左上角的坐标
	private int BlockLeftTopX[] = new int[50];
	// y方向51个格子
	private int BlockTopLeftY[] = new int[50];
	private Thread m_Thread = null;
	private int CurGrade = 0;
	private int foods = 0;
	private int MaxGrade = 0;
	// 蛇的移动方向
	public static int MOVE_UP = 1;// 上
	public static int MOVE_DOWN = 2;// 下
	public static int MOVE_LEFT = 3;// 左
	public static int MOVE_RIGHT = 4;// 右

	// 线程 500ms执行一次
	public void run() {
		for (i = 0; i <= length - 1; i++) {
			BlockLeftTopX[i] = 90 - i * 10;
			BlockTopLeftY[i] = 60;
		}
		NewHeadLeftTopX = BlockLeftTopX[0];
		NewHeadLeftTopY = BlockTopLeftY[0];
		m_SnakeDirection = 4;
		while (m_Thread != null) {
			Step();
			try {
				m_Thread.sleep(time);
			} catch (Exception ee) {
				System.out.println(m_SnakeDirection + "");
			}
		}
	}

	public Snake() {
		// 默认time = 500;
		time = 500;
		// ***************创建新对象**************
		setVisible(true);
		menuBar = new JMenuBar();
		Container con = getContentPane();
		toolkit = getToolkit();

		// **************游戏菜单对象*****************
		youXiMenu = new JMenu("游戏");
		kaiShiYouXi = new JMenuItem("开始游戏");
		exitItem = new JMenuItem("退出游戏");
		// ***************困难程度对象****************
		nanDuMenu = new JMenu("困难程度");
		cJianDan = new JMenuItem("简单");
		cPuTong = new JMenuItem("普通");
		cKunNan = new JMenuItem("困难");
		// *****************分数菜单对象****************
		fenShuMenu = new JMenu("积分排行");
		fenShuItem = new JMenuItem("最高记录");

		// ****************关于对象*********************
		guanYuMenu = new JMenu("关于");
		zuoZheItem = new JMenuItem("关于贪吃蛇");
		// ***************设置关于菜单*******************
		guanYuMenu.add(zuoZheItem);
		// ****************设置困难程度菜单**************
		nanDuMenu.add(cJianDan);
		nanDuMenu.add(cPuTong);
		nanDuMenu.add(cKunNan);
		// ******************设置分数菜单***************
		fenShuMenu.add(fenShuItem);
		// *****************设置游戏菜单****************
		youXiMenu.add(kaiShiYouXi);
		youXiMenu.add(exitItem);
		// ******************设置主菜单********************
		menuBar.add(youXiMenu);
		menuBar.add(nanDuMenu);
		menuBar.add(fenShuMenu);
		menuBar.add(guanYuMenu);
		// *********************监听注册*****************
		zuoZheItem.addActionListener(this);
		kaiShiYouXi.addActionListener(this);
		cJianDan.addActionListener(this);
		cPuTong.addActionListener(this);
		cKunNan.addActionListener(this);
		exitItem.addActionListener(this);
		addKeyListener(this); // 添加指定的按键侦听器，以接收发自此组件的按键事件
		fenShuItem.addActionListener(this);

		// *********************加快捷键********************
		KeyStroke keyOpen = KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK);
		kaiShiYouXi.setAccelerator(keyOpen);
		KeyStroke keyExit = KeyStroke.getKeyStroke('X', InputEvent.CTRL_DOWN_MASK);
		exitItem.setAccelerator(keyExit);
		// *****************设置框架**********************
		setJMenuBar(menuBar);
		setTitle("贪吃蛇");
		setResizable(false);
		setBounds(300, 200, 400, 400);
		validate(); // 有效性验证
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.repaint();
	}

	public static void main(String args[]) {
		new Snake();
	}

	// ******************菜单监听******************************
	public void actionPerformed(ActionEvent e) {
		// 先获取到菜单的选项
		Object obj = e.getSource();
		if (obj == kaiShiYouXi) {
			length = 6;
			CurGrade = 0;
			foods = 0;
			if (m_Thread == null) {
				m_Thread = new Thread(this);
				m_Thread.start();
			} else if (m_Thread != null) {
				m_Thread = null;
				m_Thread = new Thread(this);
				m_Thread.start();
			}
		}
		// 简单
		else if (obj == cJianDan) {
			time = 500;
		} else if (obj == cPuTong) {
			time = 300;
		} else if (obj == cKunNan) {
			time = 100;
		} else if (obj == exitItem) {
			System.exit(0);
		} else if (obj == zuoZheItem) {
			JOptionPane.showMessageDialog(this, "贪吃蛇v1.0000");
		} else if (obj == fenShuItem) {
			JOptionPane.showMessageDialog(this, "最高记录：" + MaxGrade + " ");
		}
	}

	// **************检查一下*******************************
	public void Step() {
		isDead();
		if (m_Thread != null) {
			// 是否吃到了东西，需要增加长度么
			if (m_IsNeedEnLength == 0) {
				ReCalcSnakeBodyPos();
			} else {
				EnLength(); // growth==1，需要让蛇变长
			}
			// 吃到了东西，成长+1 growth=1;
			if (BlockLeftTopX[0] == FoodLeftTopX && BlockTopLeftY[0] == FoodLeftTopY) {
				// 继续产生食物的标记
				IsNeedNewFood = 1;
				m_IsNeedEnLength = 1;
				// 吃到了东西响一下
				toolkit.beep();
			}

			// ****************产生食物坐标**********************
			if (IsNeedNewFood == 1) {
				IsNeedNewFood = 0;
				FoodLeftTopX = (int) Math.floor(Math.random() * 39) * 10;
				FoodLeftTopY = (int) Math.floor(Math.random() * 29) * 10 + 50;
			}
			this.repaint(); // 重绘
		}
	}

	void isDead() {
		// 根据方向先执行坐标的计算
		if (m_SnakeDirection == Snake.MOVE_RIGHT) {
			NewHeadLeftTopX += 10;
		} else if (m_SnakeDirection == Snake.MOVE_LEFT) {
			NewHeadLeftTopX -= 10;
		} else if (m_SnakeDirection == Snake.MOVE_DOWN) {
			NewHeadLeftTopY += 10;
		} else if (m_SnakeDirection == Snake.MOVE_UP) {
			NewHeadLeftTopY -= 10;
		}
		if (NewHeadLeftTopX < 0 || NewHeadLeftTopX > 390 || NewHeadLeftTopY < 50 || NewHeadLeftTopY > 390) {
			m_Thread = null;
			JOptionPane.showMessageDialog(this, "Game Over");
		}
		for (i = 1; i < length; i++) {
			if (BlockLeftTopX[i] == NewHeadLeftTopX && BlockTopLeftY[i] == NewHeadLeftTopY) {
				m_Thread = null;
				JOptionPane.showMessageDialog(this, "Game Over");
			}
		}
	}

	// 长度增加一个
	public void EnLength() {
		// 当蛇吃到东西时的方法
		if (length < 50) {
			length++;
		}
		m_IsNeedEnLength = 0;
		// 变换速度
		time = time - 5;
		ReCalcSnakeBodyPos();
		CurGrade += 100;
		if (MaxGrade < CurGrade) {
			MaxGrade = CurGrade;
		}
		foods++;
	}

	// 改变蛇的位置
	public void ReCalcSnakeBodyPos() {
		int i = 0;
		// 蛇的身体前进，头部的坐标最后变换
		for (i = length - 1; i > 0; i--) {
			BlockLeftTopX[i] = BlockLeftTopX[i - 1];
			BlockTopLeftY[i] = BlockTopLeftY[i - 1];
		}

		// 改变头部的坐标
		if (m_SnakeDirection == Snake.MOVE_RIGHT) {
			BlockLeftTopX[0] = BlockLeftTopX[0] + 10;
		} else if (m_SnakeDirection == Snake.MOVE_LEFT) {
			BlockLeftTopX[0] = BlockLeftTopX[0] - 10;
		} else if (m_SnakeDirection == Snake.MOVE_DOWN) {
			BlockTopLeftY[0] = BlockTopLeftY[0] + 10;
		} else if (m_SnakeDirection == Snake.MOVE_UP) {
			BlockTopLeftY[0] = BlockTopLeftY[0] - 10;
		}

	}

	public void keyPressed(KeyEvent e) {
		// 要知道:蛇往左边运动的时候按下方向键右是无效的
		if (m_Thread != null) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (m_SnakeDirection != Snake.MOVE_DOWN) {
					m_SnakeDirection = Snake.MOVE_UP;
					Step();
				}
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (m_SnakeDirection != Snake.MOVE_UP) {
					m_SnakeDirection = Snake.MOVE_DOWN;
					Step();
				}
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (m_SnakeDirection != Snake.MOVE_RIGHT) {
					m_SnakeDirection = Snake.MOVE_LEFT;
					Step();
				}
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (m_SnakeDirection != Snake.MOVE_LEFT) {
					m_SnakeDirection = Snake.MOVE_RIGHT;
					Step();
				}
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO 自动生成方法存根
	}

	public void keyTyped(KeyEvent e) {
		// TODO 自动生成方法存根
	}

	public void paint(Graphics g) {
		super.paint(g);
		// *******************画图**********************
		g.setColor(Color.black); // 设置背景
		g.fillRect(0, 50, 400, 400);
		g.setColor(Color.pink);
		for (i = 0; i <= length - 1; i++) {
			g.fillRect(BlockLeftTopX[i], BlockTopLeftY[i], 10, 10);
		}
		g.setColor(Color.green); // 蛇的食物
		g.fillRect(FoodLeftTopX, FoodLeftTopY, 10, 10);
		g.setColor(Color.white);
		g.drawString("当前      分数" + this.CurGrade, 6, 60);
		g.drawString("当前已吃食物数" + this.foods, 6, 72);
	}

}