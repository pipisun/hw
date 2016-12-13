package gy_test;

//2����Ա�ڲ���(member inner classes)��
//
//��Ա�ڲ�����Է����ⲿ��ľ�̬��Ǿ�̬�ķ����ͳ�Ա������
//
//���ɳ�Ա�ڲ������ķ�����
//
//OuterClass.InnerClass inner = new OuterClass().new InnerClass();
//
//�ھֲ��ڲ����з����ⲿ��ĳ�Ա�����ķ�����
//
//OuterClass.this.a;

public class MemberInner {
	private int a = 1;

	public void execute() {
		// ���ⲿ���д�����Ա�ڲ���
		InnerClass innerClass = this.new InnerClass();
	}

	/**
	 * ��Ա�ڲ���
	 */
	public class InnerClass {

		// �ڲ�����Դ������ⲿ��ͬ���ĳ�Ա����
		private int a = 2;

		public void execute() {
			// this���õ����ڲ���
			System.out.println(this.a);
			// ���ڲ�����ʹ���ⲿ��ĳ�Ա�����ķ���
			System.out.println(MemberInner.this.a);
		}
	}

	public static void main(String[] args) {
		// ������Ա�ڲ���
		MemberInner.InnerClass innerClass = new MemberInner().new InnerClass();
		innerClass.execute();
	}
}