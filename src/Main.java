
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

	public TreeNode() {
		// TODO Auto-generated constructor stub
	}

}
public class Main {
	
	
	//@SuppressWarnings("finally")
	//两个堆栈实现队列
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	int node=0;
    	while(!stack1.empty())
    	{
    		stack2.push(stack1.pop());
    	}
    	node=stack2.pop();
    	while(!stack2.empty())
    	{
    		stack1.push(stack2.pop());
    	}
    	return node;
    }
    
    
    //翻转二叉树
    public void Mirror(TreeNode root) {
    	TreeNode temp;
        if(root==null)
        	return;
        else
        {
        	temp=root.left;
        	root.left=root.right;
        	root.right=temp;
        	Mirror(root.left);
        	Mirror(root.right);
        }
    }
    
    public boolean IsBalanced_Solution(TreeNode root) {
        boolean[] balanced={true};
        if(root==null)
        {
            
        }
        else
            {
            GetDepth(root,balanced);
            
        }
        return balanced[0];
    }
    
    public int GetDepth(TreeNode root,boolean [] balanced)
        {
         int left=0;
         int right=0;
         //int height=0;
         if(root==null)
         {
        	 balanced[0]=true;
        	 return 0;
         }
             
        else
            {
            left=GetDepth(root.left,balanced)+1;
            if(balanced[0]==false)
                return 0;
            right=GetDepth(root.right,balanced)+1;
            if(balanced[0]==false)
                return 0;
            if(left-right>1 || right-left>1)
                {
                balanced[0]=false;
                return 0;
            }
            else
                {
                return Math.max(left,right);
            }
            
        }
    }
    //
   //
        public int Sum_Solution(int n) {
            int sum=0;
            sum=(int)(Math.pow(n, 2)+1);
            sum=sum>>1;
            return sum;
        }
        
        
        class ListNode {
            int val;
            ListNode next = null;

            ListNode(int val) {
                this.val = val;
            }
        }
        // 找出两个链表中的第一个公共节点
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        	//使用HashMap解决
        	Map<ListNode,Integer> Find=new HashMap<ListNode,Integer>();
        	ListNode cur=pHead1;
        	while(cur!=null)
        	{
        		Find.put(cur, cur.val);
        		cur=cur.next;
        	}
        	cur=pHead2;
        	while(cur!=null)
        	{
        		if(Find.containsValue(cur.val))
        		{
        			return cur;
        		}
        		else
        		{
        			cur=cur.next;
        		}
        	}
    		return null;
        }
    
	public int ReverseString(String filename) throws Exception
	{	
		//文件名
		File file=new File(filename);
		//存放读取到的所有word
		String [] str=new String[100];
		//存放单个的长度，便于筛选
		int [] wlen=new int[100];
		//判断有无访问，便于筛选
		boolean [] visited=new boolean[100];
		//存放临时word
		String temp="";
		int i=0;
		int n=0;//计数
		BufferedReader reader=null;
		try {
			reader=new BufferedReader(new FileReader(file));//读取文件
			while((temp=reader.readLine())!=null)
			{
				
				str[i]=temp;
				wlen[i]=temp.length();
				visited[i]=false;
				i++;
				if(i>=100)
				{
					reader.close();
					throw new Exception("Error: Limited Str[] Size!");
				}	
			}
			//数组中数量为i
			for(int j=0;j<i;j++)
			{
				for(int k=j+1;k<i;k++)
				{
					//当且仅当后面未访问且长度相等时比较
					if(visited[k]==false && (str[k].length()==str[j].length()))
					{
						//进行比较
						if(check(str[j].toCharArray(),str[k].toCharArray()))
						{
							visited[j]=true;
							visited[k]=true;
							n++;
						}
					}
				}
			}
			System.out.println("the number is "+n);
			//reader.close();
			//return n;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			//
			System.out.println(""+e.getMessage());
			e.printStackTrace();
		} finally
		{
			reader.close();
			//return n;
		}
		return n;
		
	}
	
	//判断单个是否为逆序
	boolean check(char [] str1,char [] str2)
	{
		//boolean flag=false;
		int len=str1.length;
		for(int i=0;i<str1.length;i++)
		{
			if(str1[i]!=str2[len-1-i])
			{
				return false;
			}
		}
		return true;
	}
	
	//二叉树链表的打印
	 class Solution {
	    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
	    		//采用队列链表的方式依次进行层次遍历
	    		//需要使用对应的Queue队列来实现
	    		ArrayList<ArrayList<Integer>> result =new ArrayList<ArrayList<Integer>>();
	    		if(pRoot==null)
	    			return result;
	    		//将对应节点保存起来，依次完成层次遍历
	    		Queue<TreeNode> layer=new LinkedList<TreeNode>();
	    		ArrayList<Integer> layerList=new ArrayList<Integer>();
	    		layer.add(pRoot);
	    		int start=0,end=1;
	    		while(!layer.isEmpty())
	    		{
	    			//边将每一层的值和节点取出
	    			//同时对应把下一层的节点输入进去
	    			TreeNode cur=layer.remove();
	    			layerList.add(cur.val);
	    			start++;
	    			//将该节点对应的加入下一层，其实已是下一层的东西
	    			if(cur.left!=null)
	    			{
	    				layer.add(cur.left);
	    			}
	    			if(cur.right!=null)
	    			{
	    				layer.add(cur.right);
	    			}
	    			//表示该层已经遍历结束
	    			if(start==end)
	    			{
	    				//第二次赋值为第二层的长度
	    				//end为每次的长度
	    				end=layer.size();
	    				start=0;
	    				result.add(layerList);
	    				layerList=new ArrayList<Integer>();
	    			}
	    		}
	    	
				return result;
	    			
	    }
	    
	}
	
	
	//二维数组查找
	  public boolean Find(int [][] array,int target) {
		  		int left=0;
		  		int right=0;
		  		int mid=0;
				for(int []row : array)
				{
					if(row[row.length-1]<target && row[0]>target)
						continue;
					else
					{
						//内部可以变换成二分查找
						//设定对应的边界
						left=0;
						right=row.length-1;
						mid=right/2+1;
						while(left<=right)
						{
							//如果是在左边
							if(row[mid]==target)
							{
								return true;
							}
							else if(row[mid]>target)
							{
								right=mid;
								mid=(right-left)/2+1+left;
								
							}
							else
							{
								left=mid+1;
								mid=(right-left)/2+1+left;
							}
						}
					}
				}
				return false;
	
	  }
	
	
//	  public String replaceSpace(StringBuffer str) {
//	    	
//	    }
	
	  //矩形查找
	  public int RectCover(int target) {
		  	//其本质与斐波那契额数列相同
		  	//排除前项
		   if(target==0)
			   return 0;
		   else if(target==1)
			   return 1;
		   else if(target==2)
			   return 2;
		   else
			   return RectCover(target-1)+RectCover(target-2);
			   
		  
	    }
	
class StackTest {

		    
		    Stack<Integer> stest=new Stack<Integer>();
		    int min=0;
		    public void push(int node) {
		    	if(node<=min)
		    	{
		    		min=node;
		    	}
		        stest.push(node);
		    }
		    
		    public void pop() {
		        if(stest.pop()==min)
		        {
		        	min=stest.peek();
		        	 for(int x : stest)
				        {
				        	if(x<=min)
				        		min=x;
				        }
		        }
		       
		    }
		    
		    public int top() {
		    	//peek 不会移除元素
		        return stest.peek();
		    }
		    
		    public int min() {
		        return min;
		    }
		}
	  
