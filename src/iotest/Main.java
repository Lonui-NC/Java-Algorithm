package iotest;
import java.util.Scanner;
//ר������дIO��������Ϣ
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M=0,N=0;
		int i;
		int A=0,B=0;
		Scanner in=new Scanner(System.in);
		//���ڴ��ڶ�������������N,M�����в���
		while(in.hasNext())
		{
			//�����ӦN��M
			N=in.nextInt();
			M=in.nextInt();
			int[] score =new int[N];
			//�����ӦǰN��ѧ����Ϣ
			for(i=0;in.hasNext() && i<N;i++){
				score[i]=in.nextInt();
			}
			//�����ַ���
			String c=null;
			for(i=0;in.hasNext() && i<M;i++){
				//��������������
				c=in.next();//in.next()��ʾ��Ӧ�������ַ�
				A=in.nextInt();
				B=in.nextInt();
				process(c,A,B,score);
			}
			
			
		}
	}
	//����ִ�д�����
	private static void process(String c,int A,int B,int[] score){
		int begin,end;
		//����ʾ��ӦΪ��ѯʱ
		if(c.equals("Q")){
			//��ʾ��Ӧ�ı߽�
			//A,B�Ĵ�С�п��ܲ���
			end=Math.max(A, B);
			begin=Math.min(A, B)-1;
			int max=score[begin];
			for(int i=begin;i<end;i++){
				if(max<score[i]){
					max=score[i];
				}
			}
			System.out.println(max);
		}
		else if(c.equals("U")){
			score[A-1]=B;
		}
		
	}

}




























