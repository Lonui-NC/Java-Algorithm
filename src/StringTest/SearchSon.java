package StringTest;

public class SearchSon {
	//暴力匹配算法查找子串
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
	
	//KMP算法实现
	class KMP
	{
		private String pat;
		private int[][] dfa;
		public KMP(String pat)
		{
			//由模式字符串构造DFA
			this.pat=pat;
			int M=pat.length();
			int R=256;
			dfa=new int[R][M];
			//在这里用了Char的字符形式，256位，可以表示对应的所有字符和字母！！！！
			dfa[pat.charAt(0)][0]=1;
			for(int X=0,j=1;j<M;j++)
			{
				//计算dfa[][j]
				for(int c=0;c<R;c++)
					dfa[c][j]=dfa[c][X];//匹配失败，复制前面的值
				//仅当字符匹配成功时进入下一状态
				dfa[pat.charAt(j)][j]=j+1;
				//否则从当前状态回退或继续
				X=dfa[pat.charAt(j)][X];
				
				//dfa中包含了所有的可能组合
				//其对应关系和转换变换是连贯的
				//所有可以用dfa来表示实际过程中可能出现的无限可能状态
				//j也不用置0，因为会自动置0
			}
		}
		
		public int search(String txt)
		{
			//在txt上模拟
			int i,j,N=txt.length(),M=pat.length();
			for(i=0,j=0;i<N && j<M;i++)
				j=dfa[txt.charAt(i)][j];//匹配当前待匹配字符串的值在子串中的匹配和位置
			if(j==M) return i-M;//如果匹配成功到了最后一步，返回值
			else	return N;//未找到匹配
				
			
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