//	替换空格
		public String replaceSpace(StringBuffer str) {
//			int i=0;
//			int len=str.length();
//			for(i=0;i<len;i++)
//			{
//				if(str.charAt(i)==' ')
//				{
//					str.deleteCharAt(i);
//					str.
//				}
//			}
			//return str.toString().replaceAll("\\s", "%20");
			//分成两种，重新遍历数组后赋值
			char [] before=str.toString().toCharArray();
			StringBuffer after=new StringBuffer();
			for(int i=0;i<before.length;i++)
			{
				if(before[i]==' ')
				{
					after.append("%20");
				}
				else
				{
					after.append(before[i]);
				}
			}
			return after.toString();
			
			
		}
		
		//连续子数组的最大和
		public int FindGreatestSumOfSubArray(int[] array) {
	        int len=array.length;
	        if(len==0)
	        	return 0;
	        int bef=array[0];
	        int temp=bef;
	        int max=bef;
//	        for(int i=0;i<len;i++)
//	        {
//	        	temp=array[i];
//	        	bef=array[i];
//	        	for(int j=i+1;j<len;j++)
//	        	{
//	        		temp+=array[j];
//	        		//temp+=i;
//		        	if(temp>bef)
//		        		bef=temp;
//	        	}
//	        	if(bef>max)
//	        	{
//	        		max=bef;
//	        	}
//	        	
//	        }
//	        return max;
	        
	        //采用动态规划思想来分析
	        //首先如果前面的和已经得到小于0肯定舍掉不用
	        int sum=array[0],tempsum=array[0];
	        for(int i=1;i<array.length;i++)
	        {
	        	//如果当前值小于0，表明从前面得到的结果或延续下去是没有意义的
	        	//因为此时不会给总和带来成长，所以要重新开始计数
	        	//故此时应该从array[i] 开始
	        	tempsum=(tempsum<0) ?array[i] :tempsum+array[i];
	        	sum=(tempsum>sum) ?tempsum :sum;
	        }
	        return 1;
	        
	    }

		//统计数字在排序数组中出现的次数
		public int GetNumberOfK(int [] array , int k) {
			//重新写，二分查找
//			//书上的例子
//			int left=0,right=array.length-1;
//			int last=-1;
//			while(left<=right)
//			{
//				int mid=(left+right)/2;
//				if(array[mid]<k)
//				{
//					left=mid+1;
//				}
//				else if(array[mid]>k)
//				{
//					right=mid-1;
//				}
//				else
//				{
//					last=mid;
//					
//				}
//			}
			

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//		       int len=array.length;
//		       if(len==0)
//		    	   return 0;
//		       int sum=0;
//		       int flag=0;
//		       for(int i=0;i<len;i++)
//		       {
//		    	   if(array[i]==k)
//		    	   {
//		    		   sum++;
//		    		   flag=1;
//		    	   }
//		    		  
//		    	   if(array[i]!=k && flag==1)
//		    		   break;
//		       }
//		       return sum;
		       
		       
		       
		       
		       
		       
		       
		       //情况考虑不全
		       //先用最简单的来实现
//		       for(int i=0;i<len;i++)
//		       {
//		    	   if(array[i]==k)
//		    	   {
//		    		   
//		    		   first=i;
//		    		   break;
//		    	   }
//		    	   
//		       }
//		       for(int i=first;i<len;i++)
//		       {
//		    	   if(array[i]==k)
//		    	   {
//		    		   last=i;
//		    		   
//		    	   }
//		       }
//		       return last-first;
			if(array==null || array.length==0)
				return 0;
			int t=getFirst(array,0,array.length-1,k);
			if(t!=-1)
				return getLast(array,0,array.length-1,k)-t+1;
			return 0;

	    }
	  
	int getFirst(int [] array, int s,int e,int k)
	{
			if(s>=e)
				return array[s]==k ?s:-1;
			int m=(s+e)/2;
			if(array[m]<k)
				return getFirst(array,m+1,e,k);
			else
				return getFirst(array,s,m,k);
			
	}
	
	int getLast(int [] array,int s,int e,int k){
		if(s>=e){
			if(array[s]==k)
				return s;
			return array[s-1]==k? s-1:-1;
			
		}
		int  m=(s+e)/2;
		if(array[m] <=k)
			return getLast(array,m+1,e,k);
		else
			return getLast(array,s,m,k);
	}
	//判断二叉树对称
	boolean isSymmetrical(TreeNode pRoot)
    {
		//其实为判断翻转二叉树与对应的二叉树相同的变种
		//首先实现函数翻转二叉树
//		TreeNode tempRoot=pRoot;
//		TreeNode RRoot=ReverseBinaryTree(tempRoot);
//		//翻转二叉树后由于原来为树结构，所以把原有的树也翻转了
//		//再多加一个即可
//		
//		System.out.println(pRoot.val+","+pRoot.left.val+","+pRoot.right.val);
//		System.out.println(RRoot.val+","+RRoot.left.val+","+RRoot.right.val);
//		//实现函数判断二叉树是否相同
//		return IsSameTree(pRoot,RRoot);
		
//        if(pRoot==null)
//        	return true;
//        else if(pRoot.left.val!=pRoot.right.val)
//        	return false;
//        else
//        	return isSymmetrical(pRoot.left) && isSymmetrical(pRoot.right);
		
		
		
		//同之前想的一样，为比较同一棵树的左和右，不做修改，递归
		if(pRoot==null)
			return true;
		else
			return comRoot(pRoot.left,pRoot.right);
		
    }
		boolean comRoot(TreeNode left,TreeNode right)
		{
			if(left==null && right==null)
				return true ;
			else if(left==null || right==null)
				return false;
			else if(left.val!=right.val)
				return false;
			else 
				return (comRoot(left.right,right.left) && comRoot(left.left,right.right));
			
		}
	
	
	TreeNode ReverseBinaryTree(TreeNode pRoot)
	{
		TreeNode temp;
		if(pRoot==null)
			return null;
		else
		{
//			temp=pRoot.left;
//			pRoot.left=pRoot.right;
//			pRoot.right=temp;
			
			temp=ReverseBinaryTree(pRoot.left);
			pRoot.left=ReverseBinaryTree(pRoot.right);
			pRoot.right=temp;
			return pRoot;
		}
		
	}
	
//	boolean IsSameTree(TreeNode Root1,TreeNode Root2)
//	{
//		if(Root1==null && Root2==null)
//			return true;
//		else if(Root1==null || Root2==null)
//			return false;
//		else
//		{
//			if(Root1.val!=Root2.val)
//				return false;
//			else
//				return (IsSameTree(Root1.left,Root2.left) && IsSameTree(Root1.right,Root2.right));
//		}
//		
//	}
	
	//输入一个链表，从尾部到头打印
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> temp=new Stack<Integer>();
        ArrayList<Integer> result =new ArrayList<Integer> ();
        //判断空值
        if(listNode==null)
        	return result;
        //判断是否为空
        while(listNode!=null)
        {
        	temp.push(listNode.val);
        	listNode=listNode.next;
        }
        while(!temp.isEmpty())
        {
        	result.add(temp.pop());
        }
		return result;
    }
	
	//查找两个数，使其和正好为S
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        HashMap <Integer,Integer> temp=new HashMap<Integer,Integer>();
        ArrayList<Integer> result=new ArrayList<Integer>();
        int multi=0;
		if(array==null)
        	return null;
		//判断其中的数
		for(int x: array)
		{
			//超过sum，退出
			if(x>sum)
				break;
			//System.out.println(x+" ");
			//System.out.println(temp.containsValue(x));
			if(temp.containsValue(x))
			{
				//肯定后面发现的x更大
				//发现和相同且乘积小的，存入，并释放更新元素
				
				if(multi!=0 && multi>x*(sum-x))
				{
					multi=x*(sum-x);
					result.clear();
					
					result.add(sum-x);
					result.add(x);
					//System.out.println(x+" ");
				}
				else
				{
					multi=x*(sum-x);
					result.add(sum-x);
					result.add(x);
				}
			}
			//每次都存值，判断
			temp.put(x, sum-x);
			
		}
		for (Map.Entry<Integer,Integer> pair:temp.entrySet())
		{
			System.out.println(pair.getKey()+":"+pair.getValue());
		}
		if(temp.isEmpty())
			return null;
		return result;
		
