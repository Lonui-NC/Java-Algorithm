package singleton;

public class SingletonTest {
	//懒汉单例，在第一次调用的时候实例化自己
	private SingletonTest(){}
	private static SingletonTest single=null;
	//静态工厂方法
	//加入synchronized 方法保证线程同步
	public static synchronized SingletonTest getInstance(){
		if(single==null)
		{
			single=new SingletonTest();
		}
		return single;
	}

}

//饿汉式单例类，在类初始化时，已经自动实例化
	class Singleton1{
		private Singleton1(){}
		private static final Singleton1 single=new Singleton1();
		//静态工厂方法
		public static Singleton1 getInstance(){
			return single;
		}
		
		
		
	}




















