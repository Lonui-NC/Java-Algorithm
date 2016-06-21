package iotest;

import java.util.Stack;
//java �Թ��㷨
//����
class Step{
	int x,y,d;
	public Step(int x,int y,int d){
		this.x=x;
		this.y=y;
		this.d=d;
	}
	
}
public class MazeTest {
	//�����Թ�·���㷨������������⡣������������
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �Թ�����
        int[][] maze = {{1,1,1,1,1,1,1,1,1,1},
                        {1,0,1,1,1,0,1,1,1,1},
                        {1,1,0,1,0,1,1,1,1,1},
                        {1,0,1,0,0,0,0,0,1,1},
                        {1,0,1,1,1,0,1,1,1,1},
                        {1,1,0,0,1,1,0,0,0,1},
                        {1,0,1,1,0,0,1,1,0,1},
                        {1,1,1,1,1,1,1,1,1,1}};
        //����������ƶ���ʽ
        //����Ϊ8�֣����ε���
        int[][] move = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        Stack<Step> s=new Stack<Step>();//���Բ�д���͵ģ�������
        Stack<Step> s1=new Stack<Step>();
        int a=path(maze,move,s);
        while(!s.isEmpty())
        {
        	Step step=s.pop();
        	System.out.println(step.x+":"+step.y);
        }
	}

	public static int path(int[][] maze,int[][] move,Stack<Step> s){
		Step temp=new Step(1,1,-1);//���
		s.push(temp);
		while(!s.isEmpty()){
			//ȡ��ǰһ�����õ�
			temp=s.pop();
			//��ȡ��ǰ������
			int x=temp.x;
			int y=temp.y;
			int d=temp.d+1;
			while(d<8){
				int i=x+move[d][0];
				int j=y+move[d][1];
				if(maze[i][j]==0){//�õ�ɴ�
					temp=new Step(i,j,d);//����õ�
					s.push(temp);
					x=i;
					y=j;
					maze[x][y]=-1;//�����µ㣬��־�Ѿ�����
					if(x==6 && y==8){
						return 1;//������ڣ��Թ�������1
					}
					else
					{
						d=0;//���³�ʼ������
					}
				}
				else{
					//������ɵ���
					d++;//�ı䷽��
				}
			}
		}
		return 0;
	}
}



















































