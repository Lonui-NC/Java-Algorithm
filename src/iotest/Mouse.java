package iotest;

public class Mouse {
//	递归方法求对应的点，方法1
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] maze={{2,2,2,0,2,2,2,0,0},  
                 {2,0,0,0,0,0,2,0,0},  
                 {2,0,2,2,2,2,2,2,2},  
                 {0,0,0,0,0,0,0,0,2},  
                 {2,0,2,2,2,2,0,2,2},  
                 {2,0,2,2,0,0,0,2,2},  
                 {2,0,2,2,0,2,2,0,2},  
                 {2,0,2,0,0,0,0,0,0},  
                 {2,0,2,2,2,2,2,2,2}         
                };  
		 Map map=new Map(maze,new Point(7,8));
		 Mouse.go(map,new Point(0,3));
		 map.print();
	}
	
	public static void go(Map map,Point p){
		map.step(p);
		//这个函数中如果上下左右都不能走，那么就把对应的点置为不可到达，然后返回回去
		//深度搜索，如果其中一个方向可达到，那么就走那个方向
		//当走过的这个方向不行时，该方向上所有点结束，返回上一个点
		//如果上一个点没找到，结束前面的，再返回上上一个点
		//不是边界点
		//存在可能性是四个方向都能走
		//但按照深度搜索肯定一个方向可以走到，
		//不计算效率，只要能走到就行了！！！！！！！
		if(p.y<map.maze[0].length-1)
		{
			test(map,new Point(p.x,p.y+1));
		}
		if(p.x<map.maze.length-1)
		{
			test(map,new Point(p.x+1,p.y));
		}
		if(p.y>=1)
		{
			test(map,new Point(p.x,p.y-1));
		}
		if(p.x>=1)
		{
			test(map,new Point(p.x-1,p.y));
		}
		if(!map.isArrived())
		{
			map.empty(p);
		}
		return;
	}
	
	//判断当前点是否合适
	public static void test(Map map,Point p){
		//如果没到达终点并且当前点可以走
		if(!map.isArrived() && map.isEmpty(p)){
			go(map,p);
		}
	}
	
}

//定义点的集合
//代表了迷宫中的点，可以先行获得，对应哪个点的值是最后的终点
class Point{
	int x;
	int y;
	public Point(int x1,int y1){
		x=x1;
		y=y1;
	}
}

class Map{
	//直接赋值一个二维数组，直接获取
	int[][] maze;
	Point end;//终点
	public Map(int[][] maze,Point end){
		this.maze=maze;
		this.end=end;
	}
	
	//判断是否到达终点
	public boolean isArrived(){
		return maze[end.x][end.y]==1;
	}
	//当前这一格是否可行
	public boolean isEmpty(Point p){
		
		return maze[p.x][p.y]==0;
	}
	//可以理解为当经过对应p点无法到达终点时，将印记抹去
	public void empty(Point p){
		maze[p.x][p.y]=0;
	}
	//走到Point p
	public void step(Point p){
		maze[p.x][p.y]=1;
	}
	//打印地图
	public void print(){
		for(int i=0;i<maze.length;i++)
		{
			for(int j=0;j<maze[0].length;j++)
			{
				if(maze[i][j]==2){
					System.out.print("█");
				}
				else if(maze[i][j]==0){
					System.out.print(" ");
				}
				else if(maze[i][j]==1)
				{
					System.out.print("1");
				}
			}
			System.out.println();
		}
	}
}











































