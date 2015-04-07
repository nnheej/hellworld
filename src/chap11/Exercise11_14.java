package chap11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Exercise11_14 {
	public static void main(String[] args){
		/* Calendar 클래스와 SimpleDateFormat클래스를
		 * 이용해서
		 * 2010년의 매월 두 번째 일요일의
		 * 날짜를 출력하시오*/
		Calendar today = Calendar.getInstance();
		for(int i=0; i<12; i++){
			today.set(2015, i,1);
			today.set(Calendar.DAY_OF_WEEK_IN_MONTH,2); 
			//이달의 몇 째 요일 DAY_OF_WEEK_IN_MONTH
			today.set(Calendar.DAY_OF_WEEK, 1);
			//일요일 DAY_OF_WEEK : 1 두개 같이 쓰면 된다.
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd / F번째 E요일");
			String result = df.format(new Date(today.getTimeInMillis()));
			System.out.println(result);
		}
	}
}
