package chap9;

public class Exercise9_9 {
	static String delChar(String src, String delChar){
		/*String newStr = "";
		for(int i =0; i<src.length(); i++){
			char ch = src.charAt(i);
			if(delChar.indexOf(ch)==-1){
				newStr += ch;
			}
		}
		*/
		StringBuffer newStr = new StringBuffer(src.length());
		for(int i =0; i<src.length(); i++){
			char ch = src.charAt(i);
			if(delChar.indexOf(ch)==-1){
				newStr.append(ch);
			}
		}
		
		
		return newStr.toString();
	}
	public static void main(String[] args){
		System.out.println("(1!2@3^4~5)"+"->"+delChar("(1!2@3^4~5)","~!@#$%^&*()"));
		System.out.println("(1 2   3   4\t5)"+"->"+delChar("(1 2   3   4\t5)"," \t"));
	}
}
