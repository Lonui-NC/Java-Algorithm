package iotest;

import java.util.Stack;
//java 迷宫算法
//步长
class Step{
	int x,y,d;
	public Step(int x,int y,int d){
		this.x=x;
		this.y=y;
		this.d=d;
	}
	
}
public class MazeTest {
	//所有迷宫路径算法都可以这样求解。。。。。。。
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 迷宫定义
        int[][] maze = {{1,1,1,1,1,1,1,1,1,1},
                        {1,0,1,1,1,0,1,1,1,1},
                        {1,1,0,1,0,1,1,1,1,1},
                        {1,0,1,0,0,0,0,0,1,1},
                        {1,0,1,1,1,0,1,1,1,1},
                        {1,1,0,0,1,1,0,0,0,1},
                        {1,0,1,1,0,0,1,1,0,1},
                        {1,1,1,1,1,1,1,1,1,1}};
        //定义基本的移动方式
        //方向为8种，依次递增
        int[][] move = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        Stack<Step> s=new Stack<Step>();//可以不写泛型的！！！！
        Stack<Step> s1=new Stack<Step>();
        int a=path(maze,move,s);
        while(!s.isEmpty())
        {
        	Step step=s.pop();
        	System.out.println(step.x+":"+step.y);
        }
	}

	public static int path(int[][] maze,int[][] move,Stack<Step> s){
		Step temp=new Step(1,1,-1);//起点
		s.push(temp);
		while(!s.isEmpty()){
			//取出前一个可用点
			temp=s.pop();
			//获取当前点坐标
			int x=temp.x;
			int y=temp.y;
			int d=temp.d+1;
			while(d<8){
				int i=x+move[d][0];
				int j=y+move[d][1];
				if(maze[i][j]==0){//该点可达
					temp=new Step(i,j,d);//到达该点
					s.push(temp);
					x=i;
					y=j;
					maze[x][y]=-1;//到达新点，标志已经到达
					if(x==6 && y==8){
						return 1;//到达出口，迷宫，返回1
					}
					else
					{
						d=0;//重新初始化方向
					}
				}
				else{
					//如果不可到达
					d++;//改变方向
				}
			}
		}
		return 0;
	}
}



















































