package Recurit;

import java.util.*;
//This is where to practice Job Program
public class Main {

	//求解最长公共子序列要用到动态规划的概念。我们用c[i][j]记录X[i]与Y[j] 的LCS 的长度，那么在计算c[i,j]之前，c[i-1][j-1]，c[i-1][j]与c[i][j-1]均已计算出来。此时我们根据X[i] = Y[j]还是X[i] != Y[j]，就可以计算出c[i][j]。问题的递归式写成：
	//在经典的算法导论那本书里，文章使用了b[][]来记录c[i,j] 选自于哪一个（从递归式里，我们知道有三个不同的选择），但是，我们可以不借助于数组b而借助于数组c本身临时判断c[i,j]的值是由c[i-1,j-1]，c[i-1,j]和c[i,j-1]中哪一个数值元素所确定，原理是通过我们如何选取c[i,j]来决定的。
	//最长公共子序列 动态规划
	//其实动态扩展要横竖多加1行1列
	public static int[][] LCS(String str1,String str2){
		int[][] opt=new int[str2.length()+1][str1.length()+1];
		
		for(int i=0;i<=str2.length();i++)
		{
			opt[i][0]=0;
		}
		
		for(int j=0;j<=str1.length();j++)
		{
			opt[0][j]=0;
		}
		
		for(int j=1;j<=str1.length();j++){
			for(int i=1;i<=str2.length();i++){
				if(str2.charAt(i-1)==str1.charAt(j-1)){
					opt[i][j]=opt[i-1][j-1]+1;
				}
				else{
					opt[i][j]=(opt[i-1][j]>opt[i][j-1])?opt[i-1][j]:opt[i][j-1];
				}
			}
		}
		//System.out.println(opt);
		for(int i=0;i<opt.length;i++){
			for(int j=0;j<opt[0].length;j++){
				System.out.print(opt[i][j]);
			}
			System.out.println();
		}	
		return opt;
	}
	
	//
	//按照原有的方式就不会出现这种问题，因为b有标记！！！！所以注意下！！！！
	public static void print(int[][] opt,String X,String Y,int i,int j){

		if(i==0 || j==0){
			return;
		}
//		//此时不应该这样写，因为有其他可能不同字母使其相等，故要判断等于
//		if(X.charAt(i-1)==Y.charAt(j-1)){
//			print(opt,X,Y,i-1,j-1);
//			System.out.print(X.charAt(i-1));
//		}
//		else if(opt[i-1][j]>=opt[i][j-1]){
//			print(opt,X,Y,i-1,j);
//		}
//		else{
//			print(opt,X,Y,i,j-1);
//		}
		System.out.println("X:"+i+"-"+X.charAt(i - 1)+";Y:"+j+"-"+Y.charAt(j - 1));
		 if (X.charAt(j - 1) == Y.charAt(i - 1)) { 
             print(opt, X, Y, i - 1, j - 1);  // don't put this line before the upper line. Otherwise, the order is wrong.  
             System.out.print(X.charAt(i - 1));    
		 }else if (opt[i - 1][j] >= opt[i][j]) {  
             print(opt, X, Y, i - 1, j);  
		 } else {  
             print(opt, X, Y, i, j - 1);
         }  
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//腾讯实习生编程1 构造回文
	public static void Tencent1(){
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String frontl=sc.nextLine();
			char[] t=frontl.toCharArray();
			char c;
			for(int i=0;i<t.length/2;i++){
				c=t[i];
				t[i]=t[t.length-i-1];
				t[t.length-i-1]=c;
			}
			String backl=new String(t);
			int[][] opt=LCS(frontl,backl);
			System.out.println(frontl.length()-opt[frontl.length()][frontl.length()]);
		}
		
	}
	
	//腾讯实习生编程2 字符移位
	public static void Tecent2(){
		Scanner sc=new Scanner(System.in);
		char temp;//用于交换
		//把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。\
		//傻了，输出两次不就可以了。。。。。。
		//第一次输出小写字母，第二次输出大写字母
		while(sc.hasNext()){
			char[] l=sc.nextLine().toCharArray();
			for(int i=0;i<l.length;i++){
				if(l[i]>='a' && l[i]<='z')
					System.out.print(l[i]);
			}	
			for(int i=0;i<l.length;i++){
				if(l[i]>='A' && l[i]<='Z')
					System.out.print(l[i]);
			}
			System.out.println();
		}
		
	}
	
	//腾讯实习生编程2 数的二元组
	public static void Tencent3(){
		HashMap<Integer,Integer> res=new HashMap<Integer,Integer>();
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String l=sc.nextLine();
			String[] num=l.split(" ");
			for(int i=0;i<num.length;i++){
				for(int j=i;j<num.length;j++){
					int a=Integer.parseInt(num[i]);
					int b=Integer.parseInt(num[j]);
					int c=a-b;
					//int max=
				}
			}
		}
		
	}
	
	
	
	//腾讯实习生编程3 数的二元组
	//先排序后写，傻了。。。。。。。
