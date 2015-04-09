package chap14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileHead2 {
	private static BufferedReader br;

	public static void main(String[] args) throws IOException {

		try {
			int lineNum = Integer.parseInt(args[0]);
			String fileName = args[1];
			String path = FileHead2.class.getResource("").getPath();
			File f = new File(path+fileName);
			if (f.exists() && !f.isDirectory()) {
				br = new BufferedReader(new FileReader(path + fileName));
				String line = "";
				int i = 1;
				while ((line = br.readLine()) != null && (lineNum >= i)) {
					System.out.println(i + ":" + line);
					i++;
				}
			} else {
				throw new FileNotFoundException(fileName
						+ "은 디렉토리거나 존재하지 않는 파일");
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Usage:java FileHead2 10 Filename");
		}
	}
}
