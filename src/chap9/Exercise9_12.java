package chap9;

public class Exercise9_12 {
	static int getRand(int from, int to){
		/*from 범위의 시작값 to 범위의 끝값 까지 random으로 숫자 생성 후 반환 */
/*		if(from>to){
			int tmp = from;
			from = to;
			to = tmp;
		}
		return (int)(Math.random()*(to-from+1))+from;*/
		
		return (int)(Math.random()*(Math.abs(to-from)+1))+Math.min(from, to);
	}
	public static void main(String[] args){
		for(int i=0; i<20; i++){
			System.out.print(getRand(1,-3)+",");
		}
	}

}
