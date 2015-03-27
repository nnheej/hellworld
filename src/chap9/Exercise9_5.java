package chap9;

public class Exercise9_5 {
	public static int count(String src, String target) {
		int count = 0;
		int pos;
		int index;
		/*
		 * 반본묵을 사용해서 아래의 과정을 반복한다. 
		 * 1. src에서 target을 pos의 위치부터 찾는다. 찾으면 count의 값을
		 * 1 증가 시키고, pos의 값을 target.length만큼 증가시킨다. 
		 * 3. indexOf 결과가 -1이면 반복문을
		 * 빠져나가서 count를 반환한다.
		 */
		// 주어진 src에서 target String이 몇 번 나오는지 count해 반환

		for (pos = 0; pos < src.length(); pos++) {
			if ((index=src.indexOf(target) )== -1) {
				break;

			}
			else {
				count++;
				pos += target.length()+index;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(count("12345AB12AB345AB", "AB"));
		System.out.println(count("12345", "AB"));
	}

}