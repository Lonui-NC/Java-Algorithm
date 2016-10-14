package dp;

public class MainDP {
	public static void main(String[] args){
		 //保留空字符串是为了getLength()方法的完整性也可以不保留  
        //但是在getLength()方法里面必须额外的初始化c[][]第一个行第一列  
        String[] x = {"", "A", "B", "C", "B", "D", "A", "B"};  
        String[] y = {"", "B", "D", "C", "A", "B", "A"};  
        
//        int[][] b=getLength(x,y);
//        Display(b,x,x.length-1,y.length-1);
        String str1 = new String("binghaven");  
        String str2 = new String("jingseven");  
        getLCString(str1.toCharArray(), str2.toCharArray());  
	}
	
	
	//引进一个二维数组c[][]，用c[i][j]记录X[i]与Y[j] 的LCS 的长度，
	//b[i][j]记录c[i][j]是通过哪一个子问题的值求得的，以决定搜索的方向。
	
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return 返回决定搜索方向的数组
	 */
	//为了节约重复求相同子问题的时间，引入一个数组，不管它们是否对最终解有用，
	//把所有子问题的解存于该数组中，这就是动态规划法所采用的基本方法。
	//动态规划是用数组来保存状态
	public static int[][] getLength(String[] x,String[] y){
		int[][] b=new int[x.length][y.length];
		int[][] c=new int[x.length][y.length];
		
		//注意记录两个数组，一个保持状态，一个记录字符
		for(int i=1;i<x.length;i++){
			for(int j=1;j<y.length;j++){
				//一个记录状态，一个记录字符
				//分别表示对应的来源，是i==j,i-1,还是j-1
				if(x[i]==y[j]){
					c[i][j]=c[i-1][j-1]+1;
					b[i][j]=1;
				}else if(c[i-1][j]>=c[i][j-1]){
					c[i][j]=c[i-1][j];
					b[i][j]=0;
				}
				else {
					c[i][j]=c[i][j-1];
					b[i][j]=-1;
				}
			}
		}
		return b;
	}
	
	//回溯的基本实现
	public static void Display(int[][] b,String[] x,int i,int j){
			if(i==0 || j==0)
				return;
			
			if(b[i][j]==1){
				Display(b,x,i-1,j-1);
				System.out.println(x[i]+" ");
			}
			else if(b[i][j]==0){
				Display(b,x,i-1,j);
			}
			else if(b[i][j]==-1){
				Display(b,x,i,j-1);
			}
			
	}
	
	//最长公共子串，连续的子串
	  //在动态规划矩阵生成方式当中，每生成一行，前面的那一行就已经没有用了，
	//因此这里只需使用一维数组，而不是常用的二位数组  
	//动态规划的核心，寻找递归方程，保持对应状态，生成数组存储状态
	public static void getLCString(char[] str1,char[] str2){
		int len1,len2;
		len1=str1.length;
		len2=str2.length;
		int maxLen=len1>len2?len1:len2;
		
		int[] max=new int[maxLen];//保存对应最长子串的数组
		int[] maxIndex=new int[maxLen];//保存最大长度的索引数组
		int[] c=new int[maxLen];//存放最长长度
		
		int i,j;
		//在这里面i是str2，j是str1
		for(i=0;i<len2;i++){
			for(j=len1-1;j>=0;j--){
				if(str2[i]==str1[j]){
					if((i==0) || (j==0))
						c[j]=1;//起始时索引为1
					else
						//此时C[j-1]还是上次循环中的值，因为还没被重新赋值
						c[j]=c[j-1]+1;//在滑动时增加索引值表示最大的索引
					//这里表明前面的下标加1，其实暗示了对应的动态规划，就是一行一行的刷新
					//如果前面一行有对应的值，那么下面一行接着来实现
					//前一个 c[j-1]匹配，后一个，c[j]匹配加1
				}
				else{
					c[j]=0;
				}
				
				//如果只有一个最长的,表明起始的最大值和index都是一样的
				//一个存下标位置，一个存长度
				if(c[j]>max[0]){
					max[0]=c[j];
					maxIndex[0]=j;
					
					for(int k=1;k<maxLen;k++){
						max[k]=0;
						maxIndex[k]=0;
					}
				}
				else if(c[j]==max[0]){
					for(int k=1;k<maxLen;k++){
						if(max[k]==0){
							//找到不为0的部分，存放新的一组值和下标
							max[k]=c[j];
							maxIndex[k]=j;
							break;
						}
					}
				}
				
				
				for(int temp: c){
					System.out.print(temp);
				}
				System.out.println();
			}
		}
		
		for(j=0;j<maxLen;j++){
			if(max[j]>0){
				System.out.println("ss of "+(j+1)+"is:");
				for(i=maxIndex[j]-max[j]+1;i<=maxIndex[j];i++){
					System.out.print(str1[i]);
				}
				System.out.println(" ");
			}
		}
		
		
	}
	
	
	
	
	
	
	//图G是不带权的无向连通图，一条边的长度为1，因此，求距离顶点v的最远的顶点
	//即求距离顶点v的边数最多的顶点。利用广度优先遍历算法，从v出发进行广度遍历，类似于从顶点v出发一层层地向外扩展，到达j, …，最后到达的一个顶点k即为距离v最远的顶点。
	//遍历时利用队列逐层暂存各个顶点，最后出队的一个顶点k即为所求。
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
