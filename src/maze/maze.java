package maze;

import java.util.Stack;

public class maze {
	public static void main(String args[]) {
		boolean isExit;
		boolean[][] testMaze = { { true, true, true, true, true },
				{ true, true, false, false, true },
				{ true, false, true, false, true },
				{ true, false, false, true, false },
				{ true, true, true, true, true } };
		printMaze(testMaze);
		isExit = canExit(testMaze);
		System.out.println("RESULT : ["+isExit+"]");
	}

	public static boolean canExit(boolean[][] maze) {
	
		Coordinate startCoord = new Coordinate(0, 0); // startCoordinate
		Stack<Coordinate> s = new Stack<Coordinate>();
		s.push(startCoord);

		Coordinate coord;
		boolean result = false;

		while (true) {
			coord = s.pop(); // current coordinate
			int x = coord.getX();
			int y = coord.getY();
			boolean isVisit = coord.isVisit();
			System.out.println("(x,y,isVisit) : " + x + "," + y+ ","+coord.isVisit());

			int count = 0;

			/* exit condition */
			if (x == 4 && y == 4) {
				result = true;
				break;
			}
			if (isVisit) { //이미갔던 길이면!
				System.out.println("here?");
				break;
			}
			/* else we cannot exit.. */
			coord.setVisit(true); /*visit 설정하고 다시 넣기 */
			System.out.println("->change(x,y,isVisit) : " + x + "," + y+ ","+coord.isVisit());
			s.push(coord);
			
			/* find another way */
			count = findWay(coord,maze,s);
			System.out.println("count : "+count);
			if(count==0){ //if we cannot find another way
				/*count가 0이면 이전에 넣은거 뺴줘야함*/
				System.out.println("there is no way");
				s.pop();
			}

		}
		return result;
	}
	public static int findWay(Coordinate coord,boolean[][] maze, Stack<Coordinate> s){
		//coord 는 현재 좌표 maze는 미로정보 stack은 그동안 갔던 좌표정보 
		int count = 0;
		int x = coord.getX();
		int y = coord.getY();
		Coordinate newCoord = null;
		Stack<Coordinate> newS = null;
		
		// 앞 y+1 뒤 y-1 좌 x-1 우 x+1
		if(y+1<5 && maze[x][y+1]){
			newCoord = new Coordinate(x,y+1,false);
			newS = (Stack<Coordinate>)s.clone();
			if(!isExistInStack(newS,newCoord)){
				s.push(newCoord);
				System.out.println("i'm new : "+newCoord.getX()+","+newCoord.getY());
				count++;
			}
		}
		if(x+1<5 && maze[x+1][y]){
			newCoord = new Coordinate(x+1,y,false);
			newS = (Stack<Coordinate>)s.clone();
			if(!isExistInStack(newS,newCoord)){
				s.push(newCoord);
				System.out.println("i'm new : "+newCoord.getX()+","+newCoord.getY());
				count++;
			}
		}
		if(x-1>=0 && maze[x-1][y]){
			newCoord = new Coordinate(x-1,y,false);
			newS = (Stack<Coordinate>)s.clone();
			if(!isExistInStack(newS,newCoord)){
				s.push(newCoord);
				System.out.println("i'm new : "+newCoord.getX()+","+newCoord.getY());
				count++;
			}
		}
		
		if(y-1>=0 && maze[x][y-1]){
			newCoord = new Coordinate(x,y-1,false);
			newS = (Stack<Coordinate>)s.clone();
			if(!isExistInStack(newS,newCoord)){
				s.push(newCoord);
				System.out.println("i'm new : "+newCoord.getX()+","+newCoord.getY());
				count++;
			}
		}		
		/*stack에서 이미 갔던 길인지 확인하기*/
		return count;
	}
	public static boolean isExistInStack(Stack<Coordinate> s,Coordinate coord){
		Coordinate item = null;
		
		while(!s.isEmpty()){
			item = s.pop();
			if((item.getX()==coord.getX()) && (item.getY()==coord.getY()) && 
					(item.isVisit()==true)){
				System.out.println("i'm exist in stack");
				System.out.println("item : "+item.getX()+","+item.getY());
				return true;
			}
		}
		return false;
	}
	public static void printMaze(boolean[][] testMaze) {
		for (int i = 0; i < testMaze.length; i++) {
			for (int j = 0; j < testMaze[0].length; j++) {
				System.out.print(testMaze[i][j] ? "O" : "X");
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
