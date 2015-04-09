package chap14;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.util.Vector;

public class FileMergeTest2 {
	public static void main(String[] args) throws FileNotFoundException {
		if (args.length < 3) {
			System.out
					.println("Usage: java FileMergeTest result.txt 1.txt 2.txt 3.txt");
			System.exit(-1);
		}
		try {
			Vector files = new Vector();
			String path = FileMergeTest2.class.getResource("").getPath();
			for (int i = 1; i < args.length; i++) {
				files.add(new FileInputStream(path + args[i]));
			}
			SequenceInputStream sis = new SequenceInputStream(files.elements());
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(path + args[0]));
			int data;
			while ((data = sis.read()) != -1) {
				bos.write(data);
				System.out.print(data);
			}
			sis.close();
			bos.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}