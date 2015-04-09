package chap14;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.PrintStream;

public class HexaViewer {
	/*
	 * 지정된 이진파일의 내용을 실행결과와 같이 16진수로 보여주는 프로그램 (HexaViewer.java)을 작성하라. [Hint]
	 * PrintStream과 printf()를 사용하라
	 */
	public static void main(String[] args) {
		try {
			String fileName = args[0];
			BufferedInputStream bis = null;
			PrintStream ps = null;
			String path = HexaViewer.class.getResource("").getPath();
			File f = new File(path + fileName);
			int data;
			int i = 1;

			if (f.exists() && !f.isDirectory()) {
				bis = new BufferedInputStream(new FileInputStream(path
						+ fileName));
				while ((data = bis.read()) != -1) {
					ps = new PrintStream(System.out);
					ps.printf("%5x", data);
					if (i % 15 == 0) {
						System.out.println();
					}
					i++;
				}
			} else {
				throw new FileNotFoundException(fileName
						+ "을 찾을 수 없습니다. 혹은 디렉토리 입니다.");
			}
			bis.close();
			ps.close();
		} catch (Exception e) {
			System.out.println("Usage:HexaViewer." + "java fileName");
		} finally {

		}
	}
}
