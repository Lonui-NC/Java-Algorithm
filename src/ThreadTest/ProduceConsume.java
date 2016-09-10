package ThreadTest;
import java.util.*;
/**生产者消费者问题，涉及到几个类 
 * 第一，这个问题本身就是一个类，即主类 
 * 第二，既然是生产者、消费者，那么生产者类和消费者类就是必须的 
 * 第三，生产什么，消费什么，所以物品类是必须的，这里是馒头类 
 * 第四，既然是线程，那么就不是一对一的，也就是说不是生产一个消费一个，既然这样，多生产的往哪里放， 
 *      现实中就是筐了，在计算机中也就是数据结构，筐在数据结构中最形象的就是栈了，因此还要一个栈类 
 */  

public class ProduceConsume {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SyncStack ss=new SyncStack();
		Producer p=new Producer(ss);//对应仓库
		Consume c=new Consume(ss);
		Thread tp=new Thread(p);
		Thread tc=new Thread(c);
		tp.start();
		tc.start();
	}
}
	
	//货物类
	class SteamBread{
		int id;//
		SteamBread(int id){
			this.id=id;
		}
		public String toString(){
			return "steamBread:"+id;
		}
	}
	
	
	//仓库类
	class SyncStack{
		int index=0;
		SteamBread[] stb=new SteamBread[6];//仓库容量
		
		//入栈，相当于入库
		public synchronized void push(SteamBread sb){
			while(index==stb.length){//长度满了即表明栈满了
				try{
					this.wait();//让当前线程等待 ，这个线程就是push的进程
					//wait等待会释放锁等待其他进程进行notify
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			this.notify();//唤醒在此对象监视器上等待的单个线程，即消费者线程 
			stb[index]=sb;
			this.index++;
		}
		
		
		//出栈相当于消费
		public synchronized SteamBread pop(){
			while(index==0){//栈空了即仓库空了
				try{
					this.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				
			}
			this.notify();//取货
			this.index--;//push第n个之后，this.index++，使栈顶为n+1，故return之前要减一  
			return stb[index];
		}
		
	}
	
	//生产者类，实现了Runnable接口，以便于构造生产者线程
	class Producer implements Runnable{
		SyncStack ss=null;
		Producer(SyncStack ss){
			this.ss=ss;
		}
		@Override
		public void run(){
			//开始生产
			for(int i=0;i<20;i++){
				SteamBread stb=new SteamBread(i);
				ss.push(stb);
				System.out.println("Produce："+stb);
				try{
					Thread.sleep(10);//每间隔10s生产一个
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
		
	}
	
	//消费者类，实现了Runnable接口，便于构造消费者线程
	class Consume implements Runnable{
		SyncStack ss=null;
		public Consume(SyncStack ss){
			super();
			this.ss=ss;
		}
		
		@Override
		public void run(){
			for(int i=0;i<20;i++){//开始消费consume
				SteamBread stb=ss.pop();
				System.out.println("Consume: "+stb);
				try{
					Thread.sleep(100);//每消费1个间隔100s sleep不释放对象锁
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


