package gy_test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;

//4�������ڲ���(anonymous inner classes)��
//
//�����ڲ���û��������û��class�ؼ���Ҳû��extends��implements�ȹؼ������Ρ�
//
//�����ڲ������ʽ�ؼ̳�һ�������ʵ��һ���ӿڡ�

public class AnonymousInnerClassTest {
 
	
	public static void main(String[] args) {
	    AnonymousInnerClassTest test = new AnonymousInnerClassTest();

	    /**
	 * ���������ڲ���
	 * ���ɵ�������AnonymousInnerClassTest$1
	 */
	    test.print(new Date(){
	        //��дtoString()����
	        @Override
	        public String toString() {
	            return "Hello world.";
	        }
	    });

	    JButton button = new JButton();

	    /**
	 * ���������ڲ���
	 * �������ڲ���ʵ��ActionListener�ӿ�
	 * ���ɵ�������AnonymousInnerClassTest$1
	 */
	    button.addActionListener(new ActionListener(){
	        //ʵ�ֽӿ��еķ���
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            System.out.println("ʹ�������ڲ���ʵ��ActionListener�ӿ�");
	        }
	    });
	}

	public void print(Date date){
	    System.out.println(date);
	}
	 
}