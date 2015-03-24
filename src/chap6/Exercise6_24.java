package chap6;

public class Exercise6_24 {
	
	public static int abs(int value){
		return (value<0)?-value:value;
	}
	public static void main(String[] args){
		int value=5;
		System.out.println(value+"의 절대"+abs(value));
		
		value=-10;
		System.out.println(value+"값의 절대값"+abs(value));
	}

}
