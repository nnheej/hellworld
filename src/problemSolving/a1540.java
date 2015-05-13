package problemSolving;

import java.util.LinkedList;
import java.util.Scanner;

public class a1540 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int count=0;
		LinkedList<String> list = new LinkedList();

		int inputNum = in.nextInt();
		in.nextLine();
		
		for(int i=0; i<inputNum; i++){
			list.add(in.nextLine());
		}
		for(int j=0; j<list.size(); j++){
			String str = list.get(j);
			if(badCode(str)){
				System.out.println(str);
				count++;
			}
		}
		if(count<4){
			System.out.println("safe");
		}
		else if(count<=6){
			System.out.println("warning");
		}
		else{
			System.out.println("danger");
		}
		
		
	}
	public static boolean badCode(String str){
		boolean result = false;
		if(str.length()<=3){
			result = true;
		}
		if(str.contains("tap") || str.contains("xocure")){
			result = true;
		}
		return result;
	}
}
