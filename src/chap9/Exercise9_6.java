package chap9;

public class Exercise9_6 {
	public static String fillZero(String src,int length){
		/*기능 :
		 * 주어진 문자열(숫자)로 주어진 길이의 문자열을 만들고
		 * 왼쪽 빈 공간은 0으로 채운다.
		 * 만일 주어진 문자열이 널이거나 문자열의 길이가 length와 같으면 그대로 반환한다.
		 * 만일 주어진 length값이 0보다 같거나 작은 값이면 빈 문자열을 반환한다.*/
		if(src==null || src.length()==length){
			return src;
		}
		if(length<=0){
			return "";
		}
		if(length<src.length()){
			return src.substring(0, length);
		}
		
		char[] charArr = new char[length];
		for(int i=0; i<charArr.length; i++){
			charArr[i] = '0';
		}
	/*	System.out.println(charArr);
		char[] srcArr = src.toCharArray();
		for(int j=0; j<src.length(); j++){
			charArr[src.length()+j] = srcArr[j];
		}
		*/
		System.arraycopy(src.toCharArray(), 0, charArr, length-src.length(), src.length());
		return new String(charArr);
		
	}
	public static void main(String[] main){
		String src = "12345";
		System.out.println(fillZero(src,10));
		System.out.println(fillZero(src,-1));
		System.out.println(fillZero(src,3));
	}
}
