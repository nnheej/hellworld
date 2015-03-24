package chap6;

public class Exercise6_20 {
	public static void main(String[] args){
		int[] original ={1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));
		
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}

	public static int[] shuffle(int[] original){
		int[] result = new int[original.length];
		int randNum;
		int tmp;
		
		System.arraycopy(original, 0, result, 0, original.length);
		for(int i=0; i<original.length; i++){
			randNum = (int)(Math.random()*9);
			tmp = result[i];
			result[i] = result[randNum];
			result[randNum] = tmp;
		}
		return result;
	}
}