//		//自己写
//		int i=0,j=array.length-1,flag=-1;
//		ArrayList<Integer> a1=new ArrayList<Integer>();
//		if(a==null || a.length==0) return a1;
//		while(i!=j)
//		{
//			if(a[i]+a[j]==sum)
//			{
//				a1.add(a[i]);
//				a1.add(a[j]);
//				return a1;
//			}
//			else if(flag==-1) i++;
//			else if(flag==1) j--;
//			flag=flag*-1;
//			
//		}
//		 while(i < j && a[i] + a[j] > sum) --j;
//         while(i < j && a[i] + a[j] < sum) ++i;
//		return a1;
//		交替缩进寻找

		
	}
	
	//寻找数组中的逆序对
	public int InversePairs(int [] array) {
		//会有跨越的情况发生
		int sum=0;
		
		if(array==null || array.length==0)
			return sum;
        for(int i=0;i<array.length-1;i++)
        {
        	for(int j=i+1;j<array.length;j++)
        	{
        		if(array[j]<array[i])
        			sum++;
        	}
        }
        return sum;
        
    }
	
	
	class Test
	{
		HashMap<Character,Integer> temp=new HashMap<Character,Integer>();
		
		//输出字符流中第一个只出现一次的ch
		//Insert one char from stringstream
		ArrayList <Character> result=new ArrayList<Character>();
	    public void Insert(char ch)
	    {
	        if(temp.containsKey(ch))
	        {
	        	temp.put(ch, temp.get(ch)+1);
	        	//result.remove(ch);
	        }  	
	        else
	        {
	        	temp.put(ch, 1);
	        	//result.add(ch);
	        }
	        result.add(ch);
	        	
	    }
	  //return the first appearence once char in current stringstream
	    public char FirstAppearingOnce()
	    {
	    	char ch='#';
	    	for(char key : result)
	    	{
	    		if(temp.get(key)==1)
	    		{
	    			ch=key;
	    			break;
	    		}	    			
	    	}
	    	return ch;
	    }
		
	}
	//从上到下打印二叉树节点
	 public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		 //Queue需要使用LinkedList来实现
	        Queue<TreeNode> tree=new LinkedList<TreeNode>();
	        ArrayList<Integer> result=new ArrayList<Integer>();
	        TreeNode cur;
	        int start=0;
	        int end=1;
	        if(root==null)
	        	return result;
	        tree.add(root);
	        
	        while(!tree.isEmpty())
	        {        	
	        	//System.out.println(root.val+",");
	        	cur=tree.remove();
	        	result.add(cur.val);
	        	if(cur.left!=null)
	        		tree.add(cur.left);
	        	if(cur.right!=null)
	        		tree.add(cur.right);
	        	
	        	start++;
	        	if(start==end)
	        	{	        		
	        		end=tree.size();
	        		start=0;
	        	}
	        }
	        return result;		 
	    }
	
	 //两个单调链表进行合并
	 public ListNode Merge(ListNode list1,ListNode list2) {
//	     ListNode temp=new ListNode(1);
//	     ListNode head;
//	     head=temp;
//	     while(list1!=null && list2!=null)
//	     {
//	    	 if(list1.val<=list2.val)
//	    	 {
//	    		 //这里错了，因为错在交换顺序和指针上
//	    		 //对应会把链表变成循环的，不再是指针形式的东西。
//	    		 //所以会错误，输出不正确
//	    		 //此外错误在于引用上，顺序赋值有错，导致对应关系错误
//	    		 //重新修改
//	    		 temp.next=list1;
//	    		 list1=list1.next;
//	    		 temp=temp.next;
//	    	 }
//	    	 else
//	    	 {
//	    		 temp.next=list2;
//	    		 list2=list2.next;
//	    		 temp=temp.next;	    		
//	    	 }
//	     }
//	     if(list1!=null)
//	     {
//	    	 temp.next=list1;
//	     }
//	     if(list2!=null)
//	     {
//	    	 temp.next=list2;
//	     }
//	     
//	     return head.next;
//	     
		 
		 //再写一个递归实现的函数
		 ListNode head=null;
		 if(list1==null)
			 return list2;
		 if(list2==null)
			 return list1;
		 if(list1.val<=list2.val)
		 {
			 head=list1;
			 list1=list1.next;
			 head.next=Merge(list1, list2);
		 }
		 else
		 {
			 head=list2;
			 list2=list2.next;
			 head.next=Merge(list1,list2);
		 }
		 return head;
	}
	
	
	
	public void test(ListNode list1)
	{
		list1=list1.next;
		System.out.println("t:"+list1.val);
		//System.out.println("t:"+list1.next.val);
	}
	
	//输出旋转数组的最小元素
	public int minNumberInRotateArray(int [] array) {
	    if(array==null || array.length==0)
	    	return 0;
		Arrays.sort(array);
	    return array[0];
    }
	
	//输出链表的翻转
	public ListNode ReverseList(ListNode head) {
		ListNode end=null;
//		if(head==null)
//			return end;
//		else
//		{
//			end=head;
//			head=head.next;
//			end.next=ReverseList(head);
//		}
//		return end;
		//上面的是复制链表 不太对
//		Stack<ListNode> result=new Stack<ListNode>();
//		ListNode end=new ListNode(1);
//		ListNode cur=null;
//		cur=end;
//		if(head==null)
//			return end.next;
//		while(head!=null)
//		{
//			result.add(head);
//			head=head.next;
//		}
//		while(!result.isEmpty())
//		{
//			cur.next=result.pop();
//			cur=cur.next;
//		}
//		cur.next=null;//末尾节点赋值为空，否则会成为循环
		return end.next;
		//其实更简单的是直接加一个前驱和后继，再赋值
//		ListNode pre=null;
//		ListNode next=null;
//		while(head!=null)
//		{
//			//先获取当前节点下一个节点保存
//			next=head.next;
//			//令当前节点指向前一个节点
//			head.next=pre;
//			//令当前节点成为下一个的前节点
//			pre=head;
//			//换成下一个节点
//			head=next;
//			
//		}
		
		
		
		
		
    }
	
	//调整数组中奇数和偶数的位置
	public void reOrderArray(int [] array) {
        ArrayList<Integer> odd=new ArrayList<Integer>();
        ArrayList<Integer> even=new ArrayList<Integer>();
        if(array==null || array.length==0)
        	return;
        for(int i=0;i<array.length;i++)
        {
        	if(array[i]%2==0)
        		even.add(array[i]);
        	else
        		odd.add(array[i]);
        }
        odd.addAll(even);
        for(int i=0;i<array.length;i++)
        {
        	array[i]=odd.get(i);
        	
        }
		
    }
	
	//输出链表中倒数第k个节点
	//此处可以用双指针法
	//通过第一个指针与第二个指针之间相差为k
	//当第二个指针到尾部时，第一个指针指向的是为对应倒数第k个
	//然后也可以判断大小和越界
	public ListNode FindKthToTail(ListNode head,int k) {
		//用堆栈实现
		ArrayList<ListNode> end=new ArrayList<ListNode>();
		ListNode result=null;
		if(head==null)
			return null;
		//边界问题
	
		while(head!=null)
		{
			end.add(head);
			head=head.next;
		}
		if(k>end.size() || k<=0)
			return result;
		else
			return end.get(end.size()-k);
    }

	//数值的乘方
	public double Power(double base, int exponent) {
		double result=1;
        if(exponent==0)
        	return 1;
        else if(exponent>0)
        {
        	while(exponent>0)
        	{
        		result=result*base;
        		exponent--;
        	}
        }
        else//exponent<0
        {
        	while(exponent<0)
        	{
        		result=result/base;
        		exponent++;
        	}
        }
        return exponent;
	  }
	
	//顺时针打印矩阵
	public ArrayList<Integer> printMatrix(int [][] matrix) {
		ArrayList<Integer> result=new ArrayList<Integer>();
	    if(matrix==null || matrix.length==0)
	    	return result;
	    //else if
		int height=matrix.length;
	    int width=matrix[0].length;//length取第0个
	    int i=0;//作为初始的指针值变量
	    //边界条件肯定是对应的最短长度的一半，上取整
	    double end=Math.ceil((double)Math.min(height, width)/2);
	    //System.out.println("end"+end);
	    //结束条件是小于
	    //对应要判断是否相同
	    //四条边分别为
	    //i,width-1-i,height-1-i,i
	    while(i<end)
	    {
	    	//共分为上下左右四层，四个循环,在这里我们取每次打印宽或高的长度减1
	    	//起点总是左上角的点i,i
	    	//打印从左到右
	    	//容易发现其中的对称结构，用于检查
	    	//第一次输出整行，后面调整，防止出错
	    	//System.out.println("end"+i);
	    	//尽量保证都不会有+-1的情况，只是进行单纯的操作，防止越界
	    	for(int j=i;j<width-i;j++)
	    	{
	    		result.add(matrix[i][j]);//对应添加的是第i行，第j列
	    		//System.out.println("e1:"+matrix[i][j]);
	    	}
	    	//对应第二个少输出一个元素，少输出一次
	    	//不能多加1.因为可能会出错，越界
	    	//System.out.println("i:"+i);
	    	//if()
	    	//下面所有都加判断是为了保证由于新的循环赋值操作越界
	    	for(int j=i+1;j<height-i;j++)
	    	{
	    		//仅这里可能出现越界
	    		if(j<height-i)
	    		{
	    			result.add(matrix[j][width-1-i]);
//	    			System.out.println("e2:"+matrix[j][width-1-i]);
	    		}
	    		else
	    			break;
	    		//System.out.println("e2"+matrix[i][j]);
	    	}
	    	for(int j=width-2-i;(j>=i)&&(height-1-i)!=i;j--)
	    	{
	    		result.add(matrix[height-1-i][j]);
//	    		System.out.println("e3:"+matrix[height-1-i][j]);
	    		//System.out.println("e3"+matrix[i][j]);
	    	}
	    	for(int j=height-2-i;(j>i)&& (width-1-i)!=i;j--)
	    	{
	    		result.add(matrix[j][i]);
//	    		System.out.println("e4:"+matrix[j][i]);
	    		//System.out.println("e4"+matrix[i][j]);
	    	}
	    	//判断是否重复
	    	i++;
	    }
	    return result;
    }
	
	//重建二叉树
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		TreeNode root=reConstrcutBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
		return root;
    }
	
	private TreeNode reConstrcutBinaryTree(int [] pre,int starPre,int endPre,int [] in,int starIn,int endIn) {
		// TODO Auto-generated method stub
		//TreeNode root=null;
		//因为后面有递增，防止越界
        if(pre==null || starPre>endPre)
        	return null;
        if(in==null || starIn>endIn)
        	return null;
        TreeNode root=new TreeNode(pre[starPre]);
        int index=-1;
        for(int i=starIn;i<=endIn;i++)
        {
        	if(in[i]==pre[starPre])
        	{
        		index=i;
        		break;
        	}
        }
        // 用数组实现后面的序号就不一样了
        if(index>starIn)//表明此时有左孩子
        {
        	root.left=reConstrcutBinaryTree(pre,starPre+1,index-starIn+starPre,in,starIn,index-1);
        	
        }
        if(index<endIn)
        {
        	root.right=reConstrcutBinaryTree(pre, index+starPre-starIn+1, endPre, in, index+1, endIn);
        	
        }
        return root;
	}

	
	
	// Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
	//返回数组中重复的元素
    public boolean duplicate(int numbers[],int length,int [] duplication) {
    	//duplication[0]=0;
    	if(length==0 || numbers==null || numbers.length==0)
    		return false;
    	int[] temp =new int[length];
    	int flag=0;
    	int n=0;
    	for(int i=0;i<length;i++)
    	{
    		//空间换时间
    		temp[numbers[i]]++;
    		if(temp[numbers[i]]>1)
    		{
    			flag=1;
    			n=numbers[i];
    			break;
    		}
    	}
    	if(flag==1)
    	{
    		duplication[0]=n;
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
	
	
//    一、1的数目
//
//    编程之美上给出的规律：
//
//    1. 如果第i位（自右至左，从1开始标号）上的数字为0，则第i位可能出现1的次数由更高位决定（若没有高位，视高位为0），等于更高位数字X当前位数的权重10i-1。
//
//    2. 如果第i位上的数字为1，则第i位上可能出现1的次数不仅受更高位影响，还受低位影响（若没有低位，视低位为0），等于更高位数字X当前位数的权重10i-1+（低位数字+1）。
//
//    3. 如果第i位上的数字大于1，则第i位上可能出现1的次数仅由更高位决定（若没有高位，视高位为0），等于（更高位数字+1）X当前位数的权重10i-1。
//
//    二、X的数目
//
//    这里的 X∈[1,9]，因为 X=0 不符合下列规律，需要单独计算。
//
//    首先要知道以下的规律：
//
//    从 1 至 10，在它们的个位数中，任意的 X 都出现了 1 次。
//    从 1 至 100，在它们的十位数中，任意的 X 都出现了 10 次。
//    从 1 至 1000，在它们的百位数中，任意的 X 都出现了 100 次。
//    依此类推，从 1 至 10i，在它们的左数第二位（右数第 i 位）中，任意的 X 都出现了 10i−1 次。
//
//    这个规律很容易验证，这里不再多做说明。
//
//    接下来以 n=2593,X=5 为例来解释如何得到数学公式。从 1 至 2593 中，数字 5 总计出现了 813 次，其中有 259 次出现在个位，260 次出现在十位，294 次出现在百位，0 次出现在千位。
//
//    现在依次分析这些数据，首先是个位。从 1 至 2590 中，包含了 259 个 10，因此任意的 X 都出现了 259 次。最后剩余的三个数 2591, 2592 和 2593，因为它们最大的个位数字 3 < X，因此不会包含任何 5。（也可以这么看，3<X，则个位上可能出现的X的次数仅由更高位决定，等于更高位数字（259）X101-1=259）。
//
//    然后是十位。从 1 至 2500 中，包含了 25 个 100，因此任意的 X 都出现了 25×10=250 次。剩下的数字是从 2501 至 2593，它们最大的十位数字 9 > X，因此会包含全部 10 个 5。最后总计 250 + 10 = 260。（也可以这么看，9>X，则十位上可能出现的X的次数仅由更高位决定，等于更高位数字（25+1）X102-1=260）。
//
//    接下来是百位。从 1 至 2000 中，包含了 2 个 1000，因此任意的 X 都出现了 2×100=200 次。剩下的数字是从 2001 至 2593，它们最大的百位数字 5 == X，这时情况就略微复杂，它们的百位肯定是包含 5 的，但不会包含全部 100 个。如果把百位是 5 的数字列出来，是从 2500 至 2593，数字的个数与百位和十位数字相关，是 93+1 = 94。最后总计 200 + 94 = 294。（也可以这么看，5==X，则百位上可能出现X的次数不仅受更高位影响，还受低位影响，等于更高位数字（2）X103-1+（93+1）=294）。
//
//    最后是千位。现在已经没有更高位，因此直接看最大的千位数字 2 < X，所以不会包含任何 5。（也可以这么看，2<X，则千位上可能出现的X的次数仅由更高位决定，等于更高位数字（0）X104-1=0）。
//
//    到此为止，已经计算出全部数字 5 的出现次数。
//
//    总结一下以上的算法，可以看到，当计算右数第 i 位包含的 X 的个数时：
//
//    取第 i 位左边（高位）的数字，乘以 10i−1，得到基础值 a。
//    取第 i 位数字，计算修正值：
//    如果大于 X，则结果为 a+10i−1。
//    如果小于 X，则结果为 a。
//    如果等 X，则取第 i 位右边（低位）数字，设为 b，最后结果为 a+b+1。
//    相应的代码非常简单，效率也非常高，时间复杂度只有 O(log10n)。
	//求1出现的次数
    //可以求所有数字出现的次数
    
    public int NumberOf1Between1AndN_Solution(int n) {
//    	int sum=0;
//    	//明显采用递归来做
////    	s
////        for(int i=0;i<=n;i++)
////        {
////        	if(i%10==1)
////        	{
////        		sum++;
////        		//System.out.println(i+","+(i/10)%10);
////        	}
////        	if((i/10)%10==1)
////        		sum++;
////        		
////        }
//    	if(n==0)
//    		return 0;
//    	else if(n/10>1)
//    	{
//    		
//    	}
//    	else
//    	{
//    		if(n%10==1)
//    			return 1;
//    	}
//        return sum;
    	
    	if(n<0)
    		return 0;
    	int high,low,curr,tmp,i=1;
    	high=n;
    	int total=0;
    	while(high!=0)
    	{
    		high=n/(int)Math.pow(10, i);//取第i位的高位
    		tmp=n%(int)Math.pow(10, i);//取余数
    		curr=tmp/(int)Math.pow(10, i-1);//取第i位
    		low=tmp%(int)Math.pow(10, i-1);//取第i位的低位
    		if(curr==1)
    			total+=high*(int)Math.pow(10, i-1)+low+1;
    		else if(curr<1)
    		{
    			total+=high*(int)Math.pow(10, i-1);
    		}
    		else
    		{
    			total+=(high+1)*(int)Math.pow(10, i-1);
    		}
    		i++;
    	}
    	return total;
    }
	
    //判断是否为子树
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2==null)
        	return true;
        if(root1==null && root2!=null)
        	return false;
        boolean flag=false;
        if(root1.val==root2.val)
        {
        	flag=IsSubTree(root1,root2);
        	if(!flag)
        	{
        		flag=IsSubTree(root1.left,root2);
        		if(!flag)
        		{
        			flag=IsSubTree(root1.right,root2);
//        			if(!flag)
//        				return false;
        		}
        	}
        }
        return flag;
    }
    
    public boolean IsSubTree(TreeNode root1,TreeNode root2){
    	//SubTree 与SameTree 不同，可以包括
    	if(root2==null) 
    		return true;
    	if(root1==null && root2!=null) 
    		return false;
    	if(root1.val==root2.val)
    		return IsSubTree(root1.left,root2.left) && IsSubTree(root1.right,root2.right);
    	else
    		return false;
    		
    	
    }
    
    //找到第一个只出现一次的字符的位置
    public int FirstNotRepeatingChar(String str) {
    	char[] data=str.toCharArray();
    	if(data.length==0)
    		return -1;
    	HashMap<Character,Integer> result=new HashMap<Character,Integer>();
    	for(int i=0;i<data.length;i++)
    	{
    		if(result.containsKey(data[i]))
    		{
    			result.put(data[i], data.length);
    		}
    		else
    		{
    			result.put(data[i], i);
    		}
    	}
    	int index=data.length;
    	for(Map.Entry<Character, Integer> pair : result.entrySet())
    	{
    		if(pair.getValue()<index)
    		{
    			index=pair.getValue();
    		}
    	}
    	if(index<data.length)
    		return index;
    	else
    		return -1;
    }
    
    //数组中超过次数一半的元素
    public int MoreThanHalfNum_Solution(int [] array) {
        int len=array.length;
        if(len==0)
        	return 0;
        Arrays.sort(array);
        int temp=array[len/2];
        int sum=0;
        for(int i=0;i<len;i++)
        {
        	if(array[i]==temp)
        		sum++;
        }
        if(sum>len/2)
        	return temp;
        else
        	return 0;
    }
    
    
    //输出所有和为S的连续正数序列
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<Integer> temp=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(sum<0)
        	return result;
        if(sum==0)
        {
        	temp.add(0);
        	result.add(temp);
        }
        //double S=(double)sum;
        int t1=0;
        int t2=0;
        int i=1;
        
        //抽象由一元二次方程得结果
        for(int n=2;n<sum;n++)
        {
        	t1=2*n;
        	t2=2*sum+n-n*n;
        	if(t2<t1)
        		break;
        	//System.out.println(t2+","+t1);
        	if(t2%t1==0)//表明起始值存在
        	{
        		i=t2/t1;//起始的第一个值
        		//清空当前值
        		temp=new ArrayList<Integer>();
        		//依次将对应值放入
        		for(int j=0;j<n;j++)
        		{
        			temp.add(i);
        			//System.out.println(i);
        			i++;
        		}
        		//System.out.println(temp);
        		result.add(0, temp);
        		//System.out.println(result);
        	}
        	
        }
        return result;
    }
    
    
    //给出栈的压入顺序，判断是否为栈的弹出顺序
    public boolean IsPopOrder(int [] pushA,int [] popA) {
    	//每次push和pop时依次判断对应是否当前堆栈可以pop
    	//如果可以pop则pop
    	//判断最后是否原堆栈为空
        Stack<Integer> temp=new Stack<Integer>();
        if(pushA.length==0 || pushA==null)
        	return false;
        if(popA.length==0 || popA==null)
        	return false;
        int j=0;
        //重点在于判断和轮询
        for(int i=0;i<pushA.length;i++)
        {
        	temp.add(pushA[i]);
        	while(!temp.isEmpty() && temp.peek()==popA[j])
        	{
        		temp.pop();
        		j++;
        	}
        }
        return temp.isEmpty();
    }
    
    
    //判断是否为二叉搜索树后序遍历
