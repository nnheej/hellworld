package chap7;

class SutdaCard{
	final int NUM;
	final boolean ISKWANG;
	
	SutdaCard(){
		this(1,true);
	}
	SutdaCard(int num,boolean isKwang){
		this.NUM=num;
		this.ISKWANG = isKwang;
		
	}
	public String toString(){
		return NUM+(ISKWANG?"K":"");
	}
}
class SutdaDeck{
	final int CARD_NUM=20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	SutdaDeck(){
		/*1 배열 sutdacard를 적절히 초기화 하시오*/
		/*1~10까지 숫자가 적힌 카드가 한쌍씩 있고
		 *  숫자가 1,3,8인 경우에는 둘 중의 한 장은 광이어야 한다.
		 */
		for(int i=0; i<CARD_NUM; i++){
			int num = i%10+1;
			boolean  isKwang = (i<10) && (num==1 || num==3 || num==8);
			cards[i] = new SutdaCard(num,isKwang);
		}
	}
	
	public void suffle(){
		SutdaCard tmp;
		//배열 cards에 담긴 카드의 위치를 뒤섞는다.
		for(int i=0; i<CARD_NUM*2;i++){
			int rand1 = (int)(Math.random()*CARD_NUM);
			int rand2 = (int)(Math.random()*CARD_NUM);
			
			tmp = cards[rand1];
			cards[rand1] = cards[rand2];
			cards[rand2]=tmp; 
		}
	}
	public SutdaCard pick(int index){
		//배열 cards에서 지정한 위치의 sutdacard를 반환한다.
		if(index<0 || index>CARD_NUM)
			return null;
		return cards[index];
	}
	public SutdaCard pick(){
		//임의 위치의 sutdaCard 반환한다. 
		int num = (int)(Math.random()*CARD_NUM);
		return pick(num);
	}
	
}

public class Exercise7_2 {
	public static void main(String args[]){
		SutdaDeck deck = new  SutdaDeck();
		
		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.suffle();
		for(int i=0; i<deck.cards.length;i++)
			System.out.println(deck.cards[i]+",");
		System.out.println();
		System.out.println(deck.pick(0));
	}
}
