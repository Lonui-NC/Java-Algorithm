package sync;

import java.util.concurrent.TimeUnit;

public class TestThread implements Runnable {
	protected int Count=5;
	private static int taskCount=0;
	private final int id=taskCount++;
	public TestThread()
	{
		//taskCount++;
		//����Ҫ������һ������final����ʾÿ���̣߳����ڿ�ʼ����һ�γ�ʼ��������������������̸߳��ţ���ʹID���󣡣���
		//System.out.println("ts"+taskCount);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(Count>0)
			{
				System.out.println("#"+id+": now time is "+Count+" ");
				Count--;
				TimeUnit.MILLISECONDS.sleep(100);
			}
		}
		catch(InterruptedException e){
			
		}
	
		
	}

}
