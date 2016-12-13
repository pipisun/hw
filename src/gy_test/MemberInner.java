package gy_test;

//2、成员内部类(member inner classes)：
//
//成员内部类可以访问外部类的静态与非静态的方法和成员变量。
//
//生成成员内部类对象的方法：
//
//OuterClass.InnerClass inner = new OuterClass().new InnerClass();
//
//在局部内部类中访问外部类的成员变量的方法：
//
//OuterClass.this.a;

public class MemberInner {
	private int a = 1;

	public void execute() {
		// 在外部类中创建成员内部类
		InnerClass innerClass = this.new InnerClass();
	}

	/**
	 * 成员内部类
	 */
	public class InnerClass {

		// 内部类可以创建与外部类同名的成员变量
		private int a = 2;

		public void execute() {
			// this引用的是内部类
			System.out.println(this.a);
			// 在内部了中使用外部类的成员变量的方法
			System.out.println(MemberInner.this.a);
		}
	}

	public static void main(String[] args) {
		// 创建成员内部类
		MemberInner.InnerClass innerClass = new MemberInner().new InnerClass();
		innerClass.execute();
	}
}