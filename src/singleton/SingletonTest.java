package singleton;

public class SingletonTest {
	//�����������ڵ�һ�ε��õ�ʱ��ʵ�����Լ�
	private SingletonTest(){}
	private static SingletonTest single=null;
	//��̬��������
	//����synchronized ������֤�߳�ͬ��
	public static synchronized SingletonTest getInstance(){
		if(single==null)
		{
			single=new SingletonTest();
		}
		return single;
	}

}

//����ʽ�����࣬�����ʼ��ʱ���Ѿ��Զ�ʵ����
	class Singleton1{
		private Singleton1(){}
		private static final Singleton1 single=new Singleton1();
		//��̬��������
		public static Singleton1 getInstance(){
			return single;
		}
		
		
		
	}




















