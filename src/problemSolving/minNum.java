package problemSolving;

import java.io.IOException;
import java.util.Scanner;

public class minNum {
	public static void main(String args[]) throws IOException {

		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		int smallNum;

		System.out.println("입력:");
		System.out.println(num1 + " " + num2 + " " + num3);

		System.out.println("정답:");

		if (num1 < num2) {
			smallNum = num1;
		} else {
			smallNum = num2;
		}
		if (smallNum < num3) {
			System.out.print(smallNum);
		} else {
			System.out.print(num3);
		}

	}
}