//    BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，那么T满足：
//    T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。完美的递归定义 : ) 。
    public boolean VerifySquenceOfBST(int [] sequence) {
        //采用递归来实现，其中分解最后一个数肯定是根，位于中间节点上，然后再分解递归前面的
    	if(sequence==null || sequence.length==0)
    		return false;
    	//最后一个是根节点
    	int len=sequence.length;
    	int root=sequence[len-1];
    	int index=0;
    	for(int i=0;i<len-1;i++)
    	{
    		//中间节点，必须保证前面的都比root小
    		//后面的都比root大
    		if(sequence[i]>root)
    		{
    			index=i;//获取划分的中间节点位置
    			for(int j=i;j<len-1;j++)
    			{
    				if(sequence[j]<root)
    					return false;
    			}
    			break;
    		}
    	}
    	boolean left=true;
    	boolean right=true;
    	if(index>0)
    		left=VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, index));
    	if(index<len-1)
    		right=VerifySquenceOfBST(Arrays.copyOfRange(sequence, index, len-1));
    	return left&&right;
    	
    }
    
    
  //非递归 
  //非递归也是一个基于递归的思想：
  //左子树一定比右子树小，因此去掉根后，数字分为left，right两部分，right部分的
  //最后一个数字是右子树的根他也比左子树所有值大，因此我们可以每次只看有子树是否符合条件
  //即可，即使到达了左子树左子树也可以看出由左右子树组成的树还想右子树那样处理
   
  //对于左子树回到了原问题，对于右子树，左子树的所有值都比右子树的根小可以暂时把他看出右子树的左子树
  //只需看看右子树的右子树是否符合要求即可
