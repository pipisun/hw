package hwfpp.lesson8.lession8.lesson8comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestCompare implements Comparable {
	int age;
	private int ageDiff;
TestCompare(int age){
	this.age=age;
}
@Override
public int compareTo(Object o) {
	// TODO Auto-generated method stub
	TestCompare AObj=(TestCompare)o;
	if (this.age > AObj.age) 
		ageDiff=this.age-AObj.age;
		return ageDiff;
	}
public static void main(String args[]){
	
	TestCompare t1=new TestCompare(19);
	TestCompare t2=new TestCompare(11);
	System.out.println(t1.compareTo(t2));
	
	}
	
}

