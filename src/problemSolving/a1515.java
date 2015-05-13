package problemSolving;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class a1515 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Queue q = new LinkedList();
		int result = 0;

		
		String input = in.nextLine();
		String inputNums[] = input.split(" ");
		int startNum = Integer.parseInt(inputNums[0]);
		int endNum = Integer.parseInt(inputNums[1]);
		
		for(int i=1; i<=endNum; i++){
			int dn = calculateDn(i);
			q.offer(dn);
		}
		
		for(int j=startNum; j<=endNum; j++){
			if(!findDn(q,j)){
				result += j;
			}
		}
		System.out.println(result);
	}
	public static boolean findDn(Queue<Integer> q,int findNum){
		if(q.contains(findNum))
			return true;
		return false;
	}
	public static int calculateDn(int num){
		String strNum = num+"";
		int dn = 0;
		for(int i=0; i<strNum.length(); i++){
			dn+= (strNum.charAt(i)-'0');
		}
		dn+= num;
		return dn;
	}
}
