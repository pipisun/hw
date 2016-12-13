package hwfpp.lesson8.lession8.lesson8comparator;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class TryComparators implements Comparable<TryComparators> {

    String name;
    int age;

    public TryComparators(String name, int age) {
       this.name = name;
       this.age = age;
    }

    @Override
    public String toString() {
        return name + ":" + age;
    }

    @Override
    public int compareTo(TryComparators o) {
        return Comparators.NAME.compare(this, o);
    }


    public static class Comparators {

        public static Comparator<TryComparators> NAME = new Comparator<TryComparators>() {
            @Override
            public int compare(TryComparators o1, TryComparators o2) {
                return o1.name.compareTo(o2.name);
            }
        };
        public static Comparator<TryComparators> AGE = new Comparator<TryComparators>() {
            @Override
            public int compare(TryComparators o1, TryComparators o2) {
                return o1.age - o2.age;
            }
        };
        public static Comparator<TryComparators> NAMEANDAGE = new Comparator<TryComparators>() {
            @Override
            public int compare(TryComparators o1, TryComparators o2) {
                int i = o1.name.compareTo(o2.name);
                if (i == 0) {
                    i = o1.age - o2.age;
                }
                return i;
            }
        };
    }

public static void main(String args[]){
	TryComparators t1=new TryComparators("Adams",34);
	TryComparators t2=new TryComparators("Brown",30);
	ArrayList<TryComparators> studentList = new ArrayList<TryComparators>();
	studentList.add(new TryComparators("Brown",30));
	studentList.add(new TryComparators("Adams",34));
	Collections.sort(studentList, TryComparators.Comparators.AGE);
	System.out.println("age");
	for(TryComparators tC:studentList){
		System.out.println(tC.age);
	}
	Collections.sort(studentList, TryComparators.Comparators.NAME);
	System.out.println("name");
	for(TryComparators tC:studentList){
		System.out.println(tC.name);
	}
	Collections.sort(studentList, TryComparators.Comparators.NAMEANDAGE);
	System.out.println("name and age");
	for(TryComparators tC:studentList){
		
		System.out.println(tC.name);
		System.out.println(tC.age);
		
	}
	System.out.println(t1.compareTo(t2));
	
}
	
}