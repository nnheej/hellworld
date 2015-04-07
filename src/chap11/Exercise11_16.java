package chap11;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Exercise11_16 {
	/*
	 * 문자열 “123,456,789.5”를 소수점 첫 번째 자리에서 반올림하고, 그 값을 만 단위마다 콤마(,)로 구분해서 출력하시오.
	 */

	public static void main(String[] args) throws ParseException {
		String strNum = "123,456,789.5";
		DecimalFormat df = new DecimalFormat("#,###.##");
		DecimalFormat df2 = new DecimalFormat("####"); 
		DecimalFormat df3 = new DecimalFormat("#,####");
		try {
			System.out.println("data : " + strNum);
			Number num = df.parse(strNum);
			double d = num.doubleValue();
			System.out.println(d);
			System.out.println("반올림 : " +Math.round(d));
			System.out.println("만단위 : " +df3.format(num));
			
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		// System.out.println(df.format(1234567.321));

		/*
		 * float result = (int)(num.floatValue()*10f +0.5)/10f; DecimalFormat
		 * df2 = new DecimalFormat("####,####,####.#"); Number num2 =
		 * df2.parse(result+"");
		 * 
		 * System.out.println(num2.intValue());
		 */
	}
}