//	我的思路是先用快排，然后对有序数组分别求差值最大的对数和差值最小的对数。
//	快排之后，如果数组为常数数组，即最大值=最小值，则结果已经出来了。否则，进行下面的操作，其中：
//	1. 差值最大的好求，看有序数组有几个最小值和几个最大值，相乘即可。
//	2. 差值最小的，由于是有序数组，必定是相邻的差值较小，故由快排后的有序数组生成差值数组（即相邻的两两相减）。如果差值数组中0，则查看差值数组中连续0的组数，可以由排列组合知识计算总的差值最小的对数；如果差值数组中没有0，则只需计算差值数组中有多少个最小值即可。注：差值数组必定都是非负数。
//	3. 空间复杂度较大，需要一些辅助数组。
//	4. 时间复杂度：快排O(NlogN)，求差值最大O(N)，求差值最小O(N)，所以最终的时间复杂度为O(NlogN)。
//	
	public static void Interesting(){
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int num=sc.nextInt();
			int[] nums=new int[num];
			for(int i=0;i<num;i++){
				nums[i]=sc.nextInt();
			}
			getMaxMin(nums,num);
		}
		
	}
	
	public static void getMaxMin(int[] nums,int num){
		int minNum=1,maxNum=1;
		int minCount=0,maxCount=0;
		//首先对数组排序
		Arrays.sort(nums);
		//有序数组操作，判断最大最小数即为最大差
		//求最小的数的个数
		for(int i=0;i<nums.length-1;i++){
			if(nums[i]!=nums[i+1])
				break;
			else
				minNum++;
		}
		for(int j=nums.length-1;j>=1;j--){
			if(nums[j]!=nums[j-1])
				break;
			else
				maxNum++;
		}
		
		
		//判断
		
		if(nums[0]==nums[nums.length-1])
			maxCount=nums.length*(nums.length-1)/2;
		else
			maxCount=minNum*maxNum;
		
		int min_temp=nums[1]-nums[0];
		for(int j=2;j<nums.length;j++){
			if(nums[j]-nums[j-1]<min_temp)
				min_temp=nums[j]-nums[j-1];
		}
		//寻找相邻为0的个数
		//System.out.println("t"+" "+min_temp);
		if(min_temp==0){
			for(int i=1;i<nums.length;++i){
				int j=i-1;
				//判断与当前一个相等的个数
				//此时是所有的对数
				while(j>=0 && nums[j]==nums[i])
				{
					++minCount;
					--j;
				}
			}
		}
		else
		{
			for(int i=1;i<nums.length;i++){
				if(nums[i]-nums[i-1]==min_temp)
					++minCount;
			}
		}
		
		System.out.print(minCount+" "+maxCount);
	}
	
	
	
	//质数因子 华为机考
	//求质因数，从小到大取，然后每次递归除，肯定最后剩下的都是质因数
	//递归求法，肯定最后的顺序也是从小到大
	public static String getResult(long ulDataInput){
		StringBuffer str=new StringBuffer();
		if(ulDataInput<=1)
			return str.toString();
		while(ulDataInput!=1){
			for(int i=2;i<=ulDataInput;i++){
				if(ulDataInput%i==0){
					str.append(i+" ");
					ulDataInput=ulDataInput/i;
					break;
				}
			}
		}
		return str.toString();
	}
	
	
	
	public static void PrintMatrix(){
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			int[][] matrix=new int[n][n];
			int value=1;
			for(int level=0;level<n/2;level++){
				int up,down,left,right;
				for(up=level;up<n-level-1;up++){
					matrix[level][up]=value;
					value++;
				}
				
				for(right=level;right<n-level-1;right++){
					matrix[right][up]=value;
					value++;
				}
				
				for(down=n-level-1;down>level;down--){
					matrix[right][down]=value;
					value++;
				}
				
				for(left=n-level-1;left>level;left--){
					matrix[left][down]=value;
					value++;
				}
				
			}
			if(n%2!=0)
				matrix[n/2][n/2]=value;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					System.out.print(matrix[i][j]+" ");
				}
				System.out.println();
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m=new Main();
		//m.Tecent2();
		//LCS
//		String x="AABBC";
//		String y="CAABB";
//        System.out.println("x:"+x.length()+";y:"+y.length());  
//        //下标不要标错
//        int[][] opt = LCS(x,y);         
//        print(opt,x,y,y.length(), x.length());  
//		m.Tencent1();
		//m.Interesting();
		m.PrintMatrix();
	}

}
