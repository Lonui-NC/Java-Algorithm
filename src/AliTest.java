import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AliTest {
	//�ʷѼ�����Ż�ȯ
		Map <Float,Float> post=new HashMap<Float,Float>();
		//��Ŷ�Ӧ�ļ����ܶ�
		List <Float> postSum=new ArrayList<Float>();
		//���������Ż�ȯ
		Map <Float,Float> red=new HashMap<Float,Float>();
		//��Ŷ�Ӧ�ļ����ܶ�
		List <Float> redSum=new ArrayList<Float>();
		AliTest()
		{
			//ʵ�ֹ��캯��
			//������Ӧ��post��red�ĳ�ʼ����
			//ƪ�����޲���д	
			InitPost();
			InitRed();
		}
		//�ʷѼ����ʼ��
		public void InitPost()
		{
			//��һ����ӦΪ�ﵽ���ܽ��ڶ���Ϊ��Ӧ�ﵽ�ļ�����
			post.put(100.0f,10.0f);
			postSum.add(100.0f);
			post.put(200.0f,20.0f);
			postSum.add(200.0f);
		}
		//��������ʼ��
		public void InitRed()
		{
			red.put(200.0f, 30.0f);
			redSum.add(100.0f);
			red.put(300.0f, 40.0f);
			redSum.add(100.0f);
		}
		
		//�Ƽ�ϵͳ�����ض�Ӧ�ĺ���������Ż�ȯ��Map����
		//��Ӧ����Ŀ����String,�Ż�ȯ���ƣ���������ʷ�
		//�������Ӧ�ڸ���Ŀ�������Ƽ����Ż�ȯMap
		//float�ж�ӦΪ���ﳵ�еĽ��sum
		public Map <String,Map<Float,Float>> Recommand(float sum)
		{
			//���صı���
			Map <String,Map<Float,Float>> result =new HashMap<String,Map<Float,Float>>();
			//���������sumΪ�͵�float ���ͽ��з�����жϣ���������ֵ�Ƚ�
			Float [] redCho=new Float[redSum.size()];
			redSum.toArray(redCho);
			Float [] postCho=postSum.toArray(new Float[postSum.size()]);
			Arrays.sort(redCho);
			Arrays.sort(postCho);
			int i=0;
			int j=0;
			Map<Float,Float> redtemp=new HashMap<Float,Float>();
			Map<Float,Float> postemp=new HashMap<Float,Float>();
			//���ʷѽ��з�����ж�
			if(sum>redCho[0])
			{
				redtemp.put(redCho[0], red.get(redCho[0]));
				//forѭ������ʵ�ֽ���Ӧ�Ķ������������У������Ż�ȯ������
				for(j=0;j<redCho.length;j++)
				{
					if(sum>redCho[j])
						redtemp.put(redCho[j], red.get(redCho[j]));
					else//����Ӧ�Ѿ��ﲻ���Żݶ�˳�
						break;
				}
				//�������Ż�ȯ���Ƽ��꣬���Ӧ��������
				if(j==redCho.length)
				{
					
				}
				else//����Ӧδ�Ƽ��������Ƽ������뵱ǰ���������Ĺ���ȯҲ�Ƽ����û�
				{
					redtemp.put(redCho[j+1], red.get(redCho[j+1]));
					result.put("red",redtemp);
				}
				
				
			}
			else
			{
				redtemp.put(redCho[0], red.get(redCho[0]));
				result.put("red",redtemp);
			}
			
			
//			//��Ӧ�����ʷѵ��жϣ���һ��
//			if(sum>postCho[0])
//			{
//				postemp
//				result.put("post", new Map<postCho[0],red.get(postCho[0])>);
//				//forѭ������ʵ�ֽ���Ӧ�Ķ������������У������Ż�ȯ������
//				for(j=0;j<postCho.length;j++)
//				{
//					if(sum>postCho[j])
//						result.put("post", new Map<postCho[j],red.get(postCho[j])>);
//					else//����Ӧ�Ѿ��ﲻ���Żݶ�˳�
//						break;
//				}
//				//�������Ż�ȯ���Ƽ��꣬���Ӧ��������
//				if(j==postCho.length)
//				{
//					
//				}
//				else//����Ӧδ�Ƽ��������Ƽ������뵱ǰ���������Ĺ���ȯҲ�Ƽ����û�
//				{
//					result.put("post", new Map<postCho[j+1],red.get(postCho[j+1])>);
//				}
//			}
//			else
//			{
//				result.put("post", new Map<postCho[0],red.get(postCho[0])>);
//			}
//			
//			//��ʱ������������Ӧ���е��Ż݄�����ϵ��Ѿ�ȫ�����뵽��result��
//			//result�еĽ��Ϊ���з����������Ż�ȯ
			return result;
//			
		}
		
		
		//choose�����жԵ�һ������Ľ����tempΪ��һ������result��������������ʺ��Ƽ����Ż�ȯ
		//��choose�����ж�������һ����������ѡ������ͬ���������ѡȡ���û����������Ĵ���
		//
		public  Map <String,Map<Float,Float>>  Choose(Map <String,Map<Float,Float>> temp,float sum)
		{
			Map <String,Map<Float,Float>> afResult =new HashMap<String,Map<Float,Float>>();
			//�����к������н����Żݵ�ɸѡ�ͱȽ�
			return afResult;
		}
}
