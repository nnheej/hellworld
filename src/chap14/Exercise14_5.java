package chap14;

import java.io.*;

class Exercise14_5 {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out
					.println("USAGE: java Exercise14_5 TAGET_FILE RESULT_FILE");
			System.exit(0);
		}
		String path = Exercise14_1.class.getResource("").getPath();
		String inputFile = args[0];
		String outputFile = args[1];
		try {
			BufferedReader input = new BufferedReader(new FileReader(path+inputFile));
			
			HtmlTagFilterWriter output = new HtmlTagFilterWriter(
					new FileWriter(path+outputFile));
			int ch = 0;
			while ((ch = input.read()) != -1) {
				output.write(ch);
			}
			input.close();
			output.close();
		} catch (IOException e) {
		}
	}
}

class HtmlTagFilterWriter extends FilterWriter {
	StringWriter tmp = new StringWriter();

	HtmlTagFilterWriter(Writer out) {
		super(out);
	}

	public void write(int c) throws IOException {
		boolean inTag = false;
		/*
		 * (1) 아래의 로직에 맞게 코드를 작성하시오. 
		 * 1. 출력할 문자(c)가 '<'이면 inTag의 값을 true로 한다. 
		 * 2.출력할 문자(c)가 '>'이면 inTag의 값을 false로 한다. 
		 * 새로운 StringWriter를 생성한다.(기존StringWriter의 내용을 버린다.) 
		 * 3. inTag의 값이 true이면, StringWriter에 문자(c)를 출력하고inTag의 값이 false이면, 
		 * out에 문자(c)를 출력한다. 
		 * 4. StringWriter에 있는 내용을 out에
		 * 출력한다. [참고] 태그가 시작되면 StringWriter에 출력하고 태그가 끝나면 StringWriter는 비워진다.
		 */
		if(c=='<'){
			inTag = true;
		}
		if(c=='>'){
			inTag = false;
			tmp = new StringWriter();
			return;
		}
		if(inTag){
			tmp.write(c);
		}
		else{
			out.write(c);
		}
	}
	public void close() throws IOException{
		out.write(tmp.toString());
		super.close();
	}
}