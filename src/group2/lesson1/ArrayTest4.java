package group2.lesson1;

public class ArrayTest4 {
	private static int[] remove(int[] array, int n) {
		int[] newArray = new int[array.length - 1];
		// Ϊ�˲�Ӱ����������飬������������(��ֱ�Ӳ���,���������ı�)
		
		int[] tem = new int[array.length];
		System.arraycopy(array, 0, tem, 0, array.length);
		
		
		// ֻҪɾ���Ĳ������һ��
		if (n != tem.length - 1) {
			for (int i = n; i < tem.length - 1; i++) {
				tem[i] = tem[i + 1];
			}
		}
		//��ɾ���������copy���µ�����(������ɾ����� һ��Ԫ��)
		System.arraycopy(tem, 0, newArray, 0, tem.length - 1);
		return newArray;
	}

	public static int[] getNewArray(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					array = remove(array, j);
					// �ݹ�
					array = getNewArray(array);
				}
			}
		}
		return array;
	}
}