//  class Solution {
//  public:
//      bool VerifySquenceOfBST(vector<int> sequence) {
//          int size = sequence.size();
//          if(0==size)return false;
//   
//          int i = 0;
//          while(--size)
//          {
//              while(sequence[i++]<sequence[size]);
//              while(sequence[i++]>sequence[size]);
//   
//              if(i<size)return false;
//              i=0;
//          }
//          return true;
//      }
//  };
    
    //二叉树中和为某一值的路径
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        //基础方法，遍历所有路径，求解
    	ArrayList<Integer> temp=new ArrayList<Integer>();
    	ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    	ArrayList<ArrayList<Integer>> left=new ArrayList<ArrayList<Integer>>();
    	ArrayList<ArrayList<Integer>> right=new ArrayList<ArrayList<Integer>>();
    	if(root==null)
    		return result;
    	//递归即可，否则需迭代
//    	TreeNode 
//    	while()
//    	{
//    		
//    	}
    	//递归实现
    	//System.out.println("right"+root.right!=null);
    	//System.out.println(root.val+"=="+target);
    	if(root.val==target && root.left==null && root.right==null)
    	{
    		temp=new ArrayList<Integer>();
    		temp.add(root.val);
    		result.add(temp);
//    		System.out.println("result"+result);
    	}
    	//else if 互斥！！！！！！！！！！！！！！！！！！！！！！
    	//所以不行！！！！！！！！！！！！！！！！！！！！！！！！！！！
    	if(root.left!=null)
    	{
    		//递归再次调用
//    		System.out.println("left"+":");
    		left=FindPath(root.left, target-root.val);
//    		System.out.println(left);
    		if(left!=null)
    		{
    			//如果有遍历下一层中所有节点，再汇总数据
    			for(ArrayList<Integer> pair : left)
    			{
    				temp=new ArrayList<Integer>();
    	    		temp.add(root.val);
    				for(int x : pair)
    				{
    					temp.add(x);
    				}
    				result.add(temp);
    				//System.out.println("left"+":"+root.left.val);
    			}
    		}
    	}
    	//else if 互斥 所以不行
    	if(root.right!=null)
    	{
    		//递归再次调用
//    		System.out.println("right"+":");
    		right=FindPath(root.right, target-root.val);
//    		System.out.println(right);
    		if(right!=null)
    		{
    			//如果有遍历下一层中所有节点，再汇总数据
    			for(ArrayList<Integer> pair : right)
    			{
    				temp=new ArrayList<Integer>();
    	    		temp.add(root.val);
    				for(int x : pair)
    				{
    					temp.add(x);
    				}
    				result.add(temp);
    			}
    		}
    	}
    	return result;
    }
    
    
    
    
    //输出最小的n个数
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        //解决法
    	ArrayList<Integer> result=new ArrayList<Integer>();
    	if(input==null || input.length==0)
    		return result;
    	Arrays.sort(input);
    	if(k>input.length)
    		return result;
    	for(int i=0;i<k;i++)
    	{
    		result.add(input[i]);
    	}
    	return result;
    	
    	//使用简单选择排序或者对应冒泡排序也可以
    }
    
    //桶排序对应生成一个新的堆，无穷大数组，然后将下标值付给对应数组值，然后为默认值的不输出，即可得所有的k个
    //循环左移字符串
    public String LeftRotateString(String str,int n) {
    	String result=str;
        if(str==null)
        	return result;
        char[] temp=new char[str.length()];
        for(int i=0;i<temp.length;i++)
        {
        	temp[i]=str.charAt((i+n)%str.length());
        	System.out.println(temp[i]);
        }
        //char转string
        //copyValueOf
        result=String.copyValueOf(temp);
        return result;
        //直接substring
//        int len = str.length();
//        if(len == 0) return "";
//        n = n % len;
//        str += str;
//        return str.substr(n, len);
        
    }
    
    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    
    //复杂链表的复制
    public RandomListNode Clone(RandomListNode pHead)
    {
//        RandomListNode temp=pHead;
//        //System.out.println("pHead:"+pHead.label);
//        if(pHead==null)
//        	return temp;
//        RandomListNode cur;
//        cur=pHead.next;
//        RandomListNode Rnd;
//        Rnd=pHead.random;
//        //System.out.println(cur.label+" "+Rnd.label);
//        //System.out.println(cur.label+" "+Rnd.label);
//        temp.random=Rnd;
//        Rnd=pHead;
//        while(cur!=null)
//        {
//        	temp.next=cur; 	
//        	temp=cur;
//        	cur=cur.next;
//        }
//        return Rnd;
        //空指针，不太懂
        //
//    	HashMap<RandomListNode,RandomListNode> map=new HashMap<RandomListNode,RandomListNode>();
//    	RandomListNode
    	//链表复制表明的是重新生成一个新链表，不再管其他的
    	//重写
    	
    	//复杂链表的复制问题在于重复性
    	//即我通过.next生成的一个新的节点，可能已经在前面的某个节点，通过random方法生成过
    	//所以其实不好做关联
    	//方法1通过Map方法实现，然后将对应.next更新一遍后再更新.random
    	//方法2是先复制，每个节点后面是自己新节点的复制，然后将对应的random都找好
    	//然后再进行拆分
//    	RandomListNode rHead=null;
//    	//System.out.println("pHead:"+pHead.label);
//    	if(pHead==null)
//    		return rHead;
//    	else
//    	{
//    		rHead=new RandomListNode(pHead.label);
//        	if(pHead.random!=null)
//        		rHead.next=new RandomListNode(pHead.random.label);
//        	if(pHead.next!=null)
//        		rHead.next=Clone(pHead.next.next);
//            return rHead;
//    	}
//    	
    	//递归复制试一试
    	//该方法并未实现真正的复制！！！！！！！！！！！！
//    	RandomListNode copyHead=new RandomListNode(-1);
//    	if(pHead==null)
//    		return pHead;
//    	copyHead.label=pHead.label;
//    	copyHead.next=pHead.next;
//    	copyHead.random=pHead.random;
//    	copyHead.next=Clone(pHead.next);
//    	return copyHead;
    	/*
        1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
        2、遍历链表，A1->random = A->random->next;
        3、将链表拆分成原链表和复制后的链表
    */
    	if(pHead==null)
    		return null;
    	RandomListNode curNode=pHead;
    	//复制A-A*-B-B*
    	while(curNode!=null)
    	{
    		RandomListNode node=new RandomListNode(curNode.label);
    		node.next=curNode.next;
    		//只做next，后期的random要是新的才可以
    		//node.random=pHead.random;
    		curNode.next=node;
    		curNode=node.next;
    	}
    	curNode=pHead;
    	//复制对应的random节点
    	while(curNode!=null)
    	{
    		RandomListNode node=curNode.next;
    		if(curNode.random!=null) //当前值有random
    		{
    			node.random=curNode.random.next;
    		}
    		curNode=node.next;
    	}
    	//拆分
    	RandomListNode CloneHead=pHead.next;
    	RandomListNode temp;
    	curNode=pHead;
    	//下面这个是跨一个节点，跨节点复制
    	while(curNode.next!=null)
    	{
    		temp=curNode.next;
    		curNode.next=temp.next;
    		curNode=temp;
    	}
    	return CloneHead;
    	
        
    }
    
    //二叉树双向链表指针指向
    //其实类似于二叉树的中序遍历
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
        	return null;
        if(pRootOfTree.left==null && pRootOfTree.right==null)
        {
        	return pRootOfTree;
        }
       //对二叉树进行中序遍历
