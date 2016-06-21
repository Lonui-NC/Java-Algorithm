package StringTest;

public class SearchSon {
	//����ƥ���㷨�����Ӵ�
	public static int search(String pat,String txt)
	{
		int M=pat.length();
		int N=txt.length();
		for(int i=0;i<N;i++)
		{
			int j;
			for(j=0;j<M;j++)
			{
				if(txt.charAt(i+j)!=pat.charAt(j))
				{
					break;
				}
			}
			if(j==M)
				return i;
		}
		return N;
	}
	
	//KMP�㷨ʵ��
	class KMP
	{
		private String pat;
		private int[][] dfa;
		public KMP(String pat)
		{
			//��ģʽ�ַ�������DFA
			this.pat=pat;
			int M=pat.length();
			int R=256;
			dfa=new int[R][M];
			//����������Char���ַ���ʽ��256λ�����Ա�ʾ��Ӧ�������ַ�����ĸ��������
			dfa[pat.charAt(0)][0]=1;
			for(int X=0,j=1;j<M;j++)
			{
				//����dfa[][j]
				for(int c=0;c<R;c++)
					dfa[c][j]=dfa[c][X];//ƥ��ʧ�ܣ�����ǰ���ֵ
				//�����ַ�ƥ��ɹ�ʱ������һ״̬
				dfa[pat.charAt(j)][j]=j+1;
				//����ӵ�ǰ״̬���˻����
				X=dfa[pat.charAt(j)][X];
				
				//dfa�а��������еĿ������
				//���Ӧ��ϵ��ת���任�������
				//���п�����dfa����ʾʵ�ʹ����п��ܳ��ֵ����޿���״̬
				//jҲ������0����Ϊ���Զ���0
			}
		}
		
		public int search(String txt)
		{
			//��txt��ģ��
			int i,j,N=txt.length(),M=pat.length();
			for(i=0,j=0;i<N && j<M;i++)
				j=dfa[txt.charAt(i)][j];//ƥ�䵱ǰ��ƥ���ַ�����ֵ���Ӵ��е�ƥ���λ��
			if(j==M) return i-M;//���ƥ��ɹ��������һ��������ֵ
			else	return N;//δ�ҵ�ƥ��
				
			
		}
		
	}
	
	public static void main(String[] args){
		String p="ABABAC";
		String s="CACABABAAABABACBBB";
		SearchSon test=new SearchSon();
		SearchSon.KMP ktest=test.new KMP(p);
		System.out.println("test:"+test.search(p, s));
		System.out.println("kmp:"+ktest.search(s));
	}
	
}


