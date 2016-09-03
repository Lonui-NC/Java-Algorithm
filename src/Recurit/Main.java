package Recurit;

import java.util.*;
//This is where to practice Job Program
public class Main {

	//��������������Ҫ�õ���̬�滮�ĸ��������c[i][j]��¼X[i]��Y[j] ��LCS �ĳ��ȣ���ô�ڼ���c[i,j]֮ǰ��c[i-1][j-1]��c[i-1][j]��c[i][j-1]���Ѽ����������ʱ���Ǹ���X[i] = Y[j]����X[i] != Y[j]���Ϳ��Լ����c[i][j]������ĵݹ�ʽд�ɣ�
	//�ھ�����㷨�����Ǳ��������ʹ����b[][]����¼c[i,j] ѡ������һ�����ӵݹ�ʽ�����֪����������ͬ��ѡ�񣩣����ǣ����ǿ��Բ�����������b������������c������ʱ�ж�c[i,j]��ֵ����c[i-1,j-1]��c[i-1,j]��c[i,j-1]����һ����ֵԪ����ȷ����ԭ����ͨ���������ѡȡc[i,j]�������ġ�
	//����������� ��̬�滮
	//��ʵ��̬��չҪ�������1��1��
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
	//����ԭ�еķ�ʽ�Ͳ�������������⣬��Ϊb�б�ǣ�����������ע���£�������
	public static void print(int[][] opt,String X,String Y,int i,int j){

		if(i==0 || j==0){
			return;
		}
//		//��ʱ��Ӧ������д����Ϊ���������ܲ�ͬ��ĸʹ����ȣ���Ҫ�жϵ���
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//��Ѷʵϰ�����1 �������
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
	
	//��Ѷʵϰ�����2 �ַ���λ
	public static void Tecent2(){
		Scanner sc=new Scanner(System.in);
		char temp;//���ڽ���
		//��һ���ַ����Ĵ�д��ĸ�ŵ��ַ����ĺ��棬�����ַ������λ�ò��䣬�Ҳ����������Ŀռ䡣\
		//ɵ�ˣ�������β��Ϳ����ˡ�����������
		//��һ�����Сд��ĸ���ڶ��������д��ĸ
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
	
	//��Ѷʵϰ�����2 ���Ķ�Ԫ��
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
	
	
	
	//��Ѷʵϰ�����3 ���Ķ�Ԫ��
	//�������д��ɵ�ˡ�������������
//	�ҵ�˼·�����ÿ��ţ�Ȼ�����������ֱ����ֵ���Ķ����Ͳ�ֵ��С�Ķ�����
//	����֮���������Ϊ�������飬�����ֵ=��Сֵ�������Ѿ������ˡ����򣬽�������Ĳ��������У�
//	1. ��ֵ���ĺ��󣬿����������м�����Сֵ�ͼ������ֵ����˼��ɡ�
//	2. ��ֵ��С�ģ��������������飬�ض������ڵĲ�ֵ��С�����ɿ��ź�������������ɲ�ֵ���飨�����ڵ�����������������ֵ������0����鿴��ֵ����������0���������������������֪ʶ�����ܵĲ�ֵ��С�Ķ����������ֵ������û��0����ֻ������ֵ�������ж��ٸ���Сֵ���ɡ�ע����ֵ����ض����ǷǸ�����
//	3. �ռ临�ӶȽϴ���ҪһЩ�������顣
//	4. ʱ�临�Ӷȣ�����O(NlogN)�����ֵ���O(N)�����ֵ��СO(N)���������յ�ʱ�临�Ӷ�ΪO(NlogN)��
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
		//���ȶ���������
		Arrays.sort(nums);
		//��������������ж������С����Ϊ����
		//����С�����ĸ���
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
		
		
		//�ж�
		
		if(nums[0]==nums[nums.length-1])
			maxCount=nums.length*(nums.length-1)/2;
		else
			maxCount=minNum*maxNum;
		
		int min_temp=nums[1]-nums[0];
		for(int j=2;j<nums.length;j++){
			if(nums[j]-nums[j-1]<min_temp)
				min_temp=nums[j]-nums[j-1];
		}
		//Ѱ������Ϊ0�ĸ���
		//System.out.println("t"+" "+min_temp);
		if(min_temp==0){
			for(int i=1;i<nums.length;++i){
				int j=i-1;
				//�ж��뵱ǰһ����ȵĸ���
				//��ʱ�����еĶ���
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
	
	
	
	//�������� ��Ϊ����
	//������������С����ȡ��Ȼ��ÿ�εݹ�����϶����ʣ�µĶ���������
	//�ݹ��󷨣��϶�����˳��Ҳ�Ǵ�С����
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
//        //�±겻Ҫ���
//        int[][] opt = LCS(x,y);         
//        print(opt,x,y,y.length(), x.length());  
//		m.Tencent1();
		//m.Interesting();
		m.PrintMatrix();
	}

}
