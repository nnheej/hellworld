package chap7;
class Parent{
	int x = 100;

	Parent(){
		this(200);
		System.out.println("parent()");
	}
	Parent(int x){
		this.x = x;
		System.out.println("parent(int x)");
	}
	int getX(){
		System.out.println("getx");
		return x;
	}
}
class Child extends Parent{
	int x = 3000;
	Child(){
		this(1000);
		System.out.println("child()");
	}
	Child(int x){
		this.x = x;
		System.out.println("child(x)");
	}
}
public class Exercise7_7 {
	public static void main(String[] args){
		Child c = new Child();
		System.out.println("x ="+c.getX());
	}

}