//        方法二：递归版
//        解题思路：
//        1.将左子树构造成双链表，并返回链表头节点。
//        2.定位至左子树双链表最后一个节点。
//        3.如果左子树链表不为空的话，将当前root追加到左子树链表。
//        4.将右子树构造成双链表，并返回链表头节点。
//        5.如果右子树链表不为空的话，将该链表追加到root节点之后。
//        6.根据左子树链表是否为空确定返回的节点。
        TreeNode left=null;
        TreeNode temp=null;
        TreeNode right=null;
        if(pRootOfTree.left!=null)
        {
        	left=Convert(pRootOfTree.left);
        	temp=left;
        	while(temp.right!=null)
        	{
        		temp=temp.right;
        	}
        	temp.right=pRootOfTree;
        	pRootOfTree.left=temp;
        }
        right=Convert(pRootOfTree.right);
        if(pRootOfTree.right!=null)
        {
        	right.left=pRootOfTree;
        	pRootOfTree.right=right;
        }
        if(left!=null)
        	return left;
        else
        	return pRootOfTree;
        //如果两个孩子都为空，则直接返回自身
        //return pRootOfTree;
    }
    
    
    //确定字符串互异
//    遍历那么只能用两层for循环遍历，时间复杂度为O(n*n)，
//    但是根据抽屉原理，没必要遍历到N，只需要遍历到前257就够了，
//    如果N<257就遍历到N，所以时间复杂度其实为O(1)!!!
//    排序既然题目要求不能使用额外空间，而参数列表没有const或引用，
//    那么就可以对字符串排序，然后再判断，需要O（nlogn)排序，然后再遍历一遍O(n)。
//    其实也没必要全都排序，只需前257个，同抽屉原理。
    public boolean checkDifferent(String iniString) {
        // write code here
    	if(iniString==null)
    		return true;
    	int len=iniString.length();
    	if(len==1)
    		return true;
    	char c;
    	boolean flag=true;
    	int r;
    	int t;
    	for(int i=0;i<len;i++){
    		r=iniString.charAt(i);
    		for(int j=i+1;j<len;j++)
    		{
    			c=iniString.charAt(j);
    			t=r^c;
        		if(t==0)
        		{
        			flag=false;
        			return flag;
        		}
    		}	
    	}
    	return flag;
    }
    
    
    
    //在不使用额外数据的情况下，翻转字符串
    public String reverseString(String iniString) {
    	if(iniString==null || iniString.length()==0)
    		return iniString;
        // write code here
    	int len=iniString.length();
    	char[] c=iniString.toCharArray();
    	char t;
    	for(int i=0;i<c.length/2;i++)
    	{
    		t=c[i];
    		c[i]=c[len-i-1];
    		c[len-i-1]=t;
    	}
    	//对应的String 生成方式
    	return new String(c);
    }
    
    
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    //计算数组中的不一样元素，一共两个
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int temp=0;
        if(array==null || array.length==0)
        {
        	return ;
        }
        if(array.length==1)
        {
        	num1[0]=0;
        	num2[0]=0;
        	return;
        }
        for(int i=0;i<array.length;i++)
        {
        	temp=array[i]^temp;
        }
        //可以让对应的temp仅与1按位与，可得对应的是！！！
        //或者x&（-（x-1））
        int s1=temp;
        int bit=0;
        int n1=0,n2=0;
        while((s1&1)==0)
        {
        	s1=s1>>1;
        	bit++;
        }
        for(int i=0;i<array.length;i++)
        {
        	if(((array[i]>>bit)&1)!=0)
        	{
        		n1=n1^array[i];
        	}
        	else
        	{
        		n2=n2^array[i];
        	}
        }
        num1[0]=n1;
        num2[0]=n2;
    }
    
    //按字典顺序打印出字符的所有排列
