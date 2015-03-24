package chap6;

public class Exercise6_23 {
	
	public static int max(int[] arr){
		//주어진 int형의 배열의 값 중에서 제일 큰 값을 반환한다.
		//주어진 배열이 null이거나 크기가 0인경우 -999999를 반환한다.
		int max=-999999;
		if(arr==null || arr.length==0)
			return -999999;
		for(int i=0; i<arr.length ; i++)
			if(max<arr[i])
				max = arr[i];
		return max;
		
	}
	public static void main(String[] args){
		int[] data = {3,2,9,4,7};
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값:"+max(data));
		System.out.println("최대값:"+max(null));
		System.out.println("최대값:"+max(new int[]{}));//값크기가 0인 배열
	}

}
