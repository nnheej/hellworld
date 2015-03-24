package chap6;

public class Exercise6_20_2 {
	public static void main(String[] args){
		int[] original ={1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));
		
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}
	public static int[] shuffle(int[] arr){
		if(arr ==null || arr.length==0){
			return arr;
		}
		for(int i=0; i<arr.length*2;i++){ /*왜 2배로 하면 충분히 섞이는지 실험해보자*/
			int rand1 = (int)(Math.random()*arr.length);
			int rand2 = (int)(Math.random()*arr.length);
			
			int tmp = arr[rand1];
			arr[rand1] = arr[rand2];
			arr[rand2]	= tmp;
		}
		return arr;
	}
}
