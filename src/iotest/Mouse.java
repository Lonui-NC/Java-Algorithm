package iotest;

public class Mouse {
//	�ݹ鷽�����Ӧ�ĵ㣬����1
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
		//�������������������Ҷ������ߣ���ô�ͰѶ�Ӧ�ĵ���Ϊ���ɵ��Ȼ�󷵻ػ�ȥ
		//����������������һ������ɴﵽ����ô�����Ǹ�����
		//���߹������������ʱ���÷��������е������������һ����
		//�����һ����û�ҵ�������ǰ��ģ��ٷ�������һ����
		//���Ǳ߽��
		//���ڿ��������ĸ���������
		//��������������϶�һ����������ߵ���
		//������Ч�ʣ�ֻҪ���ߵ������ˣ�������������
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
	
	//�жϵ�ǰ���Ƿ����
	public static void test(Map map,Point p){
		//���û�����յ㲢�ҵ�ǰ�������
		if(!map.isArrived() && map.isEmpty(p)){
			go(map,p);
		}
	}
	
}

//�����ļ���
//�������Թ��еĵ㣬�������л�ã���Ӧ�ĸ����ֵ�������յ�
class Point{
	int x;
	int y;
	public Point(int x1,int y1){
		x=x1;
		y=y1;
	}
}

class Map{
	//ֱ�Ӹ�ֵһ����ά���飬ֱ�ӻ�ȡ
	int[][] maze;
	Point end;//�յ�
	public Map(int[][] maze,Point end){
		this.maze=maze;
		this.end=end;
	}
	
	//�ж��Ƿ񵽴��յ�
	public boolean isArrived(){
		return maze[end.x][end.y]==1;
	}
	//��ǰ��һ���Ƿ����
	public boolean isEmpty(Point p){
		
		return maze[p.x][p.y]==0;
	}
	//�������Ϊ��������Ӧp���޷������յ�ʱ����ӡ��Ĩȥ
	public void empty(Point p){
		maze[p.x][p.y]=0;
	}
	//�ߵ�Point p
	public void step(Point p){
		maze[p.x][p.y]=1;
	}
	//��ӡ��ͼ
	public void print(){
		for(int i=0;i<maze.length;i++)
		{
			for(int j=0;j<maze[0].length;j++)
			{
				if(maze[i][j]==2){
					System.out.print("��");
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











































