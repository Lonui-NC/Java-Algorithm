package iotest;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

//专门用来写IO的输入信息
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M=0,N=0;
		int i;
		int A=0,B=0;
		Scanner in=new Scanner(System.in);
		//由于存在多组数据所以用N,M来进行测试
		while(in.hasNext())
		{
			//存入对应N与M
			N=in.nextInt();
			M=in.nextInt();
			int[] score =new int[N];
			//存入对应前N个学生信息
			for(i=0;in.hasNext() && i<N;i++){
				score[i]=in.nextInt();
			}
			//操作字符串
			String c=null;
			for(i=0;in.hasNext() && i<M;i++){
				//传入三个操作字
				c=in.next();//in.next()表示对应的输入字符
				A=in.nextInt();
				B=in.nextInt();
				process(c,A,B,score);
			}
			
			
		}
		
		//最后一个字符的长度//
		Scanner scanner=new Scanner(System.in);
		int len=0;
		while(scanner.hasNext())
		{
			len=LengthOfLast(scanner.next());
		}
		System.out.println(len);
		
		Set<Integer> set=new HashSet<Integer>();
		set.add(1);
		Iterator<Integer> it=set.iterator();
		
		
		
		
	}
	
	//输入字符最后一个单词的长度
	public static int LengthOfLast(String str)
	{
		if(str==null || str.length()==0)
			return 0;
		else
			return str.length();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//操作执行处理函数
	private static void process(String c,int A,int B,int[] score){
		int begin,end;
		//当表示对应为查询时
		if(c.equals("Q")){
			//表示对应的边界
			//A,B的大小有可能不定
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




























