package ThreadTest;
import java.util.*;
public class AllThread {

	//Threadlocal
	private static final ThreadLocal<Integer> value=new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	};
	
	public void testrun(){
		for(int i=0;i<5;i++){
			new Thread(new MyThread(i)).start();
		}
	}
	
	static class MyThread implements Runnable{
		private int index;
		public MyThread(int index){
			this.index=index;
		}
		public void run(){
			 	System.out.println("线程" + index + "的初始value:" + value.get());
	            for (int i = 0; i < 10; i++) {
	                value.set(value.get() + i);
	            }
	            System.out.println("线程" + index + "的累加value:" + value.get());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}































































