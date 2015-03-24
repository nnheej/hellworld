package chap6;

public class Exerciese6_2 {
	public static void main(String args[]){
		SutdaCard card1 = new SutdaCard(3,false);
		SutdaCard card2 = new SutdaCard();
		
		System.out.println(card1.info());
		System.out.println(card2.info());
	}
}
 class SutdaCard{
	int num; //카드의 숫자 1~10
	boolean isKwang;
	
	SutdaCard(){
		this(1,true);
	}
	SutdaCard(int num,boolean isKwang){
		this.num = num;
		this.isKwang = isKwang;
	}
	
	public String info(){
		return num+(isKwang?"K":"");
	}

}
