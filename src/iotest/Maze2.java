package iotest;
//如果要找出所有的走法，只要显示走到出口的所有路径，然后退回上一格即可

public class Maze2 {
	public static void main(String[] args){
		 int[][] maze={{2,2,2,0,2,2,2,0,0},  
                 {2,0,0,0,0,0,2,0,0},  
                 {2,0,2,2,2,0,2,2,2},  
                 {0,0,0,0,0,0,0,0,2},  
                 {2,0,2,2,2,2,0,2,2},  
                 {2,0,2,2,0,0,0,2,2},  
                 {2,0,2,2,0,2,2,0,2},  
                 {2,0,2,0,0,0,0,0,0},  
                 {2,0,2,2,2,2,2,2,2}         
                };  
		 Map map=new Map(maze,new Point(7,8));
		 //对应定义的类，是包权限
		 Maze2.go(map, new Point(0,3));
	}
	
	public static void go(Map map,Point p){
		//对应走下一步，在step内有判断和go的循环
		map.step(p);
		//System.out.println(p.toString());
		//如果此时走到了，立即置其为1
		if(map.isArrived())
		{
			map.print();
			System.out.println();
			map.maze[map.end.x][map.end.y]=0;
		}
		
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
		//此处和前面的不同主要在于这里，
		//前面是最后判断，经过一系列操作是否到达终点，并且只要到达了一次即可
		//如果经过上面的操作已经到达了，那么就直接可以通过test返回，不会进行新的操作
		//这里的不同是首先在前面判断是否到达，如果到达了，把这一步到达的路径全都显示出来
		//同时将最后的路径设为可到达，为其他路径进行下一步判断
		//然后后面如果不是最终路径点，依然会回退再次递归
		//由于每次递归情况不同，所以可视作找出所有路径
		//在isArrived条件判断里加return 效果一致！！！！！！！
		map.empty(p);
	}
	
	public static void test(Map map,Point p){
		if(!map.isArrived() && map.isEmpty(p)){
			go(map,p);
		}
		
	}
}

//定义Point类，表示对应的点


















