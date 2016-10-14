package dp;

public class MainDP {
	public static void main(String[] args){
		 //�������ַ�����Ϊ��getLength()������������Ҳ���Բ�����  
        //������getLength()��������������ĳ�ʼ��c[][]��һ���е�һ��  
        String[] x = {"", "A", "B", "C", "B", "D", "A", "B"};  
        String[] y = {"", "B", "D", "C", "A", "B", "A"};  
        
//        int[][] b=getLength(x,y);
//        Display(b,x,x.length-1,y.length-1);
        String str1 = new String("binghaven");  
        String str2 = new String("jingseven");  
        getLCString(str1.toCharArray(), str2.toCharArray());  
	}
	
	
	//����һ����ά����c[][]����c[i][j]��¼X[i]��Y[j] ��LCS �ĳ��ȣ�
	//b[i][j]��¼c[i][j]��ͨ����һ���������ֵ��õģ��Ծ��������ķ���
	
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return ���ؾ����������������
	 */
	//Ϊ�˽�Լ�ظ�����ͬ�������ʱ�䣬����һ�����飬���������Ƿ�����ս����ã�
	//������������Ľ���ڸ������У�����Ƕ�̬�滮�������õĻ���������
	//��̬�滮��������������״̬
	public static int[][] getLength(String[] x,String[] y){
		int[][] b=new int[x.length][y.length];
		int[][] c=new int[x.length][y.length];
		
		//ע���¼�������飬һ������״̬��һ����¼�ַ�
		for(int i=1;i<x.length;i++){
			for(int j=1;j<y.length;j++){
				//һ����¼״̬��һ����¼�ַ�
				//�ֱ��ʾ��Ӧ����Դ����i==j,i-1,����j-1
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
	
	//���ݵĻ���ʵ��
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
	
	//������Ӵ����������Ӵ�
	  //�ڶ�̬�滮�������ɷ�ʽ���У�ÿ����һ�У�ǰ�����һ�о��Ѿ�û�����ˣ�
	//�������ֻ��ʹ��һά���飬�����ǳ��õĶ�λ����  
	//��̬�滮�ĺ��ģ�Ѱ�ҵݹ鷽�̣����ֶ�Ӧ״̬����������洢״̬
	public static void getLCString(char[] str1,char[] str2){
		int len1,len2;
		len1=str1.length;
		len2=str2.length;
		int maxLen=len1>len2?len1:len2;
		
		int[] max=new int[maxLen];//�����Ӧ��Ӵ�������
		int[] maxIndex=new int[maxLen];//������󳤶ȵ���������
		int[] c=new int[maxLen];//��������
		
		int i,j;
		//��������i��str2��j��str1
		for(i=0;i<len2;i++){
			for(j=len1-1;j>=0;j--){
				if(str2[i]==str1[j]){
					if((i==0) || (j==0))
						c[j]=1;//��ʼʱ����Ϊ1
					else
						//��ʱC[j-1]�����ϴ�ѭ���е�ֵ����Ϊ��û�����¸�ֵ
						c[j]=c[j-1]+1;//�ڻ���ʱ��������ֵ��ʾ��������
					//�������ǰ����±��1����ʵ��ʾ�˶�Ӧ�Ķ�̬�滮������һ��һ�е�ˢ��
					//���ǰ��һ���ж�Ӧ��ֵ����ô����һ�н�����ʵ��
					//ǰһ�� c[j-1]ƥ�䣬��һ����c[j]ƥ���1
				}
				else{
					c[j]=0;
				}
				
				//���ֻ��һ�����,������ʼ�����ֵ��index����һ����
				//һ�����±�λ�ã�һ���泤��
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
							//�ҵ���Ϊ0�Ĳ��֣�����µ�һ��ֵ���±�
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
	
	
	
	
	
	
	//ͼG�ǲ���Ȩ��������ͨͼ��һ���ߵĳ���Ϊ1����ˣ�����붥��v����Զ�Ķ���
	//������붥��v�ı������Ķ��㡣���ù�����ȱ����㷨����v�������й�ȱ����������ڴӶ���v����һ����������չ������j, ������󵽴��һ������k��Ϊ����v��Զ�Ķ��㡣
	//����ʱ���ö�������ݴ�������㣬�����ӵ�һ������k��Ϊ����
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
