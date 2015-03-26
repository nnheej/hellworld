package chap7;
class Buyer{
	int money=1000;
	Product[] cart = new Product[3];
	int i=0;
	
	void buy(Product p){
		if(money<p.price){
			System.out.println("잔액이 부족하여"+p.toString()+"를 살 수 없습니다.");
			return ;
		}
		else{
			money -= p.price;
			add(p);
		}
		/*가진 돈과 물건의 가격을 비교해서 
		 * 가진 돈이 적으면 메서드 종료
		 * 가진 돈이 충분하면 제품가격을 가진돈에서 빼고
		 * 장바구니에 구입한 물건을 담는다.add메서드호출*/
	}
	void add(Product p){
		if(i>=cart.length)
		{
			Product[] newCart = new Product[cart.length*2];
			System.arraycopy(cart, 0, newCart, 0, cart.length);
			cart = newCart;
		}
		
		cart[i++] = p;
		/*
		 * 1.1 i의 값이 장바구니의 크기보다 같거나크면
		 * 기존의 장바구니보다 2배 큰 새로운 배열을 생성
		 * 기존의 장바구니의 내용을 새로운 배열에 복사
		 * 새로운 장바구니와 기존의 장바구니를 바꾼다
		 * 1.2 물건을 장바구니에 저장한다. 그리고 i의 값을 1증가*/
	}
	void summary(){
		/*장바구니에 담긴 물건들의 목록을 만들어 출력한다.
		 * 장바구니에 담긴 물건들의 가격을 모두 더해서 출력
		 * 물건을 사고 남은 금액을 출력*/
		System.out.print("구입한 물건 : ");
		for(int j=0; j<i; j++){
			System.out.print(cart[j]+",");
		}
		System.out.println();
		System.out.println("사용한 금액 : "+(1000-money));
		System.out.println("남은 금액 : "+money);
	}
}

class Product{
	int price;
	
	Product(int price){
		this.price = price;
	}
}
class Tv extends Product{
	Tv() {super(100);}
	public String toString(){return "Tv";}
}
class Computer extends Product{
	Computer() {super(200);}
	public String toString(){return "Computer";}
}
class Audio extends Product{
	Audio() {super(50);}
	public String toString(){return "Audio";}
}

public class Exercise7_19 {
	
	public static void main(String[] args){
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		b.summary();
	}
}

	
