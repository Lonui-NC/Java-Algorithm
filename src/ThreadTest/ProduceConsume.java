package ThreadTest;
import java.util.*;
/**���������������⣬�漰�������� 
 * ��һ��������Ȿ�����һ���࣬������ 
 * �ڶ�����Ȼ�������ߡ������ߣ���ô�������������������Ǳ���� 
 * ����������ʲô������ʲô��������Ʒ���Ǳ���ģ���������ͷ�� 
 * ���ģ���Ȼ���̣߳���ô�Ͳ���һ��һ�ģ�Ҳ����˵��������һ������һ������Ȼ��������������������ţ� 
 *      ��ʵ�о��ǿ��ˣ��ڼ������Ҳ�������ݽṹ���������ݽṹ��������ľ���ջ�ˣ���˻�Ҫһ��ջ�� 
 */  

public class ProduceConsume {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SyncStack ss=new SyncStack();
		Producer p=new Producer(ss);//��Ӧ�ֿ�
		Consume c=new Consume(ss);
		Thread tp=new Thread(p);
		Thread tc=new Thread(c);
		tp.start();
		tc.start();
	}
}
	
	//������
	class SteamBread{
		int id;//
		SteamBread(int id){
			this.id=id;
		}
		public String toString(){
			return "steamBread:"+id;
		}
	}
	
	
	//�ֿ���
	class SyncStack{
		int index=0;
		SteamBread[] stb=new SteamBread[6];//�ֿ�����
		
		//��ջ���൱�����
		public synchronized void push(SteamBread sb){
			while(index==stb.length){//�������˼�����ջ����
				try{
					this.wait();//�õ�ǰ�̵߳ȴ� ������߳̾���push�Ľ���
					//wait�ȴ����ͷ����ȴ��������̽���notify
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			this.notify();//�����ڴ˶���������ϵȴ��ĵ����̣߳����������߳� 
			stb[index]=sb;
			this.index++;
		}
		
		
		//��ջ�൱������
		public synchronized SteamBread pop(){
			while(index==0){//ջ���˼��ֿ����
				try{
					this.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				
			}
			this.notify();//ȡ��
			this.index--;//push��n��֮��this.index++��ʹջ��Ϊn+1����return֮ǰҪ��һ  
			return stb[index];
		}
		
	}
	
	//�������࣬ʵ����Runnable�ӿڣ��Ա��ڹ����������߳�
	class Producer implements Runnable{
		SyncStack ss=null;
		Producer(SyncStack ss){
			this.ss=ss;
		}
		@Override
		public void run(){
			//��ʼ����
			for(int i=0;i<20;i++){
				SteamBread stb=new SteamBread(i);
				ss.push(stb);
				System.out.println("Produce��"+stb);
				try{
					Thread.sleep(10);//ÿ���10s����һ��
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
		
	}
	
	//�������࣬ʵ����Runnable�ӿڣ����ڹ����������߳�
	class Consume implements Runnable{
		SyncStack ss=null;
		public Consume(SyncStack ss){
			super();
			this.ss=ss;
		}
		
		@Override
		public void run(){
			for(int i=0;i<20;i++){//��ʼ����consume
				SteamBread stb=ss.pop();
				System.out.println("Consume: "+stb);
				try{
					Thread.sleep(100);//ÿ����1�����100s sleep���ͷŶ�����
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


