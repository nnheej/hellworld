package problemSolving;

import java.util.Scanner;

public class a3120 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int now = in.nextInt();
		int target = in.nextInt();
		int count=0;
		
		while(now!=target){
			int diff = Math.abs(target-now);
			int moveNum = closeNum(diff); 
			if(now<target){
				now+=moveNum;
			}
			else{
				now-=moveNum;
			}
			count++;
		}
		System.out.println(count);
	}
	public static int closeNum(int num){
		//1,5,10중 어느숫자에 가까운지리턴
		if(num>=8){
			return 10;
		}
		else if(num>=4){
			return 5;
		}
		else
			return 1;
	}
}