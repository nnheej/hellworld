package chap9;

public class Exercise9_10 {
	// 0 - 왼쪽 1 - 가운데 2 - 오른쪽 
	static String format(String str, int length, int alignment){
		//주어진 문자열을 지정된 크기의 문자열로 변환한다.
		// 나머지 공간은 공백으로 채운다.
		
		if(length<str.length())
		{
			return str.substring(0, length);
		}
		char[] chArr = new char[length];
		for(int i=0; i<chArr.length; i++){
			chArr[i] ='　';
		}
		
		switch(alignment){
		case 0:
			System.arraycopy(str.toCharArray(), 0, chArr, 0, str.length());
			break;
		case 1:
			System.arraycopy(str.toCharArray(), 0, chArr, (length-str.length())/2, str.length());
			break;
		case 2:
			System.arraycopy(str.toCharArray(), 0, chArr, length-str.length(), str.length());
			break;
		}
		
		return new String(chArr);
	}
	
	public static void main(String[] args){
		String str = "가나다";
		System.out.println(format(str,7,0));
		System.out.println(format(str,7,1));
		System.out.println(format(str,7,2));
	}
}
