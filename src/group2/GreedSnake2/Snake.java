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
			// ��Ϊ�����ӵ� ͷ��������� ʳ���λ�ã�����Ҫ�ȱ����µ�ͷ��λ��
			// ԭ�ȵ�������Ҫ�ƶ�������
			NewHeadLeftTopX, NewHeadLeftTopY,

			// �ƶ��ķ���
			m_SnakeDirection,
			// �����ʳ�� ����� ���Ͻǵ�����
			FoodLeftTopX, FoodLeftTopY,

			// �Ƿ���Ҫ����µ�ʳ��?
			IsNeedNewFood = 1,
			// �߳ٵ����µ�ʳ����ô?
			m_IsNeedEnLength = 0, time;// bojectX,YΪʳ������,m_SnakeDirectionΪ��ǰ������
	private int difficult = 2;
	// x����50�����ӣ�m n,������������ÿ�����ӵ����Ͻǵ�����
	private int BlockLeftTopX[] = new int[50];
	// y����51������
	private int BlockTopLeftY[] = new int[50];
	private Thread m_Thread = null;
	private int CurGrade = 0;
	private int foods = 0;
	private int MaxGrade = 0;
	// �ߵ��ƶ�����
	public static int MOVE_UP = 1;// ��
	public static int MOVE_DOWN = 2;// ��
	public static int MOVE_LEFT = 3;// ��
	public static int MOVE_RIGHT = 4;// ��

	// �߳� 500msִ��һ��
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
		// Ĭ��time = 500;
		time = 500;
		// ***************�����¶���**************
		setVisible(true);
		menuBar = new JMenuBar();
		Container con = getContentPane();
		toolkit = getToolkit();

		// **************��Ϸ�˵�����*****************
		youXiMenu = new JMenu("��Ϸ");
		kaiShiYouXi = new JMenuItem("��ʼ��Ϸ");
		exitItem = new JMenuItem("�˳���Ϸ");
		// ***************���ѳ̶ȶ���****************
		nanDuMenu = new JMenu("���ѳ̶�");
		cJianDan = new JMenuItem("��");
		cPuTong = new JMenuItem("��ͨ");
		cKunNan = new JMenuItem("����");
		// *****************�����˵�����****************
		fenShuMenu = new JMenu("��������");
		fenShuItem = new JMenuItem("��߼�¼");

		// ****************���ڶ���*********************
		guanYuMenu = new JMenu("����");
		zuoZheItem = new JMenuItem("����̰����");
		// ***************���ù��ڲ˵�*******************
		guanYuMenu.add(zuoZheItem);
		// ****************�������ѳ̶Ȳ˵�**************
		nanDuMenu.add(cJianDan);
		nanDuMenu.add(cPuTong);
		nanDuMenu.add(cKunNan);
		// ******************���÷����˵�***************
		fenShuMenu.add(fenShuItem);
		// *****************������Ϸ�˵�****************
		youXiMenu.add(kaiShiYouXi);
		youXiMenu.add(exitItem);
		// ******************�������˵�********************
		menuBar.add(youXiMenu);
		menuBar.add(nanDuMenu);
		menuBar.add(fenShuMenu);
		menuBar.add(guanYuMenu);
		// *********************����ע��*****************
		zuoZheItem.addActionListener(this);
		kaiShiYouXi.addActionListener(this);
		cJianDan.addActionListener(this);
		cPuTong.addActionListener(this);
		cKunNan.addActionListener(this);
		exitItem.addActionListener(this);
		addKeyListener(this); // ���ָ���İ������������Խ��շ��Դ�����İ����¼�
		fenShuItem.addActionListener(this);

		// *********************�ӿ�ݼ�********************
		KeyStroke keyOpen = KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK);
		kaiShiYouXi.setAccelerator(keyOpen);
		KeyStroke keyExit = KeyStroke.getKeyStroke('X', InputEvent.CTRL_DOWN_MASK);
		exitItem.setAccelerator(keyExit);
		// *****************���ÿ��**********************
		setJMenuBar(menuBar);
		setTitle("̰����");
		setResizable(false);
		setBounds(300, 200, 400, 400);
		validate(); // ��Ч����֤
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.repaint();
	}

	public static void main(String args[]) {
		new Snake();
	}

	// ******************�˵�����******************************
	public void actionPerformed(ActionEvent e) {
		// �Ȼ�ȡ���˵���ѡ��
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
		// ��
		else if (obj == cJianDan) {
			time = 500;
		} else if (obj == cPuTong) {
			time = 300;
		} else if (obj == cKunNan) {
			time = 100;
		} else if (obj == exitItem) {
			System.exit(0);
		} else if (obj == zuoZheItem) {
			JOptionPane.showMessageDialog(this, "̰����v1.0000");
		} else if (obj == fenShuItem) {
			JOptionPane.showMessageDialog(this, "��߼�¼��" + MaxGrade + " ");
		}
	}

	// **************���һ��*******************************
	public void Step() {
		isDead();
		if (m_Thread != null) {
			// �Ƿ�Ե��˶�������Ҫ���ӳ���ô
			if (m_IsNeedEnLength == 0) {
				ReCalcSnakeBodyPos();
			} else {
				EnLength(); // growth==1����Ҫ���߱䳤
			}
			// �Ե��˶������ɳ�+1 growth=1;
			if (BlockLeftTopX[0] == FoodLeftTopX && BlockTopLeftY[0] == FoodLeftTopY) {
				// ��������ʳ��ı��
				IsNeedNewFood = 1;
				m_IsNeedEnLength = 1;
				// �Ե��˶�����һ��
				toolkit.beep();
			}

			// ****************����ʳ������**********************
			if (IsNeedNewFood == 1) {
				IsNeedNewFood = 0;
				FoodLeftTopX = (int) Math.floor(Math.random() * 39) * 10;
				FoodLeftTopY = (int) Math.floor(Math.random() * 29) * 10 + 50;
			}
			this.repaint(); // �ػ�
		}
	}

	void isDead() {
		// ���ݷ�����ִ������ļ���
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

	// ��������һ��
	public void EnLength() {
		// ���߳Ե�����ʱ�ķ���
		if (length < 50) {
			length++;
		}
		m_IsNeedEnLength = 0;
		// �任�ٶ�
		time = time - 5;
		ReCalcSnakeBodyPos();
		CurGrade += 100;
		if (MaxGrade < CurGrade) {
			MaxGrade = CurGrade;
		}
		foods++;
	}

	// �ı��ߵ�λ��
	public void ReCalcSnakeBodyPos() {
		int i = 0;
		// �ߵ�����ǰ����ͷ�����������任
		for (i = length - 1; i > 0; i--) {
			BlockLeftTopX[i] = BlockLeftTopX[i - 1];
			BlockTopLeftY[i] = BlockTopLeftY[i - 1];
		}

		// �ı�ͷ��������
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
		// Ҫ֪��:��������˶���ʱ���·����������Ч��
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
		// TODO �Զ����ɷ������
	}

	public void keyTyped(KeyEvent e) {
		// TODO �Զ����ɷ������
	}

	public void paint(Graphics g) {
		super.paint(g);
		// *******************��ͼ**********************
		g.setColor(Color.black); // ���ñ���
		g.fillRect(0, 50, 400, 400);
		g.setColor(Color.pink);
		for (i = 0; i <= length - 1; i++) {
			g.fillRect(BlockLeftTopX[i], BlockTopLeftY[i], 10, 10);
		}
		g.setColor(Color.green); // �ߵ�ʳ��
		g.fillRect(FoodLeftTopX, FoodLeftTopY, 10, 10);
		g.setColor(Color.white);
		g.drawString("��ǰ      ����" + this.CurGrade, 6, 60);
		g.drawString("��ǰ�ѳ�ʳ����" + this.foods, 6, 72);
	}

}