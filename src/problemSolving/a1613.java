package problemSolving;

import java.util.Scanner;

public class a1613 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		
		int startNum = in.nextInt();
		int endNum = in.nextInt();
		
		int result=0;
		for(int i=startNum; i<=endNum; i++){
			if(i%12==0)
				continue;
			else if(i%3==0){
				result +=i;
			}
			else if(i%4==0){
				result -=i;
			}
		}
		System.out.println(result);
	}

}
