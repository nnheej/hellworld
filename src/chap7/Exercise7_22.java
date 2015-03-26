package chap7;
abstract class Shape{
	Point p;
	Shape(){
		this(new Point(0,0));
	}
	Shape(Point p){
		this.p = p;
	}
	abstract double calcArea();
	Point getPosition(){
		return p;
	}
	void setPosition(Point p){
		this.p = p;
	}
}
class Point{
	int x;
	int y;
	Point(){
		this(0,0);
	}
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public String toString(){
		return "["+x+","+y+"]";
	}
	
}
class Circle extends Shape{
	double r;
	Circle(double r){
		this(new Point(0,0),r);
	}
	Circle(Point p, double r){
		super(p);
		this.r = r;
	}
	@Override
	double calcArea() {
		// TODO Auto-generated method stub
		return r*r*Math.PI;
	}
}
class Rectangle extends Shape{
	double width;
	double height;
	
	Rectangle(double width,double height) {
		this(new Point(0,0),width,height);
	}
	Rectangle(Point p, double width,double height){
		super(p);
		this.width = width;
		this.height = height;
	}
	
	@Override
	double calcArea() {
		// TODO Auto-generated method stub
		return (double)width*height;
	}
	public boolean isSquare(){
		return width*height!=0 && width==height;
	}
}
public class Exercise7_22 {
	public static double sumArea(Shape[] arr){
		double sum=0;
		for(int i=0; i<arr.length; i++){
			sum+=arr[i].calcArea();
		}
		return sum;
		
	}
	public static void main(String[] args){
		Shape[] arr = {new Circle(5.0),new Rectangle(3,4), new Circle(1)};
		System.out.println("면적의 합 : "+sumArea(arr));
	}

}
