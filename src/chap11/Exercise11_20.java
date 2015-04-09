package chap11;

import java.io.*;
import java.util.*;

class Exercise11_20 {
	static ArrayList record = new ArrayList(); // 성적데이터를 저장할 공간
	static Scanner s = new Scanner(System.in);

	public static void main(String args[]) {
		while (true) {
			switch (displayMenu()) {
			case 1:
				inputRecord();
				break;
			case 2:
				displayRecord();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
		} // while(true)
	}

	// menu를 보여주는 메서드
	static int displayMenu() {
		System.out
				.println("**************************************************");
		System.out.println("* 성적 관리 프로그램 *");
		System.out
				.println("**************************************************");
		System.out.println();
		System.out.println(" 1. 학생성적 입력하기 ");
		System.out.println();
		System.out.println(" 2. 학생성적 보기");
		System.out.println();
		System.out.println(" 3. 프로그램 종료 ");
		System.out.println();
		System.out.print("원하는 메뉴를 선택하세요.(1~3) : ");
		int menu = 0;
		/*
		 * (1) 아래의 로직에 맞게 코드를 작성하시오. 1. 화면으로부터 메뉴를 입력받는다. 메뉴의 값은 1~3사이의 값이어야 한다.
		 * 2. 1~3사이의 값을 입력받지 않으면, 메뉴의 선택이 잘못되었음을 알려주고 다시 입력받는다. (유효한 값을 입력받을 때까지
		 * 반복해서 입력받는다.)
		 */
		while (true) {
			try {
				Scanner in = new Scanner(System.in);
				menu = in.nextInt();
				if (menu < 1 || menu > 3) {
					throw new Exception();
				}
			} catch (Exception e) {

			}
			break;
		}
		return menu;
	} // public static int displayMenu(){
		// 데이터를 입력받는 메서드

	static void inputRecord() {
		System.out.println("1. 학생성적 입력하기");
		System.out.println("이름,반,번호,국어성적,영어성적,수학성적'의 순서로 공백없이 입력하세요.");
		System.out.println("입력을 마치려면 q를 입력하세요. 메인화면으로 돌아갑니다.");
		while (true) {
			try{
			System.out.print(">>");
			Scanner in = new Scanner(System.in);
			String data = in.nextLine();
			if (data.equalsIgnoreCase("q")) {
				break;
			}
			String[] result = data.split(",");
			int ban = Integer.parseInt(result[1]);
			Student3 s = new Student3("", 0, 0, 0, 0, 0);
			s.name = result[0];
			s.ban = Integer.parseInt(result[1]);
			s.no = Integer.parseInt(result[2]);
			s.kor = Integer.parseInt(result[3]);
			s.eng = Integer.parseInt(result[4]);
			s.math = Integer.parseInt(result[5]);
			}catch(Exception e){
				System.out.println("입력오류입니다.");
				continue;
			}
			
			/*
			 * (2) 아래의 로직에 맞게 코드를 작성하시오. 1. Scanner를 이용해서 화면으로 부터 데이터를
			 * 입력받는다.(','를 구분자로) 2. 입력받은 값이 q 또는 Q이면 메서드를 종료하고, 그렇지 않으면 입력받은 값으로
			 * Student3인스턴스를 생성하고 record에 추가한다. 3. 입력받은 데이터에서 예외가 발생하면,
			 * "입력오류입니다."를 보여주고 다시 입력받는다. 4. q 또는 Q가 입력될 때까지 2~3의 작업을 반복한다.
			 */
		} // end of while
	} // public static void inputRecord() {
		// 데이터 목록을 보여주는 메서드

	static void displayRecord() {
		int koreanTotal = 0;
		int englishTotal = 0;
		int mathTotal = 0;
		int total = 0;
		int length = record.size();
		if (length > 0) {
			System.out.println();
			System.out.println("이름 반 번호 국어 영어 수학 총점 평균 전교등수 반등수");
			System.out
					.println("====================================================");
			for (int i = 0; i < length; i++) {
				Student3 Student3 = (Student3) record.get(i);
				System.out.println(Student3);
				koreanTotal += Student3.kor;
				mathTotal += Student3.math;
				englishTotal += Student3.eng;
				total += Student3.total;
			}
			System.out
					.println("====================================================");
			System.out.println("총점: " + koreanTotal + " " + englishTotal + " "
					+ mathTotal + " " + total);
			System.out.println();
		} else {
			System.out
					.println("====================================================");
			System.out.println(" 데이터가 없습니다.");
			System.out
					.println("====================================================");
		}
	} // static void displayRecord() {
}

class Student3 implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total;
	int schoolRank;
	int classRank; // 반등수

	Student3(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor + eng + math;
	}

	int getTotal() {
		return total;
	}

	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
	}

	public int compareTo(Object o) {
		if (o instanceof Student3) {
			Student3 tmp = (Student3) o;
			return tmp.total - this.total;
		} else {
			return -1;
		}
	}

	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math
				+ "," + getTotal() + "," + getAverage() + "," + schoolRank
				+ "," + classRank;
	}
} // class Student3

