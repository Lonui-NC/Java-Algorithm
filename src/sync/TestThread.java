package sync;

import java.util.concurrent.TimeUnit;

public class TestThread implements Runnable {
	protected int Count=5;
	private static int taskCount=0;
	private final int id=taskCount++;
	public TestThread()
	{
		//taskCount++;
		//必须要单独用一个对象final来标示每个线程，仅在开始进行一次初始化，否则后面由于其他线程干扰，会使ID错误！！！
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
