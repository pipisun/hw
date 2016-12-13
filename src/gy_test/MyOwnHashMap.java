package gy_test;

import java.util.HashMap;
/**
 * HashMap�ļ�ʵ��
 * @author txxs
 *
 */
public class MyOwnHashMap {
	/**
	 * ȡ����Ĵ�СΪ16
	 */
	private static final int SIZE = 16;
	private Entry table[] = new Entry[SIZE];

	/**
	 * ����Ҫ��key��value����һ���򵥵�Map���ݽṹ
	 * �������������е�Ͱ�ĳ�ͻ������������ֵ����
	 * ��ͬ��hashcode,�����в�ͬ��key��ʹ��ָ�롰next��
	 */
	class Entry {
		final String key;
		String value;
		Entry next;

		Entry(String k, String v) {
			key = k;
			value = v;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getKey() {
				return key;
		}
	}

	/**�������Լ�ʵ�ֵ�HashMap�и���key����value��
	 * �����û�к�key��Ӧ��value���ؿ�
	*/
	public Entry get(String k) {
		int hash = k.hashCode() % SIZE;
		Entry e = table[hash];

		//����ҵ��˶�Ӧ��Ͱ����ô��������Ѱ�ҿ�����key��Ӧ��value�Ƿ����
		while(e != null) {
			if(e.key.equals(k)) {
				return e;
			}
			e = e.next;
		}
		return null;
	}

	/**
	 * ��map�н��ض���key��value����������
	 * �����������ͬ��key��ԭ���ľ�ֵ���ᱻ�滻��
	*/
	public void put(String k, String v) {
		int hash=k.hashCode()%SIZE;
		Entry e=table[hash];
		if(e!=null){
			//����Ƿ�����ͬ��key,���������ֵ�����ֵ
			while(e.next!=null){
				if(e.key.equals(k)){
					e.value=v;
					return ;
				}
				e=e.next;
			}
			//������ĩβ����µ�Ԫ��
			Entry entryInOldBucket=new Entry(k,v);
			e.next=entryInOldBucket;
		}
		else{
		//����һ����Ͱ
		Entry entryInNewBucket=new Entry(k,v);
		table[hash]=entryInNewBucket;
		}

	}

	// ����
	public static void main(String[] args) {
		MyOwnHashMap tmhm = new MyOwnHashMap();
		HashMap map = new HashMap();
		map.put("Niranjan", "SMTS");
		map.put("Ananth", "SSE");
		map.put("Niranjan", "SMTS1");
		map.put("Chandu", "SSE");
		tmhm.put("Niranjan", "SMTS");
		tmhm.put("Ananth", "SSE");
		tmhm.put("Niranjan", "SMTS1");
		tmhm.put("Chandu", "SSE");

		//���ÿ�ʼʱ��
		long startTime = System.nanoTime(); 
		Entry e = tmhm.get("Niranjan");
		//���ý���ʱ��
		long endTime = System.nanoTime();  
		long duration = endTime - startTime;  
		System.out.println("�Լ�ʵ�ֵ�HashMap " + duration);  
		    
		//���ÿ�ʼʱ��
		startTime = System.nanoTime(); 
		String mapResult = (String) map.get("Niranjan");
		//���ý���ʱ��
		endTime = System.nanoTime();  
		duration = endTime - startTime;  
		System.out.println("ԭ�е�java.util.HashMap " + duration);  
		
		System.out.println("�Լ�ʵ�ֵ�Mapȡֵ�� "+e.getValue());
		System.out.println("ԭ�е�java.util.HashMapȡֵ�� "+mapResult);
 
	}

}