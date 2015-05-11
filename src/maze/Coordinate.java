package maze;

public class Coordinate {
	private int x;
	private int y;
	private boolean isVisit;
	
	Coordinate(int x, int y,Boolean isVisit){
		this.x = x;
		this.y = y;
		this.isVisit = isVisit;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean isVisit() {
		return isVisit;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setVisit(boolean isVisit) {
		this.isVisit = isVisit;
	}
	Coordinate(int x, int y){
		this(x,y,false);
	}
}
