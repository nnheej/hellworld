package chap14;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exercise14_1 {
	/*
	 * 커맨드라인으로 부터 파일명과 숫자를 입력받아서, 
	 * 입력받은 파일의 내용의 처음 부터 입력받은 숫자만큼의 라인을 출력하는
	 * 프로그램(FileHead.java)을 작성하라. [Hint] BufferedReader의 readLIne()을 사용하 line
	 * 파일이름
	 */
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Usage:>Exercise14_1 10 Filename.java");
			System.exit(-1);
		}
		int line = Integer.parseInt(args[0]);
		String fileName = args[1];

		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			while (line > 0) {
				System.out.println(br.readLine());
				line--;
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
			}
		}

	}
}
