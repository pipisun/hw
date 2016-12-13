package gy_test;

//1、静态内部类(static inner classes)
//
//最简单的内部类。
//
//只能访问外部类的静态成员变量与静态方法。
//
//生成静态内部类对象的方法：
//
//OuterClass.InnerClass inner = new OuterClass.InnerClass();

public class StaticInner {
	private static int a = 1;

	/**
	 * 静态内部类 生成的类名：StaticInner$InnerClass
	 */
	public static class InnerClass {
		// 静态内部类可以声明静态的成员变量，其他的内部类不可以
		private static int b = 1;

		public void execute() {
			// 静态内部类只能访问静态程序
			System.out.println(a + b);
		}
	}

	public static void main(String[] args) {
		// 创建静态内部类
		StaticInner.InnerClass innerClass = new StaticInner.InnerClass();
		innerClass.execute();
	}
}