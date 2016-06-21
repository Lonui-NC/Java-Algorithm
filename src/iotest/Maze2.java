package iotest;
//���Ҫ�ҳ����е��߷���ֻҪ��ʾ�ߵ����ڵ�����·����Ȼ���˻���һ�񼴿�

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
		 //��Ӧ������࣬�ǰ�Ȩ��
		 Maze2.go(map, new Point(0,3));
	}
	
	public static void go(Map map,Point p){
		//��Ӧ����һ������step�����жϺ�go��ѭ��
		map.step(p);
		//System.out.println(p.toString());
		//�����ʱ�ߵ��ˣ���������Ϊ1
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
		//�˴���ǰ��Ĳ�ͬ��Ҫ�������
		//ǰ��������жϣ�����һϵ�в����Ƿ񵽴��յ㣬����ֻҪ������һ�μ���
		//�����������Ĳ����Ѿ������ˣ���ô��ֱ�ӿ���ͨ��test���أ���������µĲ���
		//����Ĳ�ͬ��������ǰ���ж��Ƿ񵽴��������ˣ�����һ�������·��ȫ����ʾ����
		//ͬʱ������·����Ϊ�ɵ��Ϊ����·��������һ���ж�
		//Ȼ����������������·���㣬��Ȼ������ٴεݹ�
		//����ÿ�εݹ������ͬ�����Կ������ҳ�����·��
		//��isArrived�����ж����return Ч��һ�£�������������
		map.empty(p);
	}
	
	public static void test(Map map,Point p){
		if(!map.isArrived() && map.isEmpty(p)){
			go(map,p);
		}
		
	}
}

//����Point�࣬��ʾ��Ӧ�ĵ�


















