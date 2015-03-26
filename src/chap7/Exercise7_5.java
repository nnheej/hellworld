package chap7;

class Product2{
	int price;
	int bonusPoint;
	
	Product2(int price){
		this.price = price;
		bonusPoint = (int)(price/10.0);

	}
}
class Tv2 extends Product2{
	Tv2(){
		super(100);
	}
	public String toString(){
		return "Tv2";
	}
}
public class Exercise7_5 {
	public static void main(String[] args){
		Tv2 t = new Tv2();
	}
}
