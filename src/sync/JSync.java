package sync;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JSync {
	public static void main (String[] args){
		ExecutorService exec=Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++)
		{
			
			//ÒÀ´ÎÂÖÑ¯ÊµÏÖ
			exec.execute(new TestThread());
//			new Thread(new TestThread()).start();
		}
		exec.shutdown();
		System.out.println("Test result:");
	}
}
