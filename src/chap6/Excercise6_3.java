package chap6;

public class Excercise6_3 {
	public static void main(String args[]){
		Student s = new Student();
		s.name="둘리";
		s.ban=1;
		s.no=1;
		s.kor=100;
		s.eng=60;
		s.math=76;
		
		System.out.println(s.getTotal());
		System.out.println(s.getAverage());
		
		Student s1 = new Student("홍길동",1,2,100,60,76);
		System.out.println(s1.info());
		
	}
	
}
class Student{
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	Student(){
		
	}
	Student(String name,int ban,int no,int kor,int eng, int math){
		this.name=name;
		this.ban=ban;
		this.no=no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public String info(){
		return this.name+","+this.ban+","+
	this.no+","+this.kor+","+this.eng+","+this.math
	+","+this.getTotal()+","+this.getAverage();
	}
	public int getTotal(){
		return this.kor+
				this.eng+
				this.math;
	}
	public float getAverage(){
		return (int)(this.getTotal()/3f *10+0.5f )/10f;
	}
}