//    public ArrayList<String> Permutation(String str) {
//        ArrayList<String> result=new ArrayList<String>();
//        if(str==null || str.length()==0)
//        	return result;
//        char[]t=str.toCharArray();
//        Arrays.sort(t);
//        for(int i=0;i<t.length;i++)
//        {
//        	char f=t[i];
//        	//String b=new String()
//        }
//    }
     
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> re=new ArrayList<String>();
        if(str==null || str.length()==0)
        	return re;
        HashSet<String> set=new HashSet<String>();
        //调用函数初始化
        fun(set,str.toCharArray(),0);
        re.addAll(set);
        //最后再sort，前面直接全排列即可
        Collections.sort(re);
        return re;
     }
    
     void fun(HashSet<String> re,char[] str,int k){
    	 if(k==str.length){
    		 re.add(new String(str));
    		 return;
    	 }
    	 //假设从第0步开始，
    	 //首先是0，然后调用递归，是1，
    	 //最先加入的是第一个，全的
    	 //然后后面的回溯到上一步，
    	 //上一步为len-1,变为len,则交换后面两个的位置，再换回来
    	 //然后是len-2,变为len-1，交换（最后-1）两个的位置，进入len-1，交换了最后两个的位置即ab，ba都有
    	 //设置对应为....abc时，就是，先交换得到bac,然后交换得到...bca,再交换得到cba,cab,
    	 for(int i=k;i<str.length;i++){
    		 //对应实现交换和函数递归
    		 //两次交换的目的是将其换成原来的样子
    		 swap(str,i,k);
    		 fun(re,str,k+1);
    		 swap(str,i,k);
    	 }
     }
     
     void swap(char[] str,int i,int j){
    	 if(i!=j){
    		 char t=str[i];
    		 str[i]=str[j];
    		 str[j]=t;
    	 }
     }
    
     //字符串全排列，第二种
     private char [] seqs;
     private Integer[] book;
     //用于结果去重
     private HashSet<String> result=new HashSet<String>();
     /**
      * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
      * 例如输入字符串abc,则打印出由字符a,b,c
      * 所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。
        输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。\
      * @param str
      * @return
      */
     public ArrayList<String> Permutation2(String str){
    	 ArrayList<String> arrange=new ArrayList<String>();
    	 if(str==null || str.isEmpty())
    		 return arrange;
    	 char[] strs=str.toCharArray();
    	 seqs=new char[strs.length];
    	 book=new Integer[strs.length];
    	 for(int i=0;i<book.length;i++){
    		 book[i]=0;
    	 }
    	 //传入的是对应原始的字符集合
    	 dfs(strs,0);
    	 arrange.addAll(result);
    	 Collections.sort(arrange);
    	 return arrange;
     }
     
     //手写一个深度遍历法
     private void dfs(char[] arrs,int step){
    	 //走完所有可能，记录排列
    	 if(arrs.length==step){
    		 String str="";
    		 for(int i=0;i<seqs.length;i++){
    			 str+=seqs[i];
    		 }
    	     result.add(str);
    	     return;//返回上一步
    	 }
    	 //遍历整个序列，尝试每一种可能
    	 //dfs标记表明对应状态，实现顺序
    	 //不同顺序用标记来实现！！！！
    	 for(int i=0;i<arrs.length;i++)
    	 {
    		 //是否走过
    		 if(book[i]==0)
    		 {
    			 seqs[step]=arrs[i];
    			 //两个标记做标记，重新清零
    			 book[i]=1;
    			 //下一步
    			 dfs(arrs,step+1);
    			 book[i]=0;
    		 }
    			 
    	 }
     }
     
     
     
     //丑数，求按从小到大的第n个丑数
     //最简单的方法是遍历
     public int GetUglyNumber_Solution(int index) {
    	int x=0;
    	if(index==1)
    		return 1;
    	else if(index<=0)
    		return 0;
    	// 此处组合情况不宜讨论，重新做！
// 		for(int i=2;i<0xffff;i++)
// 		{
// 			//第一个全为2
// 			//判断其是否是整数
// 			if((Math.log(i)/Math.log(2*3*5))==(int)(Math.log(i)/Math.log(2*3*5)))
// 				index--;
// 			else if((Math.log(i)/Math.log(2))==(int)(Math.log(i)/Math.log(2)))
// 				index--;
// 			else if((Math.log(i)/Math.log(3))==(int)(Math.log(i)/Math.log(3)))
// 				index--;
// 			else if((Math.log(i)/Math.log(5))==(int)(Math.log(i)/Math.log(5)))
// 				index--;
// 			else if((Math.log(i)/Math.log(2*3))==(int)(Math.log(i)/Math.log(2*3)))
// 				index--;
// 			else if((Math.log(i)/Math.log(2*5))==(int)(Math.log(i)/Math.log(2*5)))
// 				index--;
// 			else if((Math.log(i)/Math.log(3*5))==(int)(Math.log(i)/Math.log(3*5)))
// 				index--;
// 			if(index==1)
// 				return i;
// 	   
// 		}
//    	return 0;
    	
//    	//java解法1
//    	int res[] =new int[index];
//    	ArrayList<Integer> u2=new ArrayList<Integer>();
//    	ArrayList<Integer> u3=new ArrayList<Integer>();
//    	ArrayList<Integer> u5=new ArrayList<Integer>();
//    	
//    	int temp=1;
//    	u2.add(temp);
//    	int num=0;
//    	
//    	while(num<index){
//    		if(!u2.contains(2*temp))
//    			u2.add(2*temp);
//    		if(!u3.contains(3*temp))
//    			u3.add(3*temp);
//    		if(!u5.contains(5*temp))
//    			u5.add(5*temp);
//    		temp=findMin(u2.get(0),u3.get(0),u5.get(0));
//    		if(num==0){
//    			res[num]=temp;
//    			num++;
//    		}
//    		if(num>=1 && res[num-1]!=temp){
//    			//此时肯定是从前面过来的，2，3, 5 对应的新下标
//    			//防止可能存在相同，如2*3
//    			res[num]=temp;
//    			num++;
//    		}
//    		//每次取的都是最开始的地方
//    		//如果其中一个数取到了，相互乘过，那么就把这个数移除，不再取
//    		//相当于每次保留的方法
//    		if(temp==u2.get(0)){
//    			u2.remove(0);
//    		}
//    		else if(temp==u3.get(0)){
//    			u3.remove(0);
//    		}
//    		else
//    		{
//    			u5.remove(0);
//    		}
//    	}
    	
    	//方法不好，不易写
    	//
    	
    	//java 解法2
    	/*
    	说下思路，如果p是丑数，那么p=2^x * 3^y * 5^z
    	那么只要赋予x,y,z不同的值就能得到不同的丑数。
    	如果要顺序找出丑数，要知道下面几个特（fei）点（hua）。
    	对于任何丑数p：
    	（一）那么2*p,3*p,5*p都是丑数，并且2*p<3*p<5*p
    	（二）如果p<q, 那么2*p<2*q,3*p<3*q,5*p<5*q
    	现在说说算法思想：
    	    由于1是最小的丑数，那么从1开始，把2*1，3*1，5*1，进行比较，得出最小的就是1
    	的下一个丑数，也就是2*1，
    	    这个时候，多了一个丑数‘2’，也就又多了3个可以比较的丑数，2*2，3*2，5*2，
    	这个时候就把之前‘1’生成的丑数和‘2’生成的丑数加进来也就是
    	(3*1,5*1,2*2，3*2，5*2)进行比较，找出最小的。。。。如此循环下去就会发现，
    	每次选进来一个丑数，该丑数又会生成3个新的丑数进行比较。
    	    上面的暴力方法也应该能解决，但是如果在面试官用这种方法，估计面试官只会摇头吧
    	。下面说一个O（n）的算法。
    	    在上面的特（fei）点（hua）中，既然有p<q, 那么2*p<2*q，那么
    	“我”在前面比你小的数都没被选上，你后面生成新的丑数一定比“我”大吧，那么你乘2
    	生成的丑数一定比我乘2的大吧，那么在我选上之后你才有机会选上。
    	其实每次我们只用比较3个数：用于乘2的最小的数、用于乘3的最小的数，用于乘5的最小的
    	数。也就是比较(2*x , 3*y, 5*z) ，x>=y>=z的，
    	重点说说下面代码中p的作用：int p[] = new int[] { 0, 0, 0 }; p[0]表示最小用于
    	乘2比较数在数组a中的【位置】。 */
    	
    	final int d[]={2,3,5};
    	int a[]=new int[index];
    	a[0]=1;
    	int p[]=new int[]{0,0,0};
    	int num[]=new int[]{2,3,5};
    	int cur=1;
    	
    	//序号表明顺序
    	while(cur<index){
    		int m=findMin(num[0],num[1],num[2]);
    		//这个数要比前面的大，否则只是单纯的更新下标而已，防止相等
    		if(a[cur-1]<num[m])
    			a[cur++]=num[m];
    		//此处更新丑数的下标值
    		p[m]+=1;
    		//此处更新对应的待选丑数的值，前面已经把丑数放到最终的丑数集合里面，如果需要有的话
    		num[m]=a[p[m]]*d[m];
    	}
    	return a[index-1];
    	
    	
     }
     
     private int findMin(int num2,int num3,int num5)
     {
    	 int min=Math.min(num2, Math.min(num3, num5));
    	 return min==num2?0:min==num3?1:2;
     }
     
     
     
     
     
     
     
     
     
    
    
    
     
     
     
     
     
     
     
     
     
     
     
    
    
    
	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//		Main mtest=new Main();
