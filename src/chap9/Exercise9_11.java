package chap9;

public class Exercise9_11 {

	/*
	 * 커맨드라인으로 2~9사이의 두개의 문자를 받아서 두 숫자사이의 구구단을 출력하는 프로그램을 작성하시오! 예를 들어 3과 5를
	 * 입력하면 3단부터 5단까지 출력한다.
	 */
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Usage:Exercise9_11 num1 num2");
		}
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		try {
			if (num1 < 2 || num1 > 9 || num2 < 2 || num2 > 9) {
				throw new numBoundException("2부터 9 사이 숫자를 입력하세요");
			}

			for (int i = num1; i <= num2; i++) {
				for (int j = 1; j < 10; j++) {
					System.out.println(i + "*" + j + "=" + i * j);
				}
				System.out.println();
			}
		} catch (numBoundException ex) {
			System.out.println(ex.getMessage());
		}

	}
}

class numBoundException extends Exception {
	numBoundException(String message) {
		super(message);
	}

}