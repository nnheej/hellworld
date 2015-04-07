package chap11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Exercise11_19 {
	/*
	 * 메서드명 : getDayDiff 기 능 : yyyymmdd형식의 두 문자열을 넘겨받으면 두 날짜의 차이를 일(day)단위로
	 * 반환한다. 단, 첫 번째 날짜 빼기 두 번째 날짜의 결과를 반환한다. 만일 주어진 문자열이 유효하지 않으면 0을 반환한다. 반환타입
	 * : int 매개변수 : String yyyymmdd1 - 시작날짜 String yyyymmdd2 - 끝 날짜
	 */
	public static int getDayDiff(String yyyymmdd1, String yyyymmdd2)
			throws ParseException {

		long timeDiff = 0;
		if (yyyymmdd1 == null || yyyymmdd1.length() == 0 || yyyymmdd2 == null
				|| yyyymmdd2.length() == 0) {
			return 0;
		}
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
			Date d1 = df.parse(yyyymmdd1);
			Date d2 = df.parse(yyyymmdd2);
			System.out.println(df2.format(d1)+","+df2.format(d2));
			Calendar day1 = Calendar.getInstance();
			day1.setTime(d1);
			Calendar day2 = Calendar.getInstance();
			day2.setTime(d2);

			timeDiff = day1.getTimeInMillis() - day2.getTimeInMillis();
		} catch (Exception e) {
			return 0;
		}
		return (int) (timeDiff / (1000 * 60 * 60 * 24));

	}

	public static void main(String args[]) throws ParseException {
		System.out.println(getDayDiff("20010103", "20010101"));
		System.out.println(getDayDiff("20010103", "20010103"));
		System.out.println(getDayDiff("20010103", "200103"));
		System.out.println(getDayDiff("20151010", "2015093"));
		
	}

}
