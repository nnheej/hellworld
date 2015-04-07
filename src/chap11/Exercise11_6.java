package chap11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Exercise11_6 {
	static int getGroupCount(TreeSet set, int from, int to) {
		int cnt = 0;
		Iterator it = set.iterator();
		while(it.hasNext()){
			Object o = it.next();
			if(o instanceof Student){
				Student s1 = (Student)o;
				if(s1.getAverage() >=from && s1.getAverage()<to){
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		TreeSet set = new TreeSet(new Comparator() {
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Student && o2 instanceof Student) {
					Student s1 = (Student) o1;
					Student s2 = (Student) o2;

					if (s1.getAverage() > s2.getAverage()) {
						return 1;
					} else if (s1.getAverage() == s2.getAverage()) {
						return 0;
					} else {
						return -1;
					}
				}
				return -1;
			}
		});
		set.add(new Student("홍길동", 1, 1, 100, 100, 100));
		set.add(new Student("남궁성", 1, 2, 90, 70, 80));
		set.add(new Student("안자바", 1, 3, 80, 80, 90));
		set.add(new Student("이자바", 1, 4, 70, 90, 70));
		set.add(new Student("김자바", 1, 5, 60, 100, 80));

		Iterator it = set.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("60~69 : " + getGroupCount(set, 60, 70));
		System.out.println("70~79 : " + getGroupCount(set, 70, 80));
		System.out.println("80~89 : " + getGroupCount(set, 80, 90));
		System.out.println("90~100 : " + getGroupCount(set, 90, 101));
	}
}