//		String file="E:\\RFID项目\\Algorithm\\test.txt";
//		int num=0;
//		num=mtest.ReverseString(file);		
//		TreeNode temp=new TreeNode(8);
//		temp.left=new TreeNode(6);
//		temp.right=new TreeNode(9);
////		boolean flag=mtest.isSymmetrical(temp);
////		System.out.println(flag);
//		Main mtest =new Main();
//		ArrayList <Integer> t;
//		//int [] a={1,2,4,7,11,15};
//		t=mtest.PrintFromTopToBottom(temp);
//		for(int x: t)
//		{
//			System.out.println(x+" ");
//		}
		Main mtest=new Main();
//		ListNode head=mtest.new ListNode(3);
//		ListNode next=mtest.new ListNode(4);
//		ListNode snext=mtest.new ListNode(5);
//		head.next=next;
//		head.next.next=snext;
//		ListNode temp;
//		temp=mtest.ReverseList(head);
//		//System.out.println(temp.val);
//		while(temp!=null)
//		{
//			System.out.println(temp.val);
//			temp=temp.next;
//		}
		//多维数组的定义
//		int [][]a={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//		int [][]a={{1},{2},{3}};
////		int [][]a={{1}};
//		ArrayList <Integer>temp=new ArrayList<Integer>();
//		temp=mtest.printMatrix(a);
//		for(int x: temp)
//		{
//			System.out.print(x+" ");
//		}
		//System.out.println(a.length+","+a[1].length);
//		int sum=mtest.NumberOf1Between1AndN_Solution(13);
//		System.out.println(sum);
//		int []a={1,2,3,2,2,2,5,4,2};
//		int m=mtest.MoreThanHalfNum_Solution(a);
//		System.out.println(m);
		//Proxy.newProxyInstance(arg0, arg1, arg2)
//		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
//		result=mtest.FindContinuousSequence(9);
//		System.out.println(result);
//		int[]a={1,2,3};
//		System.out.println(mtest.VerifySquenceOfBST(a));
//		Main.Solution s=mtest.new Solution();
//		//Main.Solution s=new Main().new Solution();
//		TreeNode root=new TreeNode(10);
//		root.left=new TreeNode(5);
//		root.left.left=new TreeNode(4);
//		root.left.right=new TreeNode(7);
//		root.right=new TreeNode(12);
//		System.out.println(mtest.PrintFromTopToBottom(root));
//		System.out.println(mtest.FindPath(root, 22));
//		String test="hellooo";
//		System.out.println(test);
//		System.out.println(mtest.LeftRotateString(test, 3));
//		RandomListNode test=mtest.new RandomListNode(1);
//		test.next=mtest.new RandomListNode(2);
//		test.random=mtest.new RandomListNode(3);
//		test.next.next=test.random;
//		test.next.random=test;
//		test.next.next.next=null;
//		test.next.next.random=test.next;
//		RandomListNode head=test;
//		while(test!=null)
//		{
//			System.out.println("test:"+test.label);
//			if(test.next!=null)
//				System.out.println("test.next:"+test.next.label);
//			if(test.random!=null)
//				System.out.println("test.random:"+test.random.label);
//			System.out.println();
//			test=test.next;
//		}
//		RandomListNode result;
//		
//		System.out.println("after:::");
//		System.out.println("head:"+head.label);
//		result=mtest.Clone(head);
//		while(head!=null)
//		{
//			System.out.println("test:"+head.label);
//			if(head.next!=null)
//				System.out.println("test.next:"+head.next.label);
//			if(head.random!=null)
//				System.out.println("test.random:"+head.random.label);
//			head=head.next;
//		}
		int x=0;
		for(int i=0;i<100;i++)
		{
			//第一个全为2
			//判断其是否是整数
			if((Math.log(i)/Math.log(2*3*5))==(int)(Math.log(i)/Math.log(2*3*5)))
				System.out.println(i);
			else if((Math.log(i)/Math.log(2))==(int)(Math.log(i)/Math.log(2)))
				System.out.println(i);
			else if((Math.log(i)/Math.log(3))==(int)(Math.log(i)/Math.log(3)))
				System.out.println(i);
			else if((Math.log(i)/Math.log(5))==(int)(Math.log(i)/Math.log(5)))
				System.out.println(i);
			else if((Math.log(i)/Math.log(2*3))==(int)(Math.log(i)/Math.log(2*3)))
				System.out.println(i);
			else if((Math.log(i)/Math.log(2*5))==(int)(Math.log(i)/Math.log(2*5)))
				System.out.println(i);
			else if((Math.log(i)/Math.log(3*5))==(int)(Math.log(i)/Math.log(3*5)))
				System.out.println(i);
	   
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
}