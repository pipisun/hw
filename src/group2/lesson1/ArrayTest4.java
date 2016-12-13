package group2.lesson1;

public class ArrayTest4 {
	private static int[] remove(int[] array, int n) {
		int[] newArray = new int[array.length - 1];
		// 为了不影响进来的数组，交给第三变量(不直接操作,否则自身会改变)
		
		int[] tem = new int[array.length];
		System.arraycopy(array, 0, tem, 0, array.length);
		
		
		// 只要删除的不是最后一个
		if (n != tem.length - 1) {
			for (int i = n; i < tem.length - 1; i++) {
				tem[i] = tem[i + 1];
			}
		}
		//将删除后的数组copy给新的数组(包含了删除最后 一个元素)
		System.arraycopy(tem, 0, newArray, 0, tem.length - 1);
		return newArray;
	}

	public static int[] getNewArray(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					array = remove(array, j);
					// 递归
					array = getNewArray(array);
				}
			}
		}
		return array;
	}
}