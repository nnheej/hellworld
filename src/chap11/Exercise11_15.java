package chap11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Exercise11_15 {
	static int paycheckCount(Calendar from, Calendar to) {
		/*
		 * 어떤 회사의 월급날이 매월 21일이다. 
		 * 두 날짜 사이에 월급날이 몇 번있는지 계산해서 
		 * 반환하는 메서드를 작성하고 테스트
		 * 하시오.
		 */
		/*
		(1) 아래의 로직에 맞게 코드를 작성하시오.
		1. from 또는 to가 null이면 0을 반환한다.
		2. from와 to가 같고 날짜가 21일이면 1을 반환한다.
		3. to와 from이 몇 개월 차이인지 계산해서 변수 monDiff에 담는다.
		4. monDiff가 음수이면 0을 반환한다.
		5. 만일 from의 일(DAY_OF_MONTH)이 21일이거나 이전이고
		to의 일(DAY_OF_MONTH)이 21일이거나 이후이면 monDiff의 값을 1 증가시킨다.
		6. 만일 from의 일(DAY_OF_MONTH)이 21일 이후고
		to의 일(DAY_OF_MONTH)이 21일 이전이면 monDiff의 값을 1 감소시킨다.
		*/
		
		if(from==null || to==null)
			return 0;
		if((from.equals(to)) && from.get(Calendar.DATE)==21){
			return 1;
		}
		int yearDiff = to.get(Calendar.YEAR) - from.get(Calendar.YEAR);
		int monDiff = to.get(Calendar.MONTH) - from.get(Calendar.MONTH);
		monDiff = yearDiff*12 + monDiff;
		
		int fromDate = from.get(Calendar.DAY_OF_MONTH);
		int toDate = to.get(Calendar.DAY_OF_MONTH);
	
		if(monDiff<0){
			return 0;
		}
		if(fromDate<=21 || toDate>=21)
		{
			monDiff++;
		}
		if(fromDate>21 || toDate<21){
			monDiff--;
		}
		
		
		return monDiff;
	}

	static void printResult(Calendar from, Calendar to) {
		Date fromDate = from.getTime();
		Date toDate = to.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		System.out.print(sdf.format(fromDate) + "~" + sdf.format(toDate) + ":");
		System.out.println(paycheckCount(from, to));
	}

	public static void main(String[] args) {
		Calendar fromCal = Calendar.getInstance();
		Calendar toCal = Calendar.getInstance();

		fromCal.set(2010, 0, 1);
		toCal.set(2010, 0, 1);
		printResult(fromCal, toCal);
		fromCal.set(2010, 0, 21);
		toCal.set(2010, 0, 21);
		printResult(fromCal, toCal);

		fromCal.set(2010, 0, 1);
		toCal.set(2010, 2, 1);
		printResult(fromCal, toCal);

		fromCal.set(2010, 0, 1);
		toCal.set(2010, 2, 23);
		printResult(fromCal, toCal);

		fromCal.set(2010, 0, 23);
		toCal.set(2010, 2, 21);
		printResult(fromCal, toCal);

		fromCal.set(2011, 0, 22);
		toCal.set(2010, 2, 21);
		printResult(fromCal, toCal);

	}

}
