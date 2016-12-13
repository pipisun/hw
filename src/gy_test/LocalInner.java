package gy_test;

//3���ֲ��ڲ���(local inner classes)��
//
//�����ھֲ����������ܶ���Ϊpublic��protected��private����static���͡�
//
//���巽���У�ֻ�ܷ���������Ϊfinal���͵ı�����

public class LocalInner {

	public void execute() {
		final int a = 1;
		/**
		 * �����ֲ��ڲ���
		 */
		class InnerClass {
			public void execute() {
				System.out.println("LocalInner Class");

				// �ֲ��ڲ���ֻ�ܷ���final���͵ı���
				System.out.println(a);
			}
		}
		// ֻ�������ڷ������򴴽�
		new InnerClass().execute();
	}

	public static void main(String[] args) {
		// �ⲿ����ֱ�Ӵ����ֲ��ڲ���
		LocalInner localInner = new LocalInner();
		localInner.execute();
	}
}