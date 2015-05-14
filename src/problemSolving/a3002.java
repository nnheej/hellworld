package problemSolving;

import java.util.LinkedList;
import java.util.Scanner;

public class a3002 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		
		LinkedList<Integer> listN = new LinkedList<Integer>();
		
		int n = in.nextInt(); // n 입력받기
		in.nextLine();
		String input = in.nextLine();
		String inputNums[] = input.split(" ");
		for(int i=0 ; i<n; i++){
			listN.offer(Integer.parseInt(inputNums[i])); //n만큼의 수 입력받아 listN에 저장
		}
		
		int m = in.nextInt(); //m 입력받기
		in.nextLine();
		String input2 = in.nextLine();
		String inputNums2[] = input2.split(" ");
		for(int j=0; j<m; j++){
			int result = BinarySearch(listN,0,listN.size()-1,Integer.parseInt(inputNums2[j]));
			System.out.print((result==-1?result:result+1) +" ");
		}
	}
	public static int BinarySearch(LinkedList<Integer> list,int first,int last,int target){
		int mid;
		
		while(first<=last){
			mid = (first+last)/2;
			if(target==list.get(mid)){
				return mid;
			}
			else{
				if(target <list.get(mid)){
					last = mid-1;
				}
				else{
					first = mid+1;
				}
			}
		}
		return -1;
	}
	/*public static int BinarySearch(LinkedList<Integer> list,int first, int last, int target){
		if(first>last)
			return -1;
		int mid = (first+last)/2;
		if(list.get(mid)==target){
			return mid;
		}
		else if(list.get(mid)<target){
			return BinarySearch(list, mid+1, last, target);
		}
		else {
			return BinarySearch(list, first, mid-1, target);
		}
		
	}*/
}
