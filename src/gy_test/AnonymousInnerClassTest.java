package gy_test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;

//4、匿名内部类(anonymous inner classes)：
//
//匿名内部类没有类名，没有class关键字也没有extends和implements等关键字修饰。
//
//匿名内部类会隐式地继承一个父类或实现一个接口。

public class AnonymousInnerClassTest {
 
	
	public static void main(String[] args) {
	    AnonymousInnerClassTest test = new AnonymousInnerClassTest();

	    /**
	 * 创建匿名内部类
	 * 生成的类名：AnonymousInnerClassTest$1
	 */
	    test.print(new Date(){
	        //重写toString()方法
	        @Override
	        public String toString() {
	            return "Hello world.";
	        }
	    });

	    JButton button = new JButton();

	    /**
	 * 创建匿名内部类
	 * 该匿名内部类实现ActionListener接口
	 * 生成的类名：AnonymousInnerClassTest$1
	 */
	    button.addActionListener(new ActionListener(){
	        //实现接口中的方法
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            System.out.println("使用匿名内部类实现ActionListener接口");
	        }
	    });
	}

	public void print(Date date){
	    System.out.println(date);
	}
	 
}