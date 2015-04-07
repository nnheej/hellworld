package chap11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Student implements Comparable {
	String name;
	int ban;
	int no;
	int kor, eng, math;
	int total;
	int schoolRank; // 전교등
	int classRank; // 반등수수

	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	int getTotal() {
		return kor + eng + math;
	}

	float getAverage() {
		return (int) (getTotal() / 3f * 10 + 0.5) / 10f;
	}

	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math
				+ "," + getTotal() + "," + getAverage() + "," + schoolRank
				+ "," + classRank;
	}

	@Override
	public int compareTo(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Student) {
			Student s = (Student) obj;
			return s.getTotal() - getTotal();
		} else
			return -1;
	}
}

class ClassTotalComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Student && o2 instanceof Student) {
			Student s1 = (Student) o1;
			Student s2 = (Student) o2;

			int result = s1.ban - s2.ban;
			if (result == 0) {
				result = s1.total - s2.total;
			}
			return result;
		}
		return -1;
	}
}

public class Exercise11_5 {
	public static void calculateClassRank(List list) {
		Collections.sort(list, new ClassTotalComparator());

		int prevBan = -1;
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();

		for (int i = 0; i < length; i++) {
			Student s = (Student)list.get(i);
			if(s.ban!=prevBan){
				prevRank = 0;
				prevTotal = -1;
			}
			if(s.getTotal()==prevTotal){
				s.classRank = prevRank;
			}
			else{
				s.classRank = prevRank+1;
			}
			prevBan = s.ban;
			prevRank = s.classRank;
			prevTotal = s.getTotal();
		}

	}

	public static void calculateSchoolRank(List list) {
		Collections.sort(list);

		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();

		for (int j = 0; j < length; j++) {

			Student s = (Student) list.get(j);
			if (s.getTotal() == prevTotal) {
				/* 현재 객체와 prevTotal이 같으면 동점자 */
				s.schoolRank = prevRank;
			} else { /* 아니면 rank 계산해서.. */
				s.schoolRank = j + 1;
			}
			prevRank = s.schoolRank;
			prevTotal = s.getTotal();
		}
	}

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student("홍길동", 1, 3, 100, 100, 100));
		list.add(new Student("남궁성", 1, 1, 90, 70, 80));
		list.add(new Student("안자바", 2, 2, 60, 100, 80));
		list.add(new Student("이자바", 2, 1, 70, 90, 70));
		list.add(new Student("김자바", 1, 2, 80, 80, 90));
		list.add(new Student("이밍밍", 2, 3, 70, 90, 70));
		list.add(new Student("이밍망", 2, 4, 70, 90, 60));
		

		calculateSchoolRank(list);
		calculateClassRank(list);
		Iterator it = list.iterator();

		while (it.hasNext())
			System.out.println(it.next());
	}
}
