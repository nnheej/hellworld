package chap14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileMergeTest {
	/*
	 * 커맨드라인으로 부터 o여러 파일의 이름을 입력받고, 이 파일들을 순서대로 합쳐 서 새로운 파일을 만들어 내는
	 * 프로그램(FileMergeTest.java)을 작성하시오. 단, 합칠 파 일의 개수에는 제한을 두지 않는다.
	 */
	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out
					.println("Usage: java FileMergeTest result.txt 1.txt 2.txt 3.txt");
			System.exit(-1);
		}
		String resultFileName = args[0];
		String path = FileMergeTest.class.getResource("").getPath();
		String line = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(path + resultFileName));
			for (int i = 1; i < args.length; i++) {
				br = new BufferedReader(new FileReader(path + args[i]));
				while ((line = br.readLine()) != null) {
					bw.write(line);
					bw.newLine();
					System.out.println(line);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}finally{
			br.close();
			bw.close();
		}
	}
}
