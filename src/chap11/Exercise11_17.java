package chap11;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Exercise11_17 {
	public static void main(String[] args) {

		String[] dayOfWeek = { "일", "월", "화", "수", "목", "금", "토" };
		while (true) {

			try {
				System.out
						.println("날짜를 yyyy/MM/dd의 형태로 입력해주세요. (입력 예:2007/05/11)");
				System.out.print(">>");
				Scanner in = new Scanner(System.in);
				String input = in.nextLine();
				Date today = new Date(input);
				Calendar cal = Calendar.getInstance();
				cal.setTime(today);
				System.out.println("입력하신 날짜는 "
						+ dayOfWeek[cal.get(Calendar.DAY_OF_WEEK) - 1]
						+ "요일 입니다.");
				break;
			} catch (Exception e) {
			}

		}

	}

